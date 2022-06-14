package jp.ac.chitose.domain.survey.create;

public class Administer {

    public CreatedSurvey create(Survey survey) {
        return new CreatedSurvey(survey);
    }
}
