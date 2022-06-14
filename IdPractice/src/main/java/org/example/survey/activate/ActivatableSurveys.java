package org.example.survey.activate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Getter
@Slf4j
public class ActivatableSurveys {
    private final List<ActivatableSurvey> createdSurveys;

    public ActivatableSurvey getCreatedSurveyBySurveyId(SurveyId surveyId) {
        return this.createdSurveys.stream()
                .filter(survey -> survey.getSurveyId().equals(surveyId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("surveyIdが存在しません"));
    }
}
