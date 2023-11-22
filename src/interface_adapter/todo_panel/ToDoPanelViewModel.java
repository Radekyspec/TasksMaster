package interface_adapter.todo_panel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoPanelViewModel extends ViewModel {
    /**
     * IDEA会标红未写完的Implement方法，并且为你提供搭建好框架的快捷键
     * 这个“框架”基于你的abstract class来，是一种“智能填充”
     * 只要你的abstract class写得是对的，这里就不会错
     * 而这里的abstract class是ViewModel
     * 通过观察ViewModel，我们可以窥见这个模板的技术性。
     */
    public static final String TODO_PANEL_TITLE_LABEL = "One's ToDoPanel";

    /**
     * high speed train - state
     *
     * @return state of tdpVM, which is a todolist.
     */
    public ToDoPanelState getState() {
        return state;
    }

    /*
    Ok. where will the state goes?
     */
    private final ToDoPanelState state = new ToDoPanelState();
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);



    public ToDoPanelViewModel(String viewName) {
        super("todo_panel");
    }

    /**
     * 怎样能将todo传入进来？
     * 用setToDoList()
     * 哪个method来做这件事。
     */
    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("state", null, state);
    }

    /**
     * View name 是这个view的名字。
     * View name在上面这一行代码被设定。
     * 在需要这个View时，通过这个设定好的View name，可以方便的切换。
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
