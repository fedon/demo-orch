package org.fedon.demo.embedit.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * @author Dmytro Fedonin
 *
 */
@Data
@Builder
public class UserDTO {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private List<Todo> todos;
}
