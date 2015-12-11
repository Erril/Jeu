package donjon;

public class SalleVide extends Salle {
	public SalleVide(int x,int y){
		super(x,y);
	}
	public SalleVide(){
		super();
	}
	public void nom() {
		System.out.print("vide ");
	}
}
