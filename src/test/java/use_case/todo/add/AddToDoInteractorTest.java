package use_case.todo.add;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddToDoInteractorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void importAddToDoList() {
        interactor.importAddToDoList(new AddToDoInputData("","",0,1));
        interactor.importAddToDoList(new AddToDoInputData("","",1,1));
    }
}