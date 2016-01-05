package com.gamenet.service;

import com.gamenet.dao.DataDAO;
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
    private DataDAO dataDAO;

    @Override
    @Transactional
    public List<Data> listData() {
        return dataDAO.listData();
    }
}
