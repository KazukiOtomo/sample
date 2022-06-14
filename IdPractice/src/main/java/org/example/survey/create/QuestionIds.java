package org.example.survey.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class QuestionIds {
    private final List<QuestionId> questionIds;

    public int size() {
        return this.questionIds.size();
    }

    public QuestionId get(int index) {
        return questionIds.get(index);
    }
}
