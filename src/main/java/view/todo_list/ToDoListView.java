package view.todo_list;

import entities.todo_list.ToDoList;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListState;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import view.JButtonWithFont;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ToDoListView extends JPanel implements PropertyChangeListener {
    private ToDoList toDoList;
    private final ToDoListViewModel toDoListViewModel;
    private final JButton backToHome;
    private final JButton addNewToDo;
    private final JButton goBack;
    private JLabel newToDoList;
    private JPanel toDoViews;
    private final JTextField nameInputField = new JTextField();
    private final JPanel nameInfo;

    public ToDoListView(ViewManagerModel viewManagerModel,
                        ToDoListViewModel toDoListViewModel,
                        MainProjectViewModel mainProjectViewModel,
                        ToDoPanelViewModel toDoPanelViewModel,
                        AddToDoViewModel addToDoViewModel,
                        JPanel nameInfo) {
        this.toDoListViewModel = toDoListViewModel;
        this.nameInfo = nameInfo;


        toDoViews = new JPanel();


        JPanel buttons = new JPanel();
        addNewToDo = new JButtonWithFont(ToDoListViewModel.ADD_NEW_TODO_BUTTON_LABEL);
        backToHome = new JButtonWithFont(ToDoListViewModel.BACK_TO_HOME_BUTTON_LABEL);
        goBack = new JButtonWithFont(ToDoListViewModel.GO_BACK_BUTTON_LABEL);
        buttons.add(addNewToDo);
        buttons.add(backToHome);
        buttons.add(goBack);


        backToHome.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        goBack.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(toDoPanelViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        addNewToDo.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(addToDoViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

    }
    /**
     * (general) This method gets called when a bound property is changed.
     *
     * todo write view logic here.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ToDoListState state = (ToDoListState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case ToDoListViewModel.IMPORT_TODO_LIST -> {
                JOptionPane.showMessageDialog(
                        this,
                        "Import success! \nAble to continue.");
                ToDoList toDoList = state.getNewCreatedTDL();
            }
            case ToDoListViewModel.IMPORT_TODO_LIST_FAILED -> JOptionPane.showMessageDialog(
                    this,
                    state.getError());
        }
    }
    public String getViewName() {
        return toDoListViewModel.getViewName();
    }
}
