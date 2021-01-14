import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiaDiUnFile {
	public static void main(String args[]) throws IOException  {
		try {
			//apro lo stream per la lettura del testo del file sorgente
			BufferedReader in = new BufferedReader(new FileReader("src/file.txt"));
			
			//apro lo stream per la scrittura nel file di backup
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/nuovo.txt"));
			
			String testo;
			
			while((testo = in.readLine())!=null) {
				bufferedWriter.write(testo);
				bufferedWriter.write("\n");
				bufferedWriter.flush();
			}
			
			bufferedWriter.close();
			
		}catch (FileNotFoundException e) {			
			e.printStackTrace();
			System.out.print("Errore: file non trovato.\n");
		}
		
		System.out.print("Finito.\n");
	}
}
