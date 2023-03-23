package sn.handler.malcolm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.handler.malcolm.model.User;
import sn.handler.malcolm.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User userExisting = repository.findById(id).get();
        userExisting.setName(user.getName());
        userExisting.setEmail(user.getEmail());
        return repository.save(userExisting);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        try{
            repository.deleteById(id);
            return "User deleted";
        } catch (Exception e){
            return "User not found";
        }
    }
}
