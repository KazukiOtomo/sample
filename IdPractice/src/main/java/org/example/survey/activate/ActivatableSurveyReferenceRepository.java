package org.example.survey.activate;

public interface ActivatableSurveyReferenceRepository {

    ActivatableSurveys findInactiveSurveys();
}
