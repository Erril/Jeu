package monsterfac;

public class WarriorMon extends MonsterClass {

	
	public WarriorMon(){
		force=150;
		speed=90;
		intel=80;
		agi=60;
		endu=120;
		
		provoc=130;
		type="force";
	}
	public void afficher(){
		System.out.println("warrior");
	}
}
