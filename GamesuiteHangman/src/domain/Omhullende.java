package domain;

public class Omhullende extends Vorm{
	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;

	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
		setLinkerBovenhoek(linkerBovenhoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	public void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if (linkerBovenhoek == null) {
			throw new DomainException("Positie links boven mag niet null zijn.");
		}
		this.linkerBovenhoek = linkerBovenhoek;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		if (breedte < 0) {
			throw new DomainException("Breedte mag niet negatief zijn.");
		}
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) {
		if (hoogte < 0) {
			throw new DomainException("Hoogte mag niet negatief zijn.");
		}
		this.hoogte = hoogte;
	}

	public int getMinX() {
		return getLinkerBovenhoek().getX();
	}

	public int getMinY() {
		return getLinkerBovenhoek().getY();
	}

	public int getMaxX() {
		return getLinkerBovenhoek().getX() + getBreedte();
	}

	public int getMaxY() {
		return getLinkerBovenhoek().getY() + getHoogte();
	}

	@Override
	public boolean equals(Object object) {
		Omhullende omhullende = (Omhullende) object;
		if (omhullende == null) {
			return false;
		} else if (omhullende.getLinkerBovenhoek().equals(this.getLinkerBovenhoek())
				&& omhullende.getBreedte() == this.getBreedte() && omhullende.getHoogte() == this.getHoogte()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Omhullende: " + getLinkerBovenhoek().toString() + " - " + getBreedte() + " - " + getHoogte();
	}

	@Override
	public Omhullende getOmhullende() {
		Omhullende omhullende = new Omhullende(getLinkerBovenhoek(), getBreedte(), getHoogte());
		return omhullende;
	}

}
