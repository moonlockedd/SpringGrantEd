package kz.aitu.springgranted.services.interfaces;

import kz.aitu.springgranted.models.Program;
import kz.aitu.springgranted.models.University;

import java.util.List;

public interface IUniversityService {
    List<University> getAll();
    University getById(int id);
    List<Program> getProgramsInUni(int id);
    University create(University university);
    void addProgramToUni(Program createdProgram, University university);
}
