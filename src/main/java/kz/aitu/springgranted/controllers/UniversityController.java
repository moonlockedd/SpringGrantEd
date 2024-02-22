package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.University;
import kz.aitu.springgranted.services.interfaces.IUniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("universities")
public class UniversityController {
    private final IUniversityService service;

    public UniversityController(IUniversityService service) {
        this.service = service;
    }

    @GetMapping("/")
    List<University> getAll() {
        return service.getAll();
    }
}
