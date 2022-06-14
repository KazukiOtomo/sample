package jp.ac.chitose.domain.survey.inactivate;

/**
 * @author miura218
 */
public class Administer {

    public InactiveSurvey inactivate(InactivatableSurvey inactivatableSurvey) {
        return new InactiveSurvey(inactivatableSurvey.surveyId(), inactivatableSurvey.surveyName(), new Status(false));
    }
}
