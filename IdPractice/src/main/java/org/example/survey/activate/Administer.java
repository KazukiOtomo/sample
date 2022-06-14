package jp.ac.chitose.domain.survey.activate;

public class Administer {
    public void activate(ActivatableSurvey createdSurvey) {
        createdSurvey.activate();
    }
}
