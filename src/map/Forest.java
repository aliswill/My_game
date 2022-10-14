package map;

import Utils.EventComUtil;
import monsters.EvilDog;
import monsters.FunnySnake;
import monsters.Monster;

public class Forest extends MyMap {
	public Forest() {
		super();
		this.id=id;
		this.map_level = 4;
		this.map_name = "迷幻的森林";
		this.monsters = new Monster[]{};//待補
		this.effect_param = 1.3;//此地圖事件影響的倍率加乘
		this.view_time=0;
		this.event_num=12;//事件總數
		this.eventComUtil = new EventComUtil[] {
				new EventComUtil(1,0,1,"撿到了稀有的發光石頭，賣給路過的富人並取得了不少錢",25)//好事/無特殊條件/金錢類事件/影響值
				,new EventComUtil(1,0,3,"虔誠參拜了神樹，得到森林護佑",2)//
				,new EventComUtil(1,0,3,"撿到了不知名的羽毛，敏捷值得到提升",2)
				,new EventComUtil(1,0,4,"模仿妖精的閃躲技巧，能力得到了提升",4)
				,new EventComUtil(1,0,5,"飲用了妖精之泉，生命值恢復了",25)
				,new EventComUtil(1,0,5,"食用了神樹的果實，生命值恢復了",15)
				,new EventComUtil(1,0,5,"遇到花季，停下來欣賞森林的美景",10)
				,new EventComUtil(-1,0,2,"冒犯了森林的神樹，得到了懲罰",2)//壞事/無特殊條件/金錢類事件
				,new EventComUtil(-1,0,2,"誤食偽裝成神樹果實的毒樹果實，生命值下降",15)
				,new EventComUtil(-1,0,4,"被頑皮的妖精偷走了鞋子",2)
				,new EventComUtil(-1,0,4,"遇到迷霧，喪失方向",1)
				,new EventComUtil(-1,0,5,"被路上的荊棘刺傷",10)
			
				};
}
}