import java.util.Scanner;
public class Main {
    public static StaffManagement staffManagement = new StaffManagement();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("Choose one of the following functions:\n1. Add Members\n2. Search by id\n3. Search by First and Last Name\n4. Full Show Information\n5. Exit");
            System.out.print("choice: ");
            int choice = Main.scanner.nextInt();
            switch (choice){
                case 1:
                    Main.staffManagement.add();
                    break;
                case 2:
                    Main.staffManagement.findId();
                    break;
                case 3:
                    Main.staffManagement.findName();
                    break;
                case 4:
                    Main.staffManagement.fullShowInformation();
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.println("Error!");

            }
        }
    }
}
