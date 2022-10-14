package start;

import java.util.Scanner;

import Role.Hero;
import Utils.FightUtil;
import Utils.FirstAttackUtil;
import monsters.EvilPig;
import monsters.FunnySnake;
import monsters.Monster;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("遊戲開始，請輸入你的英雄名：");
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Hero hero = new Hero(name);
		System.out.println(hero.toString());
		Monster monster = new FunnySnake();
		System.out.println(name+"遭遇了"+monster.getName()+"!");
		System.out.println(monster.toString());
		FirstAttackUtil firstattackutil = new FirstAttackUtil();
		boolean hero_first = firstattackutil.isFirst(hero.getDex(), monster.getDex());
		FightUtil fightutil= new FightUtil();
		fightutil.fight(hero_first, hero, monster);
		
		Monster monster2 = new EvilPig();
		System.out.println("===============");
		System.out.println(name+"遭遇了"+monster2.getName()+"!");
		System.out.println(monster2.toString());
		fightutil.fight(hero_first, hero, monster2);
	}

}
