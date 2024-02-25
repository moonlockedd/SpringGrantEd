package kz.aitu.springgranted.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.models.User;
import kz.aitu.springgranted.repositories.ISubjectScoreRepository;
import kz.aitu.springgranted.repositories.IUserRepository;
import kz.aitu.springgranted.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepo;
    private final ISubjectScoreRepository subjectScoreRepo;

    public UserService(IUserRepository userRepo, ISubjectScoreRepository subjectScoreRepo) {
        this.userRepo = userRepo;
        this.subjectScoreRepo = subjectScoreRepo;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }
}
