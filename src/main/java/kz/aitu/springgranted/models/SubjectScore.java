package kz.aitu.springgranted.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectScore {
    private String subject;
    private Integer score;
}
