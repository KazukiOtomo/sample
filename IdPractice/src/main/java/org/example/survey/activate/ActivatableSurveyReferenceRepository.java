package jp.ac.chitose.domain.survey.activate;

public interface ActivatableSurveyReferenceRepository {

    ActivatableSurveys findInactiveSurveys();
}
