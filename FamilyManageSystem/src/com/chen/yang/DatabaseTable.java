package com.chen.yang;

import java.io.FileNotFoundException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public abstract class DatabaseTable {
	Database db;
        private static final String  CRYPT_PREFIX= "crpt";
	private String sql;
	String name;
	static final String [] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static final int ALREADY_EXISTS = 1050;
	private boolean randomized=false;
	DatabaseTable(Database db, String name) {// name鏄暟鎹〃鐨勫悕瀛�
		this.db = db;
		this.name = name;
		
		
	}
        
	public boolean createTable() throws Exception  {
		//randomName();
		this.sql = initCreateSQL();
		boolean success=false;
		try {
			success =  db.executeCommand(sql);
		} catch (SQLException e) {
			if (e.getErrorCode() != ALREADY_EXISTS) {// 如果表存在不重新创建
				System.out.println("鍒涘缓" + name + "鏃跺嚭閿欙紒");
				System.out.println(sql);
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
			}
			success = false;
		}
		initData();
		return success;
	}

	protected abstract String initCreateSQL();

	public boolean clear() throws SQLException {
		String s = "delete from " + name + ";";
		return db.executeCommand(s);
	}
	protected void initData()  throws Exception{	
	}
	public String getName(){
		return name;
	}
        public boolean executeBatchStatement(String batchSql,Collection data,BatchAction action) throws Exception{
        	CryptoPreparedStatementWriter ps = db.getBatchStatement(batchSql);
            db.setAutoCommit(false);
            Iterator iter = data.iterator();
            while(iter.hasNext()){
                action.addBatch(ps,iter.next());
            }
            boolean success=true;
            for(int r:ps.executeBatch()){
                if(r==PreparedStatement.EXECUTE_FAILED){
                    success= false;
                }
            }
            db.setAutoCommit(true);
            return success;
        }
        protected abstract void randomName();

	
	
}
