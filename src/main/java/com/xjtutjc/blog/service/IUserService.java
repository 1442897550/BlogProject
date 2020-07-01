package com.xjtutjc.blog.service;

import com.xjtutjc.blog.domain.User;

public interface IUserService {
    User checkUser(String username, String password);
}
