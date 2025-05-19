package com.example.coinmappingapp.dao;
import com.example.coinmappingapp.exception.DBExeption;
import com.example.coinmappingapp.model.User;

public interface UserDao {
    void cadastrar(User user) throws DBExeption;
}

