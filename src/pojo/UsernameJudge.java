package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DBConn;

public class UsernameJudge {
	public UsernameJudge() {

	};

	public String result(String username) {
		String result = "";
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();

		// 判断用户名是否已被注册
		int a = 0;
		try {
			pre = con
					.prepareStatement(" Select count(*)  from user where username = '"
							+ username + "'");

			rs = pre.executeQuery();
			System.out.println("bbbb");
			while (rs.next()) {
				a = rs.getInt("count(*)");
			}
			System.out.println(a);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

			if (a == 1) {
				result = "该用户名已被注册";
				return result;
			}
			if (a == 0) {
				result = "该用户名没被注册";
				return result;
			}
		}
		return result;
	}

}
