package com.gamenet.service;

import com.gamenet.dao.UserDao;
import com.gamenet.domain.Data;
import com.gamenet.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ivan on 02.01.16.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Data getDataFor(int userId) {
        User user = userDao.findUserById(userId);
        return user.getData();
    }
}
