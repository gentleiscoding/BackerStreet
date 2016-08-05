package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DBConn;

public class Notice {
	public Notice() {

	};

	public String result() {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		String result = "";
		try {
			pre = con
					.prepareStatement("Select content from notice order by updatetime desc limit 1");
			rs = pre.executeQuery();

			while (rs.next()) {
				result = rs.getString("content");
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

}