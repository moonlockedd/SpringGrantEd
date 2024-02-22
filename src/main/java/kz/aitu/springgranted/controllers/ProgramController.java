package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.services.interfaces.IProgramService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
