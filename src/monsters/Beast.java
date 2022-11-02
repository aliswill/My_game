package monsters;

public class Beast extends Monster{
	public Beast() {
		super();
		this.monster_name="禁地的凶獸";
		this.alive_yn=true;
		this.life = 100;
		this.atk = 38;
		this.def = 38;
		this.dex = 35;
		this.exp = 50;
		this.money = 50;
		this.crit = 0.1;
		this.monster_level=16;
		this.atk_style="黑炎";
	}
}
