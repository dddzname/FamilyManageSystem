package com.qianduan;

import javax.swing.*;

//单机版的界面
public class Login {
	JFrame jf;
	JPanel contenPanel;
	JLabel welComeLabel;
	JLabel userLabel;
	JLabel passwordLabel;
	JTextField userText;
	Login(){
		jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.setSize(200, 400);
		contenPanel=new JPanel();
		jf.setContentPane(contenPanel);
		welComeLabel=new JLabel("欢迎进入家庭管理系统");
		this.contenPanel.add(this.welComeLabel);
		//添加用户名部分
		userLabel=new JLabel("用户名");
		this.contenPanel.add(this.userLabel);
		userText=new JTextField();
		
		
		jf.setVisible(true);
		
		
		
		
	}
	

	public static void main(String[] args) {
                   new Login();
	}

}
