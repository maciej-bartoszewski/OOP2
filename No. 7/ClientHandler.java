import java.io.*;
import java.net.Socket;
import java.time.LocalTime;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private final TimeHelper timeHelper = new TimeHelper();

    public ClientHandler(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            closeEverything(clientSocket, bufferedWriter, bufferedReader);
        }
    }

    @Override
    public void run() {
        try {
            int clientID = clientSocket.getPort();
            String message = bufferedReader.readLine();
            String notificationTime = bufferedReader.readLine();
            System.out.println("Received notification: " + message + ", from: " + clientID);

            LocalTime currentTime = LocalTime.now();
            LocalTime desiredTime = LocalTime.parse(notificationTime);

            long timeToSleep = timeHelper.calculateMillisToSleep(currentTime, desiredTime);
            Thread.sleep(timeToSleep);

            sendMessage(message);

            System.out.println("Notification sent successfully to: " + clientID);
        } catch (IOException e) {
            closeEverything(clientSocket, bufferedWriter, bufferedReader);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public void closeEverything(Socket clientSocket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
