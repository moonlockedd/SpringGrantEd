package kz.aitu.springgranted.repositories;

import kz.aitu.springgranted.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgramRepository extends JpaRepository<Program, Integer> {
}
