package kz.aitu.springgranted.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import kz.aitu.springgranted.models.SubjectScore;

import java.util.ArrayList;
import java.util.List;

@Converter
public class SubjectScoreListConverter implements AttributeConverter<List<SubjectScore>, String> {
    private static final String SUBJECT_SCORE_SEPARATOR = ";";
    private static final String ATTRIBUTE_SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<SubjectScore> subjectScores) {
        List<String> subjectScoreStrings = new ArrayList<>();

        for (SubjectScore subjectScore : subjectScores) {
            String subjectScoreString = (
                    subjectScore.getSubject() +
                            ATTRIBUTE_SEPARATOR +
                            subjectScore.getScore().toString()
            );

            subjectScoreStrings.add(subjectScoreString);
        }

        return String.join(SUBJECT_SCORE_SEPARATOR, subjectScoreStrings);
    }

    @Override
    public List<SubjectScore> convertToEntityAttribute(String s) {
        String[] subjectScoreStrings = s.split(SUBJECT_SCORE_SEPARATOR);
        List<SubjectScore> subjectScores = new ArrayList<>();

        for (String string : subjectScoreStrings) {
            String[] separated = string.split(ATTRIBUTE_SEPARATOR);

            subjectScores.add(new SubjectScore(
               separated[0], Integer.parseInt(separated[1])
            ));
        }

        return subjectScores;
    }
}
