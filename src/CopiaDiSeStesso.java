import java.io.*;

//Questo programma ha il compito di scrivere un nuovo file.
//Il nuovo file avrà come contenuto il contenuto del file CopiaDiSeStesso

public class CopiaDiSeStesso {
	
	public static void main(String args[]) throws IOException {
		
		try {
			//mi serve uno stream di lettura per poter leggere il contenuto del file stesso
			//decido di bufferizzare il contenuto
			BufferedReader in = new BufferedReader(new FileReader("src/CopiaDiSeStesso.java"));
			
			//creo il nuovo file e verifico che tutto sia andato a buon fine
			File file = new File("src/Lol.txt");
			if(file.createNewFile()) {
				System.out.println("File creato.\n");
			}else {
				
				System.exit(-1);
			}
			
			//inzio il processo di copiatura
			
			BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			
			String contenuto;
			int count = 1;
			
			while((contenuto = in.readLine())!=null) {
				out.write("Riga numero: " + count + contenuto + "\n");
				count++;
				out.flush();
			}
			
			in.close();
			out.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		System.out.println("File copiato con successo.\n");
	}
}
