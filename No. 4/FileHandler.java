import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileHandler {
    private final String filename;
    public FileHandler(String filename){
        this.filename = filename;
    }
    public void readData(ProductList productList) throws FileNotFoundException {
        String category = null;
        try(Scanner fileReader = new Scanner(new File(filename))){
            while (fileReader.hasNextLine()){
                String string = fileReader.nextLine().strip().toLowerCase();
                if(string.charAt(0) != '-'){
                    category = string;
                    productList.addCategory(category);
                }
                else if(string.charAt(0) == '-'){
                    string = string.substring(1);
                    productList.addProduct(category, string);
                }
            }
        }
    }
    public void saveData(ProductList productList) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            HashMap<String, ArrayList<String>> data = productList.getList();
            for (Map.Entry<String, ArrayList<String>> entry : data.entrySet()) {
                writer.write(entry.getKey() + "\n");
                for (String product : entry.getValue()) {
                    writer.write("-" + product + "\n");
                }
            }
        }
    }
}