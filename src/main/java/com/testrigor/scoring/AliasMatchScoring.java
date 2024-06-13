package com.testrigor.scoring;

public class AliasMatchScoring implements ScoringInterface {

	@Override
	public int calculateScore(String possibleName, String actualName,
		String aliases) {
		int score = 0;
        Boolean exactAliasMatch = false;
        Boolean aliasMatch = false;
		 
		if (aliases == null) {
	        return score;
	    }

	    for (String alias : aliases.split(",\\s*")) {
	    	String aliasToEval = alias.replaceAll("[^a-zA-Z0-9]", "");
	        if (aliasToEval.equalsIgnoreCase(possibleName.replaceAll("[^a-zA-Z0-9]", ""))) {
	            exactAliasMatch = true;
	        }
	    	
	        if (aliasToEval.toLowerCase().contains(possibleName.toLowerCase())) {
	        	aliasMatch = true;
	        }
	    }
	    
	    score += aliasMatch ? 1 : 0;
	    score += exactAliasMatch ? 4:0;
	    return score;
	}

}
