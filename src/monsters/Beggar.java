package monsters;

public class Beggar extends Monster{
	public Beggar() {
		super();
		this.monster_name="落魄乞討的冒險家";
		this.alive_yn=true;
		this.life = 50;
		this.atk = 19;
		this.def = 15;
		this.dex = 19;
		this.exp = 10;
		this.money = 7;
		this.crit = 0.3;
		this.monster_level=9;
		this.atk_style="搏擊";
	}
}
