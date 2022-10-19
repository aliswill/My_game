package Role;

import java.util.Scanner;

import Utils.FightUtil;
import Utils.SpeakUtil;
import Utils.WaitUtil;
import monsters.Monster;
import monsters.Beggar;

public class NPCBeggar implements NPCrole {

	private Hero hero;
	
	public NPCBeggar(Hero hero) {
		super();
		this.hero = hero;
	}


	@Override
	public void appear() {
		SpeakUtil.speak(1,"一名乞丐蜷曲著雙腿對你乞討");
		
		SpeakUtil.speak(2,"請選擇：　W:給他錢 E:搶他碗裡的錢 任意鍵:無視");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		if(v.equalsIgnoreCase("w")) {
			int gived_money = (int)(hero.getMoney()*0.2);
			if(gived_money>0) {
				System.out.println(hero.getName()+"給了乞丐"+gived_money+"元");
				
				SpeakUtil.speak(1,"乞丐感激地收下了錢");
				
				SpeakUtil.speak(1,"乞丐:謝謝你的幫助，好心的旅人，其實我年輕時也喜歡到各地冒險，我教給你一些防身的技巧如何?");
				
				hero.setAtk(hero.getAtk()+1);
				System.out.println(hero.getName()+"的攻擊力提升了1");
			}else {
				System.out.println(hero.getName()+"沒有錢可以給乞丐...");
			}
			
		}else if(v.equalsIgnoreCase("e")) {
			System.out.println(hero.getName()+"伸手要搶乞丐碗裡的幾個銅板");
			
			SpeakUtil.speak(1,"乞丐:真是世風日下啊!是你先對我不仁，休怪我了!");
			
			Monster monster = new Beggar();
			System.out.println(hero.getName()+"遭遇了等級"+monster.getMonster_level()+"的"+monster.getName()+"!");
			System.out.println(monster.toString());
			FightUtil fightutil= new FightUtil();
			fightutil.fight(hero, monster);
			if(!hero.isAlive_yn()) {
				SpeakUtil.speak(1,"乞丐：年輕人，我給你一次機會，下次不要在幹這種缺德事了");
				hero.setAlive_yn(true);
				hero.setLife(1);
				System.out.println(hero.getName()+"的生命值剩餘1");
			}
		}else {
			SpeakUtil.speak(1,"("+hero.getName()+"無視了他");
			
		}		
	}



}
