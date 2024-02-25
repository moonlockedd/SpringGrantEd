package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.services.interfaces.ISubjectScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subjectscores")
public class SubjectScoreController {
    private final ISubjectScoreService service;

    public SubjectScoreController(ISubjectScoreService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<SubjectScore> getAll() {
        return service.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<SubjectScore> create(@RequestBody SubjectScore subjectScore) {
        SubjectScore createdSubjectScore = service.create(subjectScore);

        if (createdSubjectScore == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(subjectScore, HttpStatus.CREATED);
    }
}
