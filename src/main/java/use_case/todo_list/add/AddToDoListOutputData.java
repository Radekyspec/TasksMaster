package use_case.todo_list.add;

import entities.todo_list.ToDoList;

public record AddToDoListOutputData(ToDoList toDoList, String error, boolean useCaseFailed) {

}
