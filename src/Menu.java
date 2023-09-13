import java.util.Scanner;
public class Menu {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        ComparatorPrice comparatorPrice = new ComparatorPrice();
        do {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Thoát");
            System.out.println("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productManager.displayProduct();
                    break;
                case 2:
                    productManager.addProduct();
                    break;
                case 3:
                    productManager.editProduct();
                    break;
                case 4:
                    productManager.deleteProduct();
                    break;
                case 5:
                    productManager.sortProduct(comparatorPrice);
                    break;
                case 6:
                    productManager.findMaxPrice(comparatorPrice);
                case 7:
                    System.exit(0);
            }
        } while (true);
    }
}