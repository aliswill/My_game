package Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Utils.SpeakUtil;
import map.AbandonedCity;
import map.DeepOcean;

public class NPCCat implements NPCrole {
	
	private Hero hero;
	private int feed_time;
	private List<Integer> appearMap;
	
	
	public NPCCat(Hero hero) {
		super();
		this.feed_time=0;
		this.hero = hero;
		
		appearMap = new ArrayList<Integer>();
		appearMap.add(new AbandonedCity().getId());
		appearMap.add(new DeepOcean().getId());
	}
	@Override
	public void appear() {
		// TODO Auto-generated method stub
		if(feed_time<=3) {
			SpeakUtil.speak(1,"(喵~)");
			SpeakUtil.speak(1,"(不遠處傳來了小聲的貓叫)");
			SpeakUtil.speak(2,"請輸入 w:前去查看 任意鍵:無視");
			Scanner sc = new Scanner(System.in);
			String v = sc.next();
			if(v.equalsIgnoreCase("w")) {
				SpeakUtil.speak(1,"(你發現了一隻相當瘦小的虎斑貓正躲在一處堆滿垃圾的角落)");
				SpeakUtil.speak(1,"(牠小心地盯著你，似乎相當好奇但又不敢靠近)");
				SpeakUtil.speak(2,"請輸入 W:伸手去抱牠 E:留下食物然後走到遠處 任意鍵:作勢要攻擊牠");
				v = sc.next();
				if(v.equalsIgnoreCase("e")) {
					SpeakUtil.speak(1,"(虎斑貓觀察了一陣子後才從垃圾堆後面走出來)");
					SpeakUtil.speak(1,"(牠似乎吃了你給的食物，吃完後又很快地躲到一旁的草叢中消失了身影)");
					this.feed_time++;
	
				}else {
					SpeakUtil.speak(1,"(虎斑貓被你嚇跑了)");
				}
			}
		}else if(this.feed_time==3) {
			SpeakUtil.speak(1,"(喵~)");
			SpeakUtil.speak(1,"(熟悉的叫聲傳來)");
			SpeakUtil.speak(1,"(一隻虎斑貓竄了出來，用晶亮的眼睛盯著你，看起來似乎比以前要胖了些)");
			SpeakUtil.speak(1,"(牠用頭蹭了蹭你的褲腳，然後一路跟著你，似乎想跟你一起走的樣子?)");
			SpeakUtil.speak(2,"請輸入 W:帶牠一起走 任意鍵:不帶牠走");
			Scanner sc = new Scanner(System.in);
			String v = sc.next();
			if(v.equalsIgnoreCase("e")) {
				SpeakUtil.speak(1,"(喵~虎斑貓看起來很高興地樣子)");
				SpeakUtil.speak(1,"("+hero.getName()+"成功收養了虎斑貓!)");
				SpeakUtil.speak(2,"幫虎斑貓取個名子吧? 請輸入名子:");
				v = sc.next();
				hero.setCat_name(v);
				SpeakUtil.speak(1,hero.getName()+"替虎斑貓取名為:"+v+"了!");
				hero.setHaveCat_yn(true);			
			}else {
				SpeakUtil.speak(1,"(喵~虎斑貓停留在原地目送你離開)");
				this.feed_time++;//只有一次收養機會
			}
		}
		else {
			
		}
		
	}

	@Override
	public List<Integer> getAppearMap() {
		// TODO Auto-generated method stub
		return appearMap;
	}

}
