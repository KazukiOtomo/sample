package org.example.survey.conduct;

public interface ConductableSurveyUpdateRepository {

    /**
     * 実施したSurveyを保存する
     *
     * @param conductedSurvey 実施したSurvey
     */
    void upsert(ConductedSurvey conductedSurvey);
}
