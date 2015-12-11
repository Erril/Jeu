package donjon;

import java.util.Random;
import java.util.Stack;


public class Dungeon {

	private Salle[][] donj;
	private int taille;
	private int nbSallesVides;
	private int nbMalusBonus;
	private int nbEntree;
	private int nbSortie;
	
	public Dungeon(int n){
		taille=n;
		nbSallesVides = n*n/2;
		nbMalusBonus = (n*n/2)-2;
		nbEntree=1;
		nbSortie=1;
		donj = new Salle[n][n];
		Stack<Salle> stack=new Stack<Salle>();
		for (int k=0;k<16;k++){
			stack.push(creaSalleRandom());
		}
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				
				donj[i][j] = stack.pop();
				donj[i][j].setCoord(i, j);;
			}
		}
		
	}
	public Salle creaSalleRandom(){
		Random rand = new Random();
		int  type = rand.nextInt(5);
		Salle res=new SalleVide();
		boolean fin= false;
		while (!fin){
			switch(type){
				case 0:	if(nbEntree>0){
							res = new Entree();
							fin=true;
							nbEntree--;
						}
						break;
				case 1:	if(nbSortie>0){
							res = new Sortie();
							fin=true;
							nbSortie--;
						}
						break;
				case 2:	if(nbMalusBonus>0){
							res = new SallePiege();
							fin=true;
							nbMalusBonus--;
						}
						break;
				case 3:	if(nbMalusBonus>0){
							res = new SalleBonus();
							fin=true;
							nbMalusBonus--;
						}
						break;
				case 4:	if(nbSallesVides>0){
							fin=true;
							nbSallesVides--;
						}			
						break;
						
			}
			type = rand.nextInt(5);
		}
		return res;
	}
	
	public Salle getSalleAt(int x,int y){
		return donj[x][y];
	}
	public Salle classe(int x, int y){
		Salle test=donj[x][y];
		if (test.getxPere()==x && test.getyPere()==y){
			return test;
		}
		else{
			return classe(test.getxPere(),test.getyPere());
		}	
	}
	public Salle classe(Salle s){
		
		if (s.getxPere()==s.getX() && s.getyPere()==s.getY()){
			return s;
		}
		else{
			return classe(s.getxPere(),s.getyPere());
		}	
	}
	public boolean union(int x, int y,int x2, int y2){
		Salle racine=classe(x,y);
		Salle fils=classe(x2,y2);
		if(fils!=racine){
			
			if (racine.getRang()>fils.getRang()){
				fils.setPeres(racine);
			}
			else if (racine.getRang()<fils.getRang()){
				racine.setPeres(fils);
			}
			else{
				racine.setRang(racine.getRang()+1);
				fils.setPeres(racine);
			}
			return true;
		}
		return false;
	}
	public boolean union(Salle s1, Salle s2){
		Salle racine=classe(s1);
		Salle fils=classe(s2);
		if(fils!=racine){
			
			if (racine.getRang()>fils.getRang()){
				fils.setPeres(racine);
			}
			else if (racine.getRang()<fils.getRang()){
				racine.setPeres(fils);
			}
			else{
				racine.setRang(racine.getRang()+1);
				fils.setPeres(racine);
			}
			return true;
		}
		return false;
	}
	public int getTaille() {
		return taille;
	}
	public void afficherDonj(){
		for(int i=0; i<taille;i++ ){
			for(int j=0 ; j < taille ; j++){
				System.out.print(donj[i][j].getX() + "," + donj[i][j].getY()+" ");
			}
			System.out.println();
		}	
	}
	public void afficherDonjPere(){
		for(int i=0; i<taille;i++ ){
			for(int j=0 ; j < taille ; j++){
				System.out.print(donj[i][j].getxPere() + "," + donj[i][j].getyPere()+" ");
			}
			System.out.println();
		}	
	}
	public void afficherDonjClasse(){
		Salle classe;
		for(int i=0; i<taille;i++ ){
			for(int j=0 ; j < taille ; j++){
				classe=classe(donj[i][j]);
				System.out.print(classe.getX() + "," + classe.getY()+" ");
			}
			System.out.println();
		}	
	}
	public void afficherDonjLienDroit(){

		for(int i=0; i<taille;i++ ){
			for(int j=0 ; j < taille ; j++){
				System.out.print(donj[i][j].getAcces()[1]+" ");
			}
			System.out.println();
		}	
	}
	public void afficherType(){

		for(int i=0; i<taille;i++ ){
			for(int j=0 ; j < taille ; j++){
				donj[i][j].nom();
			}
			System.out.println();
		}	
	}
	public void afficherDonjLienBas(){

		for(int i=0; i<taille;i++ ){
			for(int j=0 ; j < taille ; j++){
				System.out.print(donj[i][j].getAcces()[2]+" ");
			}
			System.out.println();
		}	
	}
	public void afficherDonjLienHaut(){

		for(int i=0; i<taille;i++ ){
			for(int j=0 ; j < taille ; j++){
				System.out.print(donj[i][j].getAcces()[0]+" ");
			}
			System.out.println();
		}	
	}
	public int ouvrirAlea(){
		Random rand = new Random();
		int  x = rand.nextInt(taille);
		int  y = rand.nextInt(taille);
		int  bias;
		int res=0;
		if (x==0){
			if(y==0){
				bias = rand.nextInt(2)+1;				
			}
			else if (y==taille-1){
				bias = rand.nextInt(2)+2;
			}
			else{
				bias = rand.nextInt(3)+1;
			}
		}
		else if (x==taille-1){
			if(y==0){
				bias = rand.nextInt(2);
			}
			else if (y==taille-1){
				bias = (rand.nextInt(2)+3)%4;
			}
			else{
				bias = (rand.nextInt(3)+3)%4;
			}
		}
		else if (y==0){
			bias = rand.nextInt(3);	
		}
		else if(y==taille-1){
			bias = (rand.nextInt(3)+2)%4;
		}
		else{
			bias = rand.nextInt(4);
		}  

		switch(bias){
			case 0:	if(union (x,y,x-1,y)){
						donj[x][y].ouvrirHaut();
						donj[x-1][y].ouvrirBas();
						res=1;
					}
					break;
			case 1:	if(union (x,y,x,y+1)){
						donj[x][y].ouvrirDroite();
						donj[x][y+1].ouvrirGauche();
						res=1;
					}
					break;
			case 2:	if(union (x,y,x+1,y)){
						donj[x][y].ouvrirBas();
						donj[x+1][y].ouvrirHaut();
						res=1;
					}
					break;
			case 3:	if(union (x,y,x,y-1)){
						donj[x][y].ouvrirGauche();
						donj[x][y-1].ouvrirDroite();
						res=1;
					}
					break;
					
		}
		
		return res;
		
	}
	public void creerLaby(){
		int cpt=0;
		while(cpt<taille*taille-1){
			cpt+=ouvrirAlea();
		}
	}

	public void dessinerDonj(){
		
		
		
		for(int i=0; i<taille;i++ ){
			System.out.println();
			for(int k=0 ; k < taille ; k++){
				if (donj[i][k].getAcces()[0]){
					System.out.print("- -   - -");
				}
				else{
					System.out.print("- - - - -");
				}
					
			}
			System.out.println();
			for(int k=0 ; k < taille ; k++){			
				System.out.print("-       -");	
			}
			System.out.println();
			for(int j=0 ; j < taille ; j++){		
				if (donj[i][j].getAcces()[1] && donj[i][j].getAcces()[3]){
					System.out.print("         ");
				}
				else if(donj[i][j].getAcces()[1]){
					System.out.print("-        ");
				}
				else if(donj[i][j].getAcces()[3]){
					System.out.print("        -");
				}
				else{
					System.out.print("-       -");
				}
					
			}
			
			System.out.println();
			for(int k=0 ; k < taille ; k++){			
					System.out.print("-       -");	
			}
			System.out.println();
			for(int k=0 ; k < taille ; k++){			
				if (donj[i][k].getAcces()[2]){
					System.out.print("- -   - -");
				}
				else{
					System.out.print("- - - - -");
				}	
			}
			
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		Dungeon d = new Dungeon(4);
		//d.afficherDonj();
		d.creerLaby();
		//d.union(0, 1, 0, 0);
		//d.union(0, 1, 2, 2);
		//d.union(3, 3, 2, 2);
		d.afficherType();
		d.dessinerDonj();
		//d.afficherDonjLienDroit();
		System.out.println();
		//d.afficherDonjLienBas();
		
	}

	
}
