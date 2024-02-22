package kz.aitu.springgranted.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ElementCollection
    private List<String> electives;
    private int minimumScore;
}
