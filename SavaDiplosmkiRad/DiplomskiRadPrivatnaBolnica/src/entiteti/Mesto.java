package entiteti;

public class Mesto {

	public int PTT;
	public String NazivMesta;
	public int RegionID;
		
	public String toString()
	{
		return  NazivMesta + "";
	}
	
	
	
	public int getPTT() {
		return PTT;
	}
	public void setPTT(int pTT) {
		PTT = pTT;
	}
	public String getNazivMesta() {
		return NazivMesta;
	}
	public void setNazivMesta(String nazivMesta) {
		NazivMesta = nazivMesta;
	}

	public int getRegionID() {
		return RegionID;
	}

	public void setRegionID(int regionID) {
		RegionID = regionID;
	}
	
	
}
