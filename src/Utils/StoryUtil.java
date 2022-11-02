package Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Items.Item;
import Role.Hero;
import monsters.BossBetrayedCommand;
import monsters.Monster;

public class StoryUtil {

	private int day;
	private Map<Integer,String> daything;
	private boolean heroNewsYN;
	
	public StoryUtil() {
		super();
		this.heroNewsYN=false;
		
		daything = new HashMap<Integer,String>();
		this.daything.put(2,"王國今日頭條:近日有邪教團體聚眾，倡導將詛咒轉移給他人的巫蠱之術，請大家誤信來路不明的宗教!");
		this.daything.put(5,"王國今日頭條:王國的二公主離家出走了，據說最後是在城鎮中看到他，請全國居民協助尋找公主!");
		this.daything.put(7,"王國今日頭條:一日賭徒，終生囚徒!又傳富家子弟在賭場輸光身家，為還賭債踏上偷竊的不歸路!");
		this.daything.put(11,"王國今日頭條:有目擊者說二公主曾進入月蝕沙漠，王后擔心的夜不能昧，請大家協尋公主!");
		this.daything.put(13,"王國今日頭條:大澳灣出現了史前巨怪!摧毀了不少漁船，國王號召各地勇士前去討伐!");
		this.daything.put(15,"王國今日頭條:驚!國王陛下身體欠安?各界分傳是否要立繼承人了!?");
		this.daything.put(17,"王國今日頭條:急!二公主還未找到!國王陛下祭出重金找人!");
		
		//加一個方法在討伐巨怪之後播報主角的事蹟
		
	}
	//第一天講故事開頭
	//第五天講公主離家出走
	//第七天開始號召討伐海怪
	//最後根據hero的條件顯示結局=>放到其他類?
	public void sayStart(int day) {
		if(day==1) {
			SpeakUtil.speak(1,"許久之前，在一個城邦之國，那裡地形複雜，猛獸眾多，對普通人而言，絕對不算是宜居之地");		
			SpeakUtil.speak(1,"因為地處邊陲，並沒有活絡的商業發展，所幸，政治局勢也還算安穩，即使國王年老，儲君也還未定，多年來也並未發生什麼大亂");
			SpeakUtil.speak(1,"至少表面上是的...");
			SpeakUtil.speak(1,"此外，那裡的奇珍異獸，珍稀的寶石，與沙漠中的寶藏傳聞，吸引了諸多人開始以「冒險者」為業，四處遊歷");	
			SpeakUtil.speak(1,"雖然其中也不乏有冒險者葬身於海獸口中，或跌落山崖，但還是不斷誕生引人入勝的冒險故事");
			SpeakUtil.speak(1,"就在這樣一個時代，屬於「他」的故事誕生了，就讓我們一起見證這個故事吧");
			SpeakUtil.speak(1,"---- The story started from then -----");
		}
		
	}
	
	public void sayNews(int day,Hero hero) {
		
		if(hero.haveItemYN("海獸的鱗片")&&!this.heroNewsYN) {
			this.heroNewsYN = true;
			if(daything.containsKey(day)) {
				daything.put(day+1,"王國今日頭條:"+hero.getName()+"擊敗了大澳灣的巨獸，為整個灣區帶來了安寧!");
			}else {
				daything.put(day,"王國今日頭條:"+hero.getName()+"擊敗了大澳灣的巨獸，為整個灣區帶來了安寧!");
			}			
		}
		
		if(!daything.containsKey(day)) {
			SpeakUtil.speak(1,"***本日王國新聞社休刊***");
		}else {
			SpeakUtil.speak(1,daything.get(day));
		}
		
	}
	
