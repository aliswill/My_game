package TestFunc;

import java.util.Scanner;

import Role.Hero;
import Utils.RandomMapUtil;

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
		hero.move();
		maputil.getIntoNewMap(hero);
		
		int i=0;
		while(i<100) {
			hero.move();
			maputil.getIntoNewMap(hero);
			i++;
		}
	}

}
