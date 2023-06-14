package com.geekaca.j2.util;

/**
 * ClassName: ArraysUtils
 * Function:  工具类
 */
public class ArraysUtils {
	//防止创建对象
	private ArraysUtils(){}

	public static String showString(int[] arr) {
		String result = "[";
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				result = result + arr[i] + ", ";
			} else {
				result = result + arr[i];
			}
		}
		result += "]";
		System.out.println(result);
		return result;
	}

	/**
	 * 求平均值
	 * @param scores
	 * @return
	 */
	public static double getAverage(double[] scores){

		double max = scores[0];
		double min = scores[0];
		double total = 0;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > max){
				max = scores[i];
			}
			if (scores[i] < min){
				min = scores[i];
			}
			total += scores[i];
		}
		double lastAverageScore = (total - max - min) / (scores.length - 2);
		return lastAverageScore;
	}
}
