package monsters;

import Items.Item;

public class BossBetrayedCommand extends Monster {
	public BossBetrayedCommand() {
		super();
		this.monster_name="BOSS - 反叛的將軍";
		this.alive_yn=true;
		this.life = 130;
		this.atk = 42;
		this.def = 40;
		this.dex = 40;
		this.exp = 70;
		this.money = 70;
		this.crit = 0.25;
		this.monster_level=17;
		this.atk_style="劍氣衝擊";
		this.drop_item= new Item("反叛軍的頭顱");
	}

}
