package com.testrigor;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

	/**
	 *
	 * Check README
	 */
	public static void main(String[] args) {
		Map<String, String> criminals = new HashMap<>();
		criminals.put("Paul White Jr.", null);
		criminals.put("Paul White", "Roger Night, Peter Llong Jr.");
		criminals.put("Roger Fedexer", "Rob Ford, Pete Lord, Roger McWire");
		criminals.put("Red Fortress", "Roger Rabbit, Ross Winter");
		criminals.put("Redford Fort", "Red Strong, Red Fort");

		// Add as many as you want
		System.out.println("Searching for \"Red \": " + findCriminal(criminals, "Red "));
		System.out.println("Searching for \"Red\": " + findCriminal(criminals, "Red"));
		System.out.println("Searching for \"null\": " + findCriminal(criminals, null));
		System.out.println("Searching for \"Ford\": " + findCriminal(criminals, "Ford"));
		
		System.out.println("Searching for \"Roger\": " + findCriminal(criminals, "Roger"));
		System.out.println("Searching for \"Ross\": " + findCriminal(criminals, "Ross"));
		System.out.println("Searching for \"white jr.\": " + findCriminal(criminals, "white jr."));
		System.out.println("Searching for \"Paul White\": " + findCriminal(criminals, "Paul White"));

		System.out.println("Searching for \"paul white\": " + findCriminal(criminals, "paul white"));
		System.out.println("Searching for \"Paulwhite\": " + findCriminal(criminals, "Paulwhite"));
		System.out.println("Searching for \"Paul White Jr.\": " + findCriminal(criminals, "Paul White Jr."));
		System.out.println("Searching for \"Paul White Jr\": " + findCriminal(criminals, "Paul White Jr"));

		System.out.println("Searching for \"Roger\": " + findCriminal(criminals, "Roger"));
		System.out.println("Searching for \"rogerfedexer\": " + findCriminal(criminals, "rogerfedexer"));
		System.out.println("Searching for \"Roger Fedexer\": " + findCriminal(criminals, "Roger Fedexer"));
		System.out.println("Searching for \"roger fedexer\": " + findCriminal(criminals, "roger fedexer"));

		System.out.println("Searching for \"Peter Llong Jr.\": " + findCriminal(criminals, "Peter Llong Jr."));
		System.out.println("Searching for \"Rob Ford\": " + findCriminal(criminals, "Rob Ford"));
		System.out.println("Searching for \"Red Fortress\": " + findCriminal(criminals, "Red Fortress"));
		System.out.println("Searching for \"Redford Fort\": " + findCriminal(criminals, "Redford Fort"));
		System.out.println("Searching for \"Ross Winter\": " + findCriminal(criminals, "Ross Winter"));
		System.out.println("Searching for \"Roger Rabbit\": " + findCriminal(criminals, "Roger Rabbit"));
		System.out.println("Searching for \"Redford\": " + findCriminal(criminals, "Redford"));
		System.out.println("Searching for \"Pete Lord\": " + findCriminal(criminals, "Pete Lord"));
		System.out.println("Searching for \"\": " + findCriminal(criminals, ""));
		System.out.println("Searching for \"   \": " + findCriminal(criminals, "   "));
		System.out.println("Searching for \" . \": " + findCriminal(criminals, " . "));

	}

	/**
	 * @param criminals
	 * @param possibleName
	 * @return A String with possible matching criminals according 
	 * to different implemented matching strategies
	 */
	public static String findCriminal(Map<String, String> criminals, String possibleName) {
		return CriminalFinder.findCriminal(criminals, possibleName);
	}
	
	

	

}
