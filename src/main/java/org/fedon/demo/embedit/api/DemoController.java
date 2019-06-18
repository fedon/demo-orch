package org.fedon.demo.embedit.api;

import org.fedon.demo.embedit.model.UserDTO;
import org.fedon.demo.embedit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmytro Fedonin
 */
@RestController
@RequestMapping("orch")
public class DemoController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getFatUser(@PathVariable("id") int id) {
        return userService.findUserWithTodos(id);
    }
}
