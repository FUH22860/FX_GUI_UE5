package test;

import model.TextException;
import model.Textverbinder;

public class TestTextverbinder {

	public static void main(String[] args) 
	{
		try
		{
//			System.out.println(Textverbinder.texteVerbindenDirekt(null, null)); 	// Fehler
//			System.out.println(Textverbinder.texteVerbindenDirekt("", null)); 		// Fehler	
//			System.out.println(Textverbinder.texteVerbindenDirekt(" ", null)); 		// Fehler	
//			System.out.println(Textverbinder.texteVerbindenDirekt(" ", "")); 		// Fehler	
//			System.out.println("\"" + Textverbinder.texteVerbindenDirekt(" ", " ") + "\""); 		// "  " (Anm.: 2x Leerzeichen)	
			System.out.println("\"" + Textverbinder.texteVerbindenDirekt("Java", "FX") + "\""); 		// "JavaFX"
			
//			System.out.println(Textverbinder.texteVerbindenLeerZeichen(null, null)); 	// Fehler
//			System.out.println(Textverbinder.texteVerbindenLeerZeichen("", null)); 		// Fehler	
//			System.out.println(Textverbinder.texteVerbindenLeerZeichen(" ", null)); 		// Fehler	
//			System.out.println(Textverbinder.texteVerbindenLeerZeichen(" ", "")); 		// Fehler	
//			System.out.println("\"" + Textverbinder.texteVerbindenLeerZeichen(" ", " ") + "\""); 		// "   " (Anm.: 3x Leerzeichen)	
			System.out.println("\"" + Textverbinder.texteVerbindenLeerZeichen("kein", "Problem ") + "\""); 		// "kein Problem"	
			
//			System.out.println(Textverbinder.texteVerbindenLeerZeile(null, null)); 	// Fehler
//			System.out.println(Textverbinder.texteVerbindenLeerZeile("", null)); 		// Fehler	
//			System.out.println(Textverbinder.texteVerbindenLeerZeile(" ", null)); 		// Fehler	
//			System.out.println(Textverbinder.texteVerbindenLeerZeile(" ", "")); 		// Fehler
//			System.out.println("\"" + Textverbinder.texteVerbindenLeerZeile(" ", " ") + "\""); 		// "   " (Anm.: 1x Leerzeichen, 1x Leerzeile, 1x Leerzeichen)				
			System.out.println("\"" + Textverbinder.texteVerbindenLeerZeile("heute", "morgen") + "\""); 		// "heute", dann Leerzeile, dann "morgen")							
		}
		catch (TextException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
