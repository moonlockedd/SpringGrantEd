package kz.aitu.springgranted.services.interfaces;

import kz.aitu.springgranted.models.Program;

import java.util.List;

public interface IProgramService {
    List<Program> getAll();
    Program getById(int id);
    List<Program> getByIds(List<Integer> ids);
    List<Program> getProgramsForUser(String[] userElectiveNames, int userTotalScore);
    Program create(Program program);
    List<Program> createAll(List<Program> programs);
    void deleteById(int id);
}
