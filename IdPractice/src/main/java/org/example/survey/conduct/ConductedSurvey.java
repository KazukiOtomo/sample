package org.example.survey.conduct;

import lombok.Data;

@Data
public class ConductedSurvey {
    private final SurveyId surveyId;
    private final Institution where;
    private final Term term;
}
