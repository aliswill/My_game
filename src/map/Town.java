package map;


import Utils.EventComUtil;
import monsters.Bastard;
import monsters.EvilDog;
import monsters.Monster;

public class Town extends MyMap {

	
	/*
	 * 1.如何使用town每次都呼叫新的monster?不然怪物的數值不會初始化
	 * =>如果在各個地圖類建立一個產生怪物的方法，分別給monster[]賦值，這需要分別寫在每個類中，因為父類不會知道各個子類的怪物類別，可是如果寫在子類，那MyMap型態是不能呼叫的
	 * 
	 */
	public Town(int id) {
		super();
		this.id=id;
		this.map_level = 1;
		this.map_name = "平凡的小鎮";
		this.monsters = new Monster[]{new EvilDog(),new Bastard()};
		this.effect_param = 1;//此地圖事件影響的倍率加乘
		this.view_time=0;
		
		this.eventComUtil = new EventComUtil[] {
				new EventComUtil(1,0,1,"在路上撿到了舊錢包",5)//好事/無特殊條件/金錢類事件/影響值
				,new EventComUtil(1,0,1,"偶然抓到了通緝犯",15)//
				,new EventComUtil(1,0,1,"熱心幫助了路人，得到了褒獎",10)
				,new EventComUtil(1,0,2,"認真訓練搏擊，提升了攻擊力",1)
				,new EventComUtil(1,0,2,"撿到一顆不知名的藥丸，食用後能力值似乎有所上升?",1)
				,new EventComUtil(1,0,3,"撿到一本防禦秘笈，防禦值上升",1)
				,new EventComUtil(-1,0,1,"被扒手偷走了錢包，損失金錢",12)//壞事/無特殊條件/金錢類事件
				,new EventComUtil(-1,0,1,"遭遇突來的大風雨，行李弄丟了一些",5)
				,new EventComUtil(-1,0,1,"被誤認成通緝犯，逃跑的時候遺失了銀錢",6)
				,new EventComUtil(-1,0,4,"吃了不乾淨的路邊攤，上吐下瀉，敏捷力下降",1)
				,new EventComUtil(-1,0,4,"因為天氣轉涼，得了重感冒，敏捷力下降",1)
				,new EventComUtil(-1,0,5,"不幸被一群發瘋的野狗咬傷",7)
				};
		this.event_num=eventComUtil.length;//事件總數
		this.monster_num=monsters.length;
//		this.good_event_type = new HashMap<Integer,String>();
//		good_event_type.put(1,"");
//		this.bad_event_type = new HashMap<Integer,String>();
	}
	
	public void rebuild() {
		this.monsters = new Monster[]{new EvilDog(),new Bastard()};//刷新怪物，避免指到同一隻怪物
	}

	
}
