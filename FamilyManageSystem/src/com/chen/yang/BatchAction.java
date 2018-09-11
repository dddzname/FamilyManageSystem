package com.chen.yang;

import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;


//用于提交批量信息
public interface  BatchAction {
    public void addBatch(CryptoPreparedStatementWriter ps,Object eachItem) throws Exception;
}
