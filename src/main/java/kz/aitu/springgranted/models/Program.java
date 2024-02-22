package kz.aitu.springgranted.models;

import jakarta.persistence.*;
import kz.aitu.springgranted.converters.StringArrConverter;
import lombok.Data;

@Data
@Entity
@Table(name="programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Convert(converter = StringArrConverter.class)
    private String[] electives;
    private int minimumScore;
    @Column(name = "university_id")
    private int universityId;
}
