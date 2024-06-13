package com.testrigor.scoring;

import com.testrigor.scoring.common.Utils;

public class ExactMatchScoring implements ScoringInterface {

	@Override
	public int calculateScore(String possibleName, String actualName,
		String aliases) {
		return Utils.isValidString(actualName) && 
			actualName.replaceAll("[^a-zA-Z0-9]", "")
	    	.equalsIgnoreCase(possibleName.replaceAll("[^a-zA-Z0-9]", "")) ? 5 : 0;
	}

}
