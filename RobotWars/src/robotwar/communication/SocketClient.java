package robotwar.communication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class SocketClient {
	public static void main(String[] args) {
		
		Socket connection = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			
			connection = new Socket("localhost", 2070);
			
			inputStreamReader = new InputStreamReader(connection.getInputStream());
			outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
			
			bufferedReader = new BufferedReader(inputStreamReader);
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			
			Scanner scanner = new Scanner(System.in);
			
			while(true)
			{
				String msg = scanner.nextLine();
				bufferedWriter.write(msg);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				
			
				System.out.println("Server: "+ bufferedReader.readLine());
				
				if (msg.equalsIgnoreCase("Adios"))
					break;
			}
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}finally
		{
		try {
			if (connection != null)
				connection.close();
			if (inputStreamReader != null)
				inputStreamReader.close();
			if (outputStreamWriter != null)
				outputStreamWriter.close();
			if (bufferedReader != null)
				bufferedReader.close();
			if (bufferedWriter != null)
				bufferedWriter.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
