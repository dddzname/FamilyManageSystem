package com.chen.yang;

import java.io.InputStream;
import java.security.InvalidKeyException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.mysql.jdbc.ResultSetImpl;

public class CryptoResultSetReader {
	
	private ResultSet resultSet;

	public CryptoResultSetReader(ResultSet rs){
		this.resultSet = rs;
	}
	public String getString(int col) throws Exception{
		return resultSet.getString(col);
	}
	
	public Integer getInt(int col) throws Exception{
		return resultSet.getInt(col);
	}
	
	public Long getLong(int col) throws Exception{
		return resultSet.getLong(col);
	}
	
	public boolean next() throws SQLException {
		return resultSet.next();
	}
	public InputStream getBinaryStream(int i) throws SQLException {
		return resultSet.getBinaryStream(i);
	}
	public void last() throws SQLException {
		resultSet.last();
	}
}
