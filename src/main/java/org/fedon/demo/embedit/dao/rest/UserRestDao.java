package org.fedon.demo.embedit.dao.rest;

import org.fedon.demo.embedit.dao.UserDao;
import org.fedon.demo.embedit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author Dmytro Fedonin
 */
@Repository
public class UserRestDao implements UserDao {

    @Value("${external.storage.url.users:http://jsonplaceholder.typicode.com/users/}")
    private String url;
    @Autowired
    private ProxyRestDao proxy;

    @Override
    public User findById(Integer id) {

        return proxy.template().getForObject(url + id, User.class, (Object) null);
    }

}
