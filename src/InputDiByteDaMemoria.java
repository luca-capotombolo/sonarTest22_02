import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/*
 * Questo prorgramma ha il compito di aprire uno stream di lettura orientato al byte 
 * che legge un come flusso un array di bytes.
 */
public class InputDiByteDaMemoria {

	public static void main(String args[]) throws Exception {
		String s2 = "Ciao mondo!";
		
		try {
			DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(s2.getBytes()));
			while(true) {
				System.out.print((char)inputStream.readByte());
			}
		}catch (EOFException e) {
			System.out.print("La lettura della stringa è terminata.\n");
		}
	}
}
