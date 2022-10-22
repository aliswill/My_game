package monsters;

import Items.Item;

public class FinalBoss extends Monster{
	public FinalBoss() {
		super();
		this.monster_name="BOSS - 反叛軍統領";
		this.alive_yn=true;
		this.life = 120;
		this.atk = 40;
		this.def = 40;
		this.dex = 40;
		this.exp = 70;
		this.money = 70;
		this.crit = 0.25;
		this.monster_level=17;
		this.atk_style="猛烈斬擊";
		this.drop_item= new Item("反叛軍的頭顱");
	}
}
