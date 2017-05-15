package entiteti;

public class Lek {
	public int LekID;
	public int ProizvodjacID;
	public String NazivLeka;
	public String Jacina;
	
	public String toString(){
		return NazivLeka + " ";
	}
	
	public int getLekID() {
		return LekID;
	}
	public void setLekID(int lekID) {
		LekID = lekID;
	}
	
	public int getProizvodjacID() {
		return ProizvodjacID;
	}
	public void setProizvodjacID(int proizvodjacID) {
		ProizvodjacID = proizvodjacID;
	}
	public String getNazivLeka() {
		return NazivLeka;
	}
	public void setNazivLeka(String nazivLeka) {
		NazivLeka = nazivLeka;
	}
	public String getJacina() {
		return Jacina;
	}
	public void setJacina(String jacina) {
		Jacina = jacina;
	}
	
	
}
