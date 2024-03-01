package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.services.interfaces.ISubjectScoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("subjectscores")
public class SubjectScoreController {
    private final ISubjectScoreService service;

    @GetMapping("/")
    public List<SubjectScore> getAll() {
        return service.getAll();
    }

    @GetMapping("{subject_score_id}")
    public ResponseEntity<SubjectScore> getById(
            @PathVariable("subject_score_id") int id
    ) {
        SubjectScore subjectScore = service.getById(id);

        if (subjectScore == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(subjectScore, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SubjectScore> create(@RequestBody SubjectScore subjectScore) {
        SubjectScore createdSubjectScore = service.create(subjectScore);

        if (createdSubjectScore == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(subjectScore, HttpStatus.CREATED);
    }

    @DeleteMapping("{subject_score_id}")
    public ResponseEntity<SubjectScore> deleteById(
            @PathVariable("subject_score_id") int id
    ) {
        SubjectScore subjectScore = service.getById(id);

        if (subjectScore == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        service.deleteById(id);

        return new ResponseEntity<>(subjectScore, HttpStatus.OK);
    }
}