	public void sayKey(Hero hero) {
		if(!hero.haveItemYN("國王的手令")&&hero.haveItemYN("海獸的鱗片")) {
			SpeakUtil.speak(1,"("+hero.getName()+"因為打倒了海獸的英勇事蹟，得到了國王的注意)");
			SpeakUtil.speak(1,"(國王將"+hero.getName()+"宣入了宮中)");
			SpeakUtil.speak(1,"國王:勇士啊!你就是"+hero.getName()+"吧!");
			SpeakUtil.speak(1,"國王:本王聽說了你成功討伐海獸，拯救了大澳灣的百姓們，實在是值得褒獎");
			SpeakUtil.speak(1,"國王:本國已經許久沒有這樣有勇有謀的年輕冒險者了");
			SpeakUtil.speak(1,"國王:如你所見，本王年事已高，國內又常有內憂外患，怪物更是層出不窮");
			SpeakUtil.speak(1,"國王:有些地區因為太過危險，本王將它們封禁了起來，以免無知的百姓闖入，造成傷亡");
			SpeakUtil.speak(1,"國王:不過，若是你的話，說不定能夠幫上本王的忙，剷除這些危險的因子");
			SpeakUtil.speak(1,"國王:你可願協助本王，剷除這些惡獸，保護我國的居民?");
			SpeakUtil.speak(1,"國王:這樣吧，本王寫一道手令給你，如此，你便能通行無阻地進入那些封禁的地區了");
			hero.getNewItem(new Item("國王的手令"));
			SpeakUtil.speak(1,"國王:希望你能回應本王的心願，保護我國百姓安寧度日");
			SpeakUtil.speak(1,"國王:對了，這是你此次討伐成功的封賞，你且好好收下");
			hero.moneyChange(100);
			SpeakUtil.speak(1,"("+hero.getName()+"得到了賞金100元)");
		}
	}
	
	public void sayFinalBoss(Hero hero) {
		SpeakUtil.speak(1,"(進入高牆之內，整個氛圍都沉重了起來，平常應是絕對不會有人進入這個地方的)");
		SpeakUtil.speak(1,"(四周黑漆漆的，似乎還隱約傳來猛獸的嚎叫聲)");
		SpeakUtil.speak(1,"(繼續往裡走，漸漸地，叫聲清晰了起來)");
		SpeakUtil.speak(1,"(那個聲音，比起兇惡，到更像是猛獸的哀號...?)");
		SpeakUtil.speak(1,hero.getName()+"鼓起勇氣往聲音的源頭走過去，彎過一片樹林，繼續走了好一段路，然後來到一個奇怪的地方");
		SpeakUtil.speak(1,"(隨處都插著詭異的木樁，地上似乎用碳粉勾勒成一個奇怪的巨大紋樣，還有從鼻腔內感受到的濃烈血氣，這似乎是一個..刑場?)");
		SpeakUtil.speak(1,"(然後，出乎意料地，聽見了人聲)");
		SpeakUtil.speak(1,"(粗獷的男聲:大人，這已是第99頭了，您的計畫快要達成了!)");
		SpeakUtil.speak(1,"(冷酷的男聲:終於...已經讓我等了許久，再也等不下去了，你快把那最後一頭凶獸找來)");
		SpeakUtil.speak(1,"(粗獷男音:遵命!)");
		SpeakUtil.speak(1,"(冷酷的男聲:那個老東西，病病癆癆的竟然還撐了這許久，我本想就讓他這樣糊塗地病死後再順理成章的政變，他終究是逼我先動手)");
		SpeakUtil.speak(1,"(冷酷的男聲:罷了，那一天就快到了，國王之位已然近在眼前!)");
		SpeakUtil.speak(1,"("+hero.getName()+"大吃一驚，那人竟是想謀奪國王之位!)");
		SpeakUtil.speak(1,"(不知他們所言的99頭凶獸是怎麼一回事，但此事眼看緊急，若現在不阻止，可能就再無機會了)");
		SpeakUtil.speak(2,"請選擇: w:上前阻止  任意鍵:假裝沒看到並逃離");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		if(v.equalsIgnoreCase("w")) {	
			SpeakUtil.speak(1,"("+hero.getName()+"大喝一聲，拿起了劍便從樹後面跑了出來)");
			SpeakUtil.speak(1,"(兩名男子大吃一驚，這一愣的瞬間，"+hero.getName()+"也認出了一名男子似乎是在國王面前相當得臉的大將軍)");
			SpeakUtil.speak(1,"將軍:為何這裡會有人!?...我知道了，你就是那個老廢物國王稱讚不已的所謂勇者吧");
			SpeakUtil.speak(1,"將軍:你也真是不幸，原本可以什麼都不知道的，既然檔在了我面前，就只好將你血祭了");
			Monster monster = new BossBetrayedCommand();
			System.out.println(hero.getName()+"遭遇了等級"+monster.getMonster_level()+"的"+monster.getName()+"!");
			System.out.println(monster.toString());
			FightUtil fightutil= new FightUtil();
			fightutil.fight(hero, monster);
			//if(!hero.isAlive_yn())
		}else {
			SpeakUtil.speak(1,"("+hero.getName()+"慌忙地逃離了現場，不敢將自己的所見所聞告訴別人)");
			hero.getNewItem(new Item("國王的死訊"));
		}
	}
	
