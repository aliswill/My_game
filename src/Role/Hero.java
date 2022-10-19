package Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
	
	
	
//	@Override
//	public String toString() {
//		return this.name+"的生命值：" + life + ",魔法力：" + magic + ",攻擊力：" + atk + ",防禦力:" + def + ",魔法攻擊力:" + ats + ",魔法防禦力:"
//				+ ""
//				+ res + ",敏捷力：" + dex + ",等級：" + level + ",爆擊率:" + crit;
//	}
	
	@Override
	public String toString() {
		return this.name+"的生命值：" + life  + ",攻擊力：" + atk + ",防禦力:" + def  + 
				 ",敏捷力：" + dex + ",等級：" + level + ",爆擊率:" + crit +",金錢:" + money;
	}
	public Hero(String name) {
		super();
		this.x_index=1;
		this.y_index=1;
		this.name = name;
		this.alive_yn=true;
		this.max_life = 40;
		this.life = 40;
		this.magic = 30;
		this.max_magic = 30;
		this.atk = 10;
		this.weapon_atk=0;
		this.def = 10;
		this.ats = 10;
		this.res = 10;
		this.dex = 10;
		this.crit = 0.15;
		this.level=1;
		this.exp=0;
		this.money = 10;
		this.exp_needed = 5;
	}
	
	
	
	public void getEventEffect(int good_or_bad,int value,int event_type) {
		int final_value = (good_or_bad*value);		
		
		switch(event_type){//1:金錢 2:atk 3:def 4:dex 5:血量 6:物品損失 7:取得物品(攻擊力) 8:取得物品(防禦力) 9:魔法力 10:全能力值(代價)
			case 1:
				this.money+=final_value;
				SpeakUtil.speak(this.name+"的金錢變化量:"+final_value);
				break;
			case 2:
				this.atk+=final_value;
				SpeakUtil.speak(this.name+"的ATK變化量:"+final_value);
				break;
			case 3:
				this.def+=final_value;
				SpeakUtil.speak(this.name+"的DEF變化量:"+final_value);
				break;
			case 4:
				this.dex+=final_value;
				SpeakUtil.speak(this.name+"的DEX變化量:"+final_value);
				break;
			case 5:
				final_value = Math.min(this.max_life-this.life,final_value);
				this.life+=final_value;
				SpeakUtil.speak(this.name+"的血量變化量:"+final_value);
				break;
			case 6:
				this.weapon_atk=0;
				this.equ_def=0;
				SpeakUtil.speak(this.name+"的裝備被劫掠一空了!");
			case 7:
				if(this.weapon_atk<final_value) {
					SpeakUtil.speak(this.name+"穿上了撿到的裝備!");
					this.weapon_atk=final_value;
				}else {
					SpeakUtil.speak(this.name+"覺得自己身上的武器比較好，因此把它留在原地就走了");
				}
				break;
			case 8:
				if(this.equ_def<final_value) {
					SpeakUtil.speak(this.name+"穿上了撿到的裝備!");
					this.equ_def=final_value;
				}else {
					SpeakUtil.speak(this.name+"覺得自己身上的裝備比較好，因此把它留在原地就走了");
				}
				break;
			case 9:
				final_value = Math.min(this.max_magic-this.magic,final_value);
				this.magic+=final_value;
				SpeakUtil.speak(this.name+"的魔法力變化量:"+final_value);
				break;
			case 10:
				this.atk+=final_value;
				this.def+=final_value;
				this.dex+=final_value;
				this.max_life-=(final_value*4);
				if(this.life>this.max_life) {
					this.life=this.max_life;
				}
				SpeakUtil.speak(this.name+"的攻擊力變化量:"+final_value);
				SpeakUtil.speak(this.name+"的防禦力變化量:"+final_value);
				SpeakUtil.speak(this.name+"的敏捷力變化量:"+final_value);
				SpeakUtil.speak(this.name+"的某個能力似乎下降了?");
				break;
		}
	}
	
	public void move() {
		
		SpeakUtil.speak("今天想往哪個方向移動?");
		boolean north=y_index>0;
		boolean west=x_index>0;
		boolean south=y_index<2;
		boolean east=x_index<2;
		List<String> s = new ArrayList<>();
		if(north) 
		{
			s.add("北");
			System.out.print("北 ");
			}
		if(west) 
		{
			s.add("西");
			System.out.print("西 ");
			}
		if(south) 
		{
			s.add("南");
			System.out.print("南 ");
		}
		if(east) 
		{
			s.add("東");
			System.out.print("東 ");
		}
		
		Scanner sc = new Scanner(System.in);
		String direction = sc.next();
		while(!s.contains(direction)) {
			SpeakUtil.speak("請輸入想移動的方向");
			direction = sc.next();
		}
		
		if(direction.equals("北")) { //文字要用equals!
			
			SpeakUtil.speak(this.name+"向北移動了一格");
			y_index--;
			}
		else if(direction.equals("東")) {
			SpeakUtil.speak(this.name+"向東移動了一格");
			x_index++;
			}
		else if(direction.equals("南")) {
			SpeakUtil.speak(this.name+"向南移動了一格");
			y_index++;
			}
		else if(direction.equals("西")) {
			SpeakUtil.speak(this.name+"向西移動了一格");
			x_index--;}	
		}
	
	
	public void getPosition() {
		SpeakUtil.speak("當前在"+x_index+","+y_index);
	}
	
	
	public void getMoney(int mon_money) {
		this.money+=mon_money;
		SpeakUtil.speak(this.name+"的金錢增加了"+mon_money);
	}
	
	public void newLevelWish() {
		SpeakUtil.speak(name+"等級提升，受到冒險之神的眷顧，可以許一個願望，請選擇：");
		SpeakUtil.speak("Q:生命、魔法值全滿，提升攻擊力、防禦力、敏捷力各1點");
		SpeakUtil.speak("W:提升攻擊力、防禦力、敏捷力各3點");
		SpeakUtil.speak("E:提升隨機能力值10點(最大生命值/最大魔法值/攻擊/防禦/敏捷/爆擊)");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		while(!v.equalsIgnoreCase("Q")&&!v.equalsIgnoreCase("W")&&!v.equalsIgnoreCase("E")) {
			SpeakUtil.speak("(請輸入對應按鍵)");
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
			double son = Math.random();
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
		
		this.exp+=mon_exp;
		
		while(this.exp>=this.exp_needed) {
			
			int last_exp = (this.exp-this.exp_needed);//此次取得的經驗值扣掉升這一等消耗的經驗值
			this.level+=1;
			this.exp=last_exp;
			this.exp_needed+=5;
			newLevelWish();
			SpeakUtil.speak(this.name+"升到"+this.level+"級了!");
			
			SpeakUtil.speak(this.name+"的能力值變為：");
			
			SpeakUtil.speak(this.toString());
		}
	}
	
	
//	public int magic_attack() {
//		Random r = new Random();
//		r.
//	} 
	
	public int attack() {
		boolean crit_yn = Math.random()>1-this.crit;
		if(crit_yn==true) {
			SpeakUtil.speak(this.name+"使出了憤怒一擊!");
			return (int) ((this.atk+weapon_atk)*(0.45+Math.random())*1.5);//發生了爆擊
		}
		else {
			return (int) ((this.atk+this.weapon_atk)*(0.45+Math.random()));
		}
	}
	
	public int hurt(int monster_atk) {
		int damage = Math.max(monster_atk-this.def,0);
		this.life = this.life-damage;
		
		if(this.life<=0) {			
			this.alive_yn=false;
			SpeakUtil.speak(this.name+"受到了"+damage+"點傷害，並且無力的倒下了。勝敗乃兵家常事，請再接再厲!");
			return damage;
		}
		SpeakUtil.speak(this.name+"受到了"+damage+"點傷害  (剩餘血量"+this.life+")");
		return damage;
	}

//	public void meetBeggar() {
//		SpeakUtil.speak("一名乞丐蜷曲著雙腿對你乞討");
//		
//		SpeakUtil.speak("請選擇：　W:給他錢 E:搶他碗裡的錢 任意鍵:無視");
//		Scanner sc = new Scanner(System.in);
//		String v = sc.next();
//		if(v.equalsIgnoreCase("w")) {
//			int gived_money = (int)(this.money*0.3);
//			if(gived_money>0) {
//				SpeakUtil.speak(this.name+"給了乞丐"+gived_money+"元");
//				
//				SpeakUtil.speak("乞丐感激地收下了錢");
//				
//				SpeakUtil.speak("乞丐:謝謝你的幫助，好心的旅人，其實我年輕時也喜歡到各地冒險，我教給你一些防身的技巧如何?");
//				
//				this.atk+=1;
//				SpeakUtil.speak(this.name+"的攻擊力提升了1");
//			}else {
//				SpeakUtil.speak(this.name+"沒有錢可以給乞丐...");
//			}
//			
//		}else if(v.equalsIgnoreCase("e")) {
//			SpeakUtil.speak(this.name+"伸手要搶乞丐碗裡的幾個銅板");
//			
//			SpeakUtil.speak("乞丐:真是世風日下啊!是你先對我不仁，休怪我了!");
//			
//			Monster monster = new Beggar();
//			SpeakUtil.speak(this.name+"遭遇了等級"+monster.getMonster_level()+"的"+monster.getName()+"!");
//			SpeakUtil.speak(monster.toString());
//			FightUtil fightutil= new FightUtil();
//			fightutil.fight(this, monster);
//			if(!this.isAlive_yn()) {
//				SpeakUtil.speak("乞丐：年輕人，我給你一次機會，下次不要在幹這種缺德事了");
//				this.setAlive_yn(true);
//				this.setLife(1);
//				SpeakUtil.speak(this.name+"的生命值剩餘1");
//			}
//		}else {
//			SpeakUtil.speak("("+this.name+"無視了他");
//			
//		}		
//	}
//	
//	public void meetTraveler(RandomMapUtil maputil) {
//			
//			SpeakUtil.speak("前方出現一名狼狽不堪的旅行者，全身都是汙跡跟血漬");
//			
//			SpeakUtil.speak("請選擇：　W:嘲笑他  E:遞給他水喝 任意鍵:無視");
//			Scanner sc = new Scanner(System.in);
//			String v = sc.next();
//			if(v.equalsIgnoreCase("w")) {
//				SpeakUtil.speak(this.name+":你怎麼搞的這麼狼狽啊~沒實力還是別出來冒險吧哈哈");
//				
//				SpeakUtil.speak("狼狽不堪的旅行者瞪了一眼"+this.name+"並踱著緩步走了");
//			}else if(v.equalsIgnoreCase("e")) {
//				SpeakUtil.speak("狼狽不堪的旅行者：謝謝你啊~你也是旅行者吧?");
//				
//				SpeakUtil.speak("狼狽不堪的旅行者：其實啊..我剛剛從"+ maputil.getDanagerousDirection(this)+"方而來");
//				
//				SpeakUtil.speak("狼狽不堪的旅行者：那裏的敵人都特別強大，你最好不要往那邊走");
//				
//				SpeakUtil.speak("狼狽不堪的旅行者：那麼再會了，謝謝你的茶水~");
//			}else {
//				SpeakUtil.speak("("+this.name+"無視了他)");
//				
//				SpeakUtil.speak("旅行者步履蹣跚地走了");
//			}		
//		}
//	
//	
//	public void meetGambler() {
//		SpeakUtil.speak("一名穿著名貴西裝的男人主動走過來向你搭話");
//		
//		SpeakUtil.speak("穿西裝的男人:唷~旅行者，每天冒險的日子不累嗎?");
//		
//		SpeakUtil.speak("穿西裝的男人:想不想嘗試輕輕鬆鬆賺快錢的方法?");
//		
//		SpeakUtil.speak("請選擇：　W:想!非常想 E:什麼方法? 任意鍵:不想。");
//		Scanner sc = new Scanner(System.in);
//		String v = sc.next();
//		if(v.equalsIgnoreCase("w")||v.equalsIgnoreCase("e")) {
//			SpeakUtil.speak("穿西裝的男人:有興趣就對啦~很簡單的!");
//			
//			SpeakUtil.speak("穿西裝的男人:我寫下1~25中的一個數字，給你三次機會，只要你猜中了，我就把賭本貼三倍給你，如何?");
//			
//			SpeakUtil.speak("穿西裝的男人:猜錯的時候我也會給你提示，來吧~你想押多少");
//			
//			SpeakUtil.speak("請選擇：　W:身上一半的錢 E:身上全部的錢 任意鍵:不押，賭博是不好的");
//			String v1 = sc.next();
//			if(this.money<2) {
//				SpeakUtil.speak(this.name+":抱歉..我身上錢不夠..");
//			}
//			else if(v1.equalsIgnoreCase("w")){
//				int gam_num = (int) (this.money*0.5);
//				if(playGuessNumber()) {
//					this.money+=(gam_num*2);
//					
//					SpeakUtil.speak(this.name+"的金錢變為:"+this.money);
//				}else {
//					this.money-=gam_num;
//					
//					SpeakUtil.speak(this.name+"的金錢變為:"+this.money);
//				}
//				
//			}else if(v1.equalsIgnoreCase("e")) {
//				int gam_num = this.money;
//				if(playGuessNumber()) {
//					this.money+=(gam_num*2);
//					
//					SpeakUtil.speak(this.name+"的金錢變為:"+this.money);
//				}else {
//					this.money-=gam_num;
//					
//					SpeakUtil.speak(this.name+"的金錢變為:"+this.money);
//				}
//			}else {
//				SpeakUtil.speak("穿西裝的男人:是你自己讓機會溜走的~別後悔啊");
//			}
//		}else {
//			SpeakUtil.speak("穿西裝的男人:诶~真冷淡耶~");
//			
//			SpeakUtil.speak("穿西裝的男人:改變心意記得跟我說喔!");
//		}
//	}
	
	
	
	public void meetInformationVendor() {
		SpeakUtil.speak("");
		
		SpeakUtil.speak("");
	}
	
	public String getName() {
		return name;
	}

	public void moneyChange(int change_num) {
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
	
	public void setLocation(int x,int y) {
		this.x_index=x;
		this.y_index=y;
	}
	
}
