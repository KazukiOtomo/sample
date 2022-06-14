package jp.ac.chitose.domain.survey.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Survey {
    private final SurveyName surveyName;
    private final Agreement agreement;
    private final Questions questions;
}
