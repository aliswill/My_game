package monsters;

import Items.Item;

public class BossSeaBeast extends Monster {
	public BossSeaBeast() {
		super();
		this.monster_name="BOSS - 深海巨獸";
		this.alive_yn=true;
		this.life = 120;
		this.atk = 37;
		this.def = 36;
		this.dex = 30;
		this.exp = 60;
		this.money = 60;
		this.crit = 0.05;
		this.monster_level=14;
		this.atk_style="海嘯風暴";
		this.drop_item= new Item("海獸的鱗片");
	}
}
