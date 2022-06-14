package jp.ac.chitose.domain.survey.create;

public interface CreatedSurveyUpdateRepository {

    /**
     * SurveyとSurveyのQuestions、Optionsを作成する
     *
     * @param createdSurvey 作成されたSurvey
     */
    void create(CreatedSurvey createdSurvey);
}
