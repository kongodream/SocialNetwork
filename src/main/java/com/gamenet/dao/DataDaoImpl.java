package com.gamenet.dao;

import com.gamenet.domain.Data;
import com.gamenet.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ivan on 02.01.16.
 */
@Repository
public class DataDaoImpl implements DataDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public Data getDataFor(User user) {
        return user.getData();
    }


}
