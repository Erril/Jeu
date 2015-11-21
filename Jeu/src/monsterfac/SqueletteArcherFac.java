package monsterfac;

public class SqueletteArcherFac implements MonsterFactory {

	public MonsterRace creerRace(){
		return new Squelette();
	}
	
	public MonsterClass creerClasse(){
		return new ArcherMon();
	}
}
