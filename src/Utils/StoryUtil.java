package Utils;

import java.util.HashMap;
import java.util.Map;

import Role.Hero;

public class StoryUtil {

	private int day;
	private Map<Integer,String> daything;
	private boolean heroNewsYN;
	
	public StoryUtil(int day) {
		super();
		this.heroNewsYN=false;
		this.day = day;
		daything = new HashMap<Integer,String>();
		this.daything.put(2,"王國今日頭條:近日有邪教團體聚眾，倡導將詛咒轉移給他人的巫蠱之術，請大家誤信來路不明的宗教!");
		this.daything.put(5,"王國今日頭條:王國的二公主離家出走了，據說最後是在城鎮中看到他，請全國居民協助尋找公主!");
		this.daything.put(7,"王國今日頭條:一日賭徒，終生囚徒!又傳富家子弟在賭場輸光身家，為還賭債踏上偷竊的不歸路!");
		this.daything.put(9,"王國今日頭條:有目擊者說二公主曾進入月蝕沙漠，王后擔心的夜不能昧，請大家協尋公主!");
		this.daything.put(11,"王國今日頭條:大澳灣出現了史前巨怪!摧毀了不少漁船，國王號召各地勇士前去討伐!");
		this.daything.put(13,"王國今日頭條:國王陛下身體欠安?各界猜測是否要立繼承人了!?");
		this.daything.put(15,"王國今日頭條:二公主還未找到!國王陛下祭出重金找人!");
		//加一個方法在討伐巨怪之後播報主角的事蹟
		
	}
	//第一天講故事開頭
	//第五天講公主離家出走
	//第七天開始號召討伐海怪
	//最後根據hero的條件顯示結局=>放到其他類?
	public  void sayStart(int day) {
		SpeakUtil.speak(1,"");
	}
	
	public  void sayNews(int day,Hero hero) {
		
		if(hero.haveItemYN("海獸的鱗片")&&!this.heroNewsYN) {
			this.heroNewsYN = true;
			if(daything.containsKey(day)) {
				daything.put(day+1,"王國今日頭條:"+hero.getName()+"擊敗了大澳灣的巨獸，為整個灣區帶來了安寧!");
			}else {
				daything.put(day,"王國今日頭條:"+hero.getName()+"擊敗了大澳灣的巨獸，為整個灣區帶來了安寧!");
			}			
		}
		SpeakUtil.speak(1,daything.get(day));
	}
}
