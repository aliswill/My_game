package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Role.Hero;
import map.AbandonedCity;
import map.CultCamp;
import map.DeepOcean;
import map.Forest;
import map.Hill;
import map.MyMap;
import map.OldTomb;
import map.RoyalForbiddenArea;
import map.Town;
import map.WindyDesert;
import monsters.Monster;



public class RandomMapUtil {

	//private Map<MyMap,PositionUtil> recordMap;	
	private MyMap[][] my_map;
//	private double cur_map_money_param;
//	private double cur_map_good_event_ratio;
//	private double cur_map_bad_event_ratio;
//	private double cur_map_ability_param;
	private MyMap cur_map;
	private double event_ratio;
	private double mon_ratio;
	
	
	
	public String getDanagerousDirection(Hero hero) {//待優化!依照物件的屬性排序
		int x_index = hero.getX_index();
		int y_index = hero.getY_index();
		boolean north=y_index>0;
		boolean west=x_index>0;
		boolean south=y_index<2;
		boolean east=x_index<2;
		int n_level = 0;
		int s_level = 0;
		int w_level = 0;
		int e_level = 0;
		
		if(north) {
			n_level = my_map[hero.getX_index()][hero.getY_index()-1].getMap_level();
		}
		if(south) {
			s_level = my_map[hero.getX_index()][hero.getY_index()+1].getMap_level();
		}
		if(west) {
			w_level = my_map[hero.getX_index()-1][hero.getY_index()].getMap_level();
		}
		if(east) {
			e_level = my_map[hero.getX_index()+1][hero.getY_index()].getMap_level();
		}
		int[] arr = {n_level,s_level,w_level,e_level};
		Arrays.sort(arr);
		
		if(arr[arr.length-1]==n_level) {
			return "北";
		}else if(arr[arr.length-1]==s_level) {
			return "南";
		}else if(arr[arr.length-1]==w_level) {
			return "西";
		}else if(arr[arr.length-1]==e_level) {
			return "東";
		}else {
			
			return "***發生錯誤***";
		}
		//接下來比較四個區域的地圖等及   
	}
	
	public double getEvent_ratio() {
		return event_ratio;
	}

	public void setEvent_ratio(double event_ratio) {
		this.event_ratio = event_ratio;
	}

	public double getMon_ratio() {
		return mon_ratio;
	}

	public void setMon_ratio(double mon_ratio) {
		this.mon_ratio = mon_ratio;
	}

	public RandomMapUtil() {
		//一維座標跟二維做標的位置對應是可以有邏輯的，不要存無用的代號跟[-1][1]~[1][-1]的位置
		my_map = new MyMap[3][3];		
		this.event_ratio=0.5;
		this.mon_ratio=0.5;
	}
	
	public void reLocateHero(Hero hero) {
		//MyMap town = my_map.;
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				if(my_map[x][y].getMap_name().equals("平凡的小鎮")){
					SpeakUtil.speak(hero.getName()+"是一名嚮往充滿挑戰性的生活的冒險家，他將從"+my_map[x][y].getMap_name()+"出發，展開他充滿挑戰的旅程!");
					hero.setLocation(x, y);
				}
			}
		}		
	}
	
	public MyMap getCurrentMap(Hero hero) {
		cur_map = my_map[hero.getX_index()][hero.getY_index()];
		return cur_map;
	}
	
	public void getMapEvent(Hero hero) {//決定該地圖發生的事件
		if(EventHappenedYn()) {
			
			SpeakUtil.speak("發生了突發事件!");
			
			cur_map = my_map[hero.getX_index()][hero.getY_index()];
			int map_event_num = cur_map.getEvent_num();
			double v = Math.random()*100;
			int event_index = (int)(v/(100/map_event_num));
			EventComUtil eventComUtil = cur_map.getEventComUtil(event_index);
			SpeakUtil.speak(hero.getName()+eventComUtil.getEvent_describe());
			hero.getEventEffect(eventComUtil.getGood_or_bad_type(),(int)(eventComUtil.getOrigin_value()*cur_map.getEffect_param()),eventComUtil.getEvent_type());//好事壞事/影響值/事件類型
		}else {
			
			SpeakUtil.speak("今天平安的度過了。");
		}
		
	}
	
	public Monster getMapMonster(Hero hero) {//已經遭遇怪物才要調用，在主程式調用		
			cur_map = my_map[hero.getX_index()][hero.getY_index()];
			cur_map.rebuild();
			int map_monster_num = cur_map.getMonster_num();
			double v = Math.random()*100;
			int monster_index = (int)(v/(100/map_monster_num));
			Monster monster = cur_map.getMonsters()[monster_index];
			return monster;

	}
	
	public boolean EventHappenedYn() {
		double v = Math.random();
		return v<=this.event_ratio;
	}
	
	public boolean MonsterHappenedYn() {
		double v = Math.random();
		return v<=this.mon_ratio;
	}
	
