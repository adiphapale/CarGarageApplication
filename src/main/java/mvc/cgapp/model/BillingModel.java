package mvc.cgapp.model;
import java.util.*;

public class BillingModel {

	private int billID;
	private String billCurrentDate;
	private double subTotalServices;
	private double subTotalSpareParts;
	private int vvid;
	
	private UserDetailsModel userDetailsModel;
	private VehicleFormModel vehicleFormModel;
	
	private List<SubServicesModel> subService;
	private Map<SubSparePartsModel,Integer> subSpareParts;
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public String getBillCurrentDate() {
		return billCurrentDate;
	}
	public void setBillCurrentDate(String billCurrentDate) {
		this.billCurrentDate = billCurrentDate;
	}
	public double getSubTotalServices() {
		return subTotalServices;
	}
	public void setSubTotalServices(double subTotalServices) {
		this.subTotalServices = subTotalServices;
	}
	public double getSubTotalSpareParts() {
		return subTotalSpareParts;
	}
	public void setSubTotalSpareParts(double subTotalSpareParts) {
		this.subTotalSpareParts = subTotalSpareParts;
	}
	public int getVvid() {
		return vvid;
	}
	public void setVvid(int vvid) {
		this.vvid = vvid;
	}
	public UserDetailsModel getUserDetailsModel() {
		return userDetailsModel;
	}
	public void setUserDetailsModel(UserDetailsModel userDetailsModel) {
		this.userDetailsModel = userDetailsModel;
	}
	public VehicleFormModel getVehicleFormModel() {
		return vehicleFormModel;
	}
	public void setVehicleFormModel(VehicleFormModel vehicleFormModel) {
		this.vehicleFormModel = vehicleFormModel;
	}
	public List<SubServicesModel> getSubService() {
		return subService;
	}
	public void setSubService(List<SubServicesModel> subService) {
		this.subService = subService;
	}
	public Map<SubSparePartsModel, Integer> getSubSpareParts() {
		return subSpareParts;
	}
	public void setSubSpareParts(Map<SubSparePartsModel, Integer> subSpareParts) {
		this.subSpareParts = subSpareParts;
	}
	@Override
	public String toString() {
		return "BillingModel [billID=" + billID + ", billCurrentDate=" + billCurrentDate + ", subTotalServices="
				+ subTotalServices + ", subTotalSpareParts=" + subTotalSpareParts + ", vvid=" + vvid
				+ ", userDetailsModel=" + userDetailsModel + ", vehicleFormModel=" + vehicleFormModel + ", subService="
				+ subService + ", subSpareParts=" + subSpareParts + "]";
	}
}
