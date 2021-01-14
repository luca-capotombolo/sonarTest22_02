import java.io.*;

/*
 * Questo programma apre uno stream di input verso il file "src/file.txt" bufferizzandolo
 * per aumentare l'efficienza. Leggo il contenuto del file e lo vado a scrivere all'interno
 * di una stringa il cui contenuto verrà alla fine stampato per verificare che il file
 * è stato letto con successo.
 */

public class IOClass {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new FileReader("src/file.txt"));
		String s = new String();
		String s2 = new String();
		while ((s = in.readLine())!=null) {
			s2 += s + "\n";			
		}
		//chiudo lo stream
		in.close();
		System.out.println(s2);			
		
	}
}
