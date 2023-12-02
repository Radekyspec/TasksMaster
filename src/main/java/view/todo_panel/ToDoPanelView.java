package view.todo_panel;

import entities.todo_list.ToDoList;
import entities.todo_panel.ToDoPanel;
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
    private ToDoPanel toDoPanel;
    private final ToDoPanelViewModel toDoPanelViewModel;
    private final ToDoPanelController toDoPanelController;
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
     * logic:
     * ADD_NEW_TODOLIST:
     *   1. get TDL name and part of detail and integrate into a long text.
     *   2. create this new TDL and add button.
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ToDoPanelState state = (ToDoPanelState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case ToDoPanelViewModel.ADD_NEW_TODOLIST -> {
//                toDoListList.addItem(state.getNewCreatedTDL());
                JButton newToDoList = new JButton(state.getNewCreatedTDL().getName()
                        + " - "
                        + state.getNewCreatedTDL().getDetail());
                toDoListViews.add(newToDoList);
            }
            case ToDoPanelViewModel.IMPORT_TODOLIST -> {
                JOptionPane.showMessageDialog(
                        this,
                        "You get here! Then write Importing List logic.");
                for (ToDoList toDoList : state.getListOfToDoList()) {
                    JButton newToDoList = new JButton(toDoList.getName()
                            + " - "
                            + toDoList.getDetail());
                    toDoListViews.add(newToDoList);
                }
            }
            case ToDoPanelViewModel.INITIALIZE_TODO_PANEL -> {

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