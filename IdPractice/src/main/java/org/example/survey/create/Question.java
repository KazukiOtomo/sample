package jp.ac.chitose.domain.survey.create;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Question {
    private final QuestionSentence questionSentence;
    private final QuestionType questionType;
    private final Options options;

    public Question(QuestionSentence questionSentence, QuestionType questionType, Options options) {
        this.questionSentence = questionSentence;
        this.questionType = questionType;
        this.options = options;

        var isDescriptionQuestion = new IsDescriptionQuestion();
        var haveOption = new HaveOptions();
        if (isDescriptionQuestion.and(haveOption).test(this)) throw new IllegalArgumentException();
    }

    public static Question singleChoiceQuestion(QuestionSentence questionSentence, Options options) {
        return new Question(questionSentence, QuestionType.SINGLE_CHOICE, options);
    }

    public static Question multipleChoiceQuestion(QuestionSentence questionSentence, Options options) {
        return new Question(questionSentence, QuestionType.MULTIPLE_CHOICE, options);
    }

    public static Question descriptionQuestion(QuestionSentence questionSentence) {
        final var emptyOptions = new Options(new ArrayList<>());
        return new Question(questionSentence, QuestionType.DESCRIPTION, emptyOptions);
    }

    public static Question singleChoiceAndDescription(QuestionSentence questionSentence, Options options) {
        return new Question(questionSentence, QuestionType.SINGLE_CHOICE_AND_DESCRIPTION, options);
    }
}
