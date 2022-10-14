package monsters;

import Role.Hero;

public abstract class Monster {

	protected String monster_name;
	protected int life;
	protected int magic;
	protected boolean alive_yn;
	protected int atk;
	protected int def;
	protected int dex;
	protected int ats;
	protected int res;
	protected int exp;
	
	//public abstract int magic_atk(); 
	
	
	
	public int attack() {
		return this.atk;
	}
	

	@Override
	public String toString() {
		return monster_name+"的生命值：" + life + ",魔法力：" + magic + ",攻擊力：" + atk + ",防禦力:" + def + ",魔法攻擊力:" + ats + ",魔法防禦力:"
				+ ""
				+ res + ",敏捷力：" + dex ;
	}
	public int hurt(Hero hero) {
		int damage = Math.max(hero.getAtk()-this.def,0);
		this.life = this.life-damage;		
		if(this.life<=0) {			
			this.alive_yn=false;
			System.out.println(this.monster_name+"受到了"+damage+"點傷害，並且無力的倒下了。");
			System.out.println(hero.getName()+"獲得了"+this.exp+"點經驗值");
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
	
	public int getExp() {
		return exp;
	}


	public int getDef() {
		return def;
	}

	public int getDex() {
		return dex;
	}

}
