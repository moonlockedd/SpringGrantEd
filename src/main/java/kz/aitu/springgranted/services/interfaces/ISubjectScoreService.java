package kz.aitu.springgranted.services.interfaces;

import kz.aitu.springgranted.models.SubjectScore;
import kz.aitu.springgranted.services.SubjectScoreService;

import java.util.List;

public interface ISubjectScoreService {
    List<SubjectScore> getAll();
    SubjectScore create(SubjectScore subjectScore);
}
