package kz.aitu.springgranted.services.interfaces;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;

import java.util.List;

public interface IUniversityService {
    List<University> getAll();
    University getById(int id);
    University create(University university);
    void addProgramToUniversity(Program createdProgram, University university);
    void addProgramsToUniversity(List<Program> createdPrograms, University university);
    void deleteById(int id);
}
