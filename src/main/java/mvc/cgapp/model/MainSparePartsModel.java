package mvc.cgapp.model;

public class MainSparePartsModel {

	private int mspid;
	
	private String mspname;

	public int getMspid() {
		return mspid;
	}

	public void setMspid(int mspid) {
		this.mspid = mspid;
	}

	public String getMspname() {
		return mspname;
	}

	public void setMspname(String mspname) {
		this.mspname = mspname;
	}

	@Override
	public String toString() {
		return "MainSparePartsModel [mspid=" + mspid + ", mspname=" + mspname + "]";
	}

}
