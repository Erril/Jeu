package monster;

import monsterfac.*;

public class Monster {
	private MonsterRace race;
	private MonsterClass classe;
	private int lvl;
	private double pvMax;
	private double pvCourant;
	private double speed;
	private double intel;
	private double agi;
	private double force;
	private double endu;
	private double provoc;
	private boolean vivant;
	
	
	
	public Monster(MonsterRace racee,MonsterClass classee){
		race=racee;
		classe=classee;
		lvl=1;
		pvMax=100;
		pvCourant=100;
		speed=10;
		intel=10;
		agi=10;
		force=10;
		endu=10;
		provoc=10;
		vivant=true;
	}
	public void setMultClass(){
		speed=(classe.getSpeed()*speed/100);
		force=(classe.getForce()*force/100);
		intel=(classe.getIntel()*intel/100);
		endu=(classe.getEndu()*endu/100);
		agi=(classe.getAgi()*agi/100);
		provoc=(classe.getProvoc()*provoc/100);
		
	}
	
	public void setMultRace(){
		speed=(race.getSpeed()*speed/100);
		force=(race.getForce()*force/100);
		intel=(race.getIntel()*intel/100);
		endu=(race.getEndu()*endu/100);
		agi=(race.getAgi()*agi/100);
	}
	
	public void setMult(){
		setMultClass();
		setMultRace();
		pvMax+=(endu*2);
		pvCourant=pvMax;
	}
	
	public void afficherStat(){
		System.out.println("lvl "+lvl);
		System.out.println(speed+" speed");
		System.out.println(force+" force");
		System.out.println(intel+" intel");
		System.out.println(endu+" endu");
		System.out.println(agi+" agi");
		System.out.println(provoc+" provoc");
		System.out.println(pvCourant+"/"+pvMax+"pv");
	}
	
	public void prendreDegat(double deg){
		pvCourant-=deg;
		if(pvCourant<=0){
			pvCourant=0;
			vivant=false;
		}
	}
	public void etreSoigner(double soin){
		pvCourant+=soin;
		if(pvCourant>=pvMax){
			pvCourant=pvMax;
		}
	}
	public double degatInfliger(){
		String stat=classe.getType();
		double base=0;
		if(stat=="intel"){
			base=intel;
		}
		else if(stat=="agi"){
			base=agi;
		}
		else if(stat=="force"){
			base=force;
		}
		return base;
	}
	
	public int getLvl() {
		return lvl;
	}
	public void lvlUp(){
		setLvl(lvl+1);
	}
	public void setLvl(int lvl) {
		
		agi=10+(lvl-this.lvl);
		intel=10+(lvl-this.lvl);
		force=10+(lvl-this.lvl);
		endu=10+(lvl-this.lvl);
		speed=10+(lvl-this.lvl);
		this.lvl = lvl;
		setMult();
	}

	public double getPvCourant() {
		return pvCourant;
	}

	public void setPvCourant(int pvCourant) {
		this.pvCourant = pvCourant;
	}

	public boolean isVivant() {
		return vivant;
	}

	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}

	public double getPvMax() {
		return pvMax;
	}

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
	public double getProvoc(){
		return provoc;
	}
	public MonsterRace getRace() {
		return race;
	}

	public MonsterClass getClasse() {
		return classe;
	}
}
