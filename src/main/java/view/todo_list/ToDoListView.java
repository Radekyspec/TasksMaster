package view.todo_list;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListState;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ToDoListView extends JPanel implements PropertyChangeListener {
    private final ToDoListViewModel toDoListViewModel;
    private final JButton backToHome;
    private final JButton addNewToDo;
    private final JButton goBack;
    private JLabel newToDoList;

    public ToDoListView(ViewManagerModel viewManagerModel,
                        ToDoListViewModel toDoListViewModel,
                        MainProjectViewModel mainProjectViewModel,
                        ToDoPanelViewModel toDoPanelViewModel,
                        AddToDoViewModel addToDoViewModel) {
        this.toDoListViewModel = toDoListViewModel;

        JPanel buttons = new JPanel();
        addNewToDo = new JButton(ToDoListViewModel.ADD_NEW_TODO_BUTTON_LABEL);
        backToHome = new JButton(ToDoListViewModel.BACK_TO_HOME_BUTTON_LABEL);
        goBack = new JButton(ToDoListViewModel.GO_BACK_BUTTON_LABEL);
        buttons.add(addNewToDo);
        buttons.add(backToHome);
        buttons.add(goBack);

        /*
        只要view存在，就有ViewName，就可以抓到view
         */
        backToHome.addActionListener(
                e -> {
                    if (!e.getSource().equals(backToHome)) {
                        return;
                    }
                    viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        goBack.addActionListener(
                e -> {
                    if (!e.getSource().equals(goBack)) {
                        return;
                    }
                    viewManagerModel.setActiveView(toDoPanelViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        addNewToDo.addActionListener(
                e -> {
                    if (!e.getSource().equals(addNewToDo)) {
                        return;
                    }
                    viewManagerModel.setActiveView(addToDoViewModel.getViewName());
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
