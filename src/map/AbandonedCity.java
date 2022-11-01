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
		this.map_name = "廢棄舊城區";
		this.monsters = new Monster[]{new BattleMachine(),new RelicGuard()};
		this.effect_param = 1;//此地圖事件影響的倍率加乘
		this.view_time=0;
		
		this.eventComUtil = new EventComUtil[] {
				new EventComUtil(1,0,7,"在一處廢墟撿到一把破舊的劍",3),
				new EventComUtil(1,0,5,"找到一幢還可住人的小屋並在裡面休息了一會",8),
				new EventComUtil(-1,0,5,"被崩落的瓦石壓傷",14),
				new EventComUtil(1,0,1,"在舊屋中翻來覆去，發現了一些還尚可使用的物品，拿去換了些錢",5),
				new EventComUtil(-1,0,5,"吸入太多塵埃，肺部受到傷害",10),
				new EventComUtil(1,0,4,"跟此區的不知名機械兵器戰鬥了許久，感覺伸手更為矯健了",2),
				new EventComUtil(-1,0,5,"攀爬殘垣時不慎摔落，血流不已",10),
				new EventComUtil(1,0,1,"在斷垣殘骸中發現一隻遺落的金錶，真是賺到了",20),
				new EventComUtil(1,0,3,"找到一副舊盾牌，似乎聊勝於無?",1),
				new EventComUtil(-1,0,3,"遺失了乾糧，在此處又找不到營養的食物來源，感覺身體虛弱",2),
				
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
