package interface_adapter.project.add_people;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import use_case.project.add_people.AddPeopleOutputBoundary;
import use_case.project.add_people.AddPeopleOutputData;

import javax.swing.*;

public class AddPeoplePresenter implements AddPeopleOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final MainProjectViewModel mainProjectViewModel;

    public AddPeoplePresenter(ViewManagerModel viewManagerModel,
                              MainProjectViewModel mainProjectViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainProjectViewModel = mainProjectViewModel;
    }

    @Override
    public void prepareFailView() {
        JOptionPane.showMessageDialog(null, "User already exists");
        viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(AddPeopleOutputData addPeopleOutputData) {
        viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
