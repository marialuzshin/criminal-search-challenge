package com.testrigor.scoring.common;

public class Utils {
	public static boolean isValidString(String possibleName) {
		return !(possibleName == null || possibleName.replaceAll("[^a-zA-Z0-9]", "").isBlank());
	}
}
