package org.fedon.demo.embedit.dao.rest;

import java.util.List;

import org.fedon.demo.embedit.dao.TodoDao;
import org.fedon.demo.embedit.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Dmytro Fedonin
 */
@Repository
public class TodoRestDao implements TodoDao {

    @Value("${external.storage.url.tds:http://jsonplaceholder.typicode.com/todos?userId=}")
    private String url;
    @Autowired
    private ProxyRestDao proxy;

    @Override
    public List<Todo> listByUserId(Integer id) {
        ResponseEntity<List<Todo>> response = proxy.template().exchange("http://jsonplaceholder.typicode.com/todos?userId=" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {});
        //        return proxy.template().getForObject("http://jsonplaceholder.typicode.com/todos?userId=" + id, List.class, (Object) null);
        return response.getBody();
    }
}
