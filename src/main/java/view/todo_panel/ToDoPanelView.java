package view.todo_panel;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo_list.add.AddToDoListViewModel;
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
    private final JButton backToHome;
    private final JComboBox<Object> toDoListList;
    private final JButton select;
    private final AddToDoListViewModel addToDoListViewModel;

    private JLabel newToDoList;

    public ToDoPanelView(ViewManagerModel viewManagerModel,
                         ToDoPanelViewModel toDoPanelViewModel,
                         ToDoPanelController toDoPanelController,
                         ToDoPanelState toDoPanelState,
                         AddToDoListViewModel addToDoListViewModel,
                         MainProjectViewModel mainProjectViewModel) {
        this.toDoPanelViewModel = toDoPanelViewModel;
        this.toDoPanelController = toDoPanelController;
        this.toDoPanelState = toDoPanelState;
        this.addToDoListViewModel = addToDoListViewModel;
        toDoPanelViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(ToDoPanelViewModel.TODO_PANEL_TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT); // set position of the title.
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title); // add button that u already set.
        this.add(new JLabel());

        toDoListViews = new JPanel();
        toDoListList = new JComboBox<>();
        JPanel toDoPanel = new JPanel();
        toDoPanel.add(new JLabel(ToDoPanelViewModel.CHOOSE_PROJECT_LABEL));
        toDoPanel.add(toDoListList);

        JPanel buttons = new JPanel();
        addNewList = new JButton(ToDoPanelViewModel.ADD_NEW_LIST_BUTTON_LABEL);
        backToHome = new JButton(ToDoPanelViewModel.BACK_TO_HOME_BUTTON_LABEL);
        select = new JButton(ToDoPanelViewModel.SELECT_BUTTON_LABEL);
        buttons.add(addNewList);
        buttons.add(backToHome);
        buttons.add(select);
        addNewList.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(addToDoListViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        backToHome.addActionListener(
                e -> {
                    if (!e.getSource().equals(backToHome)) {
                        return;
                    }
                    viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
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
        switch (evt.getPropertyName()) {
            /*
            case ToDoPanelViewModel.UPDATE_ToDoList -> {
                ToDoPanelState state = (ToDoPanelState) evt.getNewValue(); //意味着方法要写到todopanel里来
                toDoListList.addItem(state.getProject());
            }

             */
        }
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