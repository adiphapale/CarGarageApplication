package mvc.cgapp.model;

public class SubServicesModel {

	private int ssid;
	private String ssname;
	private float ssprice;
	private int msid;
	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}
	public String getSsname() {
		return ssname;
	}
	public void setSsname(String ssname) {
		this.ssname = ssname;
	}
	public float getSsprice() {
		return ssprice;
	}
	public void setSsprice(float ssprice) {
		this.ssprice = ssprice;
	}
	public int getMsid() {
		return msid;
	}
	public void setMsid(int msid) {
		this.msid = msid;
	}
	@Override
	public String toString() {
		return "SubServicesModel [ssid=" + ssid + ", ssname=" + ssname + ", ssprice=" + ssprice + ", msid=" + msid
				+ "]";
	}
	
	
}
