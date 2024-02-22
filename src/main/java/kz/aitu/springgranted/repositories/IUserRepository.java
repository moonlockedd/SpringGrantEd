package kz.aitu.springgranted.repositories;

import kz.aitu.springgranted.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
