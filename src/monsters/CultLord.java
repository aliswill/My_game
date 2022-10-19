package monsters;

public class CultLord extends Monster{
	public CultLord() {
		super();
		this.monster_name="邪教貴族";
		this.alive_yn=true;
		this.life = 85;
		this.atk = 30;
		this.def = 29;
		this.dex = 27;
		this.exp = 32;
		this.money = 35;
		this.crit = 0.15;
		this.monster_level=13;
		this.atk_style="詛咒之聲";
	}
}
