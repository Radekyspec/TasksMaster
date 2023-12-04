TaskMaster
==================
Welcome to TaskMaster! If you are looking for an application to manage organization's project, you're in the
right place! We're happy to have you!

- This software serves as the project for the course 207 at the University of Toronto.
- **Distribution without permission is strongly prohibted**

Project Domain
--------------
In this era of technology, internal communication among employees within the company often falls short of efficiency.
There are few applications that cancollect project information, assign tasks,and show stats of the project effectively.

Functionalities and Specifications
----------------------------------

- FILL THIS

Code Organization
-----------------

- We mainly organized our code by layers. However, we also split some "big" layers into fractions by responsibility.
- Folder `data` contains the csv data files.
- Package `entities` contains all the entities we designed.
- Package `usecases` contains different use cases. To make the code easier to search, there are three sub-package
  in `usecases` .
    - The `generators` package contains use cases that are responsible for generating entities or attributes of
      entities.
    - The `impactors` package contains use cases that are responsible for changing the attributes of the `player` and
      the `property`
    - The `interactors` package contains use cases that refers to the actions taken for each subclass of block.

Specification
-------------
We are able to build an organization, which can set associated project and users.
We are able to register users, which have an identification message and bios.
We are able to build a project, which can set the leader and associated members. Todo-list and Messageboard can be used
among groups.
We are able to create todo-lists, which contains several todos. All todo-list will be included in todoSet, which is a
panel to manage Todo-lists. Every members of the todo-list will be notify. Leader can create and distribute todos to
certain members.  
For message board, we create the message. You can also comment asides the message, comments will have author and the
content.
We can create schedules, every member can know daliy tasks. Each tasks will have a start time and end time, and also,
every crews involved will be notify. Every members can also add some private tasks in their schedule.

