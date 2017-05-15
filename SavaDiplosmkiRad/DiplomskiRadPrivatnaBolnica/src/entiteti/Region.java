package entiteti;

public class Region {

	public int RegionID;
	public String NazivRegiona;
	
	public String toString(){
		return NazivRegiona + " ";
	}
	
	public int getRegionID() {
		return RegionID;
	}
	public void setRegionID(int regionID) {
		RegionID = regionID;
	}
	public String getNazivRegiona() {
		return NazivRegiona;
	}
	public void setNazivRegiona(String nazivRegiona) {
		NazivRegiona = nazivRegiona;
	}
	
	
}

