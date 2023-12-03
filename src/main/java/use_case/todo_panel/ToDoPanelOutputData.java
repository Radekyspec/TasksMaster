package use_case.todo_panel;

import entities.todo_list.ToDoList;

import java.util.List;

public record ToDoPanelOutputData(String error, boolean useCaseFailed, List<ToDoList> toDoList) {
}
