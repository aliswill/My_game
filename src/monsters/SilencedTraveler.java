package monsters;

public class SilencedTraveler extends Monster{
	public SilencedTraveler() {
		super();
		this.monster_name="沉默的旅者";
		this.alive_yn=true;
		this.life = 50;
		this.atk = 19;
		this.def = 16;
		this.dex = 19;
		this.exp = 18;
		this.money = 20;
		this.crit = 0.2;
		this.monster_level=9;
		this.atk_style="快速的踢擊";
	}
}
