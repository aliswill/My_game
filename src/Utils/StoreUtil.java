package Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Role.Hero;

public class StoreUtil {

	private Map<String,Commodity> commodities;
	
	
	
	public StoreUtil() {
		commodities = new HashMap<String,Commodity>();
		commodities.put("Q", new Commodity(6,"小混混的鋁棒",1,1));
		commodities.put("W", new Commodity(15,"士兵用的劍",1,3));
		commodities.put("E", new Commodity(30,"霸氣卍黑刃",1,5));
		commodities.put("R", new Commodity(50,"鴨鴨神劍",1,7));
		commodities.put("T", new Commodity(6,"小混混的吊嘎",2,1));
		commodities.put("Y", new Commodity(12,"藍色POLO衫",2,2));
		commodities.put("U", new Commodity(25,"霸王卍神鎧",2,4));
		commodities.put("I", new Commodity(50,"鴨鴨布偶裝",2,7));
	}
	
	public String welcomStore() {
		System.out.println("這裡有熱鬧的商店街，想要拜訪商店嗎? (請輸入Y/N)");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		while(!v.equals("Y")&&!v.equals("N")) {
			System.out.println("(請輸入Y/N)");
			v = sc.next();
		}
		
		return v;
	}
	
	public void useStore(Hero hero,String welcome_yn) {
		
		if(welcome_yn.equalsIgnoreCase("Y")) {//開始購物
			System.out.println("店主：歡迎光臨!請隨意挑選(按對應鍵購買，或按Z離開商店)");
			System.out.println("Q:小混混的鋁棒(攻擊力1)(6元) || W:士兵用的劍(攻擊力3)(15元) || E:霸氣卍黑刃(攻擊力5)(30元) || R:鴨鴨神劍(攻擊力7)(50元)");
			System.out.println("T:小混混的吊嘎(防禦力1)(6元) || Y:藍色POLO衫(防禦力2)(12元) || U:霸王卍神鎧(防禦力4)(25元) || I:鴨鴨布偶裝(防禦力7)(50元)" );
			Scanner sc = new Scanner(System.in);
			String v1 = sc.next();
			
			while(!v1.equalsIgnoreCase("Z")&&!commodities.keySet().contains(v1)) {
				System.out.println("(按對應鍵購買，或按Z離開商店)");
				v1 = sc.next();
			}
			if(v1.equalsIgnoreCase("Z")) {
				//離開商店
			}else if(commodities.keySet().contains(v1)) {
				Commodity c = commodities.get(v1);
				buy(hero,c);
				System.out.println("店主：謝謝光臨!是否繼續購物? (請輸入Y/N)");
				String v2 = sc.next();
				useStore(hero,v2);
			}
			
		}else if(welcome_yn.equals("N")) {
			System.out.println("店主：有機會再來哦！");
			//do nothing
		}
	}
	
	public void useHotel(Hero hero) {
		System.out.println("今晚需要住宿旅店嗎? (請輸入Y/N)");
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		while(!v.equalsIgnoreCase("Y")&&!v.equalsIgnoreCase("N")) {
			System.out.println("(請輸入Y/N)");
			v = sc.next();
		}
		if(v.equalsIgnoreCase("Y")) {//開始購物
			System.out.println("想找什麼樣的旅店呢? (按對應鍵入住，或按Z離開)");
			System.out.println("Q:歇腳的旅店(恢復少量生命值，一晚5元) W:闊氣的旅店(恢復較多生命值，一晚10元)");
			System.out.println("E:溫泉會館(恢復少量生命值與魔法力，一晚10元)" );
			String v1 = sc.next();
			while(!v1.equalsIgnoreCase("Q")&&!v1.equalsIgnoreCase("W")&&!v1.equalsIgnoreCase("E")&&!v1.equalsIgnoreCase("Z")) {
				System.out.println("(按對應鍵入住，或按Z離開)");
				v1 = sc.next();
			}
			relax(v1,hero);
		}else if(v.equalsIgnoreCase("N")) {
			//do nothing
		}
	}
	
	private void relax(String input,Hero hero) {
		if(input.equalsIgnoreCase("Q")) {
			if(hero.getMoney()>=5) {
				hero.setMoney(hero.getMoney()-5);
				int final_value = Math.min(hero.getLife()+(int)(hero.getMax_life()*0.25), hero.getMax_life());
				System.out.println(hero.getName()+"在歇腳的旅店休息了一晚，生命值恢復了"+final_value);
				hero.setLife(final_value);
			}else {
				System.out.println("沒錢還是自己搭個帳篷就好吧..");
			}
			
		}else if(input.equalsIgnoreCase("W")) {
			if(hero.getMoney()>=10) {
				hero.setMoney(hero.getMoney()-10);
				int final_value = Math.min(hero.getLife()+(int)(hero.getMax_life()*0.55), hero.getMax_life());
				System.out.println(hero.getName()+"在闊氣的旅店舒服地休息了一晚，生命值恢復了"+final_value);
				hero.setLife(final_value);
			}else {
				System.out.println("沒錢還是自己搭個帳篷就好吧..");
			}
			
			
			
		}else if(input.equalsIgnoreCase("E")) {
			if(hero.getMoney()>=10) {
				int l_final_value = Math.min(hero.getLife()+(int)(hero.getMax_life()*0.3), hero.getMax_life());
				int m_final_value = Math.min(hero.getMagic()+(int)(hero.getMax_magic()*0.3), hero.getMax_magic());
				System.out.println(hero.getName()+"在溫泉會館做了紓壓按摩，生命值恢復了"+l_final_value+",魔法力恢復了"+m_final_value);
				hero.setMagic(m_final_value);
				hero.setLife(l_final_value);
			}else {
				System.out.println("沒錢還是自己搭個帳篷就好吧..");
			}		
			
		}else if(input.equalsIgnoreCase("Z")) {
			System.out.println("店主：有機會再來住店哦！");
		}
	}
	
	private void buy(Hero hero,Commodity commodity) {
		if(hero.getMoney()>=commodity.getPrice()) {
			hero.setMoney(hero.getMoney()-commodity.getPrice());
			System.out.println(hero.getName()+"購買了"+commodity.getCom_name());
			if(commodity.getCom_type()==1) {//攻擊類商品
				if(hero.getWeapon_atk()<commodity.getChange_value()) {
					hero.setWeapon_atk(commodity.getChange_value());
					System.out.println(hero.getName()+"裝備了"+commodity.getCom_name()+","+hero.getName()+"的武器攻擊力變為:"+hero.getWeapon_atk());
				}
			}else if(commodity.getCom_type()==2) {//防禦類商品
				if(hero.getEqu_def()<commodity.getChange_value()) {
					hero.setEqu_def((commodity.getChange_value()));
					System.out.println(hero.getName()+"裝備了"+commodity.getCom_name()+","+hero.getName()+"的裝備防禦力變為:"+hero.getEqu_def());
				}
			}
			
		}else {
			System.out.println("金錢不足!");
		}
	}
	
	}

