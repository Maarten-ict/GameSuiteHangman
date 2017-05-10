package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rechthoek extends Vorm implements Drawable {
	private int breedte;
	private int hoogte;
	private Punt linkerBovenhoek;

	public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte) {
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(linkerbovenhoek);
	}

	@Override
	public boolean equals(Object o) {
		boolean gelijk = false;
		if (o instanceof Rechthoek) {
			Rechthoek rechthoek = (Rechthoek) o;
			if (this.getBreedte() == rechthoek.getBreedte() && this.getHoogte() == rechthoek.getHoogte()
					&& this.getLinkerBovenhoek() == rechthoek.getLinkerBovenhoek()) {
				gelijk = true;
			}
		}
		return gelijk;
	}

	@Override
	public String toString() {
		return "Rechthoek: positie: " + getLinkerBovenhoek().toString() + " - breedte: " + getBreedte() + " - hoogte: "
				+ getHoogte() + " - " + getOmhullende().toString();
	}

	@Override
	public Omhullende getOmhullende() {
		Omhullende omhullende = new Omhullende(getLinkerBovenhoek(), getBreedte(), getHoogte());
		return omhullende;
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	public void setLinkerBovenhoek(Punt hoek) {
		if (hoek == null) {
			throw new DomainException("hoek mag niet null zijn");
		}
		this.linkerBovenhoek = hoek;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		if (breedte <= 0) {
			throw new DomainException("breedte mag niet kleiner dan 0 zijn");
		}
		this.breedte = breedte;

	}

	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) {
		if (hoogte <= 0) {
			throw new DomainException("hoogte mag niet kleiner dan 0 zijn");
		}
		this.hoogte = hoogte;
	}

	@Override
	public void teken(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
		
		Rechthoek rechthoek = new Rechthoek(this.getLinkerBovenhoek(), this.getBreedte(), this.getHoogte());
		graphics.drawRect(rechthoek.getLinkerBovenhoek().getX(), rechthoek
				.getLinkerBovenhoek().getY(), rechthoek.getBreedte(), rechthoek
				.getHoogte());
	}

}
