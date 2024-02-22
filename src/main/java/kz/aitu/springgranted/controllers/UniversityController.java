package kz.aitu.springgranted.controllers;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;
import kz.aitu.springgranted.services.interfaces.IUniversityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<University> getAll() {
        return service.getAll();
    }

    @GetMapping("/{university_id}")
    public University getById(@PathVariable("university_id") int id) {
        return service.getById(id);
    }

    @GetMapping("/{university_id}/programs")
    public List<Program> getAllPrograms(@PathVariable("university_id") int universityId) {
        return service.getAllPrograms(universityId);
    }
}
