package main;

import monsterfac.*;
import monster.*;

public class Main {
	
	public static void main(String[] args) {
		MonsterFactory fac = new DemonWarriorFac();
		Monster mon = new Monster(fac.creerRace(),fac.creerClasse());
		mon.getClasse().afficher();
		mon.getRace().afficher();
		mon.lvlUp();
		mon.afficherStat();
		//mon.afficherStat();
		
	}

}
