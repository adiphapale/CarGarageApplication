package mvc.cgapp.model;

public class CustomerLoginModel {
	private int custId;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	private String custName;
	private String custPass;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPass() {
		return custPass;
	}
	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}
	@Override
	public String toString() {
		return "CustomerLoginModel [custId=" + custId + ", custName=" + custName + ", custPass=" + custPass + "]";
	}
	
}
