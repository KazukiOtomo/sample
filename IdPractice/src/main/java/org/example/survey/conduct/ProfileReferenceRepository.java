package org.example.survey.conduct;

public interface ProfileReferenceRepository {

    Institution findInstitutionByTeacherId(TeacherId teacherId);
}
