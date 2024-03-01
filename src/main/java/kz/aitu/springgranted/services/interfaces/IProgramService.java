package kz.aitu.springgranted.services.interfaces;

import kz.aitu.springgranted.models.Program;

import java.util.List;

public interface IProgramService {
    List<Program> getAll();
    Program getById(int id);
    List<Program> getByIds(List<Integer> ids);
    Program create(Program program);
    List<Program> createAll(List<Program> programs);
}
