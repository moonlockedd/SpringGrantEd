package kz.aitu.springgranted.services;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.repositories.IProgramRepository;
import kz.aitu.springgranted.services.interfaces.IProgramService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProgramService implements IProgramService {
    private final IProgramRepository repo;

    public ProgramService(IProgramRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Program> getAll() {
        return repo.findAll();
    }

    @Override
    public Program getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Program> getByIds(List<Integer> ids) {
        return repo.findAllById(ids);
    }

    @Override
    public List<Program> getProgramsForUser(String[] userElectiveNames, int userTotalScore) {
        // List to store filtered programs
        List<Program> programs = new ArrayList<>();

        // Filter programs
        for (Program program : repo.findAll()) {
            // Check if array of elective names match and total score is
            // higher or equal to minimum passing score
            if (Arrays.equals(
                    program.getElectives(),userElectiveNames
            ) && program.getMinimumScore() <= userTotalScore)
                programs.add(program);
        }

        return programs;
    }

    @Override
    public Program create(Program program) {
        return repo.save(program);
    }

    @Override
    public List<Program> createAll(List<Program> programs) {
        return repo.saveAll(programs);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        repo.deleteAllById(ids);
    }
}
