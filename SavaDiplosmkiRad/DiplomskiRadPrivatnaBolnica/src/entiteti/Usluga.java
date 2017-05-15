package entiteti;

public class Usluga {
	public int UslugaID;
	public String NazivUsluge;
	public double CenaUsluge;
	
	public String toString(){
		return NazivUsluge + " ";
	}
	
	public int getUslugaID() {
		return UslugaID;
	}
	public void setUslugaID(int uslugaID) {
		UslugaID = uslugaID;
	}
	public String getNazivUsluge() {
		return NazivUsluge;
	}
	public void setNazivUsluge(String nazivUsluge) {
		NazivUsluge = nazivUsluge;
	}
	public double getCenaUsluge() {
		return CenaUsluge;
	}
	public void setCenaUsluge(double cenaUsluge) {
		CenaUsluge = cenaUsluge;
	}
	
	
}
