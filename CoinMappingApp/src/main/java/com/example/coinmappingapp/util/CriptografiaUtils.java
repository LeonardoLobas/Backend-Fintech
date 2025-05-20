package com.example.coinmappingapp.util;

import com.example.coinmappingapp.exception.DBExeption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtils {

    public static String criptografia(String senha) throws DBExeption, UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes("ISO-8859-1"));
        BigInteger hash = new BigInteger(1, md.digest());
        String senhaHash = hash.toString(16);

        while (senhaHash.length() < 32) {
            senhaHash = "0" + senhaHash;
        }
        return senhaHash;
    }
}
