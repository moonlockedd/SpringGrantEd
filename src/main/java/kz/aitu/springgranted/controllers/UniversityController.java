package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;
import kz.aitu.springgranted.services.interfaces.IProgramService;
import kz.aitu.springgranted.services.interfaces.IUniversityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("universities")
public class UniversityController {
    private final IUniversityService universityService;
    private final IProgramService programService;

    @GetMapping("/")
    public List<University> getAll() {
        return universityService.getAll();
    }

    @GetMapping("{university_id}")
    public ResponseEntity<University> getById(@PathVariable("university_id") int id) {
        University university = universityService.getById(id);

        if (university == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @GetMapping("{university_id}/programs")
    public ResponseEntity<List<Program>> getProgramsInUniversity(
            @PathVariable("university_id") int id
    ) {
        University university = universityService.getById(id);

        if (university == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Integer> programIds = university.getProgramIds();
        // Get programs in the university
        List<Program> programs = programService.getByIds(programIds);

        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<University> create(@RequestBody University university) {
        University createdUniversity = universityService.create(university);

        if (university == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(createdUniversity, HttpStatus.CREATED);
    }

    @PutMapping("{university_id}/add/program")
    public ResponseEntity<University> addProgramToUniversity(
            @RequestBody Program program,
            @PathVariable("university_id") int id
    ) {
        University university = universityService.getById(id);

        if (university == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Program createdProgram = programService.create(program);

        if (createdProgram == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        universityService.addProgramToUniversity(createdProgram, university);

        return new ResponseEntity<>(university, HttpStatus.CREATED);
    }

    @PutMapping("{university_id}/add/programs")
    public ResponseEntity<University> addProgramsToUniversity(
            @RequestBody List<Program> programs,
            @PathVariable("university_id") int id
    ) {
        University university = universityService.getById(id);

        if (university == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Program> createdPrograms = programService.createAll(programs);

        universityService.addProgramsToUniversity(createdPrograms, university);

        return new ResponseEntity<>(university, HttpStatus.CREATED);
    }
}
