package persofac;

public abstract class PersoClass {
	
	protected double speed;
	protected double intel;
	protected double agi;
	protected double force;
	protected double endu;
	protected double provoc;
	protected String type;
	
	public double getSpeed() {
		return speed;
	}
	public double getProvoc() {
		return provoc;
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
