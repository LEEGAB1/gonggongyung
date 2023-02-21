package GasStation;

public class GasStation {
	private String region;
	private String storename;
	private String storeaddress;
	private String storebrand;
	private String storenumber;
	private String self;
	private String p_gasoline;
	private String gasoline;
	private String diesel;
	private String X;
	private String Y;
	
	public GasStation() {
		super();
	}

	public GasStation(String region, String storename, String storeaddress, String storebrand, String storenumber,
			String self, String p_gasoline, String gasoline, String diesel,  String x, String y) {
		super();
		this.region = region;
		this.storename = storename;
		this.storeaddress = storeaddress;
		this.storebrand = storebrand;
		this.storenumber = storenumber;
		this.self = self;
		this.p_gasoline = p_gasoline;
		this.gasoline = gasoline;
		this.diesel = diesel;
		
		X = x;
		Y = y;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getStorebrand() {
		return storebrand;
	}

	public void setStorebrand(String storebrand) {
		this.storebrand = storebrand;
	}

	public String getStorenumber() {
		return storenumber;
	}

	public void setStorenumber(String storenumber) {
		this.storenumber = storenumber;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getP_gasoline() {
		return p_gasoline;
	}

	public void setP_gasoline(String p_gasoline) {
		this.p_gasoline = p_gasoline;
	}

	public String getGasoline() {
		return gasoline;
	}

	public void setGasoline(String gasoline) {
		this.gasoline = gasoline;
	}

	public String getDiesel() {
		return diesel;
	}

	public void setDiesel(String diesel) {
		this.diesel = diesel;
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
		return "GasStation [region=" + region + ", storename=" + storename + ", storeaddress=" + storeaddress
				+ ", storebrand=" + storebrand + ", storenumber=" + storenumber + ", self=" + self + ", p_gasoline="
				+ p_gasoline + ", gasoline=" + gasoline + ", diesel=" + diesel + ", X=" + X
				+ ", Y=" + Y + "]\n";
	}

	

	
	


	

}
