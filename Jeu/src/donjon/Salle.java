package donjon;

public abstract class Salle {
	protected boolean[] acces;
	protected int x;
	protected int y;
	protected int xPere;
	protected int yPere;
	protected int rang;
	
	
	public Salle(){
		acces= new boolean[4];
		acces[0]=false;
		acces[1]=false;
		acces[2]=false;
		acces[3]=false;
		rang=0;
	}
	public Salle(int x,int y){
		acces= new boolean[4];
		acces[0]=false;
		acces[1]=false;
		acces[2]=false;
		acces[3]=false;
		this.x=x;
		this.y=y;
		xPere=x;
		yPere=y;	
		rang=0;
	}
	public boolean equals(Salle s){
		return (x==s.getX() && y==s.getY());
	}
	
	/*         haut
	 *          0
	 * gauche=3   1 = droite
	 *          2
	 *         bas   
	 * 
	 * */
	public boolean getAcces(int i){
		if (i<4 && i>=0){
			return acces[i];
		}
		return false;
	}
	public boolean getAccesH(){
		return acces[0];
	}
	public boolean getAccesD(){
		return acces[1];
	}
	public boolean getAccesB(){
		return acces[2];
	}
	public boolean getAccesG(){
		return acces[3];
	}
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	public void ouvrirHaut(){
		acces[0]=true;
	}
	public void ouvrirDroite(){
		acces[1]=true;
	}
	public void ouvrirBas(){
		acces[2]=true;
	}
	public void ouvrirGauche(){
		acces[3]=true;
	}
	public int getxPere() {
		return xPere;
	}
	public void setxPere(int xPere) {
		this.xPere = xPere;
	}
	public void setPeres(Salle sal) {
		this.xPere = sal.getX();
		this.yPere = sal.getY();
	}
	public int getyPere() {
		return yPere;
	}
	public void setyPere(int yPere) {
		this.yPere = yPere;
	}
	public boolean[] getAcces() {
		return acces;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
