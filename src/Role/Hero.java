package Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.EventComUtil;

public class Hero {

	private int x_index;
	private int y_index;
	private String name;
	private boolean alive_yn;
	private int max_life;
	private int life;
	private int magic;
	private int atk;
	private int weapon_atk;
	private int def;
	private int ats;
	private int res;
	private int exp;
	private int money;
	private int dex;
	private int level;
	private double crit;//爆擊率
	
	
	
	@Override
	public String toString() {
		return this.name+"的生命值：" + life + ",魔法力：" + magic + ",攻擊力：" + atk + ",防禦力:" + def + ",魔法攻擊力:" + ats + ",魔法防禦力:"
				+ ""
				+ res + ",敏捷力：" + dex + ",等級：" + level + ",爆擊率:" + crit;
	}
	public Hero(String name) {
		super();
		this.x_index=1;
		this.y_index=1;
		this.name = name;
		this.alive_yn=true;
		this.max_life = 30;
		this.life = 30;
		this.magic = 30;
		this.atk = 10;
		this.weapon_atk=0;
		this.def = 5;
		this.ats = 5;
		this.res = 5;
		this.dex = 10;
		this.crit = 0.1;
		this.level=1;
		this.exp=0;
		this.money = 0;
	}
	
	
	
	public void getEventEffect(int good_or_bad,int value,int event_type) {
		int final_value = (good_or_bad*value);		
		switch(event_type){//1:金錢 2:atk 3:def 4:dex 5:血量
			case 1:
				this.money+=final_value;
				System.out.println(this.name+"的金錢變化量:"+final_value);
				break;
			case 2:
				this.atk+=final_value;
				System.out.println(this.name+"的ATK變化量:"+final_value);
				break;
			case 3:
				this.def+=final_value;
				System.out.println(this.name+"的DEF變化量:"+final_value);
				break;
			case 4:
				this.def+=final_value;
				System.out.println(this.name+"的DEX變化量:"+final_value);
				break;
			case 5:
				this.life+=final_value;
				System.out.println(this.name+"的血量變化量:"+final_value);
				break;
		}
	}
	
	public void move() {
		System.out.println("今天想往哪個方向移動?");
		boolean north=y_index>0;
		boolean west=x_index>0;
		boolean south=y_index<2;
		boolean east=x_index<2;
		if(north==true) {System.out.print("北 ");}
		if(west==true) {System.out.print("西 ");}
		if(south==true) {System.out.print("南 ");}
		if(east==true) {System.out.print("東 ");}
		List<String> s = new ArrayList<>();
		if(north) {s.add("北");}
		if(east) {s.add("東");}
		if(west) {s.add("西");}
		if(south) {s.add("南");}
		
		Scanner sc = new Scanner(System.in);
		String direction = sc.next();
		while(!s.contains(direction)) {
			System.out.println("請輸入想移動的方向");
			direction = sc.next();
		}
		if(direction.equals("北")&&north) { //文字要用equals!
			
			System.out.println(this.name+"向北移動了一格");
			y_index--;
			}
		else if(direction.equals("東")&&east) {
			System.out.println(this.name+"向東移動了一格");
			x_index++;
			}
		else if(direction.equals("南")&&south) {
			System.out.println(this.name+"向南移動了一格");
			y_index++;
			}
		else if(direction.equals("西")&&west) {
			System.out.println(this.name+"向西移動了一格");
			x_index--;}	
		}
	
	
	public void getPosition() {
		System.out.println("當前在"+x_index+","+y_index);
	}
	
	public void getExperience(int mon_exp) {
		this.exp+=mon_exp;
		
		if(this.exp>5) {
			this.level+=1;
			this.exp=0;
			this.max_life+=5;
			this.life=this.max_life;
			this.magic++;
			this.atk++;
			this.def++;
			this.ats++;
			this.res++;
			this.dex++;
			System.out.println(this.name+"升到"+this.level+"級了!");
			System.out.println(this.name+"的能力值變為：");
			System.out.println(this.toString());
		}
	}
	
	public int attack() {
		boolean crit_yn = Math.random()>1-this.crit;
		if(crit_yn==true) {
			System.out.println(this.name+"使出了憤怒一擊!");
			return (int) ((this.atk+weapon_atk)*(0.35+Math.random())*1.5);//發生了爆擊
		}
		else {
			return (int) ((this.atk+this.weapon_atk)*(0.35+Math.random()));
		}
	}
	
	public int hurt(int monster_atk) {
		int damage = Math.max(monster_atk-this.def,0);
		this.life = this.life-damage;
		
		if(this.life<=0) {			
			this.alive_yn=false;
			System.out.println(","+this.name+"受到了"+damage+"點傷害，並且無力的倒下了。勝敗乃兵家常事，請再接再厲!");
			return damage;
		}
		System.out.println(this.name+"受到了"+damage+"點傷害");
		return damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive_yn() {
		return alive_yn;
	}

	public void setAlive_yn(boolean alive_yn) {
		this.alive_yn = alive_yn;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getAts() {
		return ats;
	}

	public void setAts(int ats) {
		this.ats = ats;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getCrit() {
		return crit;
	}

	public void setCrit(double crit) {
		this.crit = crit;
	}
	public int getX_index() {
		return x_index;
	}
	public int getY_index() {
		return y_index;
	}
	
	
	
}
