package com.kason.dao;

import com.kason.entity.UserTest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IBM on 2018/2/19.
 */
public interface UserRepository extends CrudRepository<UserTest,Integer> {
    //你没看错 。。。 只用继承CrudRepository 不用重写任何方法
}
