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
    public List<Program> getByIds(List<Integer> ids) {
        return repo.findAllById(ids);
    }

    @Override
    public Program create(Program program) {
        return repo.save(program);
    }
}
