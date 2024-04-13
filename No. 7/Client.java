import java.io.*;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private final TimeHelper timeHelper = new TimeHelper();

    public Client(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            closeEverything(clientSocket, bufferedWriter, bufferedReader);
        }
    }

    public void communication(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter notification message: ");
            String message = scanner.nextLine();

            System.out.print("Enter time to send notification (HH:MM:SS): ");
            LocalTime notificationTime;

            while (true) {
                try {
                    notificationTime = timeHelper.readTime(scanner);
                    break;
                } catch (MyWrongTimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Enter future time in format (HH:MM:SS)");
                }
            }

            sendMessage(message);
            sendMessage(String.valueOf(notificationTime));

            receiveMessage();
        } catch (IOException e) {
            closeEverything(clientSocket, bufferedWriter, bufferedReader);
        }
    }
    public void sendMessage(String message) throws IOException {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
    }

    public void receiveMessage() {
        String notification;
        try {
            notification = bufferedReader.readLine();
            System.out.println("Notification from server: " + notification);
        } catch (IOException e) {
            closeEverything(clientSocket, bufferedWriter, bufferedReader);
        }
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

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            Client client = new Client(socket);
            client.communication();
        } catch (IOException e) {
            System.out.println("Server is offline");
        }
    }
}