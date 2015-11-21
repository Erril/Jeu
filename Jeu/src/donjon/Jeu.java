package donjon;

public class Jeu {

	private Dungeon donj;
	private Salle salleCourante;
	
	public Jeu (int n){
		donj = new Dungeon(n);
		salleCourante = donj.getSalleAt(0 , 0);
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
	
}
