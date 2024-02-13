package org.hannmx.MyRESTProject.controllers;

import org.hannmx.MyRESTProject.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.hannmx.MyRESTProject.domain.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @GetMapping("/add")
    public String userAddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "User added from params!";
    }
}
