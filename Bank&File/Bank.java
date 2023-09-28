import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class Bank {
    private static List<User> userList = new ArrayList<>();
    private static List<Card> cardList = new ArrayList<>();
    public static final int specifiedAge = 18;
    private static Scanner scanner = new Scanner(System.in);
    private String[] receiver = {"Nguyen Van Hung", "Pham My Hanh", "Le Viet Quang", "Tran My Tam", "Nguyen Hong Nhung"};

    public int Register() {
        System.out.println("you are registering an account: ");
        System.out.print("Your name: ");
        Main.scanner.nextLine();
        String name = Bank.scanner.nextLine();
        System.out.print("Your age: ");
        int age = Bank.scanner.nextInt();
        if (age < specifiedAge) {
            System.out.println("You are not old enough to create an account. Account creation failed!");
            Bank.scanner.nextLine();
        } else {
            Bank.scanner.nextLine();
            System.out.print("Your gender: ");
            String sex = Bank.scanner.nextLine();
            System.out.print("Your address: ");
            String address = Bank.scanner.nextLine();
            System.out.print("Enter your account number: ");
            String accountNumber = Bank.scanner.next();
            readObject();
            int len = Bank.cardList.size();
            for (int idx = 0; idx < len; idx++) {
                String oldAccountNumber = Bank.cardList.get(idx).getAccountNumber();
                if (Objects.equals(oldAccountNumber, accountNumber)) {
                    System.out.println("Account already exists!");
                    return -1;
                }
            }
            System.out.print("Enter your password: ");
            String pass = Bank.scanner.next();
            System.out.print("How much money do you want to deposit: ");
            double money = Bank.scanner.nextDouble();
            User user = new User(name, age, sex, address);
            Card card = new Card(name, accountNumber, pass, money);
            userList.add(user);
            cardList.add(card);
            writeObject();

        }
        System.out.println("Account successfully created!");
        Bank.scanner.nextLine();
        return 0;
    }

    public int login() {
        System.out.print("Enter your account: ");
        String account = Bank.scanner.next();
        System.out.print("Enter your password: ");
        String pass = Bank.scanner.next();
        int len = Bank.cardList.size();
        for (int idx = 0; idx < len; idx++) {
            if (Objects.equals(Bank.cardList.get(idx).getAccountNumber(), account) && Objects.equals(Bank.cardList.get(idx).getPass(), pass)) {
                System.out.println("Logged in successfully!");
                return idx;
            }
        }
        System.out.println("Login failed. Account does not exist!");
        Bank.scanner.nextLine();
        return -1;
    }

    public void transferMoney(int index) {
        System.out.print("Enter the recipient account number: ");
        String recipientAccountNumber = Bank.scanner.next();
        Random random = new Random();
        int idx = random.nextInt(receiver.length);
        System.out.println(receiver[idx]);
        System.out.print("Enter the amount you want to send: ");
        double money = Bank.scanner.nextDouble();
        Bank.cardList.get(index).setAccountBalance(Bank.cardList.get(index).getAccountBalance() - money);
        System.out.println("Successful deposit!");
        Bank.scanner.nextLine();
    }

    public void viewAccountInformation(int index) {
        String information = Bank.userList.get(index).getName() + "\n" + Bank.cardList.get(index).getAccountNumber() + "\n" + String.valueOf(Bank.cardList.get(index).getAccountBalance());
        System.out.println(information);

    }

    public void changePassword(int index) {
        System.out.print("Enter old password: ");
        String oldPass = Bank.scanner.next();
        if (Objects.equals(oldPass, Bank.cardList.get(index).getPass())) {
            System.out.print("Enter new password: ");
            String newPass = Bank.scanner.next();
            Bank.cardList.get(index).setPass(newPass);
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Enter incorrect password!");
        }
    }

    private void writeObject() {
        File file = new File("D:\\Bank&File\\data.txt");
        int len = cardList.size();
        try {
            OutputStream os = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (int index = 0; index < len; index++) {
                oos.writeObject(Bank.cardList.get(index));
            }
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readObject() {
        File file = new File("D:\\Bank&File\\data.txt");
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Card card = null;
            while (true) {
                card = (Card) ois.readObject();
                if (card == null) {
                    break;
                } else {
                    Bank.cardList.add(card);
                }
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

