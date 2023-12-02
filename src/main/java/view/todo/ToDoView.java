package view.todo;

import interface_adapter.todo.ToDoController;
import interface_adapter.todo.ToDoViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ToDoView extends JPanel implements PropertyChangeListener {

    private final ToDoViewModel toDoViewModel;
    private final ToDoController toDoController;

    public ToDoView(ToDoViewModel toDoViewModel, ToDoController toDoController) {
        this.toDoViewModel = toDoViewModel;
        this.toDoController = toDoController;
    }
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
        return toDoViewModel.getViewName();
    }
}
