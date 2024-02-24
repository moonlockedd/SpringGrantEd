package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.services.interfaces.IProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("programs")
public class ProgramController {
    private final IProgramService service;

    public ProgramController(IProgramService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Program> getAll() {
        return service.getAll();
    }

    @GetMapping("/{program_id}")
    public ResponseEntity<Program> getById(@PathVariable("program_id") int id) {
        Program program = service.getById(id);

        if (program == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Program> create(@RequestBody Program program) {
        Program createdProgram = service.create(program);

        if (createdProgram == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(program, HttpStatus.CREATED);
    }
}
