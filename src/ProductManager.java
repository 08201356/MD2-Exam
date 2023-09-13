import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> productList;
    private Scanner scanner;
    public ProductManager(){
        productList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void addProduct(){
        System.out.println("Bạn muốn gọi sản phẩm của mình là gì?");
        String name = scanner.nextLine();
        System.out.println("Một sản phẩm giá bao nhiêu?");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Bạn muốn bán bao nhiêu sản phẩm?");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Thêm vài dòng mô tả đi!!!!");
        String description = scanner.nextLine();
        Product product = new Product(name, price, quantity, description);
        productList.add(product);
    }
    public void displayProduct(){
        for (Product product : productList){
            System.out.println(product);
        }
    }
    public void editProduct(){
        System.out.println("Nhập ID sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findById(id);
        if (product == null){
            System.out.println("Không tìm thấy ID sản phẩm.\nMời nhập lại hộ cái.");
        } else {
            System.out.println("Bạn muốn gọi sản phẩm của mình là gì?");
            String name = scanner.nextLine();
            System.out.println("Một sản phẩm giá bao nhiêu?");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Bạn muốn bán bao nhiêu sản phẩm?");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Thêm vài dòng mô tả đi!!!!");
            String description = scanner.nextLine();
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setDescription(description);
            System.out.println("Đã sửa xong. Làm ơn đừng quay lại chức năng này sớm.");
        }
    }
    private Product findById(int id){
        for (Product p : productList){
            if(p.getProductID() == id){
                return p;
            }
        }
        return null;
    }
    public void deleteProduct(){
        System.out.println("Nhập ID sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findById(id);
        if (product == null) {
            System.out.println("Không tìm thấy ID sản phẩm.\nMời nhập lại hộ cái.");
        } else {
            productList.remove(product);
            System.out.println("Xoá xong.\nCòn gì mang vào xoá nốt đê.");
        }
    }
    public void sortProduct(ComparatorPrice comparatorPrice) {
        productList.sort(comparatorPrice);
        displayProduct();
    }
    public void findMaxPrice(ComparatorPrice comparatorPrice) {
        if (productList.isEmpty()) {
            System.err.println("Danh sách sản phẩm trống!");
        } else {
            sortProduct(comparatorPrice);
            System.out.println(productList.get(productList.size()-1));
        }
    }
    public void exportData() {
        try {
            File fileProducts = new File("src\\data\\products.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileProducts));
            for (Product p : productList) {
                bw.write(p.getProductID() + "," + p.getName() + "," + p.getPrice() + "," + p.getQuantity()+ ","  + p.getDescription() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }
    public void importData() {
        ArrayList<String[]> listData = new ArrayList<>();
        try {
            File file = new File("src\\data\\products.csv");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listData.add(line.split(","));
            }
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        for (int i = 0; i < listData.size(); i++) {
            int id = Integer.parseInt(listData.get(i)[0]);
            if (Product.getINDEX() < id) {
                Product.setINDEX(id);
            }
            String name = listData.get(i)[1];
            double price = Double.parseDouble(listData.get(i)[2]);
            int quantity = Integer.parseInt(listData.get(i)[3]);
            String description = listData.get(i)[4];
            Product product = new Product(name, (int) price, quantity, description);
            productList.add(product);
        }
    }
}
