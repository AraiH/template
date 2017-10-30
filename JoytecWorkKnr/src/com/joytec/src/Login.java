package com.joytec.src;

/*
 * クラス名　：SampleServlet01.java
 *
 * 作成日　：2016/01/10
 * 作成者　：ジョイテック
 * 最終更新日：2016/01/10
 * 最終更新者：ジョイテック
 *
 */
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joytec.sql.SqliteKintai;
import com.joytec.sql.SqliteLogin;
import com.joytec.src.beans.GWork;

/**
 * Loginサーブレットです。
 */
public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = null;

		// jspから送られたリクエストパラメータの文字コードをWindows-31Jに設定します。
		request.setCharacterEncoding("Windows-31J");

		// 初期化
		request.setAttribute("Msg", "");

		try {

			// 入力情報を取得
			String employeeCd = request.getParameter("employeeCd");
			String pass = request.getParameter("pass");

			SqliteLogin sql = new SqliteLogin();

			// 照会
			String employeeNm = sql.logInchk(employeeCd, pass);

			if (employeeNm != null) {

				SqliteKintai sqliteKintai = new SqliteKintai();

				ArrayList<GWork> kintaiList = sqliteKintai.getKintai(employeeCd);

				// 社員番号
				request.setAttribute("employeeCd", employeeCd);
				// 社員名
				request.setAttribute("employeeNm", employeeNm);
				// 勤怠票
				request.setAttribute("kintaiList", kintaiList);

				// jspに転送するためにgetRequestDispatcherを定義。
				rd = request.getRequestDispatcher("/input.jsp");

			} else {

				// エラー用のjspへ渡す為リクエストに格納 "ErrMsg"という名前で
				// "整数で入力してください。"オブジェクトを格納します。
				request.setAttribute("ErrMsg", "社員番号またはパスワードが違います。");

				// //jspに転送するためにgetRequestDispatcherを定義。
				rd = request.getRequestDispatcher("/errLogin.jsp");
			}

		} catch (NumberFormatException e) {
			// エラー用のjspへ渡す為リクエストに格納 "ErrMsg"という名前で
			// "整数で入力してください。"オブジェクトを格納します。
			request.setAttribute("ErrMsg", "エラーが存在します。");
			rd = request.getRequestDispatcher("/errLogin.jsp");
		} finally {
			// 正常／例外にかかわらず、それぞれの遷移先ページに飛ばす。
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}