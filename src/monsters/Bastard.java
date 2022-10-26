package monsters;

public class Bastard extends Monster {
	public Bastard() {
		super();
		this.monster_name="攔路的小混混";
		this.alive_yn=true;
		this.life = 19;
		this.atk = 8;
		this.def = 5;
		this.dex = 9;
		this.exp = 5;
		this.money = 3;
		this.crit = 0.1;
		this.monster_level=2;
		this.atk_style="恐嚇";
	}
}
