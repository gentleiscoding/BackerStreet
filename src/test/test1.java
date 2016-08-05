package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import db.DBConn;
import pojo.Login;
import pojo.Register;
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Register signup = new Register();
		Login login = new Login();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createtime = df.format(new Date());
		String a="";
		System.out.println(a);
	}

}
