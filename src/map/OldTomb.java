package map;

import Utils.EventComUtil;
import monsters.Bastard;
import monsters.EvilDog;
import monsters.Monster;

public class OldTomb extends MyMap{

	
	public OldTomb() {
		super();
		this.id=id;
		this.map_level = 5;
		this.map_name = "古戰場的墓地";
		this.monsters = new Monster[]{};//待補
		this.effect_param = 1.5;//此地圖事件影響的倍率加乘
		this.view_time=0;
		this.eventComUtil = new EventComUtil[] {
				new EventComUtil(1,0,1,"撿到一件古代將軍的鎧甲，賣給了喜愛骨董的商人，獲得了不少錢",15)//好事/無特殊條件/金錢類事件/影響值
				,new EventComUtil(1,0,2,"參拜戰場的亡靈，得到英靈的加護",3)
				,new EventComUtil(1,0,2,"搭救了一位看不清臉的將軍，得到武術指導，力量提升。但那位將軍的身體似乎有點透明..?",3)
				,new EventComUtil(1,0,2,"找到遺落的古遺跡，研究了石壁上的神秘武功",5)
				,new EventComUtil(1,0,1,"撿到不知名旅行者遺落的舊錢袋，取得了些許金錢",10)
				,new EventComUtil(-1,0,5,"不小心觸怒了陣亡的英靈，受到詛咒，防禦力下降",5)
				,new EventComUtil(-1,0,4,"誤入了古戰場怨氣最重的舊刑場，感受到沉重的壓迫感",3)			
				,new EventComUtil(-1,0,5,"被突然出現的骷髏軍團追殺，狼狽逃離",12)
				,new EventComUtil(-1,0,2,"因為古戰場戾氣太重，覺得有些頭昏腦脹",1)
			
				};
		this.event_num=eventComUtil.length;//事件總數
		this.monster_num=monsters.length;
		}
	
	public void rebuild() {
		this.monsters = new Monster[]{    };//刷新怪物，避免指到同一隻怪物***要補
	}
}
