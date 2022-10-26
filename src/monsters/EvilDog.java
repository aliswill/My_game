package monsters;

public class EvilDog extends Monster{

	public EvilDog() {
		super();
		this.monster_name="兇惡的野狗";
		this.alive_yn=true;
		this.life = 10;
		this.atk = 8;
		this.def = 7;
		this.dex = 6;
		this.exp = 2;
		this.money = 2;
		this.crit = 0.05;
		this.monster_level=1;
		this.atk_style="瘋狗亂咬";
	}

}


/*
public class EvilPig  Monster{
	private String monster_name;
	private int life;
	private boolean alive_yn;
	private int atk;
	private int def;
	private int dex;
	public EvilPig() {
		super();
		this.monster_name="EvilPig";
		this.alive_yn=true;
		this.life = 10;
		this.atk = 5;
		this.def = 3;
		this.dex = 1;
	}
	
	public int attack() {
			return this.atk;
	}
	
	public int hurt(int hero_atk) {
		int damage = Math.max(hero_atk-this.def,0);
		this.life = this.life-damage;		
		if(this.life<=0) {			
			this.alive_yn=false;
			System.out.println(this.monster_name+"受到了"+damage+"點傷害，並且無力的倒下了。");
			return damage;
		}
		System.out.println(this.monster_name+"受到了"+damage+"點傷害");
		return damage;
	}
	
	public String getName() {
		return this.monster_name;
	}
	
	public boolean getAliveYN() {
		return this.alive_yn;
	}

	public int getLife() {
		return life;
	}

	public int getAtk() {
		return atk;
	}


	public int getDef() {
		return def;
	}

	public int getDex() {
		return dex;
	}

	
	
}
*/