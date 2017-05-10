package domain;

public class LijnStuk extends Vorm {
	private Punt StartPunt;
	private Punt EindPunt;

	public LijnStuk(Punt startPunt, Punt eindPunt) {
		if (startPunt == null || eindPunt == null) {
			throw new DomainException("Startpunt en eindpunt mogen niet null zijn.");
		}
		setStartEnEindPunt(startPunt, eindPunt);
	}

	public Punt getStartPunt() {
		return StartPunt;
	}

	public Punt getEindPunt() {
		return EindPunt;
	}

	public void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
		this.StartPunt = startPunt;
		this.EindPunt = eindPunt;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if(!(object instanceof LijnStuk)){
			return false;
		}
		LijnStuk lijnstuk = (LijnStuk) object;
		if(lijnstuk.getStartPunt().equals(this.getStartPunt())
				&& lijnstuk.getEindPunt().equals(this.getEindPunt())) {
			return true;
		}
		if(lijnstuk.getStartPunt().equals(this.getEindPunt())
				&& lijnstuk.getEindPunt().equals(this.getStartPunt())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Lijn: startpunt: " + getStartPunt().toString() + " - eindpunt: " + getEindPunt().toString() + " - " + getOmhullende().toString() ;
	}

	@Override
	public Omhullende getOmhullende() {
		int hoogte;
		int minY;
		int breedte;
		int minX;
		
		if (getStartPunt().getY() == getEindPunt().getY() && getStartPunt().getX() == getEindPunt().getX()) {
			return null;
		}
		
		if (getStartPunt().getY() < getEindPunt().getY()) {
			minY = getStartPunt().getY();
			hoogte = getEindPunt().getY() - getStartPunt().getY();
		} else {
			minY = getEindPunt().getY();
			hoogte = getStartPunt().getY() - getEindPunt().getY();
		}
		
		if (getStartPunt().getX() < getEindPunt().getX()) {
			minX = getStartPunt().getX();
			breedte = getEindPunt().getX() - getStartPunt().getX();
		} else {
			minX = getEindPunt().getX();
			breedte = getStartPunt().getX() - getEindPunt().getX();
		}

		Omhullende omhullende = new Omhullende(new Punt(minX, minY), breedte, hoogte);
		return omhullende;
	}

}
