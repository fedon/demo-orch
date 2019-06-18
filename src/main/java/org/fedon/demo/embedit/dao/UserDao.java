package org.fedon.demo.embedit.dao;

import org.fedon.demo.embedit.model.User;

/**
 * @author Dmytro Fedonin
 */
public interface UserDao {

    User findById(Integer id);
}
