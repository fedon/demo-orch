package org.fedon.demo.embedit.dao;

import java.util.List;

import org.fedon.demo.embedit.model.Todo;

/**
 * @author Dmytro Fedonin
 *
 */
public interface TodoDao {

    List<Todo> listByUserId(Integer id);
}
