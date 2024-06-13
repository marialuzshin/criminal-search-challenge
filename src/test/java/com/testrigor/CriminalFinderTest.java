package com.testrigor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriminalFinderTest {

	private static Map<String, String> criminals;
	private final String expectedRedFortress = "First name: Red Fortress. Aliases: Roger Rabbit, Ross Winter";
	private final String expectedRogerFedexer = "First name: Roger Fedexer. Aliases: Rob Ford, Pete Lord, Roger McWire";
	private final String expectedRedfordFort = "First name: Redford Fort. Aliases: Red Strong, Red Fort";
	private final String expectedPaulWhiteJr = "First name: Paul White Jr.. Aliases: null";
	private final String expectedPaulWhite = "First name: Paul White. Aliases: Roger Night, Peter Llong Jr.";
	private final String expectedNoMatch = "No Match";
	
	@BeforeAll
	private static void init() {
		criminals = new HashMap<>();
		criminals.put("Paul White Jr.", null);
		criminals.put("Paul White", "Roger Night, Peter Llong Jr.");
		criminals.put("Roger Fedexer", "Rob Ford, Pete Lord, Roger McWire");
		criminals.put("Red Fortress", "Roger Rabbit, Ross Winter");
		criminals.put("Redford Fort", "Red Strong, Red Fort");
	}
	
	@Test 
	public void havingEmptySearch_NoMatchIsReturned() {
        assertEquals(expectedNoMatch, CriminalFinder.findCriminal(criminals, ""));
        assertEquals(expectedNoMatch, CriminalFinder.findCriminal(criminals, "   "));
        assertEquals(expectedNoMatch, CriminalFinder.findCriminal(criminals, " . "));
        assertEquals(expectedNoMatch, CriminalFinder.findCriminal(criminals, null));
	}
	
	@Test 
	public void havingExactMatch() {
		assertEquals(expectedRedFortress, CriminalFinder.findCriminal(criminals, "Red Fortress")); 
		assertEquals(expectedRedfordFort, CriminalFinder.findCriminal(criminals, "Redford Fort")); 
	}
	
	@Test
    public void havingExactMatchWithDifferentCases() {
		assertEquals(expectedRedFortress, CriminalFinder.findCriminal(criminals, "Red fortress"));
		assertEquals(expectedPaulWhite, CriminalFinder.findCriminal(criminals, "Paul white"));
		assertEquals(expectedPaulWhite, CriminalFinder.findCriminal(criminals, "paul white")); 
		assertEquals(expectedRogerFedexer, CriminalFinder.findCriminal(criminals, "Roger Fedexer")); 
        assertEquals(expectedRogerFedexer, CriminalFinder.findCriminal(criminals, "roger fedexer")); 
	}
	
	@Test
    public void havingExactMatchWithDifferentSpaces() {
		assertEquals(expectedPaulWhite, CriminalFinder.findCriminal(criminals, "Paulwhite")); 
		assertEquals(expectedRogerFedexer, CriminalFinder.findCriminal(criminals, "rogerfedexer"));  
	}
	
	@Test
    public void havingExactMatchWithDifferentOrder() {
        assertEquals(expectedRogerFedexer, CriminalFinder.findCriminal(criminals, "FedeXer Roger"));
	}
		
	@Test
    public void havingExactMatchWithDifferentSpecialChars() {
		assertEquals(expectedPaulWhiteJr, CriminalFinder.findCriminal(criminals, "Paul White Jr.")); 
	    assertEquals(expectedPaulWhiteJr, CriminalFinder.findCriminal(criminals, "Paul White .Jr")); 
	    assertEquals(expectedPaulWhiteJr, CriminalFinder.findCriminal(criminals, "-Paul White _Jr"));  
	}
	
	@Test
    public void havingPartialActualNameMatch() {
        assertEquals(expectedRedFortress, CriminalFinder.findCriminal(criminals, "Red "));
        assertEquals(expectedRedFortress, CriminalFinder.findCriminal(criminals, "Red"));
        assertEquals(expectedRogerFedexer, CriminalFinder.findCriminal(criminals, "Roger"));
        assertEquals(expectedRogerFedexer, CriminalFinder.findCriminal(criminals, "Fedexer"));  
        assertEquals(expectedPaulWhiteJr, CriminalFinder.findCriminal(criminals, "white jr."));
        assertEquals(expectedRedfordFort, CriminalFinder.findCriminal(criminals, "Redford")); 
    }
	
	@Test
    public void havingExactAliasMatch() {
		assertEquals(expectedRedFortress, CriminalFinder.findCriminal(criminals, "Ross Winter")); 
		assertEquals(expectedPaulWhite, CriminalFinder.findCriminal(criminals, "Peter Llong Jr."));
		assertEquals(expectedRogerFedexer, CriminalFinder.findCriminal(criminals, "Rob Ford")); 
	}
	
	@Test
    public void havingExactAliasMatchPrevailsOverPartialName() {
		assertEquals(expectedRedFortress, CriminalFinder.findCriminal(criminals, "Roger Rabbit")); 
	}
	
	@Test
    public void havingPartialAliasMatch() {
		assertEquals(expectedRogerFedexer, CriminalFinder.findCriminal(criminals, "Ford"));
        assertEquals(expectedRedFortress, CriminalFinder.findCriminal(criminals, "Ross")); 
	}
	
	@Test
    public void havingMixedPartialAliasMatch() {
        assertEquals(expectedPaulWhite, CriminalFinder.findCriminal(criminals, "Peter Night")); 
	}
	
	@Test
    public void havingMixedActualNameAndAliasMatch_ActualNamePrevails() {
        assertEquals(expectedRedfordFort, CriminalFinder.findCriminal(criminals, "Redford Strong")); 
	}
	
	
}
