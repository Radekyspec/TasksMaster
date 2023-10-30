TaskMaster
==================
Welcome to TaskMaster! If you are looking for an application to manage organization's project, you're in the 
right place! We're happy to have you!

Project Domain
--------------
In this era of technology, internal communication among employees within the company often falls short of efficiency. There are few applications that cancollect project information, assign tasks,and show stats of the project effectively.

Specification
-------------
We are able to build an organization, which can set associated project and users.
We are able to register users, which have an identification message and bios.
We are able to build a project, which can set the leader and associated members. Todo-list and Messageboard can be used among groups.
We are able to create todo-lists, which contains several todos. All todo-list will be included in todoSet, which is a panel to manage Todo-lists. Every members of the todo-list will be notify. Leader can create and distribute todos to certain members.  
For message board, we create the message. You can also comment asides the message, comments will have author and the content.
We can create schedules, every member can know daliy tasks. Each tasks will have a start time and end time, and also, every crews involved will be notify. Every members can also add some private tasks in their schedule.

@startuml
class LoginView extends JPanel implements ActionListener, PropertyChangeListener{
+String viewName
-final LoginViewModel loginViewModel
-LoginController loginController
+void LoginView()
+void actionPerformed()
+void propertyChange()
-void setFields()
}
class LoginController{
-LoginInputBoundary loginUseCaseInteractor
+void execute()
}
Interface LoginInputBoundary
class LoginInteractor implements LoginInputBoundary{
-LoginUserDataAccessInterface userDataAccessObject
-LoginOutputBoundary loginPresenter
+LoginInteractor()
+execute()
}
class LoginPresenter{
-LoginViewModel loginViewModel
-LoggedInViewModel loggedInViewModel
-ViewManagerModel viewManagerModel
+LoginPresenter()
+prepareSuccessView()
+prepareFailView()
}
@enduml