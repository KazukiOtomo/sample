package jp.ac.chitose.domain.survey.inactivate;

public interface InactiveSurveysReferenceRepository {

    InactivatableSurveys findInactivatableSurveys();
}
