package monsterfac;

public class DemonWarriorFac implements MonsterFactory {
	
	public MonsterRace creerRace(){
		return new Demon();
	}
	
	public MonsterClass creerClasse(){
		return new WarriorMon();
	}
}
