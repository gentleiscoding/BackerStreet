package pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DBConn;

public class AnswerQuestion {

	private Question CurrentQuestion;
	private List<Integer> chosenid;
	private int hp;

	public AnswerQuestion() {

	}

	public void addchosenid(Question currentquestion) {
		this.chosenid.add(currentquestion.getID());
	}

	public Question getCurrentQuestion() {
		return CurrentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		CurrentQuestion = currentQuestion;
	}

	public void setChosenid(List<Integer> chosenid) {
		this.chosenid = chosenid;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String JudgeQuestion(String useroption) {
		String correctanswer = this.CurrentQuestion.getCorrectAnswer();
		// 回答正确
		if (useroption.equals(correctanswer)) {
			return "right";
		}
		// 错误的12种情况
		else if (useroption.equals(this.getCurrentQuestion().getOptionA())) {

			if (correctanswer.equals(this.CurrentQuestion.getOptionB())) {
				return "userAcorrectB";
			} else if (correctanswer.equals(this.CurrentQuestion.getOptionC())) {
				return "userAcorrectC";
			} else if (correctanswer.equals(this.CurrentQuestion.getOptionD())) {
				return "userAcorrectD";
			}

		} else if (useroption.equals(this.getCurrentQuestion().getOptionB())) {
			if (correctanswer.equals(this.CurrentQuestion.getOptionA())) {
				return "userBcorrectA";
			} else if (correctanswer.equals(this.CurrentQuestion.getOptionC())) {
				return "userBcorrectC";
			} else if (correctanswer.equals(this.CurrentQuestion.getOptionD())) {
				return "userBcorrectD";
			}

		} else if (useroption.equals(this.getCurrentQuestion().getOptionC())) {
			if (correctanswer.equals(this.CurrentQuestion.getOptionA())) {
				return "userCcorrectA";
			} else if (correctanswer.equals(this.CurrentQuestion.getOptionB())) {
				return "userCcorrectB";
			} else if (correctanswer.equals(this.CurrentQuestion.getOptionD())) {
				return "userCcorrectD";
			}

		} else if (useroption.equals(this.getCurrentQuestion().getOptionD())) {
			if (correctanswer.equals(this.CurrentQuestion.getOptionA())) {
				return "userDcorrectA";
			} else if (correctanswer.equals(this.CurrentQuestion.getOptionB())) {
				return "userDcorrectB";
			} else if (correctanswer.equals(this.CurrentQuestion.getOptionC())) {
				return "userDcorrectC";
			}
		}
		return "error";
	}

	public String returnquestion(int headphoto) {
		String result = "";
		// 头像
		result = result
				+ "<script type=\"text/javascript\" src=\"../js/question/game.js\">"
				+ "</script><div class=\"palyerframe\">"
				+ "<img src=\"../img/portrait/"
				+ headphoto
				+ ".jpeg\" class=\"palyer_portrait\">"
				+ " <img src=\"../img/vs.png\" class=\"palyer_portrait\">"
				+ "<img src=\"../img/portrait/computer.jpeg\" class=\"palyer_portrait\">"
				+ "</div>" + "<div class=\"player_state\">"
				+ "<div class=\"player_state_player1\">";

		// 血量
		if (this.hp == 5) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>";
		}
		if (this.hp == 4) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>";
		}
		if (this.hp == 3) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>";
		}
		if (this.hp == 2) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>";
		}
		if (this.hp == 1) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>";
		}
		result = result + "</div></div>";

		// 问题
		result = result
				+ "<div class=\"questionframe\">"
				+ "<h2 style=\"padding-top:15px; color:#000; font-family:'微软雅黑'\">"
				+ this.CurrentQuestion.getQuestion()
				+ "</h2>"
				+ "<div class=\"btn-group-vertical\" role=\"group\" aria-label=\"Vertical button group\">"
				+ "<button type=\"button\" class=\"btn btn-default\" id=\"optiona\">"
				+ this.CurrentQuestion.getOptionA()
				+ "</button>"
				+ "<button type=\"button\" class=\"btn btn-default\" id=\"optionb\">"
				+ this.CurrentQuestion.getOptionB()
				+ "</button>"
				+ "<button type=\"button\" class=\"btn btn-default\" id=\"optionc\">"
				+ this.CurrentQuestion.getOptionC()
				+ "</button>"
				+ "<button type=\"button\" class=\"btn btn-default\" id=\"optiond\">"
				+ this.CurrentQuestion.getOptionD() + "</button>" + "</div>";
		// 下一题按钮
		result = result
				+ "<button type=\"button\" class=\"btn btn-lg btn-warning\" id=\"next\">OK</button></div></div>";

		return result;
	}

	public String entergame(int headphoto) {
		String result = "";
		result = result
				+ "<div style=\"width:100%;height:605px\" id=\"gameiframe\"><html><body><script type=\"text/javascript\" src=\"../js/question/game.js\"></script><div class=\"mainframe\"><div class=\"subframe\"><div class=\"container_top_bar\"></div><div class=\"container_frame\" id=\"container_frame\"> ";
		// 头像
		result = result
				+ "<div class=\"palyerframe\">"
				+ "<img src=\"../img/portrait/"
				+ headphoto
				+ ".jpeg\" class=\"palyer_portrait\">"
				+ " <img src=\"../img/vs.png\" class=\"palyer_portrait\">"
				+ "<img src=\"../img/portrait/computer.jpeg\" class=\"palyer_portrait\">"
				+ "</div>" + "<div class=\"player_state\">"
				+ "<div class=\"player_state_player1\">";

		// 血量
		if (this.hp == 5) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>";
		}
		if (this.hp == 4) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>";
		}
		if (this.hp == 3) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>";
		}
		if (this.hp == 2) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>";
		}
		if (this.hp == 1) {
			result = result
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>"
					+ "<div class=\"player_state_heart\"><span class=\"glyphicon glyphicon-heart-empty\" aria-label=\"生命值\"></span></div>";
		}
		result = result + "</div></div>";

		// 问题
		result = result
				+ "<div class=\"questionframe\">"
				+ "<h2 style=\"padding-top:15px; color:#000; font-family:'微软雅黑'\">"
				+ this.CurrentQuestion.getQuestion()
				+ "</h2>"
				+ "<div class=\"btn-group-vertical\" role=\"group\" aria-label=\"Vertical button group\">"
				+ "<button type=\"button\" class=\"btn btn-default\" id=\"optiona\">"
				+ this.CurrentQuestion.getOptionA()
				+ "</button>"
				+ "<button type=\"button\" class=\"btn btn-default\" id=\"optionb\">"
				+ this.CurrentQuestion.getOptionB()
				+ "</button>"
				+ "<button type=\"button\" class=\"btn btn-default\" id=\"optionc\">"
				+ this.CurrentQuestion.getOptionC()
				+ "</button>"
				+ "<button type=\"button\" class=\"btn btn-default\" id=\"optiond\">"
				+ this.CurrentQuestion.getOptionD() + "</button>" + "</div>";
		// 下一题按钮
		result = result
				+ "<button type=\"button\" class=\"btn btn-lg btn-warning\" id=\"next\" >OK</button></div></div></div></div></div></body></html></div>";

		return result;
	}

	// 获取下一题
	public void nextquestion() {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();

		try {
			int qid = 0;
			// 筛选出没有出过的题目
			int index = 1;
			while (index == 1) {
				index = 0;
				qid = 1 + (int) (Math.random() * ((this.CurrentQuestion
						.getCountQid() - 1) + 1));
				for (int i = 0; i < this.chosenid.size(); i++) {
					if (this.chosenid.get(i) == qid) {
						index = 1;
					}
				}

			}
			this.chosenid.add(qid);
			// 在题目数量内随机获取一个值

			pre = con.prepareStatement("Select * from "
					+ this.CurrentQuestion.getType() + "questions where qid="
					+ qid);
			rs = pre.executeQuery();
			if (rs.next()) {
				this.CurrentQuestion.setID(qid);
				this.CurrentQuestion.setQuestion(rs.getString("question"));
				this.CurrentQuestion.setOptionA(rs.getString("optiona"));
				this.CurrentQuestion.setOptionB(rs.getString("optionb"));
				this.CurrentQuestion.setOptionC(rs.getString("optionc"));
				this.CurrentQuestion.setOptionD(rs.getString("optiond"));
				this.CurrentQuestion.setCorrectAnswer(rs
						.getString("correctanswer"));
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
