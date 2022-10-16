package TestFunc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Role.Hero;
import Utils.FightUtil;
import Utils.RandomMapUtil;
import Utils.StoreUtil;
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
		System.out.println("遊戲開始，請輸入你的英雄名：");		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Hero hero = new Hero(name);
		
		RandomMapUtil maputil = new RandomMapUtil();
		maputil.makeMap();
		maputil.getIntoNewMap(hero);
		
		while(day<=12) {
			System.out.println("今天是第"+day+"天");
			if(maputil.getCurrentMap(hero).getMap_name().equals("平凡的小鎮")) {
				StoreUtil storeutil = new StoreUtil();
				String welcome_yn = storeutil.welcomStore();
				storeutil.useStore(hero, welcome_yn);
				
			}
			hero.move();
			maputil.getIntoNewMap(hero);		
			if(maputil.MonsterHappenedYn()) {
				Monster monster = maputil.getMapMonster(hero);
				System.out.println(name+"遭遇了等級"+monster.getMonster_level()+"的"+monster.getName()+"!");
				System.out.println(monster.toString());
				FightUtil fightutil= new FightUtil();
				fightutil.fight(hero, monster);
			}else {
				System.out.println("今天沒有遭遇怪物。");
			}
			maputil.getMapEvent(hero);
			System.out.println("今天"+hero.getName()+"的狀態值為:"+hero.toString());
			day++;
		}
		
		

	}

}
