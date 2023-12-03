package use_case.todo_list.import1;

import data_access.todopanel.ToDoPanelDataAccessInterface;
import entities.todo_list.ToDoList;
import use_case.todo_panel.ToDoPanelOutputBoundary;

import java.util.List;

public class ImportToDoListInteractor implements ImportToDoListOutputBoundary{
    private final ToDoPanelDataAccessInterface userDAO;
    private final ToDoPanelOutputBoundary toDoPanelPresenter;

    public ImportToDoListInteractor(ToDoPanelDataAccessInterface toDoPanelDataAccessObject,
                               ToDoPanelOutputBoundary toDoPanelPresenter) {
        this.userDAO = toDoPanelDataAccessObject;
        this.toDoPanelPresenter = toDoPanelPresenter;
    }

    /**
     * it uses ToDoPanelDataAccessInterface, it doesn't create a new one.
     * @param importToDoListInputData Standard input data.
     */
    @Override
    public void importToDoList(ImportToDoListInputData importToDoListInputData) {
        List<ToDoList> listOfToDo = userDAO.importToDoList(
                importToDoListInputData.getProjectID(),
                importToDoListInputData.getToDoPanelID());
        if (listOfToDo == null) {
            ImportToDoListOutputData outputData = new ImportToDoListOutputData(
                    userDAO.getApiErrorMessage(),
                    true,
                    importToDoListInputData.getProjectID(),
                    importToDoListInputData.getToDoPanelID(),
                    null);
            toDoPanelPresenter.prepareImportToDoListFailView(outputData);
        } else {
//            ImportToDoListOutputData outputData = new ImportToDoListOutputData(
//                    userDAO.getApiErrorMessage(),
//                    false,
//                    null,
//                    null,
//                    listOfToDo);
//            toDoPanelPresenter.prepareImportToDoListSuccessView(outputData);
        }
    }
}
