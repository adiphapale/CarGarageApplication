package mvc.cgapp.model;

public class SubSparePartsModel {

	private int spid;
	private String spname;
	private float spprice;
	private int mspid;
	
	
	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public float getSpprice() {
		return spprice;
	}
	public void setSpprice(float spprice) {
		this.spprice = spprice;
	}
	public int getMspid() {
		return mspid;
	}
	public void setMspid(int mspid) {
		this.mspid = mspid;
	}
	@Override
	public String toString() {
		return "SubSparePartsModel [spid=" + spid + ", spname=" + spname + ", spprice=" + spprice + ", mspid=" + mspid
				+ "]";
	}
}
