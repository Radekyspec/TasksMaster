package view.todopanel;

import interface_adapter.signup.SignupController;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import interface_adapter.todo_panel.TodopanelController;

import javax.swing.*;

public class TodopanelView {
    private final ToDoPanelViewModel toDoPanelViewModel;
    /**
     * ViewModel 需要从ViewModel里import方法
     */
    private final ToDoPanelController toDoPanelController;
    /**
     * Controller 应存在ToDoPanelController
     * 使用前先导入ToDoPanelController
     * 使用前先Initialize Controller
     * 使用前先写好 execute方法
     * 参照SignupController：SignupController <- SignupInputBoundary -> SignupInteractor. done
     */
    private final JButton todos; // to_do

    public class TodoPanelView (){
        //
    }
}
