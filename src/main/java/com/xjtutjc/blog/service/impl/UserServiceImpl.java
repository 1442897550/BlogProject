package com.xjtutjc.blog.service.impl;

import com.xjtutjc.blog.dao.IUserRepository;
import com.xjtutjc.blog.domain.User;
import com.xjtutjc.blog.service.IUserService;
import com.xjtutjc.blog.uitl.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRespository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRespository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
