package kz.aitu.springgranted.repositories;

import kz.aitu.springgranted.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> findByUniversityId(int universityId);
}
