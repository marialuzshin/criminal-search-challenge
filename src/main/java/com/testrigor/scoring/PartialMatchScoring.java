package com.testrigor.scoring;

import com.testrigor.scoring.common.Utils;

public class PartialMatchScoring implements ScoringInterface {

	@Override
	public int calculateScore(String possibleName, String actualName,
		String aliases) {
		int score = 0;
		
		if (!Utils.isValidString(actualName)) {
			return score;
		}
		
		String[] nameParts = actualName.toLowerCase().split("\\s+");
	    String[] parts = possibleName.toLowerCase().split("\\s+");
	    

	    for (String namePart : nameParts) {
	        for (String part : parts) {
	            if (namePart.equalsIgnoreCase(part)) {
	                score += 2;
	            }
	        }
	    }

	    return score;
	}

}
