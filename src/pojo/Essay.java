package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import db.DBConn;

public class Essay {

	public Essay() {

	}

	public String result() {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		String result = "";
		result = result
				+ "<script src=\"../js/bootstrap.min.js\"></script><script src=\"../js/index.js\"></script>"
				+ "<div id=\"essay\">"
				+ "<div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">"
				+ "<ol class=\"carousel-indicators\"><li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li><li data-target=\"#myCarousel\" data-slide-to=\"1\"></li><li data-target=\"#myCarousel\" data-slide-to=\"2\"></li></ol>"
				+ "<div class=\"carousel-inner\" role=\"listbox\">";
		try {
			pre = con
					.prepareStatement("Select * from essay order by date asc limit 3");
			rs = pre.executeQuery();
			int i = 0;
			while (rs.next()) {
				if (i == 0) {
					result = result
							+ "<div class=\"item active\"><img class=\"first-slide\" src=\"../img/"
							+ rs.getDate("date")
							+ ".jpg\" alt=\"First slide\"><div class=\"container\"><div class=\"carousel-caption\"><h1>"
							+ rs.getString("title") + "</h1>"
							+ rs.getString("content") + "</div></div></div>";
				} else {
					result = result
							+ "<div class=\"item\"><img class=\"first-slide\" src=\"../img/"
							+ rs.getDate("date")
							+ ".jpg\" alt=\"First slide\"><div class=\"container\"><div class=\"carousel-caption\"><h1>"
							+ rs.getString("title") + "</h1>"
							+ rs.getString("content") + "</div></div></div>";
				}

				i++;
			}
			result = result
					+ "</div><a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\"> <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span><span class=\"sr-only\">Previous</span></a> <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\"data-slide=\"next\"> <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span><span class=\"sr-only\">Next</span></a></div><div class=\"mylist\" style=\"color:#FEFEFE;\"><div class=\"page-header\"><h1>美文列表 <small>全部</small></h1></div>";

			pre = con
					.prepareStatement("Select * from essay order by date asc limit 3");
			rs = pre.executeQuery();
			int a = 0;

			while (rs.next()) {
				if (a == 0) {
					result = result
							+ "<div><div class=\"media-left\"><img src=\"../img/"
							+ rs.getDate("date")
							+ ".jpg\" width=\"200\" height=\"140\"></div><div class=\"media-body\"><h3>"
							+ rs.getString("title")
							+ "</h3>"
							+ rs.getString("abstract")
							+ "<div class=\"text_center right\"><a class=\"btn btn-lg btn-info\" href=\"/QA/html/detail.html?date="
							+ rs.getString("date")
							+ "\" role=\"button\" target=\"_black\">查看完整文章</a></div></div></div>";
				} else {
					result = result
							+ "<hr style=\"height:1px;border:none;border-top:1px solid #555555;\" /><div><div class=\"media-left\"><img src=\"../img/"
							+ rs.getDate("date")
							+ ".jpg\" width=\"200\" height=\"140\"></div><div class=\"media-body\"><h3>"
							+ rs.getString("title")
							+ "</h3>"
							+ rs.getString("abstract")
							+ "<div class=\"text_center right\"><a class=\"btn btn-lg btn-info\" href=\"/QA/html/detail.html?date="
							+ rs.getString("date")
							+ "\" role=\"button\" target=\"_black\">查看完整文章</a></div></div></div>";

				}
				a++;
			}

			result = result
					+ "<nav><ul class=\"pagination\"><li><a href=\"#\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li><li><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li></ul></nav></div></div>";

			return result;
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

	public String getone() {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		String result = "";
		String date = "";

		try {
			pre = con
					.prepareStatement("Select * from essay order by date desc limit 1");
			rs = pre.executeQuery();
			while (rs.next()) {
				result = rs.getString("content");
				date = rs.getString("date");
			}
			result = result.substring(0, 150)
					+ "<p>……<a href=\"/QA/html/detail.html?date=" + date
					+ "\"  target=\"_black\">点击查看全文</a></p>";
			return result;
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

	public String getdetail(String date) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		String result = "";
		String title = "";
		String content = "";
		try {
			pre = con.prepareStatement("Select * from essay where date='"
					+ date + "'");
			rs = pre.executeQuery();
			while (rs.next()) {
				title = rs.getString("title");
				content = rs.getString("content");
			}
			result = result
					+ "<img style=\"width:100%;height:100%;\"src=\"../img/"+date+".jpg\"><div style=\"position:absolute; height:600px;width:700px;background-color: #BCBCBC;opacity:0.6;margin-top:-600px;margin-left:663px; padding:10px 10px 10px 10px;\"></div><div style=\"position:absolute; color:#FFFFFF; font-size:18px; height:560px;width:600px; margin-top:-570px;margin-left:720px;\"><h1 style=\"font-family:黑体;font-size:40px;\">";
			result = result + title + "</h1>" + content + "</div></div>";

			return result;
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
