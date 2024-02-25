package kz.aitu.springgranted.services;

import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.repositories.ISubjectScoreRepository;
import kz.aitu.springgranted.services.interfaces.ISubjectScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectScoreService implements ISubjectScoreService {
    private ISubjectScoreRepository repo;

    public SubjectScoreService(ISubjectScoreRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<SubjectScore> getAll() {
        return repo.findAll();
    }

    @Override
    public List<SubjectScore> getByIds(List<Integer> ids) {
        return repo.findAllById(ids);
    }

    @Override
    public SubjectScore create(SubjectScore subjectScore) {
        return repo.save(subjectScore);
    }
}
