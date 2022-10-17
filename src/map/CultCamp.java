package map;

import Utils.EventComUtil;
import monsters.Monster;

public class CultCamp extends MyMap{

	public CultCamp() {
		super();
		this.id=id;
		this.map_level = 12;
		this.map_name = "邪教營地";
		this.monsters = new Monster[]{};
		this.effect_param = 1;//此地圖事件影響的倍率加乘
		this.view_time=0;
		
		this.eventComUtil = new EventComUtil[] {
				new EventComUtil(1,0,1,"臨時事件",0)
				};
		this.event_num=eventComUtil.length;//事件總數
		this.monster_num=monsters.length;
	}
	@Override
	public void rebuild() {
		// TODO Auto-generated method stub
		
	}

	
	
}
