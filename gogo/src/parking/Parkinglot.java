package parking;

public class Parkinglot {
	private String storename;
	private String storeaddress;
	private int totalnum;
	private int usenum;
	private int availablenum;
	private int tenprice;
	private int dayprice;
	private String X;
	private String Y;

	public Parkinglot() {
		super();
	}
	
	public Parkinglot(String storename, String storeaddress, int totalnum, int usenum, int availablenum, int tenprice,
			int dayprice, String x, String y) {
		super();
		this.storename = storename;
		this.storeaddress = storeaddress;
		this.totalnum = totalnum;
		this.usenum = usenum;
		this.availablenum = availablenum;
		this.tenprice = tenprice;
		this.dayprice = dayprice;
		X = x;
		Y = y;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getStoreaddress() {
		return storeaddress;
	}

	public void setStoreaddress(String storeaddress) {
		this.storeaddress = storeaddress;
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

	public int getTenprice() {
		return tenprice;
	}

	public void setTenprice(int tenprice) {
		this.tenprice = tenprice;
	}

	public int getDayprice() {
		return dayprice;
	}

	public void setDayprice(int dayprice) {
		this.dayprice = dayprice;
	}

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	@Override
	public String toString() {
		return "Parkinglot [storename=" + storename + ", storeaddress=" + storeaddress + ", totalnum=" + totalnum
				+ ", usenum=" + usenum + ", availablenum=" + availablenum + ", tenprice=" + tenprice + ", dayprice="
				+ dayprice + ", X=" + X + ", Y=" + Y + "]\n";
	}
	
	
}
