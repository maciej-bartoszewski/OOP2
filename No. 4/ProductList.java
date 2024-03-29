import java.util.ArrayList;
import java.util.HashMap;

public class ProductList {
    HashMap<String, ArrayList<String>> list;

    public ProductList() {
        list = new HashMap<>();
    }

    public void showCategoriesAndProducts() {
        list.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(product -> System.out.println("- " + product));
        });
    }

    public void clearList() {
        list.clear();
    }

    public void showCategories() {
        list.forEach((category, productList) ->
                System.out.println((list.keySet().stream().toList().indexOf(category) + 1) + ". " + category));
    }

    public int countCategories() {
        return list.size();
    }

    public String getCategoryById(int id) {
        return list.keySet().stream().toList().get(id);
    }

    public void addCategory(String category) {
        list.put(category, new ArrayList<>());
    }

    public boolean removeCategory(String category) {
        if (list.containsKey(category)) {
            list.remove(category);
            return true;
        }
        return false;
    }

    public void showProducts(String category, boolean withId) {
        if (withId)
            list.get(category).forEach(product -> System.out.println((list.get(category).indexOf(product) + 1) + ". " + product));
        else list.get(category).forEach(product -> System.out.println("- " + product));
    }

    public int countProductsInCategory(String selectedCategory) {
        for (String category : list.keySet()) {
            if (category.equals(selectedCategory)) return list.get(category).size();
        }
        return -1;
    }

    public String getProductById(String category, int id) {
        return list.get(category).get(id);
    }

    public boolean addProduct(String category, String product) {
        if (!list.containsKey(category)) addCategory(category);
        if (list.get(category).contains(product)) return false;
        list.get(category).add(product);
        return true;
    }

    public boolean removeProduct(String category, String product) {
        if (list.get(category).contains(product)) {
            list.get(category).remove(product);
            if(list.get(category).isEmpty()) list.remove(category);
            return true;
        }
        return false;
    }

    public HashMap<String, ArrayList<String>> getList() {
        return list;
    }
}