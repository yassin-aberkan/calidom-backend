package be.webideas.calidom.rest;

import be.webideas.calidom.model.User;
import be.webideas.calidom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public User getUser(@PathVariable String username) {
        return userService.getUserByName(username);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}