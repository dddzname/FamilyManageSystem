package com.chen.yang;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;

public class CryptoPreparedStatementWriter{

	private PreparedStatement preparedStatement;

	public CryptoPreparedStatementWriter(PreparedStatement ps)
			throws SQLException {
		this.preparedStatement =ps;
	
	}
	
	public void setInt(int parameterIndex,int x) throws SQLException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
			preparedStatement.setInt(parameterIndex, x);
	}
	
	public void setString(int parameterIndex,String x) throws SQLException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
//			byte[] by=Cryptography.Encrytor(x);
			preparedStatement.setString(parameterIndex, x);
	}
	
	public void setLong(int parameterIndex,Long x) throws SQLException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{

//		byte[] by=Cryptography.Encrytor(x.toString());
		preparedStatement.setLong(parameterIndex, x);
 
	
    }
	
	
	
	

	public void setObject(int parameterIndex,Object x) throws SQLException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		preparedStatement.setObject(parameterIndex, x);
    }
	public void addBatch() throws SQLException{
		preparedStatement.addBatch();
	}
	
	public int[] executeBatch() throws SQLException{
		return preparedStatement.executeBatch();
	}
	public boolean execute() throws SQLException{
		return preparedStatement.execute();
	}

	public void setBinaryStream(int i, FileInputStream fis, int length) throws SQLException {
		preparedStatement.setBinaryStream(i, fis,length);
	}




	
}
