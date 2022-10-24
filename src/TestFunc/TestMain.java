package TestFunc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Role.Hero;
import Role.NPCBeggar;
import Role.NPCCat;
import Role.NPCGambler;
import Role.NPCPoet;
import Role.NPCPrincess;
import Role.NPCTrader;
import Role.NPCTraveler;
import Role.NPCrole;
import Utils.FightUtil;
import Utils.RandomMapUtil;
import Utils.SpeakUtil;
import Utils.StoreUtil;
import Utils.StoryUtil;
import Utils.WaitUtil;
import monsters.BossSeaBeast;
import monsters.FinalBoss;
import monsters.FunnySnake;
import monsters.Monster;

public class TestMain {

	public static void main(String[] args) {
		
		
		
		boolean seaBossBeatYN = false;
		boolean finalBossBeatYN = false;
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
		StoryUtil storyutil = new StoryUtil();
		RandomMapUtil maputil = new RandomMapUtil();
		maputil.makeMap();		
		
		NPCrole trader = new NPCTrader(hero);
		NPCrole poet = new NPCPoet(hero, maputil);
		NPCrole beggar = new NPCBeggar(hero);
		NPCrole gambler = new NPCGambler(hero);
		NPCrole traveler = new NPCTraveler(hero, maputil);
		NPCPrincess princess = new NPCPrincess(hero);
		NPCCat cat = new NPCCat(hero);
		
		storyutil.sayStart(day);
		maputil.reLocateHero(hero);
		maputil.getMapNPC(hero, traveler);
		while(day<=25) {
			
			SpeakUtil.speak(1,"今天是第"+day+"天");
			storyutil.sayNews(day, hero);
	
			if(maputil.getCurrentMap(hero).getId()==1) {				
				StoreUtil storeutil = new StoreUtil();
				String welcome_yn = storeutil.welcomStore();
				storeutil.useStore(hero, welcome_yn);				
			}
			
			hero.move(maputil);
			maputil.getIntoNewMap(hero);
			
			maputil.getMapNPC(hero, trader);
			maputil.getMapNPC(hero, poet);
			maputil.getMapNPC(hero, beggar);
			maputil.getMapNPC(hero, gambler);
			maputil.getMapNPC(hero, traveler);
			maputil.getMapNPC(hero, cat);
			princess.appear(day,maputil);
			
			if(day>=11&&maputil.getCurrentMap(hero).getId()==6&&!seaBossBeatYN) {//海怪boss
				Monster seaBoss = new BossSeaBeast();
				SpeakUtil.speak(1,name+"遭遇了等級"+seaBoss.getMonster_level()+"的"+seaBoss.getName()+"!");
				SpeakUtil.speak(1,seaBoss.toString());
				if(hero.failToEscape()) {
					FightUtil fightutil= new FightUtil();
					fightutil.fight(hero, seaBoss);
					if(!hero.isAlive_yn()||hero.getLife()<=0) {
						SpeakUtil.speak(1,"遊戲結束!請下次再挑戰");
						break;
					}else {
						seaBossBeatYN=true;
					}
				}
			}
			
			if(maputil.getCurrentMap(hero).getId()==9&&!finalBossBeatYN) {//海怪boss
				Monster boss = new FinalBoss();
				SpeakUtil.speak(1,name+"遭遇了等級"+boss.getMonster_level()+"的"+boss.getName()+"!");
				SpeakUtil.speak(1,boss.toString());
				if(hero.failToEscape()) {
					FightUtil fightutil= new FightUtil();
					fightutil.fight(hero, boss);
					if(!hero.isAlive_yn()||hero.getLife()<=0) {
						SpeakUtil.speak(1,"遊戲結束!請下次再挑戰");
						break;
					}else {
						finalBossBeatYN=true;
					}
				}
			}
			
			if(maputil.MonsterHappenedYn()) {
				Monster monster = maputil.getMapMonster(hero);
				SpeakUtil.speak(1,name+"遭遇了等級"+monster.getMonster_level()+"的"+monster.getName()+"!");
				SpeakUtil.speak(1,monster.toString());
				if(hero.failToEscape()) {
					FightUtil fightutil= new FightUtil();
					fightutil.fight(hero, monster);
					if(!hero.isAlive_yn()||hero.getLife()<=0) {
						SpeakUtil.speak(1,"遊戲結束!請下次再挑戰");
						break;
					}
				}
				
			}else {
				
				SpeakUtil.speak(1,"今天沒有遭遇怪物。");
			}
			
			maputil.getMapEvent(hero);
			if(!hero.isAlive_yn()||hero.getLife()<=0) {
				SpeakUtil.speak(1,"遊戲結束!請下次再挑戰");
				break;
			}
			
			if(maputil.getCurrentMap(hero).getMap_name().equals("平凡的小鎮")) {
				StoreUtil storeutil = new StoreUtil();
				storeutil.useHotel(hero);
				
			}
			
			storyutil.sayKey(hero);
			
			if(storyutil.sayEndding(hero, day)) {
				break;
			}
			
			
			
			SpeakUtil.speak(1,"--------------------------------------------");
			SpeakUtil.speak(1,"今天"+hero.getName()+"的狀態值為:"+hero.toString());
			day++;
		}
		
		

	}

}
