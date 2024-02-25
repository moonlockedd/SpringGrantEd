package kz.aitu.springgranted.services;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;
import kz.aitu.springgranted.repositories.IUniversityRepository;
import kz.aitu.springgranted.services.interfaces.IUniversityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService implements IUniversityService {
    private final IUniversityRepository universityRepo;

    public UniversityService(IUniversityRepository universityRepo) {
        this.universityRepo = universityRepo;
    }

    @Override
    public List<University> getAll() {
        return universityRepo.findAll();
    }

    @Override
    public University getById(int id) {
        return universityRepo.findById(id).orElse(null);
    }

    @Override
    public University create(University university) {
        return universityRepo.save(university);
    }

    @Override
    public void addProgramToUni(Program createdProgram, University university) {
        int createdProgramId = createdProgram.getId();
        university.getProgramIds().add(createdProgramId);
        universityRepo.save(university);
    }
}
