package jp.ac.chitose.domain.survey.inactivate;

/**
 * @author miura218
 */
public record Status(boolean value) {

    public boolean isActive() {
        return this.value;
    }
}
