package TestFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Role.Hero;
import Utils.FightUtil;
import Utils.RandomMapUtil;
import monsters.FunnySnake;
import monsters.Monster;

public class TestMain {

	public static void main(String[] args) {

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
