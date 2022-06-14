package jp.ac.chitose.domain.survey.conduct;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Teacher {
    private final Institution institution;

    public ConductedSurvey conduct(ConductableSurvey conductableSurvey, Term term) {
        return new ConductedSurvey(conductableSurvey.getSurveyId(), institution, term);
    }
}
