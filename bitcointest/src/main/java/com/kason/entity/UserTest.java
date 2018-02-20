package com.kason.entity;

import javax.persistence.*;

/**
 * Created by IBM on 2018/2/19.
 */
@Entity
@Table(name="user_test")
public class UserTest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;

    //省略get set 方法


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
