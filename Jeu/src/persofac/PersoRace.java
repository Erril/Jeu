package persofac;

public abstract class PersoRace {
	
	protected double speed;
	protected double intel;
	protected double agi;
	protected double force;
	protected double endu;
	protected String type;
	
	public double getSpeed() {
		return speed;
	}

	public double getIntel() {
		return intel;
	}
	public double getAgi() {
		return agi;
	}
	public double getForce() {
		return force;
	}
	public double getEndu() {
		return endu;
	}
	public String getType(){
		return type;
	}
	public void afficher(){}

}