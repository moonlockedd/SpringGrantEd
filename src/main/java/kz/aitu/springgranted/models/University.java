package kz.aitu.springgranted.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id")
    List<Program> programs;
}
