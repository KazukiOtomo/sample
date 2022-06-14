package jp.ac.chitose.domain.survey.activate;

public interface ActivatableSurveyUpdateRepository {

    /**
     * 実施の可能／不可能の状態を更新する
     *
     * @param inactiveSurvey 更新するSurvey
     */
    void update(ActivatableSurvey inactiveSurvey);
}
