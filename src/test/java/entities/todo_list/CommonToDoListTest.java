package entities.todo_list;

import entities.todo.CommonToDoFactory;
import entities.todo.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonToDoListTest {
    private ToDoList toDoList;
    private ToDo toDo;

    @BeforeEach
    void setUp() {
        String[] strings = new String[]{};
        toDoList = CommonToDoListFactory.create(1, 1, "ToDoPanel View", "Implement of ToDoPanelView tasks");
        toDo = CommonToDoFactory.create(1, "Implement To do View", strings, "incomplete");
    }

    @Test
    void getProjectID() {
        assertEquals(1, toDoList.getProjectID());
    }

    @Test
    void getListID() {
        assertEquals(1, toDoList.getListID());
    }

    @Test
    void getName() {
        assertEquals("ToDoPanel View", toDoList.getName());
    }

    @Test
    void getDetail() {
        assertEquals("Implement of ToDoPanelView tasks", toDoList.getDetail());
    }

    @Test
    void getAddToDos() {
        assertEquals(0, toDoList.getToDos().size());
        toDoList.addToDos(toDo);
        assertEquals(1, toDoList.getToDos().size());
        assertEquals(toDo, toDoList.getToDos().get(1L));
    }
}