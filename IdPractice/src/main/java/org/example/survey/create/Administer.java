package org.example.survey.create;

public class Administer {

    public CreatedSurvey create(Survey survey) {
        return new CreatedSurvey(survey);
    }
}
