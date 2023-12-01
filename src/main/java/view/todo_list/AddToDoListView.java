package view.todo_list;

import interface_adapter.ViewManagerModel;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_list.add_todo_list.AddToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddToDoListView extends JPanel implements PropertyChangeListener {
    private final ToDoPanelViewModel toDoPanelViewModel;
    private JButton confirm;
    private JButton cancel;
    public AddToDoListView(ViewManagerModel viewManagerModel,
                           ToDoPanelViewModel toDoPanelViewModel) {
        this.toDoPanelViewModel = toDoPanelViewModel;

        JPanel buttons = new JPanel();
        confirm = new JButton(AddToDoListViewModel.ADD_NEW_TODO_BUTTON_LABEL);
        cancel = new JButton(AddToDoListViewModel.GO_BACK_BUTTON_LABEL);
        buttons.add(confirm);
        buttons.add(cancel);

        confirm.addActionListener(
                e -> {
                    if (!e.getSource().equals(confirm)) {
                        return;
                    }
                    viewManagerModel.setActiveView(toDoPanelViewModel.getViewName()); //manage ToDoList in ToDoPanel
                    viewManagerModel.firePropertyChanged();
                }
        );
        cancel.addActionListener(
                e -> {
                    if (!e.getSource().equals(cancel)) {
                        return;
                    }
                    viewManagerModel.setActiveView(toDoPanelViewModel.getViewName());
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
