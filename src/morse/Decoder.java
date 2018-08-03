package morse;

public class Decoder {

	public static String decode(String sourceText) {
		return new Decoder(sourceText).morseCodeCiper().sudokuReplaceCipher().keyboardReplaceCipher().railFenceCipher()
				.flashbackCipher().out();
	}

	char[] currentText;

	/**
	 * 
	 */
	public Decoder(String sourceText) {
		super();
		this.currentText = sourceText.toUpperCase().replaceAll("[^.-]", "").toCharArray();
	}

	public Decoder morseCodeCiper() {
		String[] mapper = { ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." };
		char[] targetText = new char[currentText.length / 5];
		for (int i = 0; i < targetText.length; i++) {
			String value = new String(currentText, i * 5, 5);
			for (int v = 0; v < mapper.length; v++) {
				if (mapper[v].equals(value)) {
					targetText[i] = Character.forDigit(v + 1, 10);
				}
			}
		}
		currentText = targetText;
		return this;
	}

	public Decoder sudokuReplaceCipher() {
		int[] mapper = { 21, 22, 23, 31, 32, 33, 41, 42, 43, 51, 52, 53, 61, 62, 63, 71, 72, 73, 74, 81, 82, 83, 91, 92,
				93, 94 };
		char[] targetText = new char[currentText.length / 2];
		for (int i = 0; i < targetText.length; i++) {
			int value = Integer.parseInt(new String(currentText, i * 2, 2));
			for (int v = 0; v < mapper.length; v++) {
				if (mapper[v] == value) {
					targetText[i] = (char) (v + 'A');
				}
			}
		}
		currentText = targetText;
		return this;
	}

	public Decoder keyboardReplaceCipher() {
		String mapper = "QWERTYUIOPASDFGHJKLZXCVBNM";
		char[] targetText = new char[currentText.length];
		for (int i = 0; i < targetText.length; i++) {
			targetText[i] = (char) (mapper.indexOf(currentText[i]) + 'A');
		}
		currentText = targetText;
		return this;
	}

	public Decoder railFenceCipher() {
		int splitPoint = (currentText.length + 1) / 2;
		char[] targetText = new char[currentText.length];
		for (int i = 0; i < targetText.length; i++) {
			if (i % 2 == 0) {
				targetText[i] = currentText[i / 2];
			} else {
				targetText[i] = currentText[i / 2 + splitPoint];
			}
		}
		currentText = targetText;
		return this;
	}

	public Decoder flashbackCipher() {
		char[] targetText = new char[currentText.length];
		for (int i = 0; i < targetText.length; i++) {
			targetText[currentText.length - i - 1] = currentText[i];
		}
		currentText = targetText;
		return this;
	}

	public String out() {
		return new String(currentText);
	}

}
