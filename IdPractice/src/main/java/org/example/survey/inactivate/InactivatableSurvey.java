package org.example.survey.inactivate;

/**
 * @author miura218
 */
public record InactivatableSurvey(SurveyId surveyId,
                                  SurveyName surveyName,
                                  Status status) {

    public InactivatableSurvey {
        if (!status.isActive()) {
            throw new IllegalArgumentException("状態が不正です");
        }
    }
}
