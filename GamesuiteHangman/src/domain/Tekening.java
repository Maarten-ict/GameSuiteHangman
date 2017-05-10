package domain;

import java.util.ArrayList;

public class Tekening {

	private String naam;
	ArrayList<Vorm> vormen;
	private static final int MIN_X = 0;
	private static final int MAX_X = 399;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 399;

	public Tekening(String naam) {
		setNaam(naam);
		vormen = new ArrayList<>();
	}

	public void voegToe(Vorm vorm) {
		if (vorm == null) {
			throw new DomainException("vorm mag niet leeg zijn");
		}
		if(vormen.contains(vorm)) return;
		if (!valtBinnenTekening(vorm)) {
			throw new DomainException("Vorm moet binnen de tekening vallen.");
		}
		vormen.add(vorm);
	}

	private boolean valtBinnenTekening(Vorm vorm) {
		Omhullende omhullende = vorm.getOmhullende();
		Punt[] grenzenOmhullende = { omhullende.getLinkerBovenhoek(),
				new Punt(omhullende.getLinkerBovenhoek().getX() + omhullende.getBreedte(),
						omhullende.getLinkerBovenhoek().getY()),
				new Punt(omhullende.getLinkerBovenhoek().getX(),
						omhullende.getLinkerBovenhoek().getY() + omhullende.getHoogte()),
				new Punt(omhullende.getLinkerBovenhoek().getX() + omhullende.getBreedte(),
						omhullende.getLinkerBovenhoek().getY() + omhullende.getHoogte()) };
		for (Punt punt : grenzenOmhullende) {
			if (punt.getX() < getMinX() || punt.getX() > getMaxX() || punt.getY() < getMinY()
					|| punt.getY() > getMaxY()) {
				return false;
			}
		}
		return true;
	}

	public Vorm getVorm(int index) {
		return vormen.get(index);
	}

	public int getAantalVormen() {
		return vormen.size();
	}

	public void verwijder(Vorm vorm) {
		boolean ok = true;
		for (int i = 0; i < this.vormen.size() && ok; i++) {
			if (this.vormen.get(i).equals(vorm)) {
				vormen.remove(i);
				ok = false;
			}
		}
	}

	public boolean bevat(Vorm vorm) {
		boolean bevat = false;
		if (vormen.contains(vorm)) {
			bevat = true;
		}
		return bevat;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		boolean gelijk = false;
		if (object instanceof Tekening) {
			Tekening tekening = (Tekening) object;
			if (this.getAantalVormen() == tekening.getAantalVormen() && this.isZelfdeLijst(tekening.getVormen())) {
				gelijk = true;
			}
		}
		
		return gelijk;
	}

	@Override
	public String toString() {
		return "Tekening: " + this.getNaam();
	}

	// TODO: Check if vorm is out of image, then ignore (check tests)
	public boolean isZelfdeLijst(ArrayList<Vorm> vormen) {
		boolean zelfde = true;
		for(Vorm v: vormen){
			if(!(this.vormen.contains(v)) && isZichtbaar(v)){
				zelfde = false;
			}
		}
		for (Vorm v : vormen) {
			if (!(this.vormen.contains(v)) && isZichtbaar(v)) {
				zelfde = false;
			}
		}
		
		return zelfde;
	}
	
	public boolean isZichtbaar(Vorm v){
		if(v.getOmhullende().getMaxX() < MIN_X) return false;
		if(v.getOmhullende().getMinX() > MAX_X) return false;
		if(v.getOmhullende().getMaxY() < MIN_Y) return false;
		if(v.getOmhullende().getMinY() > MAX_Y) return false;
		return true;
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("Naam is niet geldig");
		}
		this.naam = naam;
	}

	public ArrayList<Vorm> getVormen() {
		return vormen;
	}
	

	public static int getMinX() {
		return MIN_X;
	}

	public static int getMaxX() {
		return MAX_X;
	}

	public static int getMinY() {
		return MIN_Y;
	}

	public static int getMaxY() {
		return MAX_Y;
	}

}
