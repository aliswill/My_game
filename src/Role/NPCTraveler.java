package Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.RandomMapUtil;
import Utils.SpeakUtil;
import Utils.WaitUtil;
import map.CultCamp;
import map.Hill;
import map.MyMap;
import map.OldTomb;
import map.WindyDesert;

public class NPCTraveler implements NPCrole{
	private List<Integer> appearMap;
	private Hero hero;
	private RandomMapUtil maputil;
	public NPCTraveler(Hero hero,RandomMapUtil maputil) {
		this.hero=hero;
		this.maputil=maputil;
		appearMap = new ArrayList<Integer>();
		appearMap.add(new Hill().getId());
		appearMap.add(new OldTomb().getId());
	}
	
	public List<Integer> getAppearMap() {
		return appearMap;
	}

	@Override
	public void appear() {
		// TODO Auto-generated method stub
		SpeakUtil.speak(1,"(前方出現一名狼狽不堪的旅行者，全身都是汙跡跟血漬)");
		
		SpeakUtil.speak(2,"請選擇：　W:嘲笑他  E:遞給他水喝 任意鍵:無視");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		if(v.equalsIgnoreCase("w")) {
			SpeakUtil.speak(1,hero.getName()+":你怎麼搞的這麼狼狽啊~沒實力還是別出來冒險吧哈哈");
			
			SpeakUtil.speak(1,"狼狽不堪的旅行者瞪了一眼"+hero.getName()+"並踱著緩步走了");
			
			hero.good_point_change(-1);
		}else if(v.equalsIgnoreCase("e")) {
			SpeakUtil.speak(1,"狼狽不堪的旅行者：謝謝你啊~你也是旅行者吧?");
			
			SpeakUtil.speak(1,"狼狽不堪的旅行者：其實啊..我剛剛從"+ maputil.getDanagerousDirection(hero)+"方而來");
			
			SpeakUtil.speak(1,"狼狽不堪的旅行者：那裏的敵人都特別強大，你最好不要往那邊走");
			
			SpeakUtil.speak(1,"狼狽不堪的旅行者：那麼再會了，謝謝你的茶水~");
		}else {
			SpeakUtil.speak(1,"("+hero.getName()+"無視了他)");
			
			SpeakUtil.speak(1,"旅行者步履蹣跚地走了");
		}

	}
}