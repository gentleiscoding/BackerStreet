package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConn;

public class Question {
	private int ID;
	private String Question;
	private String OptionA;
	private String OptionB;
	private String OptionC;
	private String OptionD;
	private String CorrectAnswer;
	private String Type;
	private int CountQid;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getOptionA() {
		return OptionA;
	}

	public void setOptionA(String optionA) {
		OptionA = optionA;
	}

	public String getOptionB() {
		return OptionB;
	}

	public void setOptionB(String optionB) {
		OptionB = optionB;
	}

	public String getOptionC() {
		return OptionC;
	}

	public void setOptionC(String optionC) {
		OptionC = optionC;
	}

	public String getOptionD() {
		return OptionD;
	}

	public void setOptionD(String optionD) {
		OptionD = optionD;
	}

	public String getCorrectAnswer() {
		return CorrectAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		CorrectAnswer = correctAnswer;
	}

	

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public int getCountQid() {
		return CountQid;
	}

	public void setCountQid(int countPid) {
		CountQid = countPid;
	}
	//第一次获取题目
	public Question(String type) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		this.setType(type);
		try {
			// 获取该类型题目数量
			pre = con.prepareStatement("Select count(*) from " + type
					+ "questions");
			rs = pre.executeQuery();
			if (rs.next()) {
				this.CountQid = Integer.parseInt(rs.getString("count(*)"));	
			}	
			// 在题目数量内随机获取一个值
			int qid = 1 + (int) (Math.random() * ((this.CountQid - 1) + 1));
			System.out.println(qid);
			pre = con.prepareStatement("Select * from " + this.Type
					+ "questions where qid=" + qid);
			rs = pre.executeQuery();
			if (rs.next()) {
				this.ID = qid;
				this.Question = rs.getString("question");
				this.OptionA = rs.getString("optiona");
				this.OptionB = rs.getString("optionb");
				this.OptionC = rs.getString("optionc");
				this.OptionD = rs.getString("optiond");
				this.CorrectAnswer=rs.getString("correctanswer");
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
	}
	
}
