package Utils;

import Role.Hero;
import monsters.Monster;

public class FightUtil {
	public FightUtil() {}
	
	
	
	
	public void fight(Hero hero,Monster monster) {
		while(hero.isAlive_yn()&&monster.getAliveYN()) {
			WaitUtil.wait(1000);
			if(is_hero_attack(hero.getDex(),monster.getDex())) {//英雄攻擊
				//目標設計多種指令:1.攻擊 2.使用咒文 3.逃跑(僅在戰鬥一開始可以跑)
				System.out.println(hero.getName()+"用力的揍了"+monster.getName());
				monster.hurt(hero);
				if(!monster.getAliveYN()) {
				hero.getExperience(monster.getExp());
				hero.getMoney(monster.getMoney());
				break;
			}
			}else {//怪物攻擊
				hero.hurt(monster.attack());
				if(!hero.isAlive_yn()) {
					break;
				}
			}
					
					
					
		}
	}
	
	public boolean is_hero_attack(int hero_dex,int monster_dex) {
		//利用敏捷來回傳此輪誰進行攻擊
		if(hero_dex+monster_dex==0) {
			return Math.random()>0.5;
		}
		double mom = hero_dex+monster_dex;
		double son = hero_dex;
		double hero_attack_ratio=son/mom;
		double r = Math.random();
		
		return r<hero_attack_ratio;
		
	}
	
//	public double getRatio() {
//		
//	}
	
	
//	public void fight(boolean hero_first,Hero hero,Monster monster) {
//		if(hero_first) {//英雄先攻
//			while(hero.isAlive_yn()==true&&monster.getAliveYN()==true) {
//				System.out.println(hero.getName()+"用力的揍了"+monster.getName());
//				monster.hurt(hero.attack(),hero);
//				if(monster.getAliveYN()==false) {
//					hero.getExperience(monster.getExp());
//					break;
//				}
//				System.out.println(hero.getName()+"被"+monster.getName()+"打得滿地打滾");
//				hero.hurt(monster.attack());
//				
//				if(hero.isAlive_yn()==false) {
//					break;
//				}
//			}
//		}
//		else {
//			while(hero.isAlive_yn()==true&&monster.getAliveYN()==true) {
//				System.out.println(hero.getName()+"被"+monster.getName()+"打得滿地打滾");
//				hero.hurt(monster.attack());
//				if(hero.isAlive_yn()==false) {
//					break;
//				}
//				System.out.println(hero.getName()+"用力的揍了"+monster.getName());
//				monster.hurt(hero.attack(),hero);	
//				if(monster.getAliveYN()==false) {
//					hero.getExperience(monster.getExp());
//					break;
//				}
//			}
//		}
//	}
}
