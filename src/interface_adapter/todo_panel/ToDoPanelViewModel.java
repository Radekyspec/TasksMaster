package interface_adapter.todo_panel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoPanelViewModel extends ViewModel {
    /**
     * IDEA会标红未写完的Implement方法，并且为你提供搭建好框架的快捷键
     * 这个“框架”基于你的abstract class来，是一种“智能填充”
     * 只要你的abstract class写得是对的，这里就不会错
     * 而这里的abstract class是viewmodel
     * 通过观察viewmodel，我们可以窥见这个模板的技术性。
     */
    public static final String TODO_PANEL_TITLE_LABEL = "One's ToDoPanel";

    /**
     * 用于添加
     * @return
     */
    public TodopanelState getState() {
        return state;
    }

    private final TodopanelState state = new TodopanelState();
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);



    public ToDoPanelViewModel(String viewName) {
        super("todo_panel");
    }

    /**
     * 需要创建：ToDoPanelState
     * 需要创建：PropertyChangeSupport
     * Property change 需要创建一个<这样的></>对象。
     * Todo需要有stage吗？暂时不清楚
     * 所以这里留空
     */
    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("state", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        /**
         * 如果需要add再做这件事。
         */
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * View name 是这个view的名字。
     * View name在上面这一行代码被设定。
     * 在需要这个View时，通过这个设定好的View name，可以方便的切换。
     */



}
