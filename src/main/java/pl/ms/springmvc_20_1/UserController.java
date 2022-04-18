package pl.ms.springmvc_20_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    String printUsers() {
        return userRepository.printUsers();
    }

    @GetMapping("/add")
    String addUser(@RequestParam("imie") String firstName, @RequestParam("nazwisko") String lastName,
                   @RequestParam("wiek") int age) {
        return addUserToRepository(firstName, lastName, age, "success.html", "err.html");
    }

    @PostMapping("/addViaForm")
    String addUserViaForm(@RequestParam String firstName, @RequestParam String lastName,
                          @RequestParam int age) {
        return addUserToRepository(firstName, lastName, age,
                "redirect:/success.html", "redirect:/err.html");
    }
    private String addUserToRepository(String firstName, String lastName, int age, String success, String error) {
        if (firstName !=null && firstName.length() > 0 && lastName != null && lastName.length() > 0) {
            userRepository.addUser(new User(firstName, lastName, age));
            return success;
        } else
            return error;
    }
}
