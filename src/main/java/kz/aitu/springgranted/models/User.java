package kz.aitu.springgranted.models;

import jakarta.persistence.*;
import kz.aitu.springgranted.converters.SubjectScoreListConverter;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    @Convert(converter = SubjectScoreListConverter.class)
    private List<SubjectScore> subjectScores;
}
