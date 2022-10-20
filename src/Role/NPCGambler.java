package Role;

import java.util.Scanner;

import Utils.CheckType;
import Utils.SpeakUtil;
import Utils.WaitUtil;

public class NPCGambler implements NPCrole {

	private Hero hero;
	
	
	public NPCGambler(Hero hero) {
		super();
		this.hero = hero;
	}

	@Override
	public void appear() {
		// TODO Auto-generated method stub
		SpeakUtil.speak(1,"(一名穿著名貴西裝的男人主動走過來向你搭話)");
		
		SpeakUtil.speak(1,"穿西裝的男人:唷~旅行者，每天冒險的日子不累嗎?");
		
		SpeakUtil.speak(1,"穿西裝的男人:想不想嘗試輕輕鬆鬆賺快錢的方法?");
		
		SpeakUtil.speak(2,"請選擇：　W:想!非常想 E:什麼方法? 任意鍵:不想。");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		if(v.equalsIgnoreCase("w")||v.equalsIgnoreCase("e")) {
			SpeakUtil.speak(1,"穿西裝的男人:有興趣就對啦~很簡單的!");
			
			SpeakUtil.speak(1,"穿西裝的男人:我寫下1~25中的一個數字，給你三次機會，只要你猜中了，我就把賭本貼三倍給你，如何?");
			
			SpeakUtil.speak(1,"穿西裝的男人:猜錯的時候我也會給你提示，來吧~你想押多少");
			
			SpeakUtil.speak(2,"請選擇：　W:身上一半的錢 E:身上全部的錢 任意鍵:不押，賭博是不好的");
			String v1 = sc.next();
			if(hero.getMoney()<2) {
				System.out.println(hero.getName()+":抱歉..我身上錢不夠..");
			}
			else if(v1.equalsIgnoreCase("w")){
				int gam_num = (int) (hero.getMoney()*0.5);
				if(playGuessNumber()) {
					hero.moneyChange(gam_num*2);
					
					System.out.println(hero.getName()+"的金錢變為:"+hero.getMoney());
				}else {
					hero.moneyChange(-gam_num*2);
					
					System.out.println(hero.getName()+"的金錢變為:"+hero.getMoney());
				}
				
			}else if(v1.equalsIgnoreCase("e")) {
				int gam_num = hero.getMoney();
				if(playGuessNumber()) {
					hero.moneyChange(gam_num*2);
					
					System.out.println(hero.getName()+"的金錢變為:"+hero.getMoney());
				}else {
					hero.moneyChange(-gam_num*2);
					
					System.out.println(hero.getName()+"的金錢變為:"+hero.getMoney());
				}
			}else {
				SpeakUtil.speak(1,"穿西裝的男人:是你自己讓機會溜走的~別後悔啊");
			}
		}else {
			SpeakUtil.speak(1,"穿西裝的男人:诶~真冷淡耶~");
			
			SpeakUtil.speak(1,"穿西裝的男人:改變心意記得跟我說喔!");
		}
	}

	public boolean playGuessNumber() {
		int ans = (int)(Math.random()*25)+1;
		int time=0;
		SpeakUtil.speak(2,"穿西裝的男人:答案已經出好，你開始猜吧");	
		Scanner sc = new Scanner(System.in);
		while(time<3) {					
			String v = sc.next();
			while(!CheckType.isNumeric(v)) {
				SpeakUtil.speak(2,"穿西裝的男人:喂喂，我說猜數字欸數字");	
				v = sc.next();
			}
			int guess_num = Integer.parseInt(v);										
			if(guess_num<ans) {
				SpeakUtil.speak(2,"穿西裝的男人:哈哈!再大一些");
			}else if(guess_num>ans) {
				SpeakUtil.speak(2,"穿西裝的男人:可惜囉!再小一些");
			}else {
				SpeakUtil.speak(1,"穿西裝的男人:喔!不!你怎麼可能猜中..");
				
				return true;
			}
			time++;
		}
		SpeakUtil.speak(1,"穿西裝的男人:哈哈!又是一頭肥羊!謝謝你啦~");
		return false;
	}
}
