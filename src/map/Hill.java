package map;

import Utils.EventComUtil;
import monsters.Bastard;
import monsters.EvilDog;
import monsters.FunnySnake;
import monsters.Monster;
import monsters.StrongBear;

public class Hill extends MyMap {
	
	public Hill(int id) {
		super();
		this.id=id;
		this.map_level = 3;
		this.map_name = "野性山丘";
		this.monsters = new Monster[]{new FunnySnake(),new StrongBear()};
		this.effect_param = 1;//此地圖事件影響的倍率加乘
		this.view_time=0;
		
		this.eventComUtil = new EventComUtil[] {
				new EventComUtil(1,0,5,"找到一顆甜美的蘋果樹，在樹下休息並恢復了些許體力",7)//好事/無特殊條件/金錢類事件/影響值
				,new EventComUtil(1,0,5,"看到天上出現美麗的彩虹，停下來欣賞，覺得心曠神怡",5)//
				,new EventComUtil(1,0,1,"偶然獵得一張梅花鹿皮，換取了些許旅費",4)
				,new EventComUtil(1,0,7,"撿到一把獵戶用的弓(攻擊力1)",1)
				,new EventComUtil(1,0,4,"辛勤的苦練狩獵技巧，感覺愈來愈敏捷了!",1)
				,new EventComUtil(1,0,2,"學習狩獵各種猛獸，攻擊技巧也愈來愈好了",1)
				,new EventComUtil(1,0,1,"幫助了被野獸攻擊的小孩，從孩子的媽媽那裏收到了謝禮",10)//壞事/無特殊條件/金錢類事件
				,new EventComUtil(-1,0,2,"知識不足，把毒蘑菇拿來燉湯喝，覺得頭昏腦脹",2)
				,new EventComUtil(-1,0,1,"遭遇路間劫匪，被搶走了盤纏",6)
				,new EventComUtil(-1,0,5,"誤入頑皮蛇的巢穴，被一群頑皮蛇包圍並咬傷",7)
				,new EventComUtil(-1,0,5,"被夜裡的毒蟲螫傷，全身搔癢",5)
				,new EventComUtil(-1,0,4,"誤入獅子的巢穴，被嚇得落荒而逃",1)
				};
		this.event_num=eventComUtil.length;//事件總數
		this.monster_num=monsters.length;
	}
	
	@Override
	public void rebuild() {
		// TODO Auto-generated method stub
		this.monsters = new Monster[]{new FunnySnake(),new StrongBear()};
	}

}
