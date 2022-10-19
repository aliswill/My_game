package monsters;

public class RelicGuard extends Monster{
	public RelicGuard() {
		super();
		this.monster_name="遺跡守衛";
		this.alive_yn=true;
		this.life = 95;
		this.atk = 35;
		this.def = 35;
		this.dex = 25;
		this.exp = 36;
		this.money = 39;
		this.crit = 0.1;
		this.monster_level=14;
		this.atk_style="巨石攻擊";
	}
}
