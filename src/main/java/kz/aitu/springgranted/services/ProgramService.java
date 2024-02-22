package kz.aitu.springgranted.services;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.repositories.IProgramRepository;
import kz.aitu.springgranted.services.interfaces.IProgramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService implements IProgramService {
    private final IProgramRepository repo;

    public ProgramService(IProgramRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Program> getAll() {
        return repo.findAll();
    }

    @Override
    public Program getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Program create(Program program) {
        return null;
    }

    @Override
    public List<Program> getByUniversityId(int id) {
        return null;
    }
}
