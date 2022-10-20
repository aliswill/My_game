package Role;

import Utils.RandomMapUtil;

public class NPCPrincess implements NPCrole {
	private Hero hero;
	private int meet_time;
	
	public NPCPrincess(Hero hero) {
		super();
		this.meet_time=0;
		this.hero = hero;
	}
	
	@Override
	public void appear() {
		//固定天數在固定地點一定會遇到 ex:3/4天a地，9/10天b地 14/15天c地
		//最多共遇到3次，每次提不同的要求，3次都達成擇滿足條件
		//第一次要錢.第二次打贏混混.第三次答對所有問題
		if(this.meet_time==0) {
			
		}else if(this.meet_time==1) {
			
		}else if(this.meet_time==2) {
			
		}
		
	}

}
