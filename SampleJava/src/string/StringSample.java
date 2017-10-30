package string;

public class StringSample {

	public static void main(String[] args) {

		String st01 = "abc";

		String st02 = "abc";

		String st03 = "abaaa";

		String st04 = st03 + "c";

		System.out.println("st01 = " + st01);
		System.out.println("st02 = " + st02);
		System.out.println("st03 = " + st03);
		System.out.println("st04 = " + st04);

		if (st01 == st02) {
			System.out.println("st01とst02は同じ");
		} else {
			System.out.println("st01とst02は違う");
		}

		if (st01 == st03) {
			System.out.println("st01とst03は同じ");
		} else {
			System.out.println("st01とst03は違う");
		}

		if (st01 == st04) {
			System.out.println("st01とst04は同じ");
		} else {
			System.out.println("st01とst04は違う");
		}

		if (st01.equals(st04)) {
			System.out.println("st01とst04は同じ");
		} else {
			System.out.println("st01とst04は違う");
		}

		// Javaにおけるプリミティブ型には以下の8つが存在する。
		//
		// byte
		// short
		// int
		// long
		// char
		// float
		// double
		// boolean

		// int は初期化できない
		// int num =new int(); //コメントを外すとエラーになります

		// byte は初期化できない
		// byte b = new byte(); //コメントを外すとエラーになります

		// short は初期化できない
		// short b = new short(); //コメントを外すとエラーになります

		// double は初期化できない
		// double d =new double(); //コメントを外すとエラーになります

		// char は初期化できない
		// char ch =new char(); //コメントを外すとエラーになります

		// ストリングは初期化出来る
		String st = new String();

	}
}
