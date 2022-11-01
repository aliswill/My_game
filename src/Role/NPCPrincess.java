package Role;

import java.util.Scanner;

import Items.Item;
import Utils.FightUtil;
import Utils.RandomMapUtil;
import Utils.SpeakUtil;
import map.MyMap;
import monsters.Beggar;
import monsters.CrazyWindy;
import monsters.Monster;

public class NPCPrincess  {
	private Hero hero;
	private int meet_time;
	private int help_time;
	private RandomMapUtil maputil;
	
	public NPCPrincess(Hero hero) {
		super();
		this.meet_time=0;
		this.hero = hero;
		this.help_time=0;
		
	}
	
	//問題:建構的時候傳的hero 會跟後來的hero狀態都是連動的嗎?
	public void appear(int day,RandomMapUtil maputil) {
		MyMap cur_map = maputil.getCurrentMap(hero);
		//固定天數在固定地點一定會遇到 5/6天城鎮，9/10天沙漠 15/16古城
		//最多共遇到3次，每次提不同的要求，3次都達成擇滿足條件
		//第一次要錢(買吃的給他).第二次打贏怪物.第三次答對所有問題
		if(this.meet_time==0&&day>4&&day<7&&cur_map.getId()==1) {
			this.meet_time++;
			SpeakUtil.speak(1,"(前方，一名戴著兜帽，看不清臉的女子似乎與麵包攤的老闆起了爭執)");
			SpeakUtil.speak(1,"戴兜帽的女子:不過是吃了你幾個麵包，我今天剛好沒帶錢，我之後再付給你錢就是了，為什麼不讓我走?");
			SpeakUtil.speak(1,"麵包攤的老闆:小姐，我們這裡不賒帳的，你今天就得付錢，要不你留在這裡幫工兩天?");
			SpeakUtil.speak(1,"戴兜帽的女子:不行!我有急事不能留在這裡..");
			SpeakUtil.speak(1,"(女子看起來相當著急的樣子)");
			SpeakUtil.speak(2,"請選擇: W:走上前幫她付錢 任意鍵:無視");
			Scanner sc = new Scanner(System.in);
			String v = sc.next();
			if(v.equalsIgnoreCase("W")) {
				SpeakUtil.speak(1,hero.getName()+":老闆，我幫她付錢吧?看她很著急的樣子");
				SpeakUtil.speak(1,"麵包攤的老闆:哦?可以啊，一共是十枚錢");
				if(hero.getMoney()>=10) {
					SpeakUtil.speak(1,"("+hero.getName()+"給了老板十元)");
					hero.moneyChange(-10);
					SpeakUtil.speak(1,"戴兜帽的女子:謝謝你啊英雄!等我跟父王..等我拿了錢包一定還你錢!");
					SpeakUtil.speak(1,"(戴兜帽的女子急匆匆地走了)");
					this.help_time++;
				}else {
					SpeakUtil.speak(1,hero.getName()+":呃..我沒有帶那麼多錢..");
					SpeakUtil.speak(1,"麵包攤的老闆:那就沒辦法了，小姐，你自己看著辦吧");
					SpeakUtil.speak(1,"(那兩人繼續僵持著，你無奈只好先行離開)");
				}
			}else {
				//nothing happened
				SpeakUtil.speak(1,"("+hero.getName()+"無視了他");
				}
			
		}else if(this.meet_time==1&&day>10&&day<13&&cur_map.getId()==5) {
			this.meet_time++;
			SpeakUtil.speak(1,"(一片黃沙中，你看到一名身材嬌小的女子正在被怪物追逐)");
			SpeakUtil.speak(1,"(女子:救命..誰能救救我!)");
			SpeakUtil.speak(2,"請選擇: W:幫助她 任意鍵:無視");
			Scanner sc = new Scanner(System.in);
			String v = sc.next();
			if(v.equalsIgnoreCase("W")) {
				Monster monster = new CrazyWindy();
				System.out.println(hero.getName()+"遭遇了等級"+monster.getMonster_level()+"的"+monster.getName()+"!");
				System.out.println(monster.toString());
				FightUtil fightutil= new FightUtil();
				fightutil.fight(hero, monster);//被打死會怎樣?
				if(hero.isAlive_yn()) {//還活著
					if(this.help_time>0) {
						SpeakUtil.speak(1,"女子:謝謝你!好心的勇士,你好英勇啊~");
						SpeakUtil.speak(1,"女子:等等..我好像看過你..");
						SpeakUtil.speak(1,"女子:啊!你是上次在城鎮幫我付錢那個好心人!");
						SpeakUtil.speak(1,"女子:不過我現在還是沒有錢可以還給你..");
						SpeakUtil.speak(1,"女子:但真的非常感謝你!可以告訴我你的名子嗎?");
						SpeakUtil.speak(1,"("+hero.getName()+"將名子告訴了女子)");
						SpeakUtil.speak(1,"女子:原來你叫做"+hero.getName()+"..(女子看起來有些羞怯)");
						SpeakUtil.speak(1,"女子:我..我叫作艾爾薇瑟");
						SpeakUtil.speak(1,"女子:真的很謝謝你，"+hero.getName()+"!我一定找機會報答你!");
						
						SpeakUtil.speak(1,"(女子又看了你一眼然後慢慢離開了)");					
					}else {
						SpeakUtil.speak(1,"女子:謝謝你救了我，好心的勇士");
						SpeakUtil.speak(1,"女子:等我跟父..和好了，一定請他賞賜你!");
						SpeakUtil.speak(1,"女子:抱歉，我還有事情就先走了，謝謝你");
						SpeakUtil.speak(1,"(女子向你鞠了一個躬後離開了)");	
					
					}
					this.help_time++;
				}
		}else {
			SpeakUtil.speak(1,"("+hero.getName()+"無視了他");
			//不幫助 甚麼都沒發生
		}
		}else if(this.meet_time==2&&day>16&&day<19&&cur_map.getId()==8&&this.help_time==2) {
			this.meet_time++;
			SpeakUtil.speak(1,"(你看到一名女子正在一處廢棄的石椅上坐著沉思)");	
			SpeakUtil.speak(2,"請選擇: W:走過去搭話 任意鍵:無視");	
			Scanner sc = new Scanner(System.in);
			String v = sc.next();
			if(v.equalsIgnoreCase("W")) {
				SpeakUtil.speak(1,hero.getName()+":小姐，這裡地方很危險的，為什麼獨自坐在這裡?");
				SpeakUtil.speak(1,"(女子抬起頭看向了你)");
				SpeakUtil.speak(1,"女子:啊!是你!"+"hero.getName()");
				SpeakUtil.speak(1,hero.getName()+":你是..");		
				SpeakUtil.speak(2,"請選擇: Q:愛麗絲 W:貝爾蘿菈 E:艾爾薇瑟 R:羅塔汀 T:林志玲 ");	
				v = sc.next();
				if(v.equalsIgnoreCase("E")) {//答對
					SpeakUtil.speak(1,"艾爾薇瑟:對!你還記得我的名子..(艾爾薇瑟看起來很開心的樣子)");
					SpeakUtil.speak(1,"艾爾薇瑟:其實..我在這裡是因為我與父親吵架了");
					SpeakUtil.speak(1,"艾爾薇瑟:我和他賭氣了好多天，不願意回家");
					SpeakUtil.speak(1,"艾爾薇瑟:實際上我是離家出走了..希望能夠讓他擔心我，很幼稚對不對..");
					SpeakUtil.speak(1,"艾爾薇瑟:但是昨晚我突然想到，小時候有一次我也是賭氣跑出家門，在這裡迷了路");
					SpeakUtil.speak(1,"艾爾薇瑟:父親他腿不好，卻還是大晚上的到處找我");
					SpeakUtil.speak(1,"艾爾薇瑟:最後，在我遇到怪物時，父親找到了我");
					SpeakUtil.speak(1,"艾爾薇瑟:就在這裡..在這個地方，他揹著我跑了好久");
					SpeakUtil.speak(1,"艾爾薇瑟:然後緊緊摟著我，那麼威嚴的父親第一次哭了，告訴我他有多麼擔心");
					SpeakUtil.speak(1,"艾爾薇瑟:所以我..我後悔了，我不該再讓父親擔心");
					SpeakUtil.speak(1,"艾爾薇瑟:你也覺得我應該回家了對嗎?");
					SpeakUtil.speak(2,"請選擇: W:不，我覺得你父親早就忘記你了 E:嗯嗯你該回去了，回到你父親身邊，他一定非常擔心你!  任意鍵:別回去了，你就投入我的懷抱吧，哇哈哈!");
					v = sc.next();
					if(v.equalsIgnoreCase("E")) {
						SpeakUtil.speak(1,"艾爾薇瑟:你果然也這麼覺得..");
						SpeakUtil.speak(1,"艾爾薇瑟:我不該讓父親擔心的..我該回去了");
						SpeakUtil.speak(1,"艾爾薇瑟:謝謝你聽我說心事，還幫了我這麼多次");
						SpeakUtil.speak(1,"艾爾薇瑟:再會了"+hero.getName()+"，我回去一定會和父親說我遇到了一位向你這般英勇又體貼的人");			
						SpeakUtil.speak(1,"艾爾薇瑟:很快我們一定會再見的，溫柔的勇士");
						SpeakUtil.speak(1,"艾爾薇瑟:對了，這個送給你，你戴著他一定要常常想著我");
						hero.getNewItem(new Item("精緻的手鐲"));
				
						SpeakUtil.speak(1,"(艾爾薇瑟擁抱了你並離開了)");
						this.help_time++;
					}else {
						SpeakUtil.speak(1,"艾爾薇瑟:.....");
						SpeakUtil.speak(1,"(艾爾薇瑟看起來有些生氣)");
						SpeakUtil.speak(1,"艾爾薇瑟:這樣啊，我不該跟你說的，我還以為你是個體貼溫柔的人");
						SpeakUtil.speak(1,"艾爾薇瑟:抱歉浪費了你的時間，我要走了");
						SpeakUtil.speak(1,"(艾爾薇瑟頭也不回地走了)");
					}
				}else {
					SpeakUtil.speak(1,"女子:這樣啊，你果然不記得我了，我是艾爾薇瑟(女子看起來有些失落)");
					SpeakUtil.speak(1,"女子:上次就是你從沙怪手中救了我");
					SpeakUtil.speak(1,"女子:我只是在想一些心事，不要緊的");
					SpeakUtil.speak(1,"(女子繼續沉思，不再與你說話)");
				}
			}else {
				//不理會 甚麼都沒發生
				SpeakUtil.speak(1,"("+hero.getName()+"無視了他)");
			}
		}
		
	}

}