//	public void getMapEvent(Hero hero) { //這個方法會先決定好事還是壞事
//		cur_map = my_map[hero.getX_index()][hero.getY_index()];
//		cur_map_money_param = cur_map.getMoney_param();
//		cur_map_ability_param = cur_map.getAbility_param();
//		cur_map_good_event_ratio = cur_map.getGood_event_ratio();
//		cur_map_bad_event_ratio = cur_map.getBad_event_ratio();
//		//int good_bad_event = EventUtil(cur_map_good_event_ratio,cur_map_bad_event_ratio);
//		
//		if(good_bad_event==1) {
//			EventComUtil event = new EventComUtil(good_bad_event,,,);
//		}else if(good_bad_event==2) {
//			
//		}else {
//			
//		}
//	}
	
	
	
//	public int EventUtil(double good_event_ratio,double bad_event_ratio) {
//		double v = Math.random();
//		if(v<good_event_ratio) {//發生好事
//			return 1;
//		}else if(v>=good_event_ratio&&v<(good_event_ratio+bad_event_ratio)) {//發生壞事
//			return -1;
//		}else {//什麼都沒發生
//			return 0;
//		}
//	}
	
	public void getIntoNewMap(Hero hero){
		
		SpeakUtil.speak(hero.getName()+"來到了"+my_map[hero.getX_index()][hero.getY_index()].getMap_name());
		
	}
	
	public void makeMap() {
		//給定一張圖，在這裡面取得並保存該圖的位置，並將位置賦值給那張圖的物件?=>其時不用吧?
		//由這個類決定圖的排列，並取得主角往哪邊走會到哪裡就好
		
//學習用	Integer[] int_array = {0,1,2,3,4,5,6,7,8};//注意不是int
//		List<Integer> int_list = Arrays.asList(int_array);//他是參照原本的陣列，所以shuffled=之後兩個都會一起變
//		Collections.shuffle(int_list);//list洗牌
//		Integer[] new_int_list = int_list.toArray(new Integer[0]);//要傳入一個參數，告訴他要回傳成什麼類型
		//測試SpeakUtil.speak(int_list);
		
		//step1 陣列洗牌
		List<MyMap> map_list = new ArrayList<MyMap>();
		
		map_list.add(new Town(1));//臨時用**********要件入真正的地圖
		map_list.add(new Forest());
		map_list.add(new AbandonedCity());
		map_list.add(new CultCamp());
		map_list.add(new OldTomb());
		map_list.add(new Hill(1));
		map_list.add(new RoyalForbiddenArea());
		map_list.add(new WindyDesert(1));
		map_list.add(new DeepOcean());
		
		Collections.shuffle(map_list);//list洗牌
		
		//step1 一維轉成二維
		int x_index;
		int y_index;
		for(int i=0;i<map_list.size();i++) {
			//排序0/3/6=>x=0，排序1/4/7=>x=1，排序2/5/8=>x=2
			//排序0/1/2=>y=0，排序3/4/5=>y=1，排序6/7/8=>y=2
			
			x_index=i%3;
			
			if(i==0)
			{
				y_index=0;
			}else {
				y_index=(int)i/3;
			}		
			my_map[x_index][y_index]=map_list.get(i);
			
		} //隨機地圖成工!
//		for(int a=0;a<3;a++) {
//			for(int b=0;b<3;b++) {
//				SpeakUtil.speak(my_map[a][b].getId());
//			}
//		}

		
	}
}
