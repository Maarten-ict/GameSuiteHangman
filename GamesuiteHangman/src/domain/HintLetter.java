package domain;

public class HintLetter {
	private char letter;
	private boolean geraden;

	public HintLetter(char c) {
		this.letter = c;
		geraden = false;
	}

	public boolean raad(char c) {
		Character geradenChar = (Character) c;
		if (geraden){
			return false;
		}
		if (geradenChar.equals(getLetter())) {
			this.geraden = true;
			return true;
		} else if (geradenChar.equals(Character.toLowerCase(getLetter()))
				|| geradenChar.equals(Character.toUpperCase(getLetter()))) {
			this.geraden = true;
			return true;
		}
		return false;
	}

	public char toChar() {
		if (isGeraden()) {
			return letter;
		} else {
			return '_';
		}
	}

	public char getLetter() {
		return this.letter;
	}

	public boolean isGeraden() {
		return this.geraden;
	}

}
