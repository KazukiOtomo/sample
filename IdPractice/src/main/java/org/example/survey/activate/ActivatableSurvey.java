package jp.ac.chitose.domain.survey.activate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ActivatableSurvey {

    private final SurveyId surveyId;
    private final SurveyName surveyName;
    private Status status;

    public void activate() {
        this.status = new Status(true);
    }

    boolean isActive() {
        return status.isValue();
    }
}
