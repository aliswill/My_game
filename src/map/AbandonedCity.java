package map;

import Utils.EventComUtil;
import monsters.BattleMachine;
import monsters.Monster;
import monsters.RelicGuard;

public class AbandonedCity extends MyMap{
	public AbandonedCity() {
		super();
		this.id=8;
		this.map_level = 14;
		this.map_name = "廢棄古城";
		this.monsters = new Monster[]{new BattleMachine(),new RelicGuard()};
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
		this.monsters = new Monster[]{new BattleMachine(),new RelicGuard()};
	}
}
