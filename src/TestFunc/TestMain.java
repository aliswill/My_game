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

		// TODO Auto-generated method stub
		System.out.println("遊戲開始，請輸入你的英雄名：");		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Hero hero = new Hero(name);
		RandomMapUtil maputil = new RandomMapUtil();
		maputil.makeMap();
		maputil.getIntoNewMap(hero);
		hero.move();
		maputil.getIntoNewMap(hero);
		maputil.getMapEvent(hero);
		
		Monster monster = new FunnySnake();
		System.out.println(name+"遭遇了"+monster.getName()+"!");
		System.out.println(monster.toString());
		FightUtil fightutil= new FightUtil();
		fightutil.fight(hero, monster);
	}

}
