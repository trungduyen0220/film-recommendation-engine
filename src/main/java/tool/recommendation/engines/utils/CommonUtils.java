package tool.recommendation.engines.utils;

public class CommonUtils {
	public static boolean isInteger(String strNum) {
		if (strNum == null) {
			return false;
		}
		if (strNum.matches("^[+-]?\\d+$")) {
			return true;
		}
		return false;
	}
}
