package map;

import Utils.EventComUtil;
import monsters.Bastard;
import monsters.EvilDog;
import monsters.Monster;

public class WindyDesert extends MyMap{

	public WindyDesert(int id) {
		super();
		this.id=id;
		this.map_level = 7;
		this.map_name = "狂風的沙地";
		this.monsters = new Monster[]{};
		this.effect_param = 1;//此地圖事件影響的倍率加乘
		this.view_time=0;
		
		this.eventComUtil = new EventComUtil[] {
				new EventComUtil(1,0,5,"找到一座遺落的碉堡，在裡面稍作休憩",10)//好事/無特殊條件/金錢類事件/影響值
				,new EventComUtil(1,0,1,"發現遇難的旅行者的屍體，從遺落的背包中蒐集了些許旅費",10)//
				,new EventComUtil(1,0,1,"發現一張遺落的藏寶圖，依循指引在一處沙洞中發現了巨額的財寶!",50)
				,new EventComUtil(1,0,7,"撿到一把旅者遺落的匕首(攻擊力4)",4)
				,new EventComUtil(-1,0,5,"被沙漠蠍攻擊，受了點傷",5)
				,new EventComUtil(-1,0,2,"誤飲了含有毒素的綠洲泉水，攻擊力下降",2)
				,new EventComUtil(-1,0,5,"誤入了不知是誰設置的陷阱，摔傷了腿",13)
				,new EventComUtil(-1,0,1,"被狂風颳走了行李，遺失備用錢包",10)
				,new EventComUtil(-1,0,5,"被捲入無底的流沙，費盡千辛萬苦才爬了出來",20)
				,new EventComUtil(-1,0,4,"遭遇沙塵暴，風砂刺進了眼睛，導致敏捷力下降",3)
				,new EventComUtil(-1,0,6,"遭遇強大的沙匪，被搶走了全身的裝備...",0)
				};
		this.event_num=eventComUtil.length;//事件總數
		this.monster_num=monsters.length;
	}
	
	@Override
	public void rebuild() {
		// TODO Auto-generated method stub
		
	}
	
}
