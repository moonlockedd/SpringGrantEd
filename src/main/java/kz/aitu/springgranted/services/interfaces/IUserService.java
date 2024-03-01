package kz.aitu.springgranted.services.interfaces;

import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User getById(int id);
    User create(User user);
    void addSubjectScoreToUser(SubjectScore createdSubjectScore, User user);
    void addSubjectScoresToUser(List<SubjectScore> createdSubjectScores, User user);
    void deleteById(int id);
}
