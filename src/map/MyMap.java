package map;

import monsters.Monster;

public abstract class MyMap {
	protected int id;
	protected int map_level;
	protected String map_name;
	protected Monster[] monsters;
	


	public String getPosition() {
		return null;
	};
	
	public int getId() {
		return id;
	}
}
