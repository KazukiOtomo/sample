package jp.ac.chitose.domain.survey.conduct;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Term {
    LocalDate startAt;
    LocalDate stopAt;

    public Term(LocalDate startAt, LocalDate stopAt) {
        if (startAt.isAfter(stopAt)) throw new IllegalArgumentException();
        this.startAt = startAt;
        this.stopAt = stopAt;
    }
}
