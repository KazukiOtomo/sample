package org.example.survey.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QuestionType {
    SINGLE_CHOICE("singleChoice", "単一選択"),
    MULTIPLE_CHOICE("multipleChoice", "複数選択"),
    DESCRIPTION("description", "記述"),
    SINGLE_CHOICE_AND_DESCRIPTION("singleChoiceAndDescription", "単一選択記述");

    private final String label;
    private final String displayLabel;

}
