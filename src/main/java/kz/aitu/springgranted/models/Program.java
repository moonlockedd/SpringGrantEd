package kz.aitu.springgranted.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String[] electives;
    private int minimumScore;
}
