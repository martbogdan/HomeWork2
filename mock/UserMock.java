package mock;

import models.User;

public class UserMock {
    private User admin = new User("Igor", "1111", 1);
    private User user = new User("Andriy", "2222", 0);

    private User users[] = {admin, user};

    public User checkUser(User user) {
        for(int i = 0; i < users.length; i++) {
            if (user.getUserName().equalsIgnoreCase(users[i].getUserName()) &&
                user.getPassword().equalsIgnoreCase(users[i].getPassword())) {
                return users[i];
            }
        }

        return null;
    }
}
