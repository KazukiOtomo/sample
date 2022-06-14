package jp.ac.chitose.domain.survey.inactivate;

/**
 * @author miura218
 */
public record InactiveSurvey(SurveyId surveyId,
                             SurveyName surveyName,
                             Status status) {

    public InactiveSurvey {
        if (status.isActive()) {
            throw new IllegalArgumentException("状態が不正です");
        }
    }
}
