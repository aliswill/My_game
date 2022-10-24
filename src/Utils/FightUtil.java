package Utils;

import Role.Hero;
import monsters.Monster;

public class FightUtil {
	public FightUtil() {}
	
	
	
	
	public void fight(Hero hero,Monster monster) {
		while(hero.isAlive_yn()&&monster.getAliveYN()) {
			
			if(is_hero_attack(hero.getDex(),monster.getDex())) {//英雄攻擊
				//目標設計多種指令:1.攻擊 2.使用咒文 3.逃跑(僅在戰鬥一開始可以跑)
				SpeakUtil.speak(2,hero.getName()+"用力的揍了"+monster.getName());
				monster.hurt(hero);
				if(hero.isHaveCat_yn()) {
					if(Math.random()<0.3) {
						int final_value = Math.min(hero.getLife()+(int)(hero.getMax_life()*0.05), hero.getMax_life());					
						SpeakUtil.speak(2,hero.getCat_name()+"幫你舔舐傷口，"+hero.getName()+"恢復了"+(final_value-hero.getLife())+"點生命值");
						hero.setLife(final_value);
					}
				}
				if(!monster.getAliveYN()) {
				
				hero.getMonsterMoney(monster.getMoney());;
				hero.getDropItem(monster);
				hero.getExperience(monster.getExp());
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
//				SpeakUtil.speak(hero.getName()+"用力的揍了"+monster.getName());
//				monster.hurt(hero.attack(),hero);
//				if(monster.getAliveYN()==false) {
//					hero.getExperience(monster.getExp());
//					break;
//				}
//				SpeakUtil.speak(hero.getName()+"被"+monster.getName()+"打得滿地打滾");
//				hero.hurt(monster.attack());
//				
//				if(hero.isAlive_yn()==false) {
//					break;
//				}
//			}
//		}
//		else {
//			while(hero.isAlive_yn()==true&&monster.getAliveYN()==true) {
//				SpeakUtil.speak(hero.getName()+"被"+monster.getName()+"打得滿地打滾");
//				hero.hurt(monster.attack());
//				if(hero.isAlive_yn()==false) {
//					break;
//				}
//				SpeakUtil.speak(hero.getName()+"用力的揍了"+monster.getName());
//				monster.hurt(hero.attack(),hero);	
//				if(monster.getAliveYN()==false) {
//					hero.getExperience(monster.getExp());
//					break;
//				}
//			}
//		}
//	}
}
