package org.example.survey.conduct;

public interface ConductableSurveyReferenceRepository {

    /**
     * 実施可能なSurveyの一覧を取得する
     *
     * @return 実施可能なSurveyの一覧
     */
    ConductableSurveys findConductableSurveys();
}
