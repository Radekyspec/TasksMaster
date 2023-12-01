package view.todo;

import interface_adapter.ViewManagerModel;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.add_todo_list.AddToDoListViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddToDoView extends JPanel implements PropertyChangeListener {
    private final JButton confirm;
    private final JButton cancel;
    private final AddToDoListViewModel addToDoListViewModel;

    public AddToDoView(ViewManagerModel viewManagerModel,
                       AddToDoListViewModel addToDoListViewModel) {
        this.addToDoListViewModel = addToDoListViewModel;

        JPanel buttons = new JPanel();
        confirm = new JButton(AddToDoViewModel.CONFIRM_NEW_TODO_BUTTON_LABEL);
        cancel = new JButton(AddToDoViewModel.GO_BACK_BUTTON_LABEL);
        buttons.add(confirm);
        buttons.add(cancel);

        confirm.addActionListener(
                e -> {
                    if (!e.getSource().equals(confirm)) {
                        return;
                    }
                    viewManagerModel.setActiveView("addToDoListViewModel.getViewName()"); //manage ToDoList in ToDoPanel
                    viewManagerModel.firePropertyChanged();
                }
        );
        cancel.addActionListener(
                e -> {
                    if (!e.getSource().equals(cancel)) {
                        return;
                    }
                    viewManagerModel.setActiveView("addToDoListViewModel.getViewName()");
                    viewManagerModel.firePropertyChanged();
                }
        );
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
}
