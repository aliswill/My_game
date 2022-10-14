package Utils;

public class EventComUtil {

	private int good_or_bad_type;
	private int special_con;//觸發事件的特殊條件參數
	private int event_type;
	private String event_describe;
	private double origin_value;
	
	public EventComUtil(int good_or_bad_type, int special_con, int event_type,String event_describe,double origin_value) {
		super();
		this.good_or_bad_type = good_or_bad_type;
		this.special_con = special_con;//實際上對應拜訪次數
		this.event_type = event_type;//事件類型://1:金錢 2:atk 3:def 4:dex 5:血量
		this.event_describe = event_describe;
		this.origin_value = origin_value;
	}

	public int getGood_or_bad_type() {
		return good_or_bad_type;
	}


	public int getEvent_type() {
		return event_type;
	}

	public String getEvent_describe() {
		return event_describe;
	}

	public double getOrigin_value() {
		return origin_value;
	}
	
	
	
	
	
	
}
