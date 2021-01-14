import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class OutputDiCaratteriSuFile {

	public static void main(String args[]) throws Exception {
		String contenutoString = "Questo sarà il contenuto che andrò a scrivere all'interno del nuovo file";
		String s;
		
		try {
			//apro uno stream che mi consente di leggere carattere per carrattere oppure
			//riga per riga i caratteri della stringa
		
			BufferedReader bufferedReader = new BufferedReader(new StringReader(contenutoString));
		
			//apro uno stream bufferizzato di output (scrittura) per poter scrivere sul file
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/nuovo2.txt")));
		
			while((s=bufferedReader.readLine())!=null) {
				out.println(s);
			}
		
			out.println();
			out.close();
		
			System.out.print("Copiatura stringa effettuata.");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("Exceptionnnn\n");
		}finally {
			
		}
		
	}
}
