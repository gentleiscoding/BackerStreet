package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DBConn;

public class Login {
	public Login() {

	};

	public int getheadphoto(String username) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		String headphoto="";
		try {
			pre = con
					.prepareStatement("Select headphoto from user WHERE username='"
							+ username + "'");
			rs = pre.executeQuery();
			while (rs.next()) {
				headphoto = rs.getString("headphoto");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return Integer.parseInt(headphoto);
	}

	public String result(String username, String password) {
		String result = "";
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre = con
					.prepareStatement("Select password from user WHERE username='"
							+ username + "'");
			rs = pre.executeQuery();
			String passw = "";
			while (rs.next()) {
				passw = rs.getString("password");

			}
			if (!passw.equals(password)) {
				System.out.println(passw);
				System.out.println(password);
				result = "账号或密码错误";
				return result;
			}
			if (passw.equals(password)) {
				result = "登陆成功";
				return result;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return result;
	}
}
