package org.fedon.demo.embedit.service;

import org.fedon.demo.embedit.dao.TodoDao;
import org.fedon.demo.embedit.dao.UserDao;
import org.fedon.demo.embedit.model.User;
import org.fedon.demo.embedit.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dmytro Fedonin
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TodoDao todoDao;

    public UserDTO findUserWithTodos(Integer id) {
        User user = userDao.findById(id);
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .todos(todoDao.listByUserId(id))
                .build();
    }
}
