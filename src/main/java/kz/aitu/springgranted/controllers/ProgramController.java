package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.services.interfaces.IProgramService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("programs")
public class ProgramController {
    private final IProgramService service;

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
        // To have the same array regardless of how user orders strings
        Arrays.sort(program.getElectives());
        Program createdProgram = service.create(program);

        if (createdProgram == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(program, HttpStatus.CREATED);
    }
}
