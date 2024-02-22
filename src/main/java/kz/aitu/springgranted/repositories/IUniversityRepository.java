package kz.aitu.springgranted.repositories;

import kz.aitu.springgranted.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUniversityRepository extends JpaRepository<University, Integer> {
}
