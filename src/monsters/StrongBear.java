package monsters;

public class StrongBear extends Monster {
	public StrongBear() {
		super();
		this.monster_name="飢餓的熊";
		this.alive_yn=true;
		this.life = 24;
		this.atk = 13;
		this.def = 10;
		this.dex = 12;
		this.exp = 10;
		this.money = 7;
		this.crit = 0.2;
		this.monster_level=5;
		this.atk_style="撕咬";
	}
}
