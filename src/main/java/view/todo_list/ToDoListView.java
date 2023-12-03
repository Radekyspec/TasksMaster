package view.todo_list;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo.add_todo.AddToDoState;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListController;
import interface_adapter.todo_list.ToDoListState;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import view.JButtonWithFont;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class ToDoListView extends JPanel implements PropertyChangeListener {
    private long projectID;
    private ToDoList toDoList;
    private final ToDoListViewModel toDoListViewModel;
    private final JButton backToHome;
    private final JButton addNewToDo;
    private final JButton goBack;
    private JLabel newToDoList;
    private JPanel toDoViews;
    private final JTextField nameInputField = new JTextField();
    private final ToDoListController toDoListController;
    private Map<JButton, ToDo> buttonToDoMap;
    private final AddToDoViewModel addToDoViewModel;

    public ToDoListView(ViewManagerModel viewManagerModel,
                        ToDoListViewModel toDoListViewModel,
                        MainProjectViewModel mainProjectViewModel,
                        ToDoPanelViewModel toDoPanelViewModel,
                        AddToDoViewModel addToDoViewModel,
                        ToDoListController toDoListController) {
        this.toDoListViewModel = toDoListViewModel;
        this.toDoListController = toDoListController;
        this.addToDoViewModel = addToDoViewModel;
        toDoListViewModel.addPropertyChangeListener(this);

        toDoViews = new JPanel();
        toDoViews.setLayout(new BoxLayout(toDoViews, BoxLayout.Y_AXIS));


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
                    addToDoViewModel.getState().setToDoListID(toDoList.getListID());
                    addToDoViewModel.getState().setProjectID(projectID);
                    viewManagerModel.setActiveView(addToDoViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

    }
    /**
     * (general) This method gets called when a bound property is changed.
     * FOR VIEW, see case IMPORT_TODO and case IMPORT_SINGLE_TODO.
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
                this.toDoList = state.getNewCreatedTDL();
                this.projectID = state.getProjectID();
                buttonToDoMap.clear();
                toDoViews.removeAll();
                toDoListController.execute(projectID, toDoList.getListID());
            }
            case ToDoListViewModel.IMPORT_TODO_LIST_FAILED -> JOptionPane.showMessageDialog(
                    this,
                    state.getError());
            case ToDoListViewModel.IMPORT_TODO -> {
                for (ToDo toDo : state.getListOfToDo()) {
                    this.toDoList.addToDos(toDo);
                    JButton newToDo = new JButtonWithFont(
                            state.getNewToDo().getProgress() + "-" + state.getNewToDo().getTarget());
                    buttonToDoMap.put(newToDo, toDo);
                    toDoViews.add(newToDo);
                    newToDo.addActionListener(
                            e -> {
                                ToDo toDo1 = buttonToDoMap.get((JButton) e.getSource());
                                addToDoViewModel.getState().setNewCreatedToDo(toDo1);
                                addToDoViewModel.getState().setProjectID(projectID);
                                addToDoViewModel.firePropertyChanged(AddToDoViewModel.CREATE_TODO);
                            }
                    );
                }
            }
            case ToDoListViewModel.IMPORT_SINGLE_TODO -> {
                ToDo toDo = state.getNewToDo();
                this.toDoList.addToDos(toDo);
                JButton newToDo = new JButtonWithFont(
                        state.getNewToDo().getProgress() + "-" + state.getNewToDo().getTarget());
                buttonToDoMap.put(newToDo, toDo);
                toDoViews.add(newToDo);
                newToDo.addActionListener(
                        e -> {
                            ToDo toDo1 = buttonToDoMap.get((JButton) e.getSource());
                            addToDoViewModel.getState().setNewCreatedToDo(toDo1);
                            addToDoViewModel.getState().setProjectID(projectID);
                            addToDoViewModel.firePropertyChanged(AddToDoViewModel.CREATE_TODO);
                        }
                );
            }
        }
    }
    public String getViewName() {
        return toDoListViewModel.getViewName();
    }
}
