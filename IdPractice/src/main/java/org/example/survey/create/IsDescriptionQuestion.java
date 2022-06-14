package jp.ac.chitose.domain.survey.create;

import java.util.function.Predicate;

public class IsDescriptionQuestion implements Predicate<Question> {
    @Override
    public boolean test(Question question) {
        return question.getQuestionType().equals(QuestionType.DESCRIPTION);
    }
}
