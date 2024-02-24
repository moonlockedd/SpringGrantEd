package kz.aitu.springgranted.repositories;

import kz.aitu.springgranted.models.SubjectScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectScoreRepository extends JpaRepository<SubjectScore, Integer> {
}
