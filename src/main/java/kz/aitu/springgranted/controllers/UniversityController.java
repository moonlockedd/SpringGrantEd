package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;
import kz.aitu.springgranted.services.interfaces.IUniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("universities")
public class UniversityController {
    private final IUniversityService service;

    public UniversityController(IUniversityService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<University> getAll() {
        return service.getAll();
    }

    @GetMapping("/{university_id}")
    public ResponseEntity<University> getById(@PathVariable("university_id") int id) {
        University university = service.getById(id);

        if (university == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<University> create(@RequestBody University university) {
        University createdUniversity = service.create(university);

        if (university == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(university, HttpStatus.CREATED);
    }

    @GetMapping("/{university_id}/programs")
    public List<Program> getAllPrograms(@PathVariable("university_id") int universityId) {
        return service.getAllPrograms(universityId);
    }
}
