package Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Items.Item;
import Utils.Commodity;
import Utils.SpeakUtil;
import map.CultCamp;
import map.MyMap;
import map.WindyDesert;

public class NPCTrader implements NPCrole{
private Map<String,Commodity> commodities;
private Hero hero;
private List<Integer> appearMap;
	
	
	public NPCTrader(Hero hero) {
		this.hero = hero;
		appearMap = new ArrayList<Integer>();
		appearMap.add(new CultCamp().getId());
		appearMap.add(new WindyDesert().getId());
		commodities = new HashMap<String,Commodity>();
		commodities.put("Q", new Commodity(90,"秘銀寶劍",1,10));
		commodities.put("W", new Commodity(140,"骨製巨劍",1,14));
		commodities.put("E", new Commodity(90,"秘銀鎧甲",2,10));
		commodities.put("R", new Commodity(140,"獸王鎧甲",2,14));
		commodities.put("A", new Commodity(100,"古怪的石頭",3,0));//勝利道具之一
		commodities.put("S", new Commodity(50,"帥氣的頭巾",4,0));//騙人用 只是看起來很帥
		
	}
	
	
	
	public List<Integer> getAppearMap() {
		return appearMap;
	}



	public String welcomStore() {
	SpeakUtil.speak(1,"(路旁，一名旅行商人揹著沉重的囊袋)");
	SpeakUtil.speak(1,"旅行商人:年輕人啊，要不要看看我這兒的商品?我可是有很多你平常買不到的稀奇寶貝");
	SpeakUtil.speak(2,"請選擇: Y:看看商品 N:不看");
	Scanner sc = new Scanner(System.in);
	String v1 = sc.next();
		while(!v1.equalsIgnoreCase("Y")&&!v1.equalsIgnoreCase("N")) {
			SpeakUtil.speak(2,"(請輸入Y/N)");
			v1 = sc.next();			
		}		
		return v1;	
	
	}

	public void useStore(Hero hero,String welcome_yn) {//TODO:有BUG要修 金錢不足時無法再次購買		
		// TODO Auto-generated method stub			
		if(welcome_yn.equalsIgnoreCase("Y"))  {
			SpeakUtil.speak(1,"旅行商人:唷呵呵~好眼光，盡情挑吧~ (按對應鍵購買，或按Z離開商店)");
			SpeakUtil.speak(2,"Q:秘銀寶劍(攻擊力10)(90元) || W:古製巨劍(攻擊力14)(140元) || E:秘銀鎧甲(防禦力10)(90元) || R:獸王鎧甲(防禦力14)(140元)");
			SpeakUtil.speak(2,"A:古怪的石頭(烏黑的石頭，不知道有什麼用?)(500元) || S:帥氣的頭巾(感覺戴了會很帥?)(50元) " );
			Scanner sc = new Scanner(System.in);
			String v1 = sc.next();
			
			while(!v1.equalsIgnoreCase("Z")&&!commodities.keySet().contains(v1)) {
				SpeakUtil.speak(2,"(按對應鍵購買，或按Z離開商店)");
				v1 = sc.next();
			}
			
			if(v1.equalsIgnoreCase("Z")) {
				//離開商店
			}else if(commodities.keySet().contains(v1)) {
				Commodity c = commodities.get(v1);
				buy(hero,c);
				SpeakUtil.speak(2,"旅行商人:這可是難得的寶貝，你真識貨!要再挑些嗎? (Y:要 任意鍵:不要)");
				String v2 = sc.next();
				useStore(hero,v2);
			}
			
		}else{
			SpeakUtil.speak(1,"旅行商人:真可惜~過了這個村就沒這個店啦~");
			//do nothing
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
			hero.getNewItem(new Item("古怪的石頭"));
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

	@Override
	public void appear() {
		// TODO Auto-generated method stub
		useStore(hero,welcomStore());
	}
}
