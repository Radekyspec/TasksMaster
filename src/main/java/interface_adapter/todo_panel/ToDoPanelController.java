package interface_adapter.todo_panel;

import use_case.todo_panel.ToDoPanelInputBoundary;
import use_case.todo_panel.ToDoPanelInputData;
import use_case.todo_panel.ToDoPanelInteractor;

public class ToDoPanelController {
    private final ToDoPanelInputBoundary toDoPanelInteractor;


    public ToDoPanelController(ToDoPanelInputBoundary toDoPanelInteractor) {
        this.toDoPanelInteractor = toDoPanelInteractor;
        /**
         * 解答：这里相当于自己创建了一个toDoPanelInteractor，并且将这个Interactor放在自己class里使用
         */
    }

    /**
     * 为什么我们需要这个data部分？
     * 慢慢写，你就知道了。
     * 先initialize
     */
    public void execute() {
        ToDoPanelInputData toDoPanelInputData = new ToDoPanelInputData(tdpContent);
        /**
         * Interactor get data from Inputdata, and start working.
         * 看清楚了！这里execute的是interactor的execute
         */
        ToDoPanelInteractor.execute(toDoPanelInputData);
        /*
        我这儿没写好，Boundary不见了。应该现在Boundary抽象化
         */
    }
}
