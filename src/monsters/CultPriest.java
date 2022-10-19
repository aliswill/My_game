package monsters;

public class CultPriest extends Monster{
	public CultPriest() {
		super();
		this.monster_name="邪教祭司";
		this.alive_yn=true;
		this.life = 70;
		this.atk = 29;
		this.def = 23;
		this.dex = 26;
		this.exp = 29;
		this.money = 32;
		this.crit = 0.25;
		this.monster_level=12;
		this.atk_style="巫毒之術";
	}
}
