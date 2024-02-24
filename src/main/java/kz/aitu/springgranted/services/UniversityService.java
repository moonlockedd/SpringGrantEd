package kz.aitu.springgranted.services;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;
import kz.aitu.springgranted.repositories.IUniversityRepository;
import kz.aitu.springgranted.services.interfaces.IUniversityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService implements IUniversityService {
    private final IUniversityRepository repo;

    public UniversityService(IUniversityRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<University> getAll() {
        return repo.findAll();
    }

    @Override
    public University getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public University create(University university) {
        return repo.save(university);
    }

    @Override
    public List<Program> getAllPrograms(int universityId) {
        University university = getById(universityId);

        return university.getPrograms();
    }
}
