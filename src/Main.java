public class Main {
    public static void main(String[] args) {
        do {
            try {
                Menu menu = new Menu();
                menu.menu();
            } catch (Exception ex){
                System.out.println(" ");
            }
        } while (true);
    }
}