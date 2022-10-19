package monsters;

public class BattleMachine extends Monster {
	public BattleMachine() {
		super();
		this.monster_name="戰鬥兵器";
		this.alive_yn=true;
		this.life = 100;
		this.atk = 40;
		this.def = 33;
		this.dex = 30;
		this.exp = 40;
		this.money = 45;
		this.crit = 0.15;
		this.monster_level=15;
		this.atk_style="古代射線";
	}
}