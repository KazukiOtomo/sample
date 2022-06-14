package jp.ac.chitose.domain.survey.create;

import java.util.function.Predicate;

public class HaveOptions implements Predicate<Question> {

    @Override
    public boolean test(Question question) {
        return !question.getOptions().isEmpty();
    }
}
