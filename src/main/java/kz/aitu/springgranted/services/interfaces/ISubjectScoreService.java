package kz.aitu.springgranted.services.interfaces;

import kz.aitu.springgranted.models.SubjectScore;

import java.util.List;

public interface ISubjectScoreService {
    List<SubjectScore> getAll();
    List<SubjectScore> getByIds(List<Integer> ids);
    int getTotalScore(List<SubjectScore> subjectScores);
    SubjectScore create(SubjectScore subjectScore);
    List<SubjectScore> createAll(List<SubjectScore> subjectScores);
}
