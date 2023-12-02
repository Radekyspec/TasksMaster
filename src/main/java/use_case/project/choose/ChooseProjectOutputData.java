package use_case.project.choose;

import entities.project.Project;

import java.util.List;

public class ChooseProjectOutputData {
    private final List<Project> projectList;
    private final Project chosenProject;
    private final String error;
    private final boolean useCaseFailed;

    public ChooseProjectOutputData(
            List<Project> projectList,
            String error,
            boolean useCaseFailed
    ) {
        this.projectList = projectList;
        this.error = error;
        this.useCaseFailed = useCaseFailed;

        chosenProject = null;
    }

    public ChooseProjectOutputData(
            Project project,
            String error,
            boolean useCaseFailed
    ) {
        chosenProject = project;
        this.error = error;
        this.useCaseFailed = useCaseFailed;

        projectList = null;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public String getError() {
        return error;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public Project getChosenProject() {
        return chosenProject;
    }
}
