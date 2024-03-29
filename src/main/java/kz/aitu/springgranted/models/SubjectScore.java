package kz.aitu.springgranted.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subject_scores")
public class SubjectScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private int score;
}
