package kz.aitu.springgranted.repositories;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUniversityRepository extends JpaRepository<University, Integer> {
}
