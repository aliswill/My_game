package map;

import Utils.EventComUtil;
import monsters.Bastard;
import monsters.BossSeaBeast;
import monsters.EvilDog;
import monsters.Monster;
import monsters.Siren;
import monsters.WhaleKiller;

public class DeepOcean extends MyMap {

	public DeepOcean() {
		super();
		this.id=id;
		this.map_level = 10;
		this.map_name = "大澳灣";
		this.monsters = new Monster[]{new WhaleKiller(),new Siren()};
		this.effect_param = 1;//此地圖事件影響的倍率加乘
		this.view_time=0;
		this.boss= new BossSeaBeast();
		
		this.eventComUtil = new EventComUtil[] {
				new EventComUtil(1,0,1,"撿到了閃閃發光的珍珠，似乎滿值錢的",20)//好事/無特殊條件/金錢類事件/影響值
				,new EventComUtil(1,0,1,"撿到了可以聽到海潮聲的海螺，似乎很受部分收藏加的青睞",13)//
				,new EventComUtil(1,0,2,"採集了一些閃閃發光紅珊瑚做成手串，聽說有提高攻擊力的效果",2)
				,new EventComUtil(1,0,1,"收集了漂亮的海貝，並賣了不少錢",10)
				,new EventComUtil(1,0,8,"撿到了蛟人戰士的鎧甲(防禦力5)",5)
				,new EventComUtil(1,0,7,"撿到了蛟人戰士的長戟(攻擊力6)",6)
				,new EventComUtil(1,0,1,"撿到了百年一見的美麗彩色珍珠，可以賣得很好的價錢!",40)//壞事/無特殊條件/金錢類事件
				,new EventComUtil(-1,0,5,"遭遇有毒的水母群，因此被刺傷",20)
				,new EventComUtil(-1,0,5,"被巨魟的尾巴掃到，中了巨毒",30)
				,new EventComUtil(-1,0,2,"被巨毒的水母扎到，攻擊力下降",3)
				,new EventComUtil(-1,0,6,"遭遇巨大的章魚怪，遺失了全部裝備!",0)
				,new EventComUtil(-1,0,4,"遇到強大的海流，難以前進",2)
				};
		this.event_num=eventComUtil.length;//事件總數
		this.monster_num=monsters.length;
	}
	
	
	@Override
	public void rebuild() {
		// TODO Auto-generated method stub
		this.monsters = new Monster[]{new WhaleKiller(),new Siren()};
	}

}
