package view.todo_panel;

import interface_adapter.todo_panel.ToDoPanelViewModel;
import interface_adapter.todo_panel.ToDoPanelController;
import interface_adapter.todo_panel.ToDoPanelState;

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
    private final ToDoPanelState toDoPanelState;

    public ToDoPanelView(ToDoPanelViewModel toDoPanelViewModel, ToDoPanelController toDoPanelController, ToDoPanelState toDoPanelState) {
        this.toDoPanelViewModel = toDoPanelViewModel;
        this.toDoPanelController = toDoPanelController;
        this.toDoPanelState = toDoPanelState;
        toDoPanelViewModel.addPropertyChangeListener(this);
        toDoListViews = new JPanel();
        JLabel title = new JLabel(ToDoPanelViewModel.TODO_PANEL_TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT); // set position of the title.
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title); // add button that u already set.
        this.add(new JLabel());
    }

    /**
     * This method gets called when a bound property is changed.
     * 在使用这个功能前，需要FirePropertyChange发送信号。
     * evt囊括了一个firing change里的所有元素，包括：
     * 1 get old value
     * 2 get new value * 得到新的state
     * 3 get property name
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /*
        为何使用括号(ToDoPanelState)？因为getNewValue返回object。
        To ensure type safety of Java, we must assume a type.
        The type can be the type or its subclass.
         */
        ToDoPanelState state = (ToDoPanelState) evt.getNewValue();
        JButton newToDoList = new JButton(state.getToDoList().getName());
        /*
        successfully add one todolist.
         */
        toDoListViews.add(newToDoList);
        /*
        now is time to use it
        and who will use it? FirePropertyChange which have been set.
         */

    }

    /**
     * When required view name, return the view name.
     * View name is required when doing view exchanging.
     * @return the name of this view.
     */
    public String getViewName() {
        return toDoPanelViewModel.getViewName();
    }
}