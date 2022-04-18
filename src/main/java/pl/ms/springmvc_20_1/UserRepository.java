package pl.ms.springmvc_20_1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("John", "Doe", 15));
        users.add(new User("Jan", "Nowak", 25));
        users.add(new User("Ania", "Kowalska", 40));
    }

    void addUser(User user) {
        users.add(user);
    }

    String printUsers() {
        String result ="";
        for (User user : users) {
            result +=user + "<br>";
        }
        return result;
    }
}
