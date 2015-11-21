package perso;

import java.util.ArrayList;
import java.util.Random;


public class Groupe {
	private ArrayList<Perso> groupe; 
	private ArrayList<Perso> groupeAble;
	private double provocGlob;
	
	public Groupe(){
		groupe=new ArrayList<Perso>();
		groupeAble=new ArrayList<Perso>();
		provocGlob=0;
	}
	
	public void ajouterMembre(Perso p){
		ajoutVitesse(p,groupe);
		ajoutVitesse(p,groupeAble);
		provocGlob+=p.getProvoc();
	}
	
	public void supprimerMembre(Perso p){
		groupe.remove(p);
		groupeAble.remove(p);
		provocGlob-=p.getProvoc();
	}
	public void membreKO(Perso p){		
		groupeAble.remove(p);
		provocGlob-=p.getProvoc();
	}
	/* provocGlob= 200
	 * x=120
	 * groupe provoc = 50|60|40|50
	 * res=le troisieme perso car la somme des deux premier ne fait que 110 et en ajoutant le 3 eme on obtient 150>120
	 */
	public Perso designerCible(){
		Random rand = new Random();
		int  x = rand.nextInt((int)provocGlob);
		boolean trouve =false;
		double cpt=0;
		Perso res=groupe.get(0);
		for(Perso pers : groupeAble){
			cpt+=pers.getProvoc();
			if(cpt>x && !trouve){
				res=pers;
				trouve=true;
			}
		}
		return res;
	}
	
	public void prendreDegat(double deg){
		Perso pers=designerCible();
		pers.prendreDegat(deg);
		if (!pers.isVivant()){
			membreKO(pers);
		}
	}
	
	/*
	 * ajoute dans un arraylist trier en fonction de la vitesse (O(n))
	 */
	
	public void ajoutVitesse(Perso p, ArrayList<Perso> groupie){
		if(groupie.isEmpty()){//array vide => ajout simple
			groupie.add(p);
		}
		else{
			int cpt =0;
			while(groupie.get(cpt).getSpeed()>p.getSpeed() && cpt<groupie.size()){
				cpt++;//trouver la position de de l'element
			}
			if (cpt<groupie.size()){//si ce n'est pas le dernier
				groupie.add(cpt,p);
			}
			else{//si c'est le dernier on l'ajoute a la fin (exception si cpt=size())
				groupie.add(p);
			}
		}	
	}
	
}
