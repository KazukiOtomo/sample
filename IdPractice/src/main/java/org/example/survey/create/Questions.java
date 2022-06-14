package org.example.survey.create;

import lombok.Getter;

import java.util.*;

@Getter
public class Questions {
    private final Map<Ordinal, Question> questions;

    public Questions(List<Question> questions) {
        if (questions.isEmpty()) throw new IllegalArgumentException("質問が0個の調査は作成できません");
        this.questions = new LinkedHashMap<>(questions.size());
        for (var question : questions) {
            this.questions.put(this.decideOrdinal(), question);
        }
    }

    private Ordinal decideOrdinal() {
        return new Ordinal(this.questions.size() + 1);
    }

    public long size() {
        return this.questions.size();
    }

    public Question get(int index) {
        var key = new ArrayList<>(this.questions.keySet()).get(index);
        return questions.get(key);
    }

    public Set<Map.Entry<Ordinal, Question>> entrySet() {
        return this.questions.entrySet();
    }
}
