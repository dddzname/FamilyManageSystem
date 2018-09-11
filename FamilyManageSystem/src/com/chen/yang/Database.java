package com.chen.yang;

import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Database {
	private Connection conn;
	private String dataBaseName;
	
	java.sql.PreparedStatement ps;

	public Database(String url, String dataBaseName, String user,
			String password) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		this.dataBaseName = dataBaseName;
		conn = (Connection) DriverManager.getConnection(url + dataBaseName,
				user, password);
	}

	public boolean executeCommand(String sql) throws SQLException {
		ps = conn.prepareStatement(sql);
		return ps.execute();
	}

	public CryptoResultSetReader executeQuery(String sql) throws Exception {
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		return new CryptoResultSetReader(rs);
	}

	public int executeUpdate(String sql) throws SQLException {
		ps = conn.prepareStatement(sql);
		return ps.executeUpdate();
	}

	public void close() throws SQLException {
		if (!conn.isClosed()) {
			conn.commit();
			conn.close();
		}
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		conn.setAutoCommit(autoCommit);
	}

	public CryptoPreparedStatementWriter getBatchStatement(String sql) throws SQLException {
		return new CryptoPreparedStatementWriter((PreparedStatement) conn.prepareStatement(sql));
//		return (PreparedStatement) new CryptoPreparedStatementWriter((MySQLConnection)conn,sql);
	}

	
	
	public String getDataBaseName() {
		return dataBaseName;
	}

}
