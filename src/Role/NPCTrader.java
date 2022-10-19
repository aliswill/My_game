package Role;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Utils.Commodity;
import Utils.SpeakUtil;

public class NPCTrader implements NPCrole{
private Map<String,Commodity> commodities;
private Hero hero;

	
	
	public NPCTrader(Hero hero) {
		this.hero = hero;
		
		commodities = new HashMap<String,Commodity>();
		commodities.put("Q", new Commodity(90,"秘銀寶劍",1,10));
		commodities.put("W", new Commodity(140,"骨製巨劍",1,14));
		commodities.put("E", new Commodity(90,"秘銀鎧甲",2,10));
		commodities.put("R", new Commodity(140,"獸王鎧甲",2,14));
		commodities.put("A", new Commodity(100,"古怪的石頭",3,0));//勝利道具之一
		commodities.put("S", new Commodity(50,"帥氣的頭巾",4,0));//騙人用 只是看起來很帥
		
	}



	@Override
	public void appear() {//TODO:有BUG要修 金錢不足時無法再次購買
		
		// TODO Auto-generated method stub
		SpeakUtil.speak(1,"一名旅行商人揹著沉重的囊袋");
		SpeakUtil.speak(1,"旅行商人:年輕人啊，要不要看看我這兒的商品?我可是有很多你平常買不到的稀奇寶貝");
		SpeakUtil.speak(2,"請選擇: w:看看商品 任意鍵:不看");
		Scanner sc = new Scanner(System.in);
		String v1 = sc.next();
		if(v1.equalsIgnoreCase("w")) {
			SpeakUtil.speak(1,"旅行商人:唷呵呵~好眼光，盡情挑吧~ (按對應鍵購買，或按Z離開商店)");
			SpeakUtil.speak(2,"Q:秘銀寶劍(攻擊力10)(90元) || W:古製巨劍(攻擊力14)(140元) || E:秘銀鎧甲(防禦力10)(90元) || R:獸王鎧甲(防禦力14)(140元)");
			SpeakUtil.speak(2,"A:古怪的石頭(烏黑的石頭，不知道有什麼用?)(100元) || S:帥氣的頭巾(感覺戴了會很帥?)(50元) " );
			v1 = sc.next();
			
			while(!v1.equalsIgnoreCase("Z")&&!commodities.keySet().contains(v1)) {
				SpeakUtil.speak(2,"(按對應鍵購買，或按Z離開商店)");
				v1 = sc.next();
			}
			
			if(v1.equalsIgnoreCase("Z")) {
				SpeakUtil.speak(1,"旅行商人:真可惜啊~過了這個村就沒這個店了~");
				//離開商店
			}else if(commodities.keySet().contains(v1)) {
				Commodity c = commodities.get(v1);
				buy(hero,c);
				SpeakUtil.speak(1,"旅行商人:謝謝光臨~不好意思啊，我這兒看緣分，一次只能買一件商品，若還有喜歡的就下次再來吧");
				
			}
		}else {
			SpeakUtil.speak(1,"旅行商人:真可惜啊~過了這個村就沒這個店了~");
		}
	}
	
	private void buy(Hero hero,Commodity commodity) {
		if(hero.getMoney()>=commodity.getPrice()) {
			
			hero.setMoney(hero.getMoney()-commodity.getPrice());
			SpeakUtil.speak(1,hero.getName()+"購買了"+commodity.getCom_name());
			if(commodity.getCom_type()==1) {//攻擊類商品
				if(hero.getWeapon_atk()<commodity.getChange_value()) {
					hero.setWeapon_atk(commodity.getChange_value());
					SpeakUtil.speak(1,hero.getName()+"裝備了"+commodity.getCom_name()+","+hero.getName()+"的武器攻擊力變為:"+hero.getWeapon_atk());
				}
			}else if(commodity.getCom_type()==2) {//防禦類商品
				if(hero.getEqu_def()<commodity.getChange_value()) {
					hero.setEqu_def((commodity.getChange_value()));
					SpeakUtil.speak(1,hero.getName()+"裝備了"+commodity.getCom_name()+","+hero.getName()+"的裝備防禦力變為:"+hero.getEqu_def());
				}
			
		}else if(commodity.getCom_type()==3) {
			hero.setMoney(hero.getMoney()-commodity.getPrice());
			SpeakUtil.speak(1,hero.getName()+"購買了"+commodity.getCom_name());
			SpeakUtil.speak(1,"(真是奇怪的石頭，也許會在哪裡派上用場?)");
		}else if(commodity.getCom_type()==4) {
			hero.setMoney(hero.getMoney()-commodity.getPrice());
			SpeakUtil.speak(1,hero.getName()+"購買了"+commodity.getCom_name());
			SpeakUtil.speak(1,hero.getName()+"戴上了"+commodity.getCom_name()+"，看起來相當帥氣");
			}
		}else {
			SpeakUtil.speak(1,"金錢不足!");
		}
	
	}
}
