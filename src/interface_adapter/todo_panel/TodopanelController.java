package interface_adapter.todo_panel;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;
import use_case.todo_panel.ToDoPanelInputBoundary;

public class TodopanelController {
    private final ToDoPanelInputBoundary toDoPanelInteractor;


    public TodopanelController(ToDoPanelInputBoundary toDoPanelInteractor) {
        this.toDoPanelInteractor = toDoPanelInteractor;
        /**
         * 解答：这里相当于自己创建了一个toDoPanelInteractor，并且将这个Interactor放在自己class里使用
         */
    }

    /**
     * 这里的Inputdata,Interactor 全部需要自己去创建
     */
    public void execute() {
        ToDoPanelInputData toDoPanelInputData = new ToDoPanelInputData();
        ToDoPanelInteractor.execute(ToDoPanelInputData);
    }
}
