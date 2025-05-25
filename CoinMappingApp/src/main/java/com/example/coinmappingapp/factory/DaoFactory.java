package com.example.coinmappingapp.factory;

import com.example.coinmappingapp.dao.*;
import com.example.coinmappingapp.dao.impl.*;
import com.example.coinmappingapp.model.TipoReceita;

public class DaoFactory {
    public static UserDao getUserDAO() {
        return new OracleUserDao();
    }

    public static ReceitaDao getReceitaDAO() {
        return new OracleReceitaDao();
    }

    public static TipoReceitaDao getTipoReceitaDAO() {
        return new OracleTipoReceita();
    }

    public static TipoDespesaDao getTipoDespesaDAO() {
        return new OracleTipoDespesa();
    }

    public static DespesaDao getDespesaDAO() {
        return new OracleDespesaDao();
    }
}
