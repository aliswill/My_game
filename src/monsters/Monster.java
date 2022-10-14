package monsters;

import Role.Hero;

public abstract class Monster {

	protected String monster_name;
	protected int monster_level;
	protected int life;
	protected int magic;
	protected boolean alive_yn;
	protected int atk;
	protected int def;
	protected int dex;
	protected int ats;
	protected int res;
	protected int exp;
	protected int money;
	protected String atk_style;
	protected double crit;
	
	//public abstract int magic_atk(); 
	
	
	
	public int attack() {
		boolean crit_yn = Math.random()>1-this.crit;
		double atk_param = Math.random();
		if(crit_yn==true) {
			System.out.println(this.monster_name+"使出了憤怒一擊");
			
			return (int) ((this.atk)*(0.35+atk_param)*1.5);//發生了爆擊
		}
		else {
			System.out.println(this.monster_name+"使出"+this.atk_style);
			return (int) ((this.atk)*(0.35+atk_param));
		}
	}
	


//	@Override
//	public String toString() {
//		return monster_name+" 的狀態為：生命值：" + life + ",魔法力：" + magic + ",攻擊力：" + atk + ",防禦力:" + def + ",魔法攻擊力:" + ats + ",魔法防禦力:"
//				+ ""
//				+ res + ",敏捷力：" + dex ;
//	}
	
	public String toString() {
		return monster_name+" 的狀態為：生命值：" + life + ",攻擊力：" + atk + ",防禦力:" + def +  ",敏捷力：" + dex ;
	}
	
	
	
	public int getMoney() {
		return money;
	}


	public int getMonster_level() {
		return monster_level;
	}


	public int hurt(Hero hero) {
		int damage = Math.max(hero.attack()-this.def,0);
		this.life = this.life-damage;		
		if(this.life<=0) {			
			this.alive_yn=false;
			System.out.println(this.monster_name+"受到了"+damage+"點傷害，並且無力的倒下了。");
			System.out.println(hero.getName()+"獲得了"+this.exp+"點經驗值");
			return damage;
		}
		System.out.println(this.monster_name+"受到了"+damage+"點傷害"+" (剩餘血量"+this.life+")");
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
