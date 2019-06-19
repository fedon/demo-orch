package org.fedon.demo.embedit.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.fedon.demo.embedit.dao.TodoDao;
import org.fedon.demo.embedit.dao.UserDao;
import org.fedon.demo.embedit.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Dmytro Fedonin
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private Integer userId = Integer.valueOf(1);

    @Mock
    private UserDao userDao;
    @Mock
    private TodoDao todoDao;
    @InjectMocks
    private UserService userService;

    @Test
    public void findUserWithTodos() {
        when(userDao.findById(userId)).thenReturn(new User());

        userService.findUserWithTodos(userId);
        verify(userDao).findById(userId);
        verify(todoDao).listByUserId(userId);
    }
}
