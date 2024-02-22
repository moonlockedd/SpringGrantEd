package kz.aitu.springgranted.services;

import kz.aitu.springgranted.models.User;
import kz.aitu.springgranted.repositories.IUserRepository;
import kz.aitu.springgranted.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository repo;

    public UserService(IUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return null;
    }
}
