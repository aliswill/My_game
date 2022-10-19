package Role;

import java.util.Scanner;

import Utils.FightUtil;
import Utils.RandomMapUtil;
import Utils.WaitUtil;
import monsters.Monster;
import monsters.Beggar;

public class NPC {
	
	
	
	
	public void meetBeggar(Hero hero) {//移到hero了
		System.out.println("一名乞丐蜷曲著雙腿對你乞討");
		WaitUtil.wait(1000);
		System.out.println("請選擇：　W:給他錢 E:搶他碗裡的錢 任意鍵:無視");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		if(v.equalsIgnoreCase("w")) {
			int gived_money = (int)(hero.getMoney()*0.2);
			if(gived_money>0) {
				System.out.println(hero.getName()+"給了乞丐"+gived_money+"元");
				WaitUtil.wait(1000);
				System.out.println("乞丐感激地收下了錢");
				WaitUtil.wait(1000);
				System.out.println("乞丐:謝謝你的幫助，好心的旅人，其實我年輕時也喜歡到各地冒險，我教給你一些防身的技巧如何?");
				WaitUtil.wait(1000);
				hero.setAtk(hero.getAtk()+1);
				System.out.println(hero.getName()+"的攻擊力提升了1");
			}else {
				System.out.println(hero.getName()+"沒有錢可以給乞丐...");
			}
			
		}else if(v.equalsIgnoreCase("e")) {
			System.out.println(hero.getName()+"伸手要搶乞丐碗裡的幾個銅板");
			WaitUtil.wait(1000);
			System.out.println("乞丐:真是世風日下啊!是你先對我不仁，休怪我了!");
			WaitUtil.wait(1000);
			Monster monster = new Beggar();
			System.out.println(hero.getName()+"遭遇了等級"+monster.getMonster_level()+"的"+monster.getName()+"!");
			System.out.println(monster.toString());
			FightUtil fightutil= new FightUtil();
			fightutil.fight(hero, monster);
			if(!hero.isAlive_yn()) {
				System.out.println("乞丐：年輕人，我給你一次機會，下次不要在幹這種缺德事了");
				hero.setAlive_yn(true);
				hero.setLife(1);
				System.out.println(hero.getName()+"的生命值剩餘1");
			}
		}else {
			System.out.println("("+hero.getName()+"無視了他");
			
		}		
	}
	
	public void meetTraveler(Hero hero,RandomMapUtil maputil) {//移到hero了
//		
//		System.out.println("前方出現一名狼狽不堪的旅行者，全身都是汙跡跟血漬");
//		WaitUtil.wait(1000);
//		System.out.println("請選擇：　W:嘲笑他  E:遞給他水喝 任意鍵:無視");
//		Scanner sc = new Scanner(System.in);
//		String v = sc.next();
//		if(v.equalsIgnoreCase("w")) {
//			System.out.println(hero.getName()+":你怎麼搞的這麼狼狽啊~沒實力還是別出來冒險吧哈哈");
//			WaitUtil.wait(1000);
//			System.out.println("狼狽不堪的旅行者瞪了一眼"+hero.getName()+"並踱著緩步走了");
//		}else if(v.equalsIgnoreCase("e")) {
//			System.out.println("狼狽不堪的旅行者：謝謝你啊~你也是旅行者吧?");
//			WaitUtil.wait(1000);
//			System.out.println("狼狽不堪的旅行者：其實啊..我剛剛從"+ maputil.getDanagerousDirection(hero)+"方而來");
//			WaitUtil.wait(1000);
//			System.out.println("狼狽不堪的旅行者：那裏的敵人都特別強大，你最好不要往那邊走");
//			WaitUtil.wait(1000);
//			System.out.println("狼狽不堪的旅行者：那麼再會了，謝謝你的茶水~");
//		}else {
//			System.out.println("("+hero.getName()+"無視了他)");
//			WaitUtil.wait(1000);
//			System.out.println("旅行者步履蹣跚地走了");
//		}		
	}
}
