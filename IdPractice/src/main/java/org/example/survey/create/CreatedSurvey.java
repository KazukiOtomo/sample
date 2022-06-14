package jp.ac.chitose.domain.survey.create;

import lombok.Getter;

@Getter
public class CreatedSurvey {

    private final SurveyName surveyName;
    private final Agreement agreement;
    private final Questions questions;

    CreatedSurvey(Survey survey) {
        this.surveyName = survey.getSurveyName();
        this.agreement = survey.getAgreement();
        this.questions = survey.getQuestions();
    }
}
