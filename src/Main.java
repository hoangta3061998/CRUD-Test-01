import controller.ProductController;
import model.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        ProductController productController = new ProductController();
        Scanner scanner = new Scanner(System.in);
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Product[] list = productController.findAll();
                    if (productController.getSize() == 0) {
                        System.out.println("Khong co san pham nao");
                    }
                    for (int i = 0; i < list.length - 1; i++) {
                        if (list[i] != null) {
                            System.out.println("\n");
                            System.out.println("-----Danh sach san pham-----");
                            System.out.printf("%d \t %s \t %f \t %s ", list[i].getId(), list[i].getName(), list[i].getPrice(), list[i].getDescription());
                            System.out.println("\n");
                        }
                    }
                    break;
                case 2: {
                    System.out.println("Nhap id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhap ten:");
                    String name = scanner.nextLine();
                    System.out.println("Nhap gia:");
                    float price = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Nhap mo ta:");
                    String description = scanner.nextLine();
                    Product product = new Product(id, name, price, description);
                    if (productController.add(product) == -2) {
                        System.out.println("San pham da ton tai");
                    } else if (productController.add(product) == -1) {
                        System.out.println("Danh sach da day");
                    } else {
                        System.out.println("Them thanh cong");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Nhap id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhap ten:");
                    String name = scanner.nextLine();
                    System.out.println("Nhap gia:");
                    float price = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Nhap mo ta:");
                    String description = scanner.nextLine();
                    Product product = new Product(id, name, price, description);
                    if (productController.editById(id, product)) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("San pham khong ton tai");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Nhap id san pham:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (productController.deleteById(id)) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("San pham khong ton tai");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Nhap ten san pham muon tim kiem:");
                    String name = scanner.nextLine();
                    Product product = productController.findByName(name);
                    if (product != null) {
                        System.out.println("-------Ket qua-----------");
                        System.out.printf("%d \t %s \t %f \t %s ", product.getId(), product.getName(), product.getPrice(), product.getDescription());
                        System.out.println("-------------------------");
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                }
                case 6:
                    productController.sortByPrice();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Khong hop le");
            }
        } while (choice != 0);
    }

    public static void displayMenu() {
        System.out.println("\n");
        System.out.println("----------------------------");
        System.out.println("1.Hien thi danh sach san pham");
        System.out.println("2.Them 1 san pham moi");
        System.out.println("3.Sua thong tin cua 1 san pham");
        System.out.println("4.Xoa 1 san pham");
        System.out.println("5.Tim kiem san pham theo ten");
        System.out.println("6.Sap xep san pham");
        System.out.println("7.Thoat");
        System.out.println("Nhap vao lua chon:");
    }
}
