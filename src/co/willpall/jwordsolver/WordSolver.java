package co.willpall.jwordsolver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordSolver
{
	public static void main( String[] args )
	{
		try
		{
			String letters = "mleisory";
	        
			Scanner scanner = new Scanner( new BufferedReader( new FileReader( "dictionary.txt" ) ) );
			ArrayList<String> words = new ArrayList<String>();
			
			int i = 0;
			while( scanner.hasNext() && ( i < 2000 ) )
			{
				String word = scanner.next();
				
				if( word.length() > 7 )
					continue;
		        
		        if( numberMatchedLetters( letters, word ) > 3 )
		        	words.add( word );
				
				//i++;
			}
			
			for( int j = 0; j < words.size(); j++ )
			{
				System.out.println( words.get( j ) );
			}
		}
		catch( FileNotFoundException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int numberMatchedLetters( String letters, String word )
	{
		int matched = 0;
		
		for( int i = 0; i < letters.length(); i++ )
		{
			if( contains( letters.charAt( i ), word ) )
				matched++;
		}
		
		return matched;
	}
	
	public static boolean contains( char needle, String haystack )
	{
		char[] string = haystack.toCharArray();
		
		for( int i = 0; i < haystack.length(); i++ )
		{
			if( string[i] == needle )
				return true;
		}
		
		return false;
	}
	
}
