package ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.AnswerQuestion;
import pojo.Essay;
import pojo.Login;
import pojo.Notice;
import pojo.Question;
import pojo.Register;
import pojo.UsernameJudge;

public class ser extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String state = (String) request.getParameter("state");
		System.out.println(state);
		PrintWriter out = response.getWriter();

		ServletContext application = request.getSession().getServletContext();

		// 注册的ser
		if (state.equals("register")) {
			String username = (String) request.getParameter("username");
			String password1 = (String) request.getParameter("password1");
			String password2 = (String) request.getParameter("password2");
			int headphoto = Integer.parseInt(request.getParameter("pnumber"));
			String email = (String) request.getParameter("email");
			String signupresult = "";
			Register register = new Register();
			System.out.println("user" + username + "p1 " + password1 + "p2 "
					+ password2);
			signupresult = register.result(username, password1, password2,
					email, headphoto);
			System.out.println(signupresult);
			if (signupresult.equals("注册成功")) {
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("headphoto", headphoto);
				out.write(signupresult);
			} else {
				System.out.println(signupresult);
				out.write(signupresult);
			}

			// if (signupresult.equals("用户名或密码长度不能超过12个字符")) {
			//
			// }
			// if (signupresult.equals("该用户已被注册")) {
			//
			// }
			// if (signupresult.equals("用户名，密码和确认密码不能为空")) {
			//
			// }
			// if (signupresult.equals("密码确认错误，请重新输入")) {
			//
			// }
			// if (signupresult.equals("注册成功")) {
			//
			// }

		}

		// 判断注册用户名是否重复
		if (state.equals("usernamejudge")) {
			String username = (String) request.getParameter("username");
			UsernameJudge usernamejudge = new UsernameJudge();
			String result = usernamejudge.result(username);
			out.write(result);
		}
		// 登陆的ser
		if (state.equals("login")) {
			// 判断账号密码是否正确
			System.out.println("bbb");
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");
			System.out.println("username= " + username + " password= "
					+ password);
			Login login = new Login();
			String loginresult = login.result(username, password);
			if (loginresult.equals("登陆成功")) {
				int headphoto = login.getheadphoto(username);
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("headphoto", headphoto);
				System.out.println(loginresult);
				out.write(loginresult);
			} else {
				System.out.println(loginresult);
				out.write(loginresult);
			}
			// if (loginresult == "密码错误") {
			// System.out.println(loginresult);
			//
			// } else if (loginresult == "不存在该用户") {
			// System.out.println(loginresult);
			// } else if (loginresult == "密码正确") {
			// System.out.println(loginresult);
			// }
		}

		// 进入答题系统
		if (state.equals("entergame")) {
			String username = (String) request.getSession().getAttribute(
					"username");
			if (username == null) {
				out.write("请先登陆");
				return;
			}
			String type = (String) request.getParameter("type");
			Question question = new Question(type);
			int headphoto = (Integer) request.getSession().getAttribute(
					"headphoto");
			// int headphoto = Integer.parseInt((String) request.getSession()
			// .getAttribute("headphoto"));
			AnswerQuestion answerquestion = new AnswerQuestion();
			ArrayList<Integer> chosenlist = new ArrayList<Integer>();
			answerquestion.setChosenid(chosenlist);
			answerquestion.addchosenid(question);
			answerquestion.setCurrentQuestion(question);
			request.getSession().setAttribute("answerquestion", answerquestion);
			answerquestion.setHp(5);
			String result = answerquestion.entergame(headphoto);
			System.out.println(result);
			out.write(result);
		}

		// 判断正误
		if (state.equals("judgequestion")) {
			String useroption = request.getParameter("useroption");
			AnswerQuestion answerquestion = (AnswerQuestion) request
					.getSession().getAttribute("answerquestion");
			String result = answerquestion.JudgeQuestion(useroption);
			if (result.equals("right")) {
				out.write(result);
			} else {
				answerquestion.setHp(answerquestion.getHp() - 1);
				out.write(result);
			}

			// if (result.equals("userAcorrectB")) {
			// }
			// if (result.equals("userAcorrectC")) {
			// }
			// if (result.equals("userAcorrectD")) {
			// }
			// if (result.equals("userBcorrectA")) {
			// }
			// if (result.equals("userBcorrectC")) {
			// }
			// if (result.equals("userBcorrectD")) {
			// }
			// if (result.equals("userCcorrectA")) {
			// }
			// if (result.equals("userCcorrectB")) {
			// }
			// if (result.equals("userCcorrectD")) {
			// }
			// if (result.equals("userDcorrectA")) {
			// }
			// if (result.equals("userDcorrectB")) {
			// }
			// if (result.equals("userDcorrectC")) {
			// }
		}

		// 进入下一题
		if (state.equals("nextquestion")) {
			AnswerQuestion answerquestion = (AnswerQuestion) request
					.getSession().getAttribute("answerquestion");
			if (answerquestion.getHp() == 0) {
				request.getSession().removeAttribute("answerquestion");
				out.write("gameover");
			} else {
				int headphoto = (Integer) request.getSession().getAttribute(
						"headphoto");
				answerquestion.nextquestion();
				String result = answerquestion.returnquestion(headphoto);
				out.write(result);
			}
		}

		// 进入科普美文
		if (state.equals("enteressay")) {
			Essay essay = new Essay();
			String result = essay.result();
			System.out.println(result);
			out.write(result);
		}

		// 得到首页的文章
		if (state.equals("getessay")) {
			Essay essay = new Essay();
			String result = essay.getone();
			System.out.println(result);
			out.write(result);
		}

		// 判断是否登录
		if (state.equals("judgelogin")) {
			String username = (String) request.getSession().getAttribute(
					"username");

			System.out.println(username);
			if (username == null) {
				out.write("<ul class=\"nav navbar-nav navbar-right\"><li><a href=\"/QA/html/register.html\">注册</a></li><li><a href=\"/QA/html/login.html\">登入</a></li></ul>");
			} else {
				int headphoto = (Integer) request.getSession().getAttribute(
						"headphoto");
				out.write("<ul class=\"nav navbar-nav navbar-right\"><li><a href=\"#\">"
						+ username
						+ "</a></li><li><a href=\"/QA/qaser?state=loginout\">注销</a></li><li><img src=\"../img/portrait/"
						+ headphoto
						+ ".jpeg\" alt=\"image\" width=\"40\"height=\"40\"></li></ul>");
			}
		}
		// 显示公告
		if (state.equals("getnotice")) {
			Notice notice = new Notice();
			out.write(notice.result());
		}
		//显示具体文章
		if (state.equals("showdetail")) {
			String date = request.getParameter("date");
			Essay essay = new Essay();
			String result = essay.getdetail(date);
			out.write(result);

		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("abc");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String state = (String) request.getParameter("state");
		System.out.println(state);
		PrintWriter out = response.getWriter();
		// 注销
		if (state.equals("loginout")) {
			request.getSession().removeAttribute("username");
			System.out.println("afterloginout"
					+ (String) request.getSession().getAttribute("username"));
			out.write("注销成功");
			response.sendRedirect("/QA/html/index.html");
		}

	}
}