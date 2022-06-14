package jp.ac.chitose.domain.survey.conduct;

public interface ProfileReferenceRepository {

    Institution findInstitutionByTeacherId(TeacherId teacherId);
}
