package monsters;

public class SkeletonArmy extends Monster{
	public SkeletonArmy() {
		super();
		this.monster_name="骷髏將軍";
		this.alive_yn=true;
		this.life = 40;
		this.atk = 20;
		this.def = 17;
		this.dex = 9;
		this.exp = 15;
		this.money = 10;
		this.crit = 0.2;
		this.monster_level=7;
		this.atk_style="死亡揮砍";
	}
}
