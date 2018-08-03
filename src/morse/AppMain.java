/**
 * 
 */
package morse;

import java.util.Scanner;

/**
 * @author XuYanhang
 *
 */
public class AppMain {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.print("ACT:Input mode. \n"
					+ "\tE -- encode\n"
					+ "\tD -- decode\n"
					+ "\tQ -- quit\n");
			String mode = scanner.nextLine();
			if (mode == null) {
				System.out.println("ERROR:Node mode return and exit");
				return;
			}
			if (mode.toUpperCase().equals("E")) {
				encode();
			} else if (mode.toUpperCase().equals("D")) {
				decode();
			} else if (mode.toUpperCase().equals("Q")) {
				return;
			} else {
				System.out.println("ERROR:Unknown mode of " + mode);
			}
		}
	}

	public static void encode() {
		while (true) {
			System.out.println("ACT:Input the text with 26 letters. Or 0 to return mode page.");
			String text = scanner.nextLine();
			if (text.equals("0")) {
				return;
			}
			try {
				System.out.println("Encode:");
				System.out.println(Encoder.encode(text, '|'));
			} catch (Exception e) {
				System.out.println("ERROR:Fail parsed text of [" + text + "]");
			}
		}
	}

	public static void decode() {
		while (true) {
			System.out.println("ACT:Input the morse codes. Or 0 to return mode page.");
			String morse = scanner.nextLine();
			if (morse.equals("0")) {
				return;
			}
			try {
				System.out.println("Decoder:");
				System.out.println(Decoder.decode(morse));
			} catch (Exception e) {
				System.out.println("ERROR:Fail parsed morse codes of [" + morse + "]");
			}
		}
	}

}
