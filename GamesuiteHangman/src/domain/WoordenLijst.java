package domain;

import java.util.ArrayList;
import java.util.Random;

public class WoordenLijst {
	ArrayList<String> woorden;
	
	public WoordenLijst(){
		woorden = new ArrayList<String>();
	}
	
	public int getAantalWoorden(){
		return woorden.size();
	}
	
	public void voegToe(String woord){
		if(woord==null||woord.trim().equals("")) throw new DomainException("Woord mag niet leeg zijn");
		if(woorden.contains(woord)) throw new DomainException("Dit woord zit al in de lijst.");
		woorden.add(woord);
	}
	
	public String getRandomWoord(){
		Random r = new Random();
		return woorden.get(r.nextInt(woorden.size()));
	}
}
