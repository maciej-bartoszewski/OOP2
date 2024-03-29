import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void drawLines(){
        System.out.println("----------------------------------------------");
    }
    public static int getDecision(int max){
        int decision;
        Scanner scanner = new Scanner(System.in);
        drawLines();
        while (true) {
            try {
                System.out.print("> ");
                decision = scanner.nextInt();
                scanner.nextLine();
                if (decision >= 1 && decision <= max) break;
                else System.out.println("Podaj odpowiedni numer");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Podaj odpowiedni numer");
            }
        }
        drawLines();
        return decision;
    }

    public static void main(String[] args) {
        ProductList staticList = new ProductList();
        ProductList userList = new ProductList();
        String fileInName = "produkty.txt";
        String fileOutName = "lista_zakupow.txt";
        FileHandler fileInHandler = new FileHandler(fileInName);
        FileHandler fileOutHandler = new FileHandler(fileOutName);

        try{
            fileInHandler.readData(staticList);
        } catch (FileNotFoundException e) {
            System.out.println("Nie udalo sie odczytac danych z pliku produktow");
            System.exit(1);
        }

        File fileOut = new File(fileOutName);
        try {
            if(fileOut.createNewFile()){
                System.out.println("Nie znaleziono poprzedniego pliku z lista zakupow, utworzono nowy");
            } else fileOutHandler.readData(userList);
        } catch (IOException e){
            System.out.println("Nie udalo sie odczytac danych z pliku listy zakupow");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            drawLines();
            System.out.println("Co chcesz zrobic?");
            System.out.println("1. Dodac produkt do listy zakupow");
            System.out.println("2. Wyswietlic produkty z listy zakupow");
            System.out.println("3. Wyswietlic produktow z danej kategorii");
            System.out.println("4. Usunac wszystkie produkty z listy zakupow");
            System.out.println("5. Usunac wszystkie produkty z danej kategorii");
            System.out.println("6. Usunac produkt z danej kategorii");
            System.out.println("7. Zapisac liste zakupow na dysku");
            int decision = getDecision(7);
            String category;
            String product;

            switch (decision){
                case 1:
                    System.out.println("Wybierz kategorie z ktorej dodasz produkt:");
                    staticList.showCategories();
                    category = staticList.getCategoryById(getDecision(staticList.countCategories()) - 1);
                    System.out.println("Wybierz produkt ktory chcesz dodac:");
                    staticList.showProducts(category, true);
                    product = staticList.getProductById(category, getDecision(staticList.countProductsInCategory(category)) - 1);

                    if(userList.addProduct(category, product)) System.out.println("Produkt dodany do listy zakupow");
                    else System.out.println("Produkt znajduje sie juz na liscie");
                    break;
                case 2:
                    if(userList.countCategories() == 0) System.out.println("Lista zakupow jest pusta");
                    else {
                        userList.showCategoriesAndProducts();
                    }
                    break;
                case 3:
                    if(userList.countCategories() == 0) System.out.println("Lista zakupow jest pusta");
                    else {
                        System.out.println("Wybierz kategorie:");
                        userList.showCategories();
                        category = userList.getCategoryById(getDecision(userList.countCategories()) - 1);
                        userList.showProducts(category, false);
                    }
                    break;
                case 4:
                    if (userList.countCategories() == 0) System.out.println("Lista zakupow jest pusta");
                    else {
                        userList.clearList();
                        System.out.println("Wszystkie produkty zostaly usuniete");
                    }
                    break;
                case 5:
                    if (userList.countCategories() == 0) System.out.println("Lista zakupow jest pusta");
                    else {
                        System.out.println("Wybierz kategorie z ktorej usuniesz wszystkie produkty:");
                        userList.showCategories();
                        category = userList.getCategoryById(getDecision(userList.countCategories()) - 1);

                        if(userList.removeCategory(category)) System.out.println("Produkty usuniete pomyslnie");
                        else System.out.println("Nie udalo sie usunac kategorii");
                    }
                    break;
                case 6:
                    if(userList.countCategories() == 0) System.out.println("Lista zakupow jest pusta");
                    else {
                        System.out.println("Wybierz kategorie z ktorej usuniesz produkt:");
                        userList.showCategories();
                        category = userList.getCategoryById(getDecision(userList.countCategories()) - 1);
                        System.out.println("Wybierz produkt ktory chcesz usunac:");
                        userList.showProducts(category, true);
                        product = userList.getProductById(category, getDecision(userList.countProductsInCategory(category)) - 1);

                        if(userList.removeProduct(category, product)) System.out.println("Produkt usuniety pomyslnie");
                        else System.out.println("Nie udalo sie usunac roduktu");
                    }
                    break;
                case 7:
                    try {
                        fileOutHandler.saveData(userList);
                        System.out.println("Dane zapisane prawidlowo");
                    } catch (IOException e){
                        System.out.println("Nie udalo sie zapisac danych");
                    }
                    running = false;
                    break;
            }
        }
    }
}