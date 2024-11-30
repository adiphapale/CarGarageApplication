package mvc.cgapp.model;

public class MainServiceModel {

	private int msid;
	private String msname;
	public int getMsid() {
		return msid;
	}
	public void setMsid(int msid) {
		this.msid = msid;
	}
	public String getMsname() {
		return msname;
	}
	public void setMsname(String msname) {
		this.msname = msname;
	}
	@Override
	public String toString() {
		return "MainService [msid=" + msid + ", msname=" + msname + "]";
	}
}
