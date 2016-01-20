package com.gamenet.dao;

import com.gamenet.domain.Data;
import com.gamenet.domain.User;

import java.util.List;

/**
 * Created by ivan on 02.01.16.
 */
public interface DataDao {

    public Data getDataFor(User user);

}
