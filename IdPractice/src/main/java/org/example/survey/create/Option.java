package jp.ac.chitose.domain.survey.create;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Option {
    private final OptionSentence optionSentence;
}
