package com.testrigor;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;

import com.testrigor.scoring.AliasMatchScoring;
import com.testrigor.scoring.ExactMatchScoring;
import com.testrigor.scoring.PartialMatchScoring;
import com.testrigor.scoring.ScoringInterface;
import com.testrigor.scoring.common.Utils;

public class CriminalFinder {
	private final static Map<String, ScoringInterface> scoringStrategies = Map.of(
        "exact", new ExactMatchScoring(),
        "partial", new PartialMatchScoring(),
        "alias", new AliasMatchScoring()
    	);
    
    public static String findCriminal(Map<String, String> criminals, String possibleName) {
    	if (Utils.isValidString(possibleName)) {
    		 String bestMatch = criminals.entrySet().stream()
    		        .map(entry -> {
    		            String actualName = entry.getKey();
    		            String aliases = entry.getValue();
    		            int score = calculateMatchScore(possibleName, actualName, aliases);
    		            return new AbstractMap.SimpleEntry<>(actualName, score);
    		        })
    		        .filter(Objects::nonNull) 
    		        .max(Map.Entry.comparingByValue())
    		        .map(Map.Entry::getKey)
    		        .orElse(null);
    			
    			if (bestMatch != null) {
    				return String.format("First name: %s. Aliases: %s", bestMatch, criminals.get(bestMatch));	
    			} else {
    				return "No Match";
    			}
    	} else {
    		return "No Match";
    	}
    }

	

	private static int calculateMatchScore(String possibleName,
		String actualName, String aliases) {
		int score = scoringStrategies.get("exact").calculateScore(possibleName, actualName, aliases);
        score += scoringStrategies.get("partial").calculateScore(possibleName, actualName, aliases);
        score += scoringStrategies.get("alias").calculateScore(possibleName, actualName, aliases);
		return score;
	}
}
