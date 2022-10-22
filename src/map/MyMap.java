package map;

import java.util.Map;

import Utils.EventComUtil;

import monsters.Monster;

public abstract class MyMap {
	protected int id;
	protected int map_level;
	protected String map_name;
	protected Monster[] monsters;
	//protected Map<String,Integer> treasure_param;//如該地圖的寶相/金錢/懲罰等的乘數
	protected double effect_param;//如該地圖的寶相/金錢/懲罰等的乘數
	protected int view_time;
	protected EventComUtil[] eventComUtil;
	protected int event_num;
	protected int monster_num;
//	protected Map<Integer,String> good_event_type;//依照拜訪次數決定事件名稱
//	protected Map<Integer,String> bad_event_type;
	
	
	public abstract void rebuild();
	
	public void addViewTime() {
		this.view_time++;
	}
	
	public int getMonster_num() {
		return monster_num;
	}


	public EventComUtil getEventComUtil(int i) {
		return eventComUtil[i];
	}
	
	

	public double getEffect_param() {
		return effect_param;
	}


	public int getEvent_num() {
		return event_num;
	}

	public int getViewTime() {
		return this.view_time;
	}
	
	public String getPosition() {
		return null;
	};
	
	public int getId() {
		return id;
	}

	public int getMap_level() {
		return map_level;
	}

	public String getMap_name() {
		return map_name;
	}

	public Monster[] getMonsters() {
		return monsters;
	}


	
	
	
}
