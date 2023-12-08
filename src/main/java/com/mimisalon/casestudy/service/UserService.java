package com.mimisalon.casestudy.service;

import com.mimisalon.casestudy.database.dao.UserDAO;
import com.mimisalon.casestudy.database.entity.User;
import com.mimisalon.casestudy.form.RegisterUserFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Lazy
    @Autowired

    private PasswordEncoder passwordEncoder;

    public User createNewUser(RegisterUserFormBean form) {
        User user = new User();

        user.setEmail(form.getEmail().toLowerCase());

        String encoded = passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: " + encoded);
        user.setPassword(encoded);

        return userDao.save(user);
    }
}
