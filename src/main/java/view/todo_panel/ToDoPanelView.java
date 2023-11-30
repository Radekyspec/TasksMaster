package view.todo_panel;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
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
     *
     *
     *
     * 老的要去那
     * 穿件一个新的for，
     * 新创建在controller
     *  给todolist——controller创建自己，返回（用presenter）
     */
    private final JPanel toDoListViews;
    private final ToDoPanelState toDoPanelState;
    private final JButton addNewList;
    private final JButton cancel;

    private JLabel newToDoList;

    public ToDoPanelView(ViewManagerModel viewManagerModel,
                         ToDoPanelViewModel toDoPanelViewModel,
                         ToDoPanelController toDoPanelController,
                         ToDoPanelState toDoPanelState) {
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

        /*
        two buttons added.
         */
        JPanel buttons = new JPanel();
        addNewList = new JButton(ToDoPanelViewModel.ADD_NEW_LIST_BUTTON_LABEL);
        cancel = new JButton(ToDoPanelViewModel.SIGNUP_CANCEL_BUTTON_LABEL);
        buttons.add(addNewList);
        buttons.add(cancel);

        cancel.addActionListener(
                e -> {
                    if (!e.getSource().equals(cancel)) {
                        return;
                    }
                    viewManagerModel.setActiveView();
                }
        );
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
        ToDoPanelState state = (ToDoPanelState) evt.getNewValue(); // state在这个方法被触发的时候就传过来了。
        /*
        statename = state.getpropertyname;
        if (statename == "new panel") {

        } else if (statename == "import panel") {

        }
        */
        JButton newToDoList = new JButton(state.getWorkKind()); //这里通过使用state的各种方法，得到各种需要的值
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