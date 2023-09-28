import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean flag = true;
        while (true) {
            if (flag == false) {
                break;
            }
            System.out.println("YUH BANK WELCOME!");
            System.out.println("1. Login\n2. Register");
            System.out.print("choose: ");
            int choose = Main.scanner.nextInt();
            switch (choose) {
                case 1:
                    int condition = Main.bank.login();
                    if (condition != -1) {
                        boolean run = true;
                        while (run) {
                            System.out.println("1. Transfer Money\n2. View Account Information\n3. Change Password\n4. Exit\n");
                            int choice = Main.scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    Main.bank.transferMoney(condition);
                                    break;
                                case 2:
                                    Main.bank.viewAccountInformation(condition);
                                    break;
                                case 3:
                                    Main.bank.changePassword(condition);
                                    break;
                                case 4:
                                    run = false;
                                    break;
                                default:
                                    System.out.println("This function does not exist!");
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    Main.bank.Register();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}
