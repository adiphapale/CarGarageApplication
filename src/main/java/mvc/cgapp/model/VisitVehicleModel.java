package mvc.cgapp.model;

public class VisitVehicleModel {

	private int visitVid;
	private long visitVrun;
	private String visitVentryDate;
	private int tid;
	public int getVisitVid() {
		return visitVid;
	}
	public void setVisitVid(int visitVid) {
		this.visitVid = visitVid;
	}
	public long getVisitVrun() {
		return visitVrun;
	}
	public void setVisitVrun(long visitVrun) {
		this.visitVrun = visitVrun;
	}
	public String getVisitVentryDate() {
		return visitVentryDate;
	}
	public void setVisitVentryDate(String visitVentryDate) {
		this.visitVentryDate = visitVentryDate;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "VisitVehicleModel [visitVid=" + visitVid + ", visitVrun=" + visitVrun + ", visitVentryDate="
				+ visitVentryDate + ", tid=" + tid + "]";
	}
	
}
