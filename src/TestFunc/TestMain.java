package TestFunc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Role.Hero;
import Role.NPCPoet;
import Role.NPCTrader;
import Utils.FightUtil;
import Utils.RandomMapUtil;
import Utils.SpeakUtil;
import Utils.StoreUtil;
import Utils.WaitUtil;
import monsters.FunnySnake;
import monsters.Monster;

public class TestMain {

	public static void main(String[] args) {
		
		
//		//測試咒語部分 隨機產生字串
//		byte[] b_arr = {'a','b','c','d','e','f','g'};//new byte[20];
//		System.out.println(b_arr);
////		Random r = new Random();
////		r.nextBytes(b_arr);
//		String s = new String(b_arr,StandardCharsets.UTF_8);
//		System.out.println(s);
//		//System.out.println(Arrays.toString(byteArr));
//		//System.out.println(Arrays.asList(b_arr.toString()));
//		
		int day=1;
		
		// TODO Auto-generated method stub
		SpeakUtil.speak(2,"遊戲開始，請輸入你的英雄名：");		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Hero hero = new Hero(name);
		
	
		
		RandomMapUtil maputil = new RandomMapUtil();
		maputil.makeMap();
		maputil.reLocateHero(hero);
		
		NPCTrader a = new NPCTrader(hero);
		NPCPoet b = new NPCPoet(hero,maputil);
		b.appear();
		a.appear();
		
		while(day<=12) {
			
			SpeakUtil.speak(1,"今天是第"+day+"天");
	
			if(maputil.getCurrentMap(hero).getId()==1) {
				
				StoreUtil storeutil = new StoreUtil();
				String welcome_yn = storeutil.welcomStore();
				storeutil.useStore(hero, welcome_yn);
				
			}
			hero.move(maputil);
			maputil.getIntoNewMap(hero);		
			if(maputil.MonsterHappenedYn()) {
				Monster monster = maputil.getMapMonster(hero);
				SpeakUtil.speak(1,name+"遭遇了等級"+monster.getMonster_level()+"的"+monster.getName()+"!");
				SpeakUtil.speak(1,monster.toString());
				if(hero.escape()) {
					FightUtil fightutil= new FightUtil();
					fightutil.fight(hero, monster);
					if(!hero.isAlive_yn()) {
						SpeakUtil.speak(1,"遊戲結束!請下次再挑戰");
						break;
					}
				}
				
			}else {
				
				SpeakUtil.speak(1,"今天沒有遭遇怪物。");
			}
			maputil.getMapEvent(hero);
			if(!hero.isAlive_yn()) {
				SpeakUtil.speak(1,"遊戲結束!請下次再挑戰");
				break;
			}
			if(maputil.getCurrentMap(hero).getMap_name().equals("平凡的小鎮")) {
				StoreUtil storeutil = new StoreUtil();
				storeutil.useHotel(hero);
				
			}
			
			SpeakUtil.speak(1,"--------------------------------------------");
			SpeakUtil.speak(1,"今天"+hero.getName()+"的狀態值為:"+hero.toString());
			day++;
		}
		
		

	}

}
