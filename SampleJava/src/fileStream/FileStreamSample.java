package fileStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author joytec
 *
 */
public class FileStreamSample {

	public static void main(String[] args) {

		// ファイルオブジェクトを宣言
		File file = new File("new.txt");


		// ファイルが存在するかどうかを判定
		if (file.exists()) {
			System.out.println("そのファイルは既に存在");

			// パスを取得
			String path = file.getAbsolutePath();

			// パスを表示
			System.out.println(path);

			try {
				// 読込み
				FileReader filereader = new FileReader(path);

				int ch;
				while ((ch = filereader.read()) != -1) {
					// 一文字づつ読込む
					System.out.print((char) ch);
				}

				// ファイルを閉じる
				filereader.close();

				// 出力準備
				FileWriter fw = new FileWriter(path, true);
				PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

				// ファイル出力
				pw.println("明日も雨");
				// ファイルを閉じる
				pw.close();

			} catch (Exception e) {
				System.out.println(e);

			}

			return;

		} else {

			System.out.println("ファイル作成");

			// パスを取得
			String path = file.getAbsolutePath();
			// パスを表示
			System.out.println(path);

			try {

				// ファイル作成
				file.createNewFile();

				// 出力準備
				FileWriter filewriter = new FileWriter(path);

				// ファイルに書き出す
				filewriter.write("今日は雨\n");
				// ファイルを閉じる
				filewriter.close();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}
}
