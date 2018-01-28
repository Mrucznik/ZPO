package gajda.szymon;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            //get data
            int start, end;
            String[] clientSentence = inFromClient.readLine().split(" ");
            start = Integer.valueOf(clientSentence[0]);
            end = Integer.valueOf(clientSentence[1]);

            PrimeNumberCalculator primeNumberCalculator = new PrimeNumberCalculator();
            long startTime = System.currentTimeMillis();
            int count = primeNumberCalculator.getPrimeCountMultithread(start, end);
            //int count = primeNumberCalculator.getPrimeCount(start, end);
            long estimatedTime = System.currentTimeMillis() - startTime;

            System.out.println("Received: " + clientSentence);
            outToClient.writeBytes("Prime numbers in range: "+count+", calculation time: "+estimatedTime+"ms\n");
        }
    }
}
