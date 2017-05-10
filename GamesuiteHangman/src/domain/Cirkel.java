package domain;

public class Cirkel extends Vorm {
	private int radius;
	private Punt middelpunt;

	public Cirkel(Punt middelpunt, int radius) {
		setMiddelpunt(middelpunt);
		setRadius(radius);
	}

	public void setMiddelpunt(Punt middelpunt) {
		if (middelpunt == null)
			throw new DomainException("Middelpunt mag niet leeg zijn.");
		this.middelpunt = middelpunt;
	}

	private void setRadius(int radius) {
		if (radius <= 0)
			throw new DomainException("Radius moet groter dan 0 zijn.");
		this.radius = radius;
	}

	public Punt getMiddelpunt() {
		return this.middelpunt;
	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (!(object instanceof Cirkel))
			return false;
		Cirkel cirkel = (Cirkel) object;
		return this.radius == cirkel.getRadius() && this.getMiddelpunt() == cirkel.getMiddelpunt();
	}

	@Override
	public String toString() {
		return "Cirkel: middelpunt: " + getMiddelpunt().toString() + " - straal: " + radius + " - "
				+ getOmhullende().toString();
	}

	@Override
	public Omhullende getOmhullende() {
		int minX = middelpunt.getX() - radius;
		int minY = middelpunt.getY() - radius;
		int breedte = radius * 2;
		int hoogte = radius * 2;
		Omhullende omhullende = new Omhullende(new Punt(minX, minY), breedte, hoogte);
		return omhullende;
	}
}
