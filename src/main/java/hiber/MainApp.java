package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
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
        CarService carService = context.getBean(CarService.class);

//        Car car1 = new Car("Mercedes", 1);
        Car car2 = new Car("Honda", 2);
        Car car3 = new Car("Mazda", 3);
        Car car4 = new Car("Lada", 4);

        Car car1 = new Car("Mercedes", 1);
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

        userService.listUsers().forEach(System.out::println);

        User user = userService.getByCar("Honda", 2);
        System.out.println(user);

//        userService.delete(user);

        Car car = carService.get(2L);
//        carService.delete(car);
//        System.out.println("======================================");

//        userService.listUsers().forEach(System.out::println);
        context.close();
    }
}
