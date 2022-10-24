package Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import Items.Item;
import Utils.CheckType;
import Utils.EventComUtil;
import Utils.FightUtil;
import Utils.RandomMapUtil;
import Utils.SpeakUtil;
import Utils.WaitUtil;
import monsters.Beggar;
import monsters.Monster;

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
	private int equ_def;
	private int def;
	private int ats;
	private int res;
	private int exp;
	private int money;
	private int dex;
	private int level;
	private int exp_needed;
	private double crit;//爆擊率
	private int max_magic;
	private Map<String,Item> Items;
	private boolean haveCat_yn;
	private String cat_name;
	
	
//	@Override
//	public String toString() {
//		return this.name+"的生命值：" + life + ",魔法力：" + magic + ",攻擊力：" + atk + ",防禦力:" + def + ",魔法攻擊力:" + ats + ",魔法防禦力:"
//				+ ""
//				+ res + ",敏捷力：" + dex + ",等級：" + level + ",爆擊率:" + crit;
//	}
	
	@Override
	public String toString() {
		return this.name+"的生命值：" + life  + ",攻擊力：" + atk + ",防禦力:" + def  + 
				 ",敏捷力：" + dex + ",等級：" + level + ",爆擊率:" + crit +",金錢:" + money
				 +",武器攻擊力:"+weapon_atk+",裝備防禦力:"+equ_def;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public Hero(String name) {
		super();
		this.x_index=1;
		this.y_index=1;
		this.name = name;
		this.alive_yn=true;
		this.max_life = 50;
		this.life = 50;
		this.magic = 30;
		this.max_magic = 30;
		this.atk = 140;
		this.weapon_atk=0;
		this.def = 140;
		this.ats = 10;
		this.res = 10;
		this.dex = 14;
		this.crit = 0.15;
		this.level=1;
		this.exp=0;
		this.money = 10;
		this.exp_needed = 5;
		this.Items = new HashMap<String,Item>();
		this.haveCat_yn=false;
	}
	
	
	
	public void getEventEffect(int good_or_bad,int value,int event_type) {
		int final_value = (good_or_bad*value);		
		
		switch(event_type){//1:金錢 2:atk 3:def 4:dex 5:血量 6:物品損失 7:取得物品(攻擊力) 8:取得物品(防禦力) 9:魔法力 10:全能力值(代價)
			case 1:
				this.money+=final_value;
				SpeakUtil.speak(1,this.name+"的金錢變化量:"+final_value);
				break;
			case 2:
				this.atk+=final_value;
				SpeakUtil.speak(1,this.name+"的ATK變化量:"+final_value);
				break;
			case 3:
				this.def+=final_value;
				SpeakUtil.speak(1,this.name+"的DEF變化量:"+final_value);
				break;
			case 4:
				this.dex+=final_value;
				SpeakUtil.speak(1,this.name+"的DEX變化量:"+final_value);
				break;
			case 5:
				final_value = Math.min(this.max_life-this.life,final_value);
				this.life+=final_value;
				SpeakUtil.speak(1,this.name+"的血量變化量:"+final_value);
				break;
			case 6:
				this.weapon_atk=0;
				this.equ_def=0;
				SpeakUtil.speak(1,this.name+"的裝備被劫掠一空了!");
				break;
			case 7:
				if(this.weapon_atk<final_value) {
					SpeakUtil.speak(1,this.name+"穿上了撿到的裝備!");
					this.weapon_atk=final_value;
				}else {
					SpeakUtil.speak(1,this.name+"覺得自己身上的武器比較好，因此把它留在原地就走了");
				}
				break;
			case 8:
				if(this.equ_def<final_value) {
					SpeakUtil.speak(1,this.name+"穿上了撿到的裝備!");
					this.equ_def=final_value;
				}else {
					SpeakUtil.speak(1,this.name+"覺得自己身上的裝備比較好，因此把它留在原地就走了");
				}
				break;
			case 9:
				final_value = Math.min(this.max_magic-this.magic,final_value);
				this.magic+=final_value;
				SpeakUtil.speak(1,this.name+"的魔法力變化量:"+final_value);
				break;
			case 10:
				this.atk+=final_value;
				this.def+=final_value;
				this.dex+=final_value;
				this.max_life-=(final_value*4);
				if(this.life>this.max_life) {
					this.life=this.max_life;
				}
				SpeakUtil.speak(1,this.name+"的攻擊力變化量:"+final_value);
				SpeakUtil.speak(1,this.name+"的防禦力變化量:"+final_value);
				SpeakUtil.speak(1,this.name+"的敏捷力變化量:"+final_value);
				SpeakUtil.speak(1,this.name+"的某個能力似乎下降了?");
				break;
		}
	}
	
	public void getDropItem(Monster monster){
		if(monster.drop_item()!=null) {
			getNewItem(monster.drop_item());
		}		
		
	}
	
	public void getNewItem(Item item) {
		this.Items.putIfAbsent(item.getItem_name(), item);
		SpeakUtil.speak(1,name+"得到了"+item.getItem_name());
	}
	
	
	public boolean haveItemYN(String item_name) {
		if(this.Items.keySet().contains(item_name)) {//檢查是否有指定物品
			return true;
		}else {
			return false;
		}
	}
	public void move(RandomMapUtil maputil) {
		
		SpeakUtil.speak(2,"今天想往哪個方向移動?");
		boolean north=y_index>0;
		boolean west=x_index>0;
		boolean south=y_index<2;
		boolean east=x_index<2;
		List<String> s = new ArrayList<>();
		System.out.print("留在原地(Q) ");
		s.add("Q");
		s.add("q");
		if(north) 
		{
			s.add("W");
			s.add("w");
			System.out.print("北(W) ");
			}
		if(west) 
		{
			s.add("A");
			s.add("a");
			System.out.print("西(A) ");
			}
		if(south) 
		{
			s.add("S");
			s.add("s");
			System.out.print("南(S) ");
		}
		if(east) 
		{
			s.add("D");
			s.add("d");
			System.out.print("東(D) ");
		}
		
		Scanner sc = new Scanner(System.in);
		String direction = sc.next();
		while(!s.contains(direction)) {
			SpeakUtil.speak(2,"請輸入想移動的方向");
			direction = sc.next();
		}
		
		if(direction.equalsIgnoreCase("w")) { //文字要用equals!		
			SpeakUtil.speak(1,this.name+"向北移動了一格");
			y_index--;
			if(!maputil.approachable(this)) {
				y_index++;
			}
			
			}
		else if(direction.equalsIgnoreCase("d")) {
			SpeakUtil.speak(1,this.name+"向東移動了一格");
			x_index++;
			if(!maputil.approachable(this)) {
				x_index--;
			}
			}
		else if(direction.equalsIgnoreCase("s")) {
			SpeakUtil.speak(1,this.name+"向南移動了一格");
			y_index++;
			if(!maputil.approachable(this)) {
				y_index--;
			}
			}
		else if(direction.equalsIgnoreCase("a")) {
			SpeakUtil.speak(1,this.name+"向西移動了一格");
			x_index--;
			if(!maputil.approachable(this)) {
				x_index++;
			}
			
		}else if(direction.equalsIgnoreCase("q")) {
			SpeakUtil.speak(1,this.name+"停留在了原地");
		}
		}
	
	
	public void getPosition() {
		SpeakUtil.speak(1,"當前在"+x_index+","+y_index);
	}
	
	
	public void getMoney(int mon_money) {
		this.money+=mon_money;
		SpeakUtil.speak(1,this.name+"的金錢增加了"+mon_money);
	}
	
	public void newLevelWish() {
		SpeakUtil.speak(1,name+"等級提升，受到冒險之神的眷顧，可以許一個願望，請選擇：");
		SpeakUtil.speak(2,"Q:生命、魔法值全滿，提升攻擊力、防禦力、敏捷力各1點");
		SpeakUtil.speak(2,"W:提升攻擊力、防禦力、敏捷力各3點");
		SpeakUtil.speak(2,"E:提升隨機能力值10點(最大生命值/最大魔法值/攻擊/防禦/敏捷/爆擊)");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		while(!v.equalsIgnoreCase("Q")&&!v.equalsIgnoreCase("W")&&!v.equalsIgnoreCase("E")) {
			SpeakUtil.speak(2,"(請輸入對應按鍵)");
			v = sc.next();
		}
		if(v.equalsIgnoreCase("Q")) {
			this.life=this.max_life;
			this.magic=this.max_magic;
			this.atk+=1;
			this.def+=1;
			this.dex+=1;
		}else if(v.equalsIgnoreCase("W")) {
			this.atk+=3;
			this.def+=3;
			this.dex+=3;
		}else {
			double son = Math.random()*100;
			double mom = 100/6;
			switch((int)(son/mom)) {
				case 0:
					this.max_life+=10;
					break;
				case 1:
					this.max_magic+=10;
					break;
				case 2:
					this.atk+=10;
					break;
				case 3:
					this.def+=10;
					break;
				case 4:
					this.dex+=10;
					break;
				case 5:
					if(this.crit<=0.9) {
						this.crit+=0.1;
						break;
					}
					break;
			}
		}
	}
	
	public void getExperience(int mon_exp) {//待修正，升級效果由玩家選擇
		SpeakUtil.speak(1,this.name+"獲得了"+mon_exp+"點經驗值");
		this.exp+=mon_exp;
		
		while(this.exp>=this.exp_needed) {
			
			int last_exp = (this.exp-this.exp_needed);//此次取得的經驗值扣掉升這一等消耗的經驗值
			this.level+=1;
			this.exp=last_exp;
			this.exp_needed+=5;
			newLevelWish();
			SpeakUtil.speak(1,this.name+"升到"+this.level+"級了!");
			
			SpeakUtil.speak(1,this.name+"的能力值變為：");
			
			SpeakUtil.speak(1,this.toString());
		}
	}
	
	
//	public int magic_attack() {
//		Random r = new Random();
//		r.
//	} 
	
	public int attack() {
		boolean crit_yn = Math.random()>1-this.crit;
		if(crit_yn==true) {
			SpeakUtil.speak(1,this.name+"使出了憤怒一擊!");
			return (int) ((this.atk+weapon_atk)*(0.5+Math.random())*1.5);//發生了爆擊
		}
		else {
			return (int) ((this.atk+this.weapon_atk)*(0.5+Math.random()));
		}
	}
	
	public boolean failToEscape() {
		SpeakUtil.speak(2,this.name+"是否要嘗試逃跑? 請選擇: (W)是 (任意鍵):否");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		if(v.equalsIgnoreCase("w")) {
			double i = Math.random();
			if(i<0.3) {
				SpeakUtil.speak(1,this.name+"成功逃跑了，但逃跑中不慎遺落了金錢");
				int money_loss = (int)(this.money*0.2);
				this.moneyChange(money_loss);
				SpeakUtil.speak(1,this.name+"的金錢減少了:"+money_loss);
				return false;
			}else if(i<0.7){
				SpeakUtil.speak(1,this.name+"成功逃跑了");
				return false;
			}else{
				SpeakUtil.speak(1,"逃跑失敗!被追上了!");
				return true;
			}
			
		}else {			
			return true;
		}
	}
	
	public int hurt(int monster_atk) {
		int damage = Math.max(monster_atk-this.def,0);
		this.life = this.life-damage;
		
		if(this.life<=0) {			
			this.alive_yn=false;
			SpeakUtil.speak(1,this.name+"受到了"+damage+"點傷害，並且無力的倒下了。勝敗乃兵家常事，請再接再厲!");
			return damage;
		}
		SpeakUtil.speak(1,this.name+"受到了"+damage+"點傷害  (剩餘血量"+this.life+")");
		return damage;
	}
	
	
	public String getName() {
		return name;
	}

	public void moneyChange(int change_num) {
		
		this.money+=change_num;
	}
	
	public void getMonsterMoney(int change_num) {
		SpeakUtil.speak(1, name+"獲得了"+change_num+"元");
		this.money+=change_num;
	}
	
	public int getMoney() {
		return money;
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
	public int getMax_life() {
		return max_life;
	}
	public void setMax_life(int max_life) {
		this.max_life = max_life;
	}
	public int getWeapon_atk() {
		return weapon_atk;
	}
	public void setWeapon_atk(int weapon_atk) {
		this.weapon_atk = weapon_atk;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getExp_needed() {
		return exp_needed;
	}
	public void setExp_needed(int exp_needed) {
		this.exp_needed = exp_needed;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getEqu_def() {
		return equ_def;
	}
	public void setEqu_def(int equ_def) {
		this.equ_def = equ_def;
	}
	public int getMax_magic() {
		return max_magic;
	}
	public void setMax_magic(int max_magic) {
		this.max_magic = max_magic;
	}
	
	public boolean isHaveCat_yn() {
		return haveCat_yn;
	}
	public void setHaveCat_yn(boolean haveCat_yn) {
		this.haveCat_yn = haveCat_yn;
	}
	public void setLocation(int x,int y) {
		this.x_index=x;
		this.y_index=y;
	}
	
}
