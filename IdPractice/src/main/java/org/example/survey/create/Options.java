package org.example.survey.create;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class Options {
    private final Map<Ordinal, Option> options;

    public Options(List<Option> options) {
        this.options = new LinkedHashMap<>(options.size());
        for (var option : options) {
            this.options.put(this.decideOrdinal(), option);
        }
    }

    public boolean isEmpty() {
        return options.isEmpty();
    }

    private Ordinal decideOrdinal() {
        return new Ordinal(this.options.size() + 1);
    }

    public int size() {
        return options.size();
    }

    public Set<Map.Entry<Ordinal, Option>> entrySet() {
        return this.options.entrySet();
    }
}
