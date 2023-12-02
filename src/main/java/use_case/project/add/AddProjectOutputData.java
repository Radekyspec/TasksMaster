package use_case.project.add;

import entities.project.Project;

public record AddProjectOutputData(Project project, String error, boolean useCaseFailed) {
}
