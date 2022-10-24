package map;

import Utils.EventComUtil;
import monsters.CultLord;
import monsters.CultPriest;
import monsters.Monster;

public class CultCamp extends MyMap{

	public CultCamp() {
		super();
		this.id=7;
		this.map_level = 12;
		this.map_name = "叛神教據點";
		this.monsters = new Monster[]{new CultPriest(),new CultLord()};
		this.effect_param = 1;//此地圖事件影響的倍率加乘
		this.view_time=0;
		
		this.eventComUtil = new EventComUtil[] {
	//1:金錢 2:atk 3:def 4:dex 5:血量 6:物品損失 7:取得物品(攻擊力) 8:取得物品(防禦力) 9:魔法力
				new EventComUtil(1,0,9,"撿到一張邪教祭司遺落的手抄咒文，感覺身上的魔力湧現了",15)
				,new EventComUtil(-1,0,3,"對神殿裡倒掛的雕像進行了參拜，受到邪神象的詛咒",3)
				,new EventComUtil(1,0,5,"混入信徒中，到神殿裡偷吃了許多進貢的美味瓜果",20)
				,new EventComUtil(1,0,2,"撿到一串遺落的法珠，上面的咒文似乎有提升力量的效果",2)
				,new EventComUtil(1,0,8,"撿到一件邪教祭司的法袍",4)
				,new EventComUtil(-1,0,5,"被信徒發現行蹤，遭到綑綁與毆打",20)
				,new EventComUtil(-1,0,4,"不小心踩到過去祭邪的陣法，全身都變得相當沉重",3)
				,new EventComUtil(1,0,2,"向邪神許願變得強大，感覺全身湧現不祥的力量，但背後會有代價嗎..?",10)
				,new EventComUtil(1,0,9,"背誦祭祀的咒文，感覺身上的魔力湧現了",12)
				
				};
		this.event_num=eventComUtil.length;//事件總數
		this.monster_num=monsters.length;
	}
	@Override
	public void rebuild() {
		// TODO Auto-generated method stub
		this.monsters = new Monster[]{new CultPriest(),new CultLord()};
	}

	
	
}
