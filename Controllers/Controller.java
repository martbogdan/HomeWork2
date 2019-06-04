package Controllers;

import mock.UserMock;
import models.User;
import view.ConsoleView;

public class Controller {

    public void execute (){
        User user = new User();
        String command = "login";
        ConsoleView view = new ConsoleView();

        while (true){
            switch (command) {
                case "login":
                    view.showMessage("Please log in");
                    String userName = view.inputFromUser();
                    view.showMessage("Please, enter password");
                    String password = view.inputFromUser();
                    user.setUserName(userName);
                    user.setPassword(password);
                    UserMock userMock = new UserMock();
                    User userFound = userMock.checkUser(user);

                    if (userFound != null) {
                        view.showMessage("Welcome "+userName);
                        if (userFound.getRole() == 1) {
                            view.showMessage("Welcome admin");
                        }
                        if (userFound.getRole() == 0) {
                            view.showMessage("Welcome user");
                        }
                    } else {
                        view.showMessage("Wrong log in");
                       continue;
                        //command = "login";
                    }
                    command = "";
                    break;
                case "doit":
                    if (user != null) {
                        view.showMessage("OK");
                    }
                    command = "";
                    break;
                case "logout":
                    view.showMessage("Successfully logged out");
                    user = null;
                    command = "";
                    break;
                case "exit":
                    view.showMessage("Bye Bye");
                    System.exit(1);
                default:
                    if (user != null) {
                        view.showMessage("Enter command");
                        command = view.inputFromUser();
                    } else {
                        view.showMessage("You have not logged in");
                        command = "login";
                    }
            }
        }
    }
}
