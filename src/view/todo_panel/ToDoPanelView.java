package view.todo_panel;

import interface_adapter.todo_panel.ToDoPanelViewModel;
import interface_adapter.todo_panel.ToDoPanelController;
import interface_adapter.todo_panel.TodopanelState;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ToDoPanelView extends JPanel implements PropertyChangeListener {
    private final ToDoPanelViewModel toDoPanelViewModel;
    /**
     * 1. VM创建了，initialize好了。此时VM基本是空的。
     * 2. 对这个变量进行了initialize，代码不报错了。意味着可以开始编辑Controller
     */
    private final ToDoPanelController toDoPanelController;
    /**
     * 必要性：我们需要一个controller。controller真正的发出指令。
     * 参照SignupController：SignupController <- SignupInputBoundary -> SignupInteractor. done
     * 1. VM创建了，initialize好了。此时基本是空的。
     */
    private final JPanel toDoListViews;
    /**
     * 文字通过todolist传递进来，这里有很多个按钮，但是暂时做5个。
     *
     */

    /**
     * 重要性：JPanel是图形界面的基础
     *
     *
     */

    public ToDoPanelView(ToDoPanelViewModel toDoPanelViewModel, ToDoPanelController toDoPanelController) {
        this.toDoPanelViewModel = toDoPanelViewModel;
        this.toDoPanelController = toDoPanelController;
        toDoPanelViewModel.addPropertyChangeListener(this);

        /**
         * Set buttons
         * Each Buttons has one row.
         */
        toDoListViews = new JPanel();


        /**
         * Set window title.
         */
        JLabel title = new JLabel(ToDoPanelViewModel.TODO_PANEL_TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT); // set position of the title.
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        /**
         * Add buttons that you already set.
         */
        this.add(title);
        this.add(new JLabel());
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TodopanelState state = (TodopanelState) evt.getNewValue();
        JButton newToDoList = new JButton(state.getToDoList().getName());
        toDoListViews.add(newToDoList);

    }
}