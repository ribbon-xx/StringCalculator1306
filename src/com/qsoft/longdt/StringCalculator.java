package com.qsoft.longdt;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} else if (input.length() == 1) {
			return toInt(input);
		} else if (!input.startsWith("//")) {
			return sumWithoutDelim(input);
		} else {
			String tmp = filterDelim(input);
			return sumWithoutDelim(tmp);
		}
	}

	private static int toInt(String input) {
		return Integer.parseInt(input);
	}

	private static int sumWithoutDelim(String input) {
		ArrayList<Integer> alInt = new ArrayList<Integer>();
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(input);
		while (m.find()) {
			alInt.add(toInt(m.group()));
		}

		int sum = 0;
		for (Integer integer : alInt) {
			if (integer < 0) {
				throw new NumberFormatException("negatives not allowed "
						+ integer);
			}
			if (integer <= 1000) {
				sum += integer;
			}
		}
		return sum;
	}

	private static String filterDelim(String input) {
		String tmp = input.replace("//", "");
		while (tmp.contains("[")) {
			String delimContent = tmp.substring(tmp.indexOf("[") + 1,
					tmp.indexOf("]"));
			String delimDefine = tmp.substring(tmp.indexOf("["),
					tmp.indexOf("]") + 1);
			// System.out.println("delimDefine: " + delimDefine);
			// System.out.println("delimContent: " + delimContent);
			tmp = tmp.replaceAll(Pattern.quote(delimDefine), "");
			tmp = tmp.replaceAll(Pattern.quote(delimContent), ",");
		}
		return tmp;
	}

}
