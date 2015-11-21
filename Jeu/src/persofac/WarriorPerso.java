package persofac;

public class WarriorPerso extends PersoClass {

	public WarriorPerso(){
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
