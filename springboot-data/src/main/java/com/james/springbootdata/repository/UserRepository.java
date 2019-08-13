package com.james.springbootdata.repository;

import com.james.springbootdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 使用jpa自带的方法
     *
     * @param lastName
     * @return
     */
    User findByLastName(String lastName);
}
