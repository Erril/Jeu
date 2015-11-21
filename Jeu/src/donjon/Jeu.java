package donjon;

import java.util.Random;

public class Jeu {

	private Dungeon donj;
	private Salle salleCourante;
	private Salle sortie;
	
	public Jeu (int n){
		Random rand = new Random();
		int x = rand.nextInt(n);
		int y = rand.nextInt(n);
		donj = new Dungeon(n);
		salleCourante = donj.getSalleAt(x , y);
		int  xs = rand.nextInt(n);
		int  ys = rand.nextInt(n);
		while(xs == x && ys==y){
			xs = rand.nextInt(n);
			ys = rand.nextInt(n);
		}
		sortie= donj.getSalleAt(xs , ys);
	}
	
	public void deplacement(int depl){
		switch(depl){
		case 0:	if(salleCourante.getAccesH()){
					salleCourante = donj.getSalleAt(salleCourante.getX()-1 , salleCourante.getY());
				}
				break;
		case 1:	if(salleCourante.getAccesD()){
					salleCourante = donj.getSalleAt(salleCourante.getX() , salleCourante.getY()+1);
				}
				break;
		case 2:	if(salleCourante.getAccesB()){
					salleCourante = donj.getSalleAt(salleCourante.getX()+1 , salleCourante.getY());
				}
				break;
		case 3:	if(salleCourante.getAccesG()){
					salleCourante = donj.getSalleAt(salleCourante.getX() , salleCourante.getY()-1);
				}
				break;		
		}
	}
	
	public boolean accesSortie(){
		return sortie.equals(salleCourante);
	}
	
}
