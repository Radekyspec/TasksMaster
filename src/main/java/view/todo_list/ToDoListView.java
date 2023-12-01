package view.todo_list;

import interface_adapter.todo.ToDoState;
import interface_adapter.todo_list.ToDoListController;
import interface_adapter.todo_list.ToDoListState;
import interface_adapter.todo_list.ToDoListViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ToDoListView extends JPanel implements PropertyChangeListener {
    private final ToDoListViewModel toDoListViewModel;
    private final ToDoListController toDoListController;
    private JLabel newToDoList;

    public ToDoListView(ToDoListViewModel toDoListViewModel,
                        ToDoListController toDoListController) {
        this.toDoListController = toDoListController;
        this.toDoListViewModel = toDoListViewModel;

    }
    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ToDoListState state = (ToDoListState) evt.getNewValue();
        if (state.getWorkKind().equals("import")) {
            return;
        } else if (state.getWorkKind().equals("create")) {

        }
    }
    public String getViewName() {
        return toDoListViewModel.getViewName();
    }
}
