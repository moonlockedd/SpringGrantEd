package kz.aitu.springgranted.services;

import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.models.User;
import kz.aitu.springgranted.repositories.IUserRepository;
import kz.aitu.springgranted.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepo;

    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
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

    @Override
    public void addSubjectScoreToUser(SubjectScore createdSubjectScore, User user) {
        user.getSubjectScoreIds().add(createdSubjectScore.getId());

        userRepo.save(user);
    }

    @Override
    public void addSubjectScoresToUser(List<SubjectScore> createdSubjectScores, User user) {
        for (SubjectScore createdSubjectScore : createdSubjectScores) {
            user.getSubjectScoreIds().add(createdSubjectScore.getId());
        }

        userRepo.save(user);
    }
}
