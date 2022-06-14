package org.example.survey.conduct;

import lombok.Data;

import java.util.List;

@Data
public class ConductableSurveys {
    private final List<ConductableSurvey> conductableSurveys;

    public ConductableSurvey get(SurveyId surveyId) {
        return this.conductableSurveys.stream()
                .filter(survey -> survey.getSurveyId().equals(surveyId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("一致するSurveyが見つかりませんでした"));
    }
}
