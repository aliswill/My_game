package Utils;

public class FirstAttackUtil {

	public boolean isFirst(int a_dex,int b_dex) {//看誰先攻
		if(a_dex>b_dex) {
			return true;
		}
		else if(a_dex==b_dex) {
			return Math.random()>0.5;
		}else {
			return false;
		}
	}
}
