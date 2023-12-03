package view.todo_panel;

import entities.todo_list.ToDoList;
import entities.todo_panel.ToDoPanel;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_list.add.AddToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelController;
import interface_adapter.todo_panel.ToDoPanelState;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class ToDoPanelView extends JPanel implements PropertyChangeListener {
    private long projectID;
    private ToDoPanel toDoPanel;
    private final ToDoPanelViewModel toDoPanelViewModel;
    private final ToDoPanelController toDoPanelController;
    private final JPanel toDoListViews;
    private final JButton addNewList;
    private final JButton backToHome;
    private final JButton select;
    private final AddToDoListViewModel addToDoListViewModel;
    private final ToDoListViewModel toDoListViewModel;

    private Map<JButton, ToDoList> buttonToDoListMap;

    public ToDoPanelView(ViewManagerModel viewManagerModel,
                         ToDoPanelViewModel toDoPanelViewModel,
                         AddToDoListViewModel addToDoListViewModel,
                         MainProjectViewModel mainProjectViewModel,
                         ToDoPanelController toDoPanelController,
                         ToDoListViewModel toDoListViewModel) {
        this.toDoPanelViewModel = toDoPanelViewModel;
        this.addToDoListViewModel = addToDoListViewModel;
        this.toDoPanelController = toDoPanelController;
        this.toDoListViewModel = toDoListViewModel;
        toDoPanelViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabelWithFont(ToDoPanelViewModel.TODO_PANEL_TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT); // set position of the title.
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title); // add button that u already set.

        toDoListViews = new JPanel();
        buttonToDoListMap = new HashMap<>();

        JPanel buttons = new JPanel();
        addNewList = new JButtonWithFont(ToDoPanelViewModel.ADD_NEW_LIST_BUTTON_LABEL);
        backToHome = new JButtonWithFont(ToDoPanelViewModel.BACK_TO_HOME_BUTTON_LABEL);
        select = new JButtonWithFont(ToDoPanelViewModel.SELECT_BUTTON_LABEL);
        buttons.add(addNewList);
        buttons.add(backToHome);
        buttons.add(select);
        addNewList.addActionListener(
                e -> {
                    addToDoListViewModel.getState().setProjectID(projectID);
                    addToDoListViewModel.getState().setToDoPanelID(this.toDoPanel.getId());
                    viewManagerModel.setActiveView(addToDoListViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        backToHome.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        this.add(toDoListViews);
        this.add(buttons);
    }

    /**
     * This method gets called when a bound property is changed.
     * logic:
     * ADD_NEW_TODOLIST:
     *   1. get TDL name and part of detail and integrate into a long text.
     *   2. create this new TDL and add button.
     * FOR VIEW, see case IMPORT_TODOLIST and INITIALIZE_TODO_PANEL
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ToDoPanelState state = (ToDoPanelState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case ToDoPanelViewModel.IMPORT_TODOLIST -> {
                JOptionPane.showMessageDialog(
                        this,
                        "You get here! Then write Importing List logic.");
                ToDoList toDoList = state.getNewCreatedTDL();
                JButton newToDoList = new JButtonWithFont(toDoList.getName()
                        + " - "
                        + toDoList.getDetail());
                buttonToDoListMap.put(newToDoList, toDoList);
                toDoListViews.add(newToDoList);
                newToDoList.addActionListener(
                        e -> {
                            ToDoList toDoList1 = buttonToDoListMap.get((JButton) e.getSource());
                            toDoListViewModel.getState().setNewCreatedTDL(toDoList1);
                            toDoListViewModel.getState().setProjectID(projectID);
                            toDoListViewModel.firePropertyChanged(ToDoListViewModel.IMPORT_TODO_LIST);
                        });
            }
            case ToDoPanelViewModel.IMPORT_TODOLIST_FAILED -> {
                JOptionPane.showMessageDialog(
                        this,
                        state.getImportToDoListError());
            }
            case ToDoPanelViewModel.INITIALIZE_TODO_PANEL -> {
                JOptionPane.showMessageDialog(
                        null,
                        "Start initializing ToDoPanel.");
                this.toDoPanel = state.getCurrentToDoPanel();
                this.projectID = state.getProjectID();
                buttonToDoListMap.clear();
                toDoListViews.removeAll();
                toDoPanelController.initializeToDoPanel(projectID, toDoPanel.getId());
            }
            case ToDoPanelViewModel.INITIALIZE_TODO_PANEL_FAILED -> {
                JOptionPane.showMessageDialog(
                        null,
                        "Initialize ToDoPanel from DAO FAILED.");
            }
        }
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