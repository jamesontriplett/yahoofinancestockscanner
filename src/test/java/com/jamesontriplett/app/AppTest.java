package com.jamesontriplett.app;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	
	ScreenScraper ss;
    @Before
    public void init()
	   {
		   ss = new ScreenScraper();
	   }
	
	public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigorous Test :-)
     * @throws FileNotFoundException 
     */
    public void testApp() throws FileNotFoundException
    {
    	PrintStream out = new PrintStream("inputtest.csv");
    	out.println("Symbol,Nothing");
    	out.println("FLT,xyz");
    	out.println("LL,zyx");
    	out.close();

    	String [] args = {"-input", "inputtest.csv"};
    	ScreenScraper.main(args);
        assertTrue( true );
    }
    
    public void testScrape(){
    	String SYMBOL = ScreenScraper.SYMBOL;

    	String desiredFields[] = ScreenScraper.desiredFields;
    	
    	YahooScreenScraper yss = new YahooScreenScraper(SYMBOL, desiredFields);
    	Map<String,String> testMap = yss.getDataBySymbol("FLT");
    	assertFalse(testMap.isEmpty());
    	for(int i=0;i < desiredFields.length; i++){
    	assertNotNull(testMap.get(desiredFields[i]));
    	System.out.println(testMap.get(desiredFields[i]));
    	}
    }
 
}
