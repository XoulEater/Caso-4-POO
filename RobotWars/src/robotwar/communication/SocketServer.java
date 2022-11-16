package robotwar.communication;

import java.io.InputStreamReader;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer{
	
	public static void main(String[] args) throws IOException {
		Socket connection2 = null;
		ServerSocket serverSocket = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		
		serverSocket = new ServerSocket (2070);
		
		while (true)
		{
			try
			{
				connection2 = serverSocket.accept();
				
				inputStreamReader = new InputStreamReader(connection2.getInputStream());
				outputStreamWriter = new OutputStreamWriter(connection2.getOutputStream());
				
				bufferedReader = new BufferedReader(inputStreamReader);
				bufferedWriter = new BufferedWriter(outputStreamWriter);
				
				while (true)
				{
					String msgClient = bufferedReader.readLine();
					
					System.out.println("Client: "+msgClient);
					
					bufferedWriter.write("MsgRecived :)" );
					bufferedWriter.newLine();
					bufferedWriter.flush();
					
					if (msgClient.equals("Adios"))
						break;
					
				}
				
				connection2.close();
				inputStreamReader.close();
				outputStreamWriter.close();
				bufferedReader.close();
				bufferedWriter.close();
				
			}catch (IOException e)
			{
				e.printStackTrace();}
		}
	}
}
