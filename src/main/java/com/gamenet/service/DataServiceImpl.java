package com.gamenet.service;

import com.gamenet.dao.DataDao;
import com.gamenet.dao.DataDaoImpl;
import com.gamenet.domain.Data;
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
    private DataDaoImpl dataDao;

    @Override
    @Transactional
    public List<Data> listData() {
        return dataDao.listData();
    }
}
