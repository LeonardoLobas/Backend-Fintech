package com.example.coinmappingapp.factory;

import com.example.coinmappingapp.dao.UserDao;
import com.example.coinmappingapp.dao.impl.OracleUserDao;

public class DaoFactory {
    public static UserDao getUserDAO() {
        return new OracleUserDao();
    }
}
