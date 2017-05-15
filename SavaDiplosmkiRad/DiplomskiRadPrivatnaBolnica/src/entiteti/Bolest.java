package entiteti;

public class Bolest {
	public int BolestID;
	public String NazivBolesti;
	public boolean MogucePruzanjeZdravstvenihUsluga;
	
	public String toString(){
		return NazivBolesti + " ";
	}

	public int getBolestID() {
		return BolestID;
	}

	public void setBolestID(int bolestID) {
		BolestID = bolestID;
	}

	public String getNazivBolesti() {
		return NazivBolesti;
	}

	public void setNazivBolesti(String nazivBolesti) {
		NazivBolesti = nazivBolesti;
	}

	public boolean isMogucePruzanjeZdravstvenihUsluga() {
		return MogucePruzanjeZdravstvenihUsluga;
	}

	public void setMogucePruzanjeZdravstvenihUsluga(boolean mogucePruzanjeZdravstvenihUsluga) {
		MogucePruzanjeZdravstvenihUsluga = mogucePruzanjeZdravstvenihUsluga;
	}
	
	

	
	
	

}
