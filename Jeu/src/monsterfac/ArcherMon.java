package monsterfac;

public class ArcherMon extends MonsterClass {
	
	public ArcherMon(){
		force=60;
		speed=120;
		intel=80;
		agi=160;
		endu=80;
		
		provoc=80;
		type="agi";
	}
	
	public void afficher(){
		System.out.println("archer");
	}
}
