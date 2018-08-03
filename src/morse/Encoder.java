package morse;

public class Encoder {

	public static String encode(String sourceText, char split) {
		return new Encoder(sourceText).flashbackCipher().railFenceCipher().keyboardReplaceCipher().sudokuReplaceCipher()
				.morseCodeCiper(split).out();
	}

	char[] currentText;

	/**
	 * 
	 */
	public Encoder(String sourceText) {
		super();
		this.currentText = sourceText.toUpperCase().replaceAll("[^A-Z]", "").toCharArray();
	}

	public Encoder flashbackCipher() {
		char[] targetText = new char[currentText.length];
		for (int i = 0; i < currentText.length; i++) {
			targetText[currentText.length - i - 1] = currentText[i];
		}
		currentText = targetText;
		return this;
	}

	public Encoder railFenceCipher() {
		int splitPoint = (currentText.length + 1) / 2;
		char[] targetText = new char[currentText.length];
		for (int i = 0; i < currentText.length; i++) {
			if (i % 2 == 0) {
				targetText[i / 2] = currentText[i];
			} else {
				targetText[i / 2 + splitPoint] = currentText[i];
			}
		}
		currentText = targetText;
		return this;
	}

	public Encoder keyboardReplaceCipher() {
		String mapper = "QWERTYUIOPASDFGHJKLZXCVBNM";
		char[] targetText = new char[currentText.length];
		for (int i = 0; i < currentText.length; i++) {
			targetText[i] = mapper.charAt(currentText[i] - 'A');
		}
		currentText = targetText;
		return this;
	}

	public Encoder sudokuReplaceCipher() {
		int[] mapper = { 21, 22, 23, 31, 32, 33, 41, 42, 43, 51, 52, 53, 61, 62, 63, 71, 72, 73, 74, 81, 82, 83, 91, 92,
				93, 94 };
		char[] targetText = new char[currentText.length * 2];
		for (int i = 0; i < currentText.length; i++) {
			int value = mapper[currentText[i] - 'A'];
			targetText[i * 2 + 0] = Character.forDigit(value / 10, 10);
			targetText[i * 2 + 1] = Character.forDigit(value % 10, 10);
		}
		currentText = targetText;
		return this;
	}

	public Encoder morseCodeCiper(char split) {
		String[] mapper = { ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." };
		char[] targetText = new char[currentText.length * 6 - 1];
		for (int i = 0; i < currentText.length; i++) {
			String value = mapper[currentText[i] - '1'];
			targetText[i * 6 + 0] = value.charAt(0);
			targetText[i * 6 + 1] = value.charAt(1);
			targetText[i * 6 + 2] = value.charAt(2);
			targetText[i * 6 + 3] = value.charAt(3);
			targetText[i * 6 + 4] = value.charAt(4);
			if (i != currentText.length - 1) {
				targetText[i * 6 + 5] = split;
			}
		}
		currentText = targetText;
		return this;
	}

	public String out() {
		return new String(currentText);
	}

}
