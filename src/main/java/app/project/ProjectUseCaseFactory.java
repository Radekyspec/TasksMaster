package app.project;

import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.project.MainProjectController;
import interface_adapter.project.MainProjectPresenter;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add_people.AddPeopleViewModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import use_case.message_board.message.MessageOutputBoundary;
import use_case.project.MainProjectOutputBoundary;
import view.project.MainProjectView;

public class ProjectUseCaseFactory {
    public ProjectUseCaseFactory(){}

    public static MainProjectView create(ViewManagerModel viewManagerModel, MainProjectViewModel mainProjectViewModel,
                                         MessageBoardViewModel messageBoardViewModel,
                                         ToDoPanelViewModel toDoPanelViewModel, AddPeopleViewModel addPeopleViewModel,
                                         ScheduleViewModel scheduleViewModel){
        return new MainProjectView(viewManagerModel, mainProjectViewModel, messageBoardViewModel, toDoPanelViewModel,
                addPeopleViewModel, scheduleViewModel);
    }
}
