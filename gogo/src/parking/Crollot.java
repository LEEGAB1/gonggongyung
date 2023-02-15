package parking;

public class Crollot {
	private String storename;
	private int totalnum;
	private int usenum;
	private int availablenum;
	
	
	
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public int getUsenum() {
		return usenum;
	}
	public void setUsenum(int usenum) {
		this.usenum = usenum;
	}
	public int getAvailablenum() {
		return availablenum;
	}
	public void setAvailablenum(int availablenum) {
		this.availablenum = availablenum;
	}
	@Override
	public String toString() {
		return "Crollot [storename=" + storename + ", totalnum=" + totalnum + ", usenum=" + usenum + ", availablenum="
				+ availablenum + "]";
	}
	public Crollot(String storename, int totalnum, int usenum, int availablenum) {
		super();
		this.storename = storename;
		this.totalnum = totalnum;
		this.usenum = usenum;
		this.availablenum = availablenum;
	}
	public Crollot() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}