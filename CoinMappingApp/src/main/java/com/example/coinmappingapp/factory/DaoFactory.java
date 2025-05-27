package com.example.coinmappingapp.factory;

import com.example.coinmappingapp.dao.*;
import com.example.coinmappingapp.dao.impl.*;

public class DaoFactory {
    public static UserDao getUserDAO() {
        return new OracleUserDao();
    }

    public static ReceitaDao getReceitaDAO() {
        return new OracleReceitaDao();
    }

    public static DespesaDao getDespesaDAO() {
        return new OracleDespesaDao();
    }
}
