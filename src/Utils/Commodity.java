package Utils;

public class Commodity {
	private int price;
	private String com_name;
	private int com_type;//1:增加攻擊力 2:增加防禦力
	private int change_value;//裝備效果值
	
	public Commodity(int price, String com_name, int com_type, int change_value) {
		super();
		this.price = price;
		this.com_name = com_name;
		this.com_type = com_type;
		this.change_value = change_value;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public int getCom_type() {
		return com_type;
	}

	public void setCom_type(int com_type) {
		this.com_type = com_type;
	}

	public int getChange_value() {
		return change_value;
	}

	public void setChange_value(int change_value) {
		this.change_value = change_value;
	}
	
	
	
}
