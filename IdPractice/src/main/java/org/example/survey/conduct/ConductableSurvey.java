package org.example.survey.conduct;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ConductableSurvey {
    private final SurveyId surveyId;
    private final SurveyName surveyName;
}
