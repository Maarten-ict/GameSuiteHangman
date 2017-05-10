package domain;

import java.util.ArrayList;

public class Driehoek extends Vorm {
	private Punt punt1;
	private Punt punt2;
	private Punt punt3;

	public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
		setHoekpunten(punt1, punt2, punt3);
	}

	public void setHoekpunten(Punt punt1, Punt punt2, Punt punt3) {
		if (punt1 == null || punt2 == null || punt3 == null)
			throw new DomainException("De 3 punten mogen niet leeg zijn.");
		this.punt1 = punt1;
		this.punt2 = punt2;
		this.punt3 = punt3;
	}

	public Punt getHoekPunt1() {
		return this.punt1;
	}

	public Punt getHoekPunt2() {
		return this.punt2;
	}

	public Punt getHoekPunt3() {
		return this.punt3;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (!(object instanceof Driehoek))
			return false;
		Driehoek driehoek = (Driehoek) object;
		ArrayList<Punt> punten = new ArrayList<Punt>();
		punten.add(getHoekPunt1());
		punten.add(getHoekPunt2());
		punten.add(getHoekPunt3());
		return punten.contains(driehoek.getHoekPunt1()) && punten.contains(driehoek.getHoekPunt2())
				&& punten.contains(driehoek.getHoekPunt3());
	}

	@Override
	public String toString() {
		return "Driehoek: hoekpunt1: " + punt1.toString() + " - hoekpunt2: " + punt2.toString() + " - hoekpunt3: "
				+ punt3.toString() + " - " + getOmhullende().toString();
	}

	@Override
	public Omhullende getOmhullende() {
		int minY = minimum(punt1.getY(), punt2.getY(), punt3.getY());
		int minX = minimum(punt1.getX(), punt2.getX(), punt3.getX());
		int maxY = maximum(punt1.getY(), punt2.getY(), punt3.getY());
		int maxX = maximum(punt1.getX(), punt2.getX(), punt3.getX());
		int breedte = maxX - minX;
		int hoogte = maxY - minY;
		Omhullende omhullende = new Omhullende(new Punt(minX, minY), breedte, hoogte);
		return omhullende;

	}

	private int minimum(int waarde1, int waarde2, int waarde3) {
		int min = waarde1;
		if (waarde2 < min) {
			min = waarde2;
		}
		if (waarde3 < min) {
			min = waarde3;
		}
		return min;
	}

	private int maximum(int waarde1, int waarde2, int waarde3) {
		int max = waarde1;
		if (waarde2 > max) {
			max = waarde2;
		}
		if (waarde3 > max) {
			max = waarde3;
		}
		return max;
	}

}
