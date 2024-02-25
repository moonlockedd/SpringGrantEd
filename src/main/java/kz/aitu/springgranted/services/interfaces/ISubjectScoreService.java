package kz.aitu.springgranted.services.interfaces;

import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.services.SubjectScoreService;

import java.util.List;

public interface ISubjectScoreService {
    List<SubjectScore> getAll();
    List<SubjectScore> getByIds(List<Integer> ids);
    SubjectScore create(SubjectScore subjectScore);
}
