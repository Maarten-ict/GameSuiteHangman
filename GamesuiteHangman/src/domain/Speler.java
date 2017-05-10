package domain;

public class Speler {
	private String naam;
	private int score;

	public Speler(String naam) {
		super();
		setNaam(naam);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (naam == null || naam.isEmpty()){
			throw new DomainException("Naam mag niet null zijn.");
		}
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addToScore(int positiveScore) {
		if (positiveScore < 0 && positiveScore + getScore() < 0 ){
			throw new DomainException("Totale score mag niet negatief zijn.");
		}			
		setScore(getScore() + positiveScore);
	}

	@Override
	public boolean equals(Object object) {
		Speler speler = (Speler) object;
		if (speler == null) {
			return false;
		} else if (speler.getNaam().equals(this.getNaam()) && speler.getScore() == this.getScore()) {
			return true;
		}
		return false;
	}

}
