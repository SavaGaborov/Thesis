package entiteti;

public class Proizvodjac {
	
	public int ProizvodjacID;
	public String NazivProizvodjaca;
	
	public String toString(){
		return NazivProizvodjaca + " ";
	}
	
	public int getProizvodjac_ID() {
		return ProizvodjacID;
	}
	public void setProizvodjacID(int proizvodjacID) {
		ProizvodjacID = proizvodjacID;
	}
	public String getNazivProizvodjaca() {
		return NazivProizvodjaca;
	}
	public void setNazivProizvodjaca(String nazivProizvodjaca) {
		NazivProizvodjaca = nazivProizvodjaca;
	}
	
	

}
