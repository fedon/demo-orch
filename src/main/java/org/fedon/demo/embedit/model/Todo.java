package org.fedon.demo.embedit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author Dmytro Fedonin
 */
@Data
@JsonIgnoreProperties({ "userId", "id" })
public class Todo {

    private Integer id;
    private Integer userId;
    private String title;
    private Boolean completed;
}
