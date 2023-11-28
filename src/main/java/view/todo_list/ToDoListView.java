package view.todo_list;

import interface_adapter.todo_list.ToDoListController;
import interface_adapter.todo_list.ToDoListViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ToDoListView extends JPanel implements PropertyChangeListener {
    private final ToDoListViewModel toDoListViewModel;
    private final ToDoListController toDoListController;
    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
    public String getViewName() {
        return toDoListViewModel.getViewName();
    }
}
