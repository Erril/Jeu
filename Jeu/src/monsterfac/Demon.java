package monsterfac;

public class Demon extends MonsterRace {

	public Demon(){
		force=130;
		speed=50;
		intel=80;
		agi=70;
		endu=130;
	}
	
	public void afficher(){
		System.out.println("demon");
	}
}