	public boolean sayEndding(Hero hero,int day) {
		if(hero.haveItemYN("國王的死訊")) {
			SpeakUtil.speak(1,"(近日，有一則驚天的消息傳遍了全國)");
			SpeakUtil.speak(1,"(國王不知怎地在一個平靜的夜裡突然就被暗殺了，連宮中的侍衛都沒有驚動)");
			SpeakUtil.speak(1,"(至今也無人知道兇手是誰)");
			SpeakUtil.speak(1,"(舉國嘩然，在人心惶惶之際，竟又爆出國王生前已確立其繼任者為國王身前當紅的霄騎將軍)");
			SpeakUtil.speak(1,"(霄騎將軍為人英勇挺拔，戰功赫赫，但畢竟與國王沒有血親關係，一時間眾人議論紛紛)");
			SpeakUtil.speak(1,"(可隨著霄騎將軍上位，成為第七位君王開始，一改往日沉穩內斂的作風，實施鐵血方針，並將反對聲音迅速消除，再也沒人敢說什麼)");
			SpeakUtil.speak(1,"(這位新君主野心勃勃，不難看出其想向外征服的決心)");
			SpeakUtil.speak(1,"(國富民強雖是好事，但人民身上的賦稅與勞役也愈發沉重，可每每有反對聲音出現，又會被迅速地消除，漸漸地，人們都開始害怕這位新王)");
			SpeakUtil.speak(1,"(而"+hero.getName()+"，至今也未敢將那夜的所見所聞告訴別人，只是繼續他的冒險生活，但夜裡，偶爾會對那夜逃跑的自己羞愧不已");
			SpeakUtil.speak(1,"這樣的自己，又怎配成為勇者呢?怎麼向天上的父親交代...("+hero.getName()+"喃喃自語道)");
			SpeakUtil.speak(1,"若能再來一次，真希望自己會有不一樣的選擇");
			SpeakUtil.speak(1,"*****遊戲結束*****");
			SpeakUtil.speak(1,"怯懦的戰士結局達成!");
		}else if(hero.haveItemYN("反叛軍的頭顱")) {
			
			SpeakUtil.speak(1,"("+hero.getName()+"擊敗了國內暗藏的反叛勢力的事情引起舉國嘩然)");
			SpeakUtil.speak(1,"(老國王發現自己竟不知何時與死神擦肩而過，感到無比後怕)");
			SpeakUtil.speak(1,"(同時，也為出現了這樣一位少年英雄而無比欣慰)");
			SpeakUtil.speak(1,"(這一日，國王再度將"+hero.getName()+"召入了宮中)");
			SpeakUtil.speak(1,"國王:啊!"+hero.getName()+"，你真是不負本王的託付，又一次保護了我國的安寧，還有本王的性命");
			SpeakUtil.speak(1,"國王:說吧!你想要怎樣的獎賞，別客氣，無論多麼豐厚的獎勵都是你應得的!");
			SpeakUtil.speak(2,"請選擇: W:我想成為國王 E:我想迎娶公主 R:我想要無上的名譽 任意鍵:我想要堆積如山的財寶");
			Scanner sc = new Scanner(System.in);
			String v = sc.next();
			
			if(v.equalsIgnoreCase("w")) {		
				SpeakUtil.speak(1,"國王:這...");
				SpeakUtil.speak(1,"國王的親衛:大膽!居然敢說這樣僭越的話!");
				SpeakUtil.speak(1,"國王:不要緊，是本王讓這位勇士提出要求的");
				SpeakUtil.speak(1,"國王:只不過..本王也不能說退位就退位，還是要對百姓負起責任的..");
				if(hero.haveItemYN("古怪的石頭")) {
					SpeakUtil.speak(1,"國王:等等!你身上那是..?");
					SpeakUtil.speak(1,"(國王注視著"+hero.getName()+"隨手用繩子掛著的那塊古怪的石頭，似乎非常震驚)");
					SpeakUtil.speak(1,"國王:那該不會是..本國遺失許久的先王的印璽吧!?");
					SpeakUtil.speak(1,"國王:是本王的父王去世的時候流給我的，他囑咐那是我王室一脈的傳家之物");
					SpeakUtil.speak(1,"國王:但在父王去世後，本王尚且年幼時的一次動亂中丟失了它，當時派了很多親信去找，但為免動搖國本也不敢大肆宣揚");
					SpeakUtil.speak(1,"國王:最終還是沒有找到，此事一直令本王寢難安");
					SpeakUtil.speak(1,"國王:想不到你竟能將它找回..這樣父王泉下有知也能安心了");
					SpeakUtil.speak(1,"國王:或許這就是上天的安排吧..你確實有成為王的命");
					SpeakUtil.speak(1,"國王:本王允諾你了，擇一吉日將王位傳予你，你便是我國的下一位領導者，擁有帶領國民前行的重任");
					SpeakUtil.speak(1,"國王的親衛:陛下...");
					SpeakUtil.speak(1,"國王:別說了，本王意已決，這是天意，他也向本王證明了他的能力");
					SpeakUtil.speak(1,"國王:不過人有多大能力，便要承擔多大責任，希望你謹記，"+hero.getName());
					SpeakUtil.speak(1,"(次月五日，國王在交待了一應事項後，於大殿舉行了隆重的傳位典禮)");
					SpeakUtil.speak(1,"國王:"+hero.getName()+"，以本王之名，今日將王位傳給你，你便是我國第七位國王");
					SpeakUtil.speak(1,"國王:此權杖是王權之象徵，今日授予你");
					hero.getNewItem(new Item("國王的權杖"));
					SpeakUtil.speak(1,"國王:此冠冕是王所承擔的責任，今日也授予你");
					hero.getNewItem(new Item("國王的冠冕"));
					SpeakUtil.speak(1,"國王:我正式宣布，"+hero.getName()+"為我國第七位君主，日後他將引領各位前行!");
					SpeakUtil.speak(1,"(眾人紛紛伏地，迎接新王"+hero.getName()+"的到來)");
					SpeakUtil.speak(1,"*****"+hero.getName()+"因其英勇之心，成為了國家的第七位君王，享有王權與百姓的心悅誠服"+"*****");
					SpeakUtil.speak(1,"****日後，就讓我們一同見證這位新王帶領的國家，將會走向何方吧!*****");
					SpeakUtil.speak(1,"*****遊戲結束*****");
					SpeakUtil.speak(1,"國王結局達成!");
					return true;
				}else {
					SpeakUtil.speak(1,"國王:這樣吧，"+hero.getName()+"，本王賜予你一塊封地與勇者的稱號，日後你亦可享盡榮華與富貴");
					SpeakUtil.speak(1,"國王:這可比當國王輕鬆多了呵呵");
					SpeakUtil.speak(1,"("+hero.getName()+"得到了國王賞賜的一塊封地，並以勇者之名享譽各地)");
					SpeakUtil.speak(1,"("+hero.getName()+"勇者的英勇事蹟，處處為人稱道，連孩子們都爭著說將來也想成為像"+hero.getName()+"一樣帥氣的勇者)");
					SpeakUtil.speak(1,"****"+hero.getName()+"成為舉國之名的勇者，並擁有自己的封地，一輩子再不愁吃穿*****");
					SpeakUtil.speak(1,"*****遊戲結束*****");
					SpeakUtil.speak(1,"勇者結局達成!");
					return true;
				}
			}else if(v.equalsIgnoreCase("e")) {
				if(hero.haveItemYN("精緻的手鐲")) {
					SpeakUtil.speak(1,"(國王看起來相當開心)");
					SpeakUtil.speak(1,"國王:妙極!妙極!你能提此要求真是太好了，本王正怕你不好意思提出來呢!");
					SpeakUtil.speak(1,"國王:公主早與我說過了，一位勇士在她離家時多次相助她的事情");
					SpeakUtil.speak(1,"國王:她能平安回到本王身邊，也都是多虧了你");
					SpeakUtil.speak(1,"國王:你們二人看來是情投意合，這真是太好了!");
					SpeakUtil.speak(1,"國王:這樣吧!本王擇一良辰吉日予你二人舉行一場最盛大的婚禮，讓全國的百姓都替你二人獻上祝福");
					SpeakUtil.speak(1,"(次月五日，國王在宮殿裡為"+hero.getName()+"與艾爾薇瑟公主，舉行了無比盛大的婚禮");
					SpeakUtil.speak(1,"(殿中的鮮花與鮮果無比繽紛，種類比普通人一輩子見過的數量不知道多了幾倍)");
					SpeakUtil.speak(1,"(由國王親自牽著公主的手，緩步走上台階，並將公主的手交付給她終身託付的對象)");
					SpeakUtil.speak(1,"(漫天的彩帶與充滿百姓祝福的彩紙鶴，鋪滿了視野)");
					SpeakUtil.speak(1,"(公主熱淚盈眶地感謝父親多年來的照顧)");
					SpeakUtil.speak(1,"(然後握緊了"+hero.getName()+"的手，一同宣揚愛的誓詞)");
					SpeakUtil.speak(1,"(同時，國王也給了這位新駙馬一塊大大的封地與莊園，讓他二人能夠舒舒服服地一起過下半輩子)");
					SpeakUtil.speak(1,"****"+hero.getName()+"與公主的婚禮受到全國百姓的祝福，兩人互相扶持，歡度餘生*****");
					SpeakUtil.speak(1,"*****遊戲結束*****");
					SpeakUtil.speak(1,"駙馬結局達成!");
					return true;
				}else {
					SpeakUtil.speak(1,"(國王似乎面有難色的樣子)");
					SpeakUtil.speak(1,"國王:這...並非本王不想答應");
					SpeakUtil.speak(1,"國王:像你這麼出色的勇士，能嫁給你也是小女的福氣");
					SpeakUtil.speak(1,"國王:實在是本王也為人父母，不可不顧小女的意願..");
					SpeakUtil.speak(1,"國王:其實公主她目前已經有心上人了");
					SpeakUtil.speak(1,"國王:雖然對方不如你立下如此大的功勞，但也是位俊傑青年");
					SpeakUtil.speak(1,"國王:最重要還是公主喜歡..這棒打鴛鴦的事情本王也是做不來呀");
					SpeakUtil.speak(1,"國王:這樣吧，"+hero.getName()+"，本王賜予你一塊封地與勇者的稱號，日後你亦可享盡榮華與富貴");
					SpeakUtil.speak(1,"國王:日後你一定可娶到其他優秀的女子，與她白頭偕老");
					SpeakUtil.speak(1,"("+hero.getName()+"得到了國王賞賜的一塊封地，並以勇者之名享譽各地)");
					SpeakUtil.speak(1,"("+hero.getName()+"勇者的英勇事蹟，處處為人稱道，連孩子們都爭著說將來也想成為像"+hero.getName()+"一樣帥氣的勇者)");
					SpeakUtil.speak(1,"****"+hero.getName()+"成為舉國之名的勇者，並擁有自己的封地，一輩子再不愁吃穿*****");
					SpeakUtil.speak(1,"*****遊戲結束*****");
					SpeakUtil.speak(1,"勇者結局達成!");
					return true;
				}
			}if(v.equalsIgnoreCase("r")) {
				SpeakUtil.speak(1,"國王:沒問題，你既然拯救了本王，你自然應得舉國的讚揚與無上的榮光");
				SpeakUtil.speak(1,"國王:這樣吧!本王授你勇者稱號，並替你建一座巨大的雕像，將你的事蹟一一刻上，想必後世的百姓也會知道你的");
				SpeakUtil.speak(1,"(國王替"+hero.getName()+"兼了一座巨大的雕像，並以勇者之名享譽各地)");
				SpeakUtil.speak(1,"("+hero.getName()+"勇者的英勇事蹟，處處為人稱道，連孩子們都爭著說將來也想成為像"+hero.getName()+"一樣知名的勇者)");
				SpeakUtil.speak(1,"****"+hero.getName()+"成為了連後世的百姓都琅琅上口的著名的勇者*****");
				SpeakUtil.speak(1,"*****遊戲結束*****");
				SpeakUtil.speak(1,"勇者(名譽)結局達成!");
				return true;
			}else {
				SpeakUtil.speak(1,"國王:哈哈哈，沒問題，你既然拯救了本王，金銀財寶自然是供你享用不盡的");
				SpeakUtil.speak(1,"國王:這樣吧!本王授你勇者稱號，並賞你一車的財寶，夠你一輩子不愁吃穿了");
				SpeakUtil.speak(1,"("+hero.getName()+"獲得了大量的金銀珠寶，從此富甲天下，並以勇者之名享譽各地)");
				SpeakUtil.speak(1,"("+hero.getName()+"勇者的英勇事蹟，處處為人稱道，連孩子們都爭著說將來也想成為像"+hero.getName()+"一樣財大氣粗的勇者)");
				SpeakUtil.speak(1,"****"+hero.getName()+"成為了一輩子不愁吃穿的富豪勇者*****");
				SpeakUtil.speak(1,"*****遊戲結束*****");
				SpeakUtil.speak(1,"勇者(富豪)結局達成!");
				return true;
			}
		}else if(day>=30) {
			if(hero.getGood_point()>15) {
				SpeakUtil.speak(1,"("+hero.getName()+"展開冒險已經過了許久)");
				SpeakUtil.speak(1,"(見識了許各種各樣的地方，也幫助了許多的人)");
				SpeakUtil.speak(1,"(漸漸地，人人都知道"+hero.getName()+"是一名熱心的冒險家，永遠會在人們需要幫助的時候即時給予援手)");
				SpeakUtil.speak(1,"(在一次選舉中，"+hero.getName()+"以相當高的票數當選為鎮長)");
				SpeakUtil.speak(1,"(雖然沒有成為傳說中的勇者，沒有屠凶獸也沒有拯救公主)");
				SpeakUtil.speak(1,"(但現在，"+hero.getName()+"發現了自己有新的目標，以幫助眾人為己任，每天不辭辛苦地奔波，忙著鎮上的大事小事)");
				SpeakUtil.speak(1,"(或許這樣的生活也是很棒的吧?)");
				SpeakUtil.speak(1,"***"+hero.getName()+"因為熱心助人當選為鎮長，為造福眾人而過著充實又辛苦的每一天***");
				SpeakUtil.speak(1,"*****遊戲結束*****");
				SpeakUtil.speak(1,"鎮長結局達成!");
				return true;
			}else if(hero.getGood_point()>0&&hero.getLevel()>=7) {//冒險家結局
				SpeakUtil.speak(1,"("+hero.getName()+"展開冒險已經過了許久)");
				SpeakUtil.speak(1,"(見識了許各種各樣的地方，也克服了許多危險)");
				SpeakUtil.speak(1,"(漸漸地，認識"+hero.getName()+"的人也愈來愈多)");
				SpeakUtil.speak(1,"("+hero.getName()+"在國內已是小有名氣的冒險者)");
				SpeakUtil.speak(1,"(不過，離當初設下的目標似乎還有一段路要走)");
				SpeakUtil.speak(1,"(冒險從未停止，繼續踏上旅途吧!)");
				SpeakUtil.speak(1,"(朝著你所想的邁進，別停下腳步)");
				SpeakUtil.speak(1,"***"+hero.getName()+"在時間的磨礪中成為一名小有名氣的冒險者，並且將會繼續他的冒險旅途***");
				SpeakUtil.speak(1,"*****遊戲結束*****");
				SpeakUtil.speak(1,"冒險家結局達成!");
				return true;
			}else if(hero.getGood_point()<=0&&hero.getMoney()>150&&hero.getLevel()>=7) {//黑幫老大
				SpeakUtil.speak(1,"("+hero.getName()+"展開冒險已經過了許久)");
				SpeakUtil.speak(1,"(不過...一切好像跟當初預料的不太一樣?)");
				SpeakUtil.speak(1,"("+hero.getName()+"利用自己的商業頭腦與武力傳了許多不義之財)");
				SpeakUtil.speak(1,"(漸漸地，也培養了自己的一股勢力)");
				SpeakUtil.speak(1,"(人人都知道，"+hero.getName()+"領導著一群惡霸到處竊盜搶劫，欺負弱小)");
				SpeakUtil.speak(1,"(大家都在等著"+hero.getName()+"被繩之以法的那一天)");
				SpeakUtil.speak(1,"(惡有惡報?誰又說得準呢，就讓他尊崇自己所選的道路吧...)");
				SpeakUtil.speak(1,"***"+hero.getName()+"成為了人人避之唯恐不及的黑幫老大!***");
				SpeakUtil.speak(1,"*****遊戲結束*****");
				SpeakUtil.speak(1,"黑幫老大結局達成!");
			}else if(hero.getGood_point()<=0){
				SpeakUtil.speak(1,"("+hero.getName()+"展開冒險已經過了許久)");
				SpeakUtil.speak(1,"(不過...一切好像跟當初預料的不太一樣?)");
				SpeakUtil.speak(1,"("+hero.getName()+"並不喜歡與怪物拚搏的冒險生活)");
				SpeakUtil.speak(1,"(反而時常欺凌弱小，偷搶拐騙，但又成不了大氣候)");
				SpeakUtil.speak(1,"(人人都知道，"+hero.getName()+"只是一個遊手好閒的小混混而已)");
				SpeakUtil.speak(1,"(在許許多多想成為冒險者的人中，不時會出現改走歪路的人，也令人不勝唏噓)");
				SpeakUtil.speak(1,"***"+hero.getName()+"成為街頭的小混混***");
				SpeakUtil.speak(1,"*****遊戲結束*****");
				SpeakUtil.speak(1,"街頭小混混結局達成!");
			}else {
				SpeakUtil.speak(1,"("+hero.getName()+"展開冒險已經過了許久)");
				SpeakUtil.speak(1,"(不過冒險似乎並不那麼吸引他)");
				SpeakUtil.speak(1,"("+hero.getName()+"意識到自己並不喜歡與怪物拚搏的冒險生活)");
				SpeakUtil.speak(1,"(每天只想平凡地工作，平凡地生活，過著差不多的日子)");
				SpeakUtil.speak(1,"("+hero.getName()+"在鎮上沒沒無聞，當著社會運轉的一顆小螺絲釘)");
				SpeakUtil.speak(1,"(不過，平凡人也有平凡的幸福吧..在天上的父親知道了想必也不會責怪他的)");
				SpeakUtil.speak(1,"***"+hero.getName()+"成為一個平凡的市民***");
				SpeakUtil.speak(1,"*****遊戲結束*****");
				SpeakUtil.speak(1,"平凡的市民結局達成!");
			}
		
		}
		return false;
	}
}
