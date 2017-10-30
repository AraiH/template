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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joytec.Consts.Constants;
import com.joytec.sql.SqliteKintai;
import com.joytec.src.beans.GWork;

/**
 * CSVサーブレットです。
 */
public class CsvExport extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		// jspから送られたリクエストパラメータの文字コードをWindows-31Jに設定します。
		request.setCharacterEncoding("Windows-31J");
		// 初期化
		request.setAttribute("Msg", "");

		try {

			// リクエスト値を取り出す。
			String employeeCd = request.getParameter("employeeCd");
			String employeeNm = request.getParameter("employeeNm");

			SqliteKintai sqliteKintai = new SqliteKintai();

			ArrayList<GWork> kintaiList = sqliteKintai.getKintai(employeeCd);

			try {
				// 出力先を作成する
				FileWriter fw = new FileWriter(Constants.CsvExport + employeeCd + ".csv", false); // ※１
				PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

				for (GWork gWork : kintaiList) {
					// 社員番号
					pw.print(gWork.getEmployeeCd());
					pw.print(",");
					// 日付
					pw.print(gWork.getBusinessDay());
					pw.print(",");
					// 開始時間
					pw.print(gWork.getWorkStart());
					pw.print(",");
					// 終了時間
					pw.print(gWork.getWorkEnd());
					pw.println();

				}

				// ファイルに書き出す
				pw.close();

				// 終了メッセージを画面に出力する
				request.setAttribute("Msg", "出力が完了しました。");

			} catch (IOException ex) {
				// 例外時処理
				ex.printStackTrace();
				// エラー用のjspへ渡す為リクエストに格納 "ErrMsg"という名前で
				// "整数で入力してください。"オブジェクトを格納します。
				request.setAttribute("ErrMsg", "エラーが存在します");

				rd = request.getRequestDispatcher("/errInput.jsp");
			}

			request.setAttribute("employeeNm", employeeNm);
			request.setAttribute("employeeCd", employeeCd);
			request.setAttribute("kintaiList", kintaiList);

			// jspに転送するためにgetRequestDispatcherを定義。
			rd = request.getRequestDispatcher("/input.jsp");

		} catch (NumberFormatException e) {
			// エラー用のjspへ渡す為リクエストに格納 "ErrMsg"という名前で
			// "整数で入力してください。"オブジェクトを格納します。
			request.setAttribute("ErrMsg", "整数で入力してください。");
			rd = request.getRequestDispatcher("/errInput.jsp");
		} finally {
			// 正常／例外にかかわらず、それぞれの遷移先ページに飛ばす。
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}