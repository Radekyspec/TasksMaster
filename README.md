TasksMaster
==================
Welcome to TasksMaster! If you are looking for an application to manage organization's project, you're in the
right place! We're happy to have you!

- This software serves as the project for the course 207 at the University of Toronto.

Project Domain
--------------

An project scheduling app.

Runtime
--------

- Java version `>= 17`

Functionalities and Specifications
----------------------------------

- Login and signup.
- Choose existing project or create a new one.
- Add message in Message Board.
- Add comment to a message.
- Add a todo list.
- Add a todo in a todo list.
- Check event and add a new one.

Code Organization
-----------------

- All codes follow `Clean Architecture` structure.
- All logical codes located in `src/main/java` and all tests are in `src/test/java`.
- `app` contains use case factories and entry file `Main.java`.
- `data_access` contains data access interfaces for use cases and their implementation.
- `entities` contains all entities we need and their factory class.
- `exceptions` contains several exceptions used in DAO.
- `interface_adapter` contains adapters used for use cases data input & output
- `use_case` contains detailed use case logic, as well as input & output boundaries.
- `view` contains GUI implementation of use case.
```
+-- app
|   +-- login
|   +-- message_board
|   +-- project
|   +-- schedule
|   +-- signup
|   +-- todo
|   +-- todo_list
|   +-- todo_panel
|   +-- Main.java
+-- data_access
+-- entities
+-- exceptions
+-- interface_adapter
+-- use_case
|   +-- login
|   |   +-- LoginInputBoundary.java
|   |   +-- LoginInputdata.java
|   |   +-- LoginInteractor.java
|   |   +-- LoginOutputBoundary.java
|   |   +-- LoginOutputData.java
|   +-- message_board
|   +-- project
|   +-- schedule
|   +-- signup
|   +-- todo
|   +-- todo_list
|   +-- todo_panel
+-- view
```

Specification
-------------
- We are able to build an organization, which can set associated project and users.

- We are able to register users, which have an identification message and bios.

- We are able to build a project, which can set the leader and associated members. Todo-list and Messageboard can be used among groups.

- We are able to create todo-lists, which contains several todos. All todo-list will be included in todoSet, which is a panel to manage Todo-lists. Every members of the todo-list will be notify. Leader can create and distribute todos to certain members.

- For message board, we create the message. You can also comment asides the message, comments will have author and the content.

- We can create schedules, every member can know daliy tasks. Each tasks will have a start time and end time, and also, every crews involved will be notify. Every members can also add some private tasks in their schedule.

