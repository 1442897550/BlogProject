package com.xjtutjc.blog.dao;

import com.xjtutjc.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);
}
