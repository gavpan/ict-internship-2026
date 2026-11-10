import java.util.*;
 
public class helpdesk {
 
    static class Ticket {
        int no;
        String name;
        String concern;
        String category;
        String status;
    }
 
    static ArrayList<Ticket> list = new ArrayList<>();
    static int count = 1;
    static Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
        while (true) {
            System.out.println("");
            System.out.println(" ICT HELPDESK");
            System.out.println("1. Create Ticket");
            System.out.println("2. View All Tickets");
            System.out.println("3. Update Ticket Status");
            System.out.println("4. Search Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            String c = sc.nextLine();
 
            if (c.equals("1")) {
                create();
            } else if (c.equals("2")) {
                viewAll();
            } else if (c.equals("3")) {
                update();
            } else if (c.equals("4")) {
                search();
            } else if (c.equals("5")) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Wrong input, try again");
            }
        }
    }
 
    static void create() {
        Ticket t = new Ticket();
        t.no = count;
        count++;
 
        System.out.print("Employee name: ");
        t.name = sc.nextLine();
        while (t.name.trim().equals("")) {
            System.out.print("Cant be empty. Employee name: ");
            t.name = sc.nextLine();
        }
 
        System.out.print("Concern: ");
        t.concern = sc.nextLine();
        while (t.concern.trim().equals("")) {
            System.out.print("Cant be empty. Concern: ");
            t.concern = sc.nextLine();
        }
 
        System.out.println("Category");
        System.out.println("1. Account");
        System.out.println("2. Hardware");
        System.out.println("3. Software");
        System.out.println("4. Network");
        System.out.print("Choose: ");
        String cat = sc.nextLine();
        while (!cat.equals("1") && !cat.equals("2") && !cat.equals("3") && !cat.equals("4")) {
            System.out.print("Invalid. Choose 1-4: ");
            cat = sc.nextLine();
        }
        if (cat.equals("1")) t.category = "Account";
        if (cat.equals("2")) t.category = "Hardware";
        if (cat.equals("3")) t.category = "Software";
        if (cat.equals("4")) t.category = "Network";
 
        t.status = "Open";
        list.add(t);
        System.out.println("Ticket created! Ticket number is " + t.no);
    }
 
    static void viewAll() {
        if (list.size() == 0) {
            System.out.println("No tickets yet");
        } else {
            for (int i = 0; i < list.size(); i++) {
                Ticket t = list.get(i);
                System.out.println("-------------------");
                System.out.println("Ticket No: " + t.no);
                System.out.println("Name: " + t.name);
                System.out.println("Concern: " + t.concern);
                System.out.println("Category: " + t.category);
                System.out.println("Status: " + t.status);
            }
            System.out.println("-------------------");
        }
    }
 
    static void update() {
        if (list.size() == 0) {
            System.out.println("No tickets yet");
            return;
        }
        System.out.print("Enter ticket number: ");
        String s = sc.nextLine();
        int n;
        try {
            n = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Numbers only!");
            return;
        }
 
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).no == n) {
                found = true;
                System.out.println("Current status: " + list.get(i).status);
                System.out.println("1. Open");
                System.out.println("2. Still In Progress");
                System.out.println("3. Resolved");
                System.out.print("New status: ");
                String st = sc.nextLine();
                if (st.equals("1")) {
                    list.get(i).status = "Open";
                    System.out.println("Updated!");
                } else if (st.equals("2")) {
                    list.get(i).status = " Still In Progress";
                    System.out.println("Updated");
                } else if (st.equals("3")) {
                    list.get(i).status = "Resolved";
                    System.out.println("Updated");
                } else {
                    System.out.println("Invalid choice, no changes made");
                }
            }
        }
        if (found == false) {
            System.out.println("Ticket not found");
        }
    }
 
    static void search() {
        System.out.print("Enter ticket number: ");
        String s = sc.nextLine();
        int n;
        try {
            n = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Numbers only");
            return;
        }
 
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).no == n) {
                found = true;
                Ticket t = list.get(i);
                System.out.println("-------------------");
                System.out.println("Ticket No: " + t.no);
                System.out.println("Name: " + t.name);
                System.out.println("Concern: " + t.concern);
                System.out.println("Category: " + t.category);
                System.out.println("Status: " + t.status);
                System.out.println("-------------------");
            }
        }
        if (found == false) {
            System.out.println("Ticket not found");
        }
    }
}