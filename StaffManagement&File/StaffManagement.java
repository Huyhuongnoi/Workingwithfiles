import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

public class StaffManagement {
    private static Scanner scanner = new Scanner(System.in);

    public int add() {
        System.out.println("Who do you want to add?\n1. Engineer\n2. Staff\n3. Worker");
        System.out.print("Choice: ");
        int choice = StaffManagement.scanner.nextInt();
        System.out.print("id: ");
        int id = StaffManagement.scanner.nextInt();
        List<String> data = readData();
        int len = data.size();
        for(int idx = 0; idx < len; idx++){
            String[] list = data.get(idx).split("\\|");
            if(Integer.parseInt(list[0]) == id){
                System.out.println("id already exists! ");
                return -1;
            }
        }
        StaffManagement.scanner.nextLine();
        System.out.print("name: ");
        String name = StaffManagement.scanner.nextLine();
        System.out.print("Age: ");
        int age = StaffManagement.scanner.nextInt();
        StaffManagement.scanner.nextLine();
        System.out.print("Sex: ");
        String sex = StaffManagement.scanner.nextLine();
        System.out.print("Address: ");
        String address = StaffManagement.scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Training Industry: ");
                String trainingIndustry = StaffManagement.scanner.nextLine();
                Engineer engineer = new Engineer(id, name, age, sex, address, trainingIndustry);
                writeData(engineer.getDataEngineer());
                break;
            case 2:
                System.out.print("Job: ");
                String job = StaffManagement.scanner.nextLine();
                Staff staff = new Staff(id, name, age, sex, address, job);
                writeData(staff.getDataStaff());
                break;
            case 3:
                System.out.print("Rank: ");
                int rank = StaffManagement.scanner.nextInt();
                Worker worker = new Worker(id, name, age, sex, address, rank);
                writeData(worker.getDataWorker());
                break;
            default:
                System.out.println("Error!");
        }
        return 0;
    }

    public void findId() {
        boolean flag = false;
        System.out.print("find ID: ");
        int idFind = StaffManagement.scanner.nextInt();
        StaffManagement.scanner.nextLine();
        List<String> Data = readData();
        int len = Data.size();
        for (int idx = 0; idx < len; idx++) {
            String[] list = Data.get(idx).split("\\|");
            int id = Integer.parseInt(list[0]);
            if (id == idFind) {
                flag = true;
                System.out.println("id: " + list[0] + "\n" + "name: " + list[1] + "\n" + "Age: " + list[2] + "\n" + "Sex: " + list[3] + "\n" + "Address: " + list[4] + "\n" + list[5]);
            }
        }
        if (flag == false) {
            System.out.println("Object not found!");
        }
    }

    public void findName() {
        boolean flag = false;
        System.out.print("find name: ");
        String nameFind = StaffManagement.scanner.nextLine();
        List<String> Data = readData();
        int len = Data.size();
        for (int idx = 0; idx < len; idx++) {
            String[] list = Data.get(idx).split("\\|");
            String name = list[1];
            if (Objects.equals(name, nameFind)) {
                flag = true;
                System.out.println("id: " + list[0] + "\n" + "name: " + list[1] + "\n" + "Age: " + list[2] + "\n" + "Sex: " + list[3] + "\n" + "Address: " + list[4] + "\n" + "job: " + list[5]);
            }
        }
        if (flag == false) {
            System.out.println("Object not found!");
        }
    }

    public void fullShowInformation() {
        List<String> data = readData();
        int len = data.size();
        for (int idx = 0; idx < len; idx++) {
            String[] list = data.get(idx).split("\\|");
            System.out.println("id: " + list[0] + "\n" + "name: " + list[1] + "\n" + "Age: " + list[2] + "\n" + "Sex: " + list[3] + "\n" + "Address: " + list[4] + "\n" + "job: " + list[5]);
            System.out.println("-------------------------------------");
        }

    }

    private void writeData(String data) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Data.txt", true));
            pw.println(data);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> readData() {
        File file = new File("D:\\LamViecVoiFile\\Data.txt");
        List<String> dataList = new ArrayList<>();
        try {
            dataList = Files.readAllLines(file.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
