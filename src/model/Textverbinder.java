package model;

public class Textverbinder {

	public static String texteVerbindenDirekt(String text1, String text2) throws TextException 
	{
		if (text1 != null && text2 != null)
			return texteVerbinden(text1, text2, "");
		else
			throw new TextException("Fehler: text1 oder text2 ungueltig (text1: \"" + text1 + "\", text2: \"" + text2 + "\")");
	}
	
	public static String texteVerbindenLeerZeichen(String text1, String text2) throws TextException
	{
		if (text1 != null && text2 != null)
			return texteVerbinden(text1, text2, " ");
		else
			throw new TextException("Fehler: text1 oder text2 ungueltig (text1: \"" + text1 + "\", text2: \"" + text2 + "\")");		
	}
	
	public static String texteVerbindenLeerZeile(String text1, String text2) throws TextException
	{
		if (text1 != null && text2 != null)
			return texteVerbinden(text1, text2, "\n");	
		else
			throw new TextException("Fehler: text1 oder text2 ungueltig (text1: \"" + text1 + "\", text2: \"" + text2 + "\")");
	}
	
	private static String texteVerbinden(String text1, String text2, String verbinder) throws TextException 
	{
		if (text1 != null && text2 != null && verbinder != null)
			if (checkTextEmpty(text1) && checkTextEmpty(text2))
				if (checkVerbinder(verbinder))
				{
					StringBuilder sb = new StringBuilder().append(text1).append(verbinder).append(text2);
					return sb.toString();
				}
				else
					throw new TextException("Fehler: verbinder ist ungueltig (verbinder: \"" + verbinder + "\")");
			else
				throw new TextException("Fehler: text1 oder text2 ungueltig (text1: \"" + text1 + "\", text2: \"" + text2 + "\")");
		else
			throw new TextException("Fehler: null-Referenz fuer text1, text2 oder verbinder erhalten (text1: \"" + text1 + " \", text2: \"" + text2 + "\", " + ", verbinder: \"" + verbinder);
	}

	private static boolean checkTextEmpty(String text)
	{
		if (text != null && !text.isEmpty())
			return true;
		else
			return false;
	}
	
	private static boolean checkVerbinder(String text)
	{
		if (text != null && (text.equals("") || text.equals(" ") || text.equals("\n") ))
			return true;
		return false;
	}
}
