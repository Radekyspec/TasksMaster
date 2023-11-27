package use_case.todo_panel;

import data_access.todopanel.ToDoPanelDataAccessInterface;

public class ToDoPanelInteractor implements ToDoPanelInputBoundary{
    private final ToDoPanelDataAccessInterface toDoPanelDataAccessObject;

    /**
     * Achieve the main function of ToDoPanel
     *
     * @param toDoPanelInputData for sth. purpose
     */
    @Override
    public void execute(ToDoPanelInputData toDoPanelInputData) {
        /*
        排除重名情况
         */
        if (toDoPanelDataAccessObject.exists(toDoPanelInputData.getClass()))
    }
}
