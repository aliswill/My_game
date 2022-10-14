package monsters;

public class MagicFairy extends Monster {

	public MagicFairy() {
		super();
		this.monster_name="惡作劇的妖精";
		this.alive_yn=true;
		this.life = 18;
		this.atk = 9;
		this.def = 3;
		this.dex = 20;
		this.exp = 7;
		this.crit = 0.03;
		this.money = 5;
		this.atk_style="妖精迷霧";
		this.monster_level=4;
	}
}
