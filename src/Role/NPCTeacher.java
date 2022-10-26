package Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.RandomMapUtil;
import Utils.SpeakUtil;
import map.Forest;
import map.Town;
import map.WindyDesert;

public class NPCTeacher implements NPCrole{

	private Hero hero;
	private int meet_time;
	private List<Integer> appearMap;
	
	
	public NPCTeacher(Hero hero) {
		super();
		this.meet_time=0;
		this.hero = hero;
		appearMap = new ArrayList<Integer>();
		appearMap.add(new Town().getId());
		
	}
	@Override
	public void appear() {
		// TODO Auto-generated method stub
		SpeakUtil.speak(1,"(牆上貼著勇者訓練班招生的廣告單，是否查看?)");
		SpeakUtil.speak(2,"請輸入: w:查看 任意鍵:略過");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		if(v.equalsIgnoreCase("w")) {
			SpeakUtil.speak(1,"(歡迎光臨勇者訓練班，最強師資將你訓練成所向無敵的勇者)");
			SpeakUtil.speak(1,"(想要報名嗎? 武術訓練班:15元/堂 防衛訓練班:15元/堂 靈巧訓練班:15元/堂)");
			SpeakUtil.speak(1,"(W:武術訓練班 E:防衛訓練班 R:靈巧訓練班  任意鍵:不想報名)");
			v = sc.next();
			if(v.equalsIgnoreCase("w")) {
				if(hero.checkMoney(15)) {
					hero.moneyChange(-15);
					SpeakUtil.speak(1,hero.getName()+"花了15元報名了武術訓練班");
					hero.setAtk(hero.getAtk()+2);
					SpeakUtil.speak(1,"經過老師的指導，"+hero.getName()+"的攻擊力提升了2");
				}else {
					SpeakUtil.speak(1,"金錢不足!");
				}
			}else if(v.equalsIgnoreCase("e")) {
				if(hero.checkMoney(15)) {
					hero.moneyChange(-15);
					SpeakUtil.speak(1,hero.getName()+"花了15元報名了防衛訓練班");
					hero.setDef(hero.getDef()+2);
					SpeakUtil.speak(1,"經過老師的指導，"+hero.getName()+"的防禦力提升了2");
				}else {
					SpeakUtil.speak(1,"金錢不足!");
				}
			}else if(v.equalsIgnoreCase("r")) {
				if(hero.checkMoney(15)) {
					hero.moneyChange(-15);
					SpeakUtil.speak(1,hero.getName()+"花了15元報名了靈巧訓練班");
					hero.setDex(hero.getDex()+2);
					SpeakUtil.speak(1,"經過老師的指導，"+hero.getName()+"的敏捷力提升了2");
				}else {
					SpeakUtil.speak(1,"金錢不足!");
				}
			}else {
				
			}
		}else {
			
		}
	}

	@Override
	public List<Integer> getAppearMap() {
		// TODO Auto-generated method stub
		return appearMap;
	}

}
