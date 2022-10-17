package Utils;

public class RandomUtil {
	public static boolean getYN(double true_ratio) {//0.3
		double result = Math.random();
		if(result<=true_ratio) {
			return true;
		}else {
			return false;
		}
	}
}
