package persofac;

public class PretrePerso extends PersoClass {

	public PretrePerso(){
		//500 points partager
		force=100;
		speed=100;
		intel=150;
		agi=80;
		endu=70;
		
		
		provoc=60;
		type="intel";
	}
	
	public void afficher(){
		System.out.println("archer");
	}
}
