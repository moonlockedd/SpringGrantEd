package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;
import kz.aitu.springgranted.services.interfaces.IProgramService;
import kz.aitu.springgranted.services.interfaces.IUniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("universities")
public class UniversityController {
    private final IUniversityService universityService;
    private final IProgramService programService;

    public UniversityController(IUniversityService universityService, IProgramService programService) {
        this.universityService = universityService;
        this.programService = programService;
    }

    @GetMapping("/")
    public List<University> getAll() {
        return universityService.getAll();
    }

    @GetMapping("/{university_id}")
    public ResponseEntity<University> getById(@PathVariable("university_id") int id) {
        University university = universityService.getById(id);

        if (university == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @GetMapping("/{university_id}/programs")
    public ResponseEntity<List<Program>> getProgramsInUni(@PathVariable("university_id") int id) {
        University university = universityService.getById(id);
        if (university == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Integer> programIds = university.getProgramIds();
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

    @PutMapping("/{university_id}/add/program")
    public ResponseEntity<University> addProgramToUni(
            @RequestBody Program program,
            @PathVariable("university_id") int id) {
        University university = universityService.getById(id);
        if (university == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Program createdProgram = programService.create(program);
        if (createdProgram == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        universityService.addProgramToUni(createdProgram, university);
        return new ResponseEntity<>(university, HttpStatus.CREATED);
    }
}
