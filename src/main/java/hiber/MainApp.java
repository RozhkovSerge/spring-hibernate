package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.CacheRequest;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car toyota = new Car("Camry", 1);
        Car honda = new Car("Civic", 2);
        Car mercedes = new Car("CLS", 3);
        Car lada = new Car("Granta", 4);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", toyota));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", honda));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", mercedes));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", lada));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        User user = userService.get(1L);
        userService.delete(user);

        List<User> users2 = userService.listUsers();
        for (User user2 : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }


        context.close();
    }
}
