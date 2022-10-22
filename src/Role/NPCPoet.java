package Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.RandomMapUtil;
import Utils.SpeakUtil;
import map.CultCamp;
import map.Forest;
import map.MyMap;
import map.WindyDesert;

public class NPCPoet implements NPCrole{

	private Hero hero;
	private int meet_time;
	private List<Integer> appearMap;
	private RandomMapUtil maputil;
	
	public NPCPoet(Hero hero, RandomMapUtil maputil) {
		super();
		this.meet_time=0;
		this.hero = hero;
		this.maputil = maputil;
		appearMap = new ArrayList<Integer>();
		appearMap.add(new Forest().getId());
		appearMap.add(new WindyDesert().getId());
	}


	public List<Integer> getAppearMap() {
		return appearMap;
	}


	@Override
	public void appear() {
		if(this.meet_time==0) {
			SpeakUtil.speak(1,"(前方，一名身著奇裝異服的男子突然從樹上跳了下來)");
			SpeakUtil.speak(1,"男子開始哼著歌");
			SpeakUtil.speak(1,"(偉大的冒險啊~迎向前方的挑戰~)");
			SpeakUtil.speak(1,"(勇敢的旅者會得到冒險之神的祝福~)");
			SpeakUtil.speak(2,"請選擇: W:問問他在唱什麼? 任意鍵:無視");
			Scanner sc = new Scanner(System.in);
			String v = sc.next();
			if(v.equalsIgnoreCase("w")) {
				SpeakUtil.speak(1,"奇裝異服的歌者:我在唱\"冒險的讚頌\"");
				SpeakUtil.speak(1,"奇裝異服的歌者:是歌頌一名勇敢的冒險者，不斷磨練自己，歷經挑戰");
				SpeakUtil.speak(1,"奇裝異服的歌者:最後成為遠近馳名的英雄，並迎娶公主的故事");
				SpeakUtil.speak(1,"奇裝異服的歌者:怎麼樣?是不是很浪漫啊!是不是很嚮往啊!哈哈哈");
				SpeakUtil.speak(2,"請選擇: W:非常浪漫!我也想成為這樣的英雄 任意鍵:還好..有點老套 ");
				v = sc.next();
				if(v.equalsIgnoreCase("w")) {
					SpeakUtil.speak(1,"奇裝異服的歌者:對吧!兄弟!我就知道你也這麼覺得");	
				}else {
					SpeakUtil.speak(1,"奇裝異服的歌者:那是你沒有聽到完整版的故事，非常的蕩氣迴腸!");
					SpeakUtil.speak(1,"奇裝異服的歌者:來吧!我說給你聽!");
					SpeakUtil.speak(1,"奇裝異服的歌者:很久很久以前，在一個鄉村中，有一個窮人家的小孩...");
					SpeakUtil.speak(1,"(奇裝異服的歌者滔滔不絕地講了兩個小時的故事)");
					SpeakUtil.speak(1,"奇裝異服的歌者:謝謝你聽我講了這麼久的故事啊~好久沒遇到這麼棒的聽眾");
				}
				SpeakUtil.speak(1,"奇裝異服的歌者:我感覺你跟我相當投緣!交個朋友吧!");
				SpeakUtil.speak(1,"奇裝異服的歌者:不過都是你在聽我說話，有些不公平，我也想了解了解你");
				SpeakUtil.speak(1,"奇裝異服的歌者:我問你~你覺得冒險對你來說是什麼?");
				SpeakUtil.speak(2,"奇裝異服的歌者:請選擇: W:充滿驚喜，是生活的泉源 E:還好，我只是想成為一個有名的英雄 其他鍵:其實我也不知道我為什麼會開始冒險..想到會遇到不知哪來的怪物就覺得可怕");
				v = sc.next();
				if(v.equalsIgnoreCase("w")) {
					maputil.setMon_ratio(0.7);
				}else if(v.equalsIgnoreCase("e")) {
					maputil.setMon_ratio(0.5);
				}else {
					maputil.setMon_ratio(0.3);
				}
				SpeakUtil.speak(1,"奇裝異服的歌者:這樣啊~那你喜歡預料之外的感覺嗎?");
				SpeakUtil.speak(2,"請選擇: W:喜歡啊!這樣的生活才有趣 E:我想我是個風險中立者.. 任意鍵:穩妥一點才是我的人生哲學");
				v = sc.next();
				if(v.equalsIgnoreCase("w")) {
					maputil.setEvent_ratio(0.7);
				}else if(v.equalsIgnoreCase("e")) {
					maputil.setEvent_ratio(0.5);
				}else {
					maputil.setEvent_ratio(0.3);
				}
				SpeakUtil.speak(1,"奇裝異服的歌者:哈哈!你真是個有趣的人!可以的話真想跟你多聊聊");
				SpeakUtil.speak(1,"奇裝異服的歌者:不過我還有些事，我們下次見啦~");
				SpeakUtil.speak(1,"奇裝異服的歌者:不過我相信一切都會如你所願的，以神之名祝福你");
				SpeakUtil.speak(1,"(奇裝異服的歌者突然以極快的速度消失了)");
				this.meet_time++;
			}else {
				SpeakUtil.speak(1,"("+hero.getName()+"無視了奇裝異服的男子)");
			}
		}else {
			SpeakUtil.speak(1,"(一抹熟悉的身影出現在"+hero.getName()+"眼前，又是上次那名奇裝異服的男子)");
			SpeakUtil.speak(1,"奇裝異服的歌者:我們又見面了!"+hero.getName());
			SpeakUtil.speak(2,"奇裝異服的歌者:你的冒險可還順利?可否後悔你的選擇了?");
			SpeakUtil.speak(2,"請選擇: W:我好像不太適應這樣的生活.. 任意鍵:不後悔，我感覺最近的冒險愈來愈順利");
			Scanner sc = new Scanner(System.in);
			String v = sc.next();
			if(v.equalsIgnoreCase("w")) {
				SpeakUtil.speak(1,"奇裝異服的歌者:這樣啊~難道神誤解了你的願望?");
				SpeakUtil.speak(1,"奇裝異服的歌者:畢竟神也不是全能的~哈哈");
				SpeakUtil.speak(1,"奇裝異服的歌者:那麼..你這次可得好好想想囉");
				SpeakUtil.speak(1,"奇裝異服的歌者:我問你~你覺得冒險對你來說是什麼?");
				SpeakUtil.speak(2,"請選擇: W:充滿驚喜，是生活的泉源 E:還好，我只是想成為一個有名的英雄 其他鍵:其實我也不知道我為什麼會開始冒險..想到會遇到不知哪來的怪物就覺得可怕");
				v = sc.next();
				if(v.equalsIgnoreCase("w")) {
					maputil.setMon_ratio(0.7);
				}else if(v.equalsIgnoreCase("e")) {
					maputil.setMon_ratio(0.5);
				}else {
					maputil.setMon_ratio(0.3);
				}
				SpeakUtil.speak(1,"奇裝異服的歌者:那麼你喜歡預料之外的感覺嗎?");
				SpeakUtil.speak(2,"請選擇: W:喜歡啊!這樣的生活才有趣 E:我想我是個風險中立者.. 任意鍵:穩妥一點才是我的人生哲學");
				v = sc.next();
				if(v.equalsIgnoreCase("w")) {
					maputil.setEvent_ratio(0.7);
				}else if(v.equalsIgnoreCase("e")) {
					maputil.setEvent_ratio(0.5);
				}else {
					maputil.setEvent_ratio(0.3);
				}
				SpeakUtil.speak(1,"奇裝異服的歌者:這樣啊我明白了~願神祝福你!我們下次見啦~");
				SpeakUtil.speak(1,"(奇裝異服的歌者哼著歌離去了)");
				
			}else {
				SpeakUtil.speak(1,"奇裝異服的歌者:這樣啊~擇己所愛，忠己所選，願神祝福你!");
			}
		}
		// TODO Auto-generated method stub		

	}

}
