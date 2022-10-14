package monsters;

public class WhaleKiller extends Monster {
	public WhaleKiller() {
		super();
		this.monster_name="深海巨鯨";
		this.alive_yn=true;
		this.life = 65;
		this.atk = 20;
		this.def = 20;
		this.dex = 22;
		this.exp = 22;
		this.money = 22;
		this.crit = 0.2;
		this.monster_level=10;
		this.atk_style="吞噬的漩渦";
	}
}
