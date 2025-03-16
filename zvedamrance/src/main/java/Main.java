import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        /*User user1 = new User("Barry","barry45@gmail.com","password");
        User user2 = new User("Sabrina","sabrina45@gmail.com","heslo");
        UserDao userDao = new UserDao();
        userDao.create(user1);
        userDao.create(user2);*/
        UserDao userDao = new UserDao();
        User [] usr = userDao.readAll();
        for (User u : usr) {
            System.out.println(u);
        }

    }
}
