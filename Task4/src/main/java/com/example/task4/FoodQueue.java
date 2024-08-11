package com.example.task4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FoodQueue {
    //variable declaration
    private static boolean isTrue = true; // Flag for program control
    private static boolean foundCustomer = false; // Flag to check if customer exists
    private static final String[] Queue1 = new String[2]; // First queue with a size of 2
    private static final String[] Queue2 = new String[3]; // Second queue with a size of 3
    private static final String[] Queue3 = new String[5]; // Third queue with a size of 5
    private static final String[] QueueData = new String[10]; // Data array to store queue information
    private static final ArrayList<Customer> customerDetails=new ArrayList<>(); // An array list to store customer details
    private static final ArrayList<String> waitingQue=new ArrayList<>(); //Array list for waiting queue
    private static int remainingStock = 50; // Initial stock count
    private static int i = 0; // Counter for Queue1
    private static int j = 0; // Counter for Queue2
    private static int k = 0; // Counter for Queue3
    private static int original_i = 0; // Original counter for Queue1
    private static int original_j = 0; // Original counter for Queue2
    private static int original_k = 0; // Original counter for Queue3
    private static int queue1Size = 2; // Maximum size of Queue1
    private static int queue2Size = 3; // Maximum size of Queue2
    private static int queue3Size = 5; // Maximum size of Queue3

    // Method to print cashier and queue format
    public static void cashierPattern() {
        System.out.println("");
        System.out.println(" ********************");
        System.out.println(" *     Cashiers     *");
        System.out.println(" ********************");
    }
    // Method to update burger stocks and display the remaining stock
    public static String burgerStocks(boolean display) {
        //remainingStock -= 5;
        if (display) {
            return "Remaining stock is " + remainingStock;
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("\t\t\t\t\tFoodies Fave Food Center");
        System.out.println("\t\t\t\t\t\t\tMain Menu");
        System.out.println("------------------------------------------------------------------");
        System.out.println("100 or VFQ:  View all Queues.");
        System.out.println("101 or VEQ:  View all Empty Queues.");
        System.out.println("102 or ACQ:  Add customers to a Queue");
        System.out.println("103 or RCQ:  Remove a customer from a Queue.");
        System.out.println("104 or PCQ:  Remove a served customer");
        System.out.println("105 or VCS:  View customer Sorted in alphabetical");
        System.out.println("106 or SPD:  Store Program data into file.");
        System.out.println("107 or LPD:  Load Program Data from file.");
        System.out.println("108 or STK:  View Remaining burger Stock.");
        System.out.println("109 or AFS:  Add burgers to Stock");
        System.out.println("999 or EXT:  Exit the Program.\n------------------------------------------------------------------");

        while (isTrue) {

            // Asking the user for an option
            System.out.println("Enter Your Choice :");
            String option = input.next();

            switch (option) {
                case "100": case "VFQ":
                    viewAllQueues();
                    break;

                case "101": case "VEQ":
                    printEmptyQueues();
                    break;

                case "102": case "ACQ":
                    Addcustomer(input);
                    break;

                case "103": case "RCQ":
                    removeCustomer(input);
                    break;

                case "104": case "PCQ":
                    removeServedCustomers(input);
                    break;

                case "105": case "VCS":
                    SortCustomerNames();
                    break;
                case "106": case "SPD":
                    storedata();
                    break;

                case "107": case "LPD":
                    loadData();
                    break;

                case "108": case"STK":
                    System.out.println("Remaining stock is " + remainingStock);
                    break;

                case"109": case"AFS":
                    AddStocks(input);
                    break;
                case"110": case"IFQ":
                    displayQueueValue();
                    break;
                case "112": case "GUI":
                    launchFoodFaveApplication();
                    break;
                case "999": case "EXT":
                    System.out.println("Thank You , Have a Great Day !");
                    isTrue = false;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    // Method to add a customer to a specific queue
    private static void Addcustomer(Scanner input) {
        int noOfBurgers;
        Customer customer =new Customer();

        try {
            System.out.println("Enter the Customer first name :");
            String firstName = input.next();
            customer.setFirstName(firstName);
            System.out.println("Enter the Customer second name :");
            customer.setLastName(input.next());
            System.out.println("Enter the no of burgers :");
            noOfBurgers=Integer.parseInt(input.next());
            customer.setNoOfBurgerCount(noOfBurgers);
            System.out.println("Enter the Queue (1, 2, or 3):");
            int queue = input.nextInt();


            if (queue < 1 || queue > 3) {
                System.out.println("Invalid Queue Entered!");
            } else if (queue == 1 && i != queue1Size) {
                boolean Added = false;
                for (int element = 0; element < 2; element++) {
                    if (Queue1[element] == null) {
                        Queue1[element] = firstName;
                        System.out.println(firstName + " has been added to Queue 1 Successfully");
                        Added = true;
                        break;
                    }
                }
                if (Added) {
                    i--;
                    original_i = i;
                } else {
                    waitingQue.add(firstName);
                    System.out.println("Queue 1 is FULL! customer added to the waiting list.");
                }

            } else if (queue == 2 && j != queue2Size) {
                boolean customerAdded = false;
                for (int element = 0; element < 3; element++) {
                    if (Queue2[element] == null) {
                        Queue2[element] = firstName;
                        System.out.println(firstName + " has been added to Queue 2 Successfully");
                        customerAdded = true;
                        break;
                    }
                }
                if (customerAdded) {
                    j--;
                    original_j = j;
                } else {
                    waitingQue.add(firstName);
                    System.out.println("Queue 2 is FULL! customer added to the waiting list.");
                }

            } else if (queue == 3 && k != queue3Size) {
                boolean customerAdded = false;
                for (int element = 0; element < 5; element++) {
                    if (Queue3[element] == null) {
                        Queue3[element] = firstName;
                        System.out.println(firstName + " has been added to Queue 3 Successfully");
                        customerAdded = true;
                        break;
                    }
                }
                if (customerAdded) {
                    k--;
                    original_k = k;
                } else {
                    waitingQue.add(firstName);
                    System.out.println("Queue 3 is FULL! customer added to the waiting list.");
                }
            } else {
                System.out.println("Selected Queue is FULL!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer");
            input.next();
        }
        customerDetails.add(customer);

    }

    // Method to view all queues
    private static void viewAllQueues() { //This shows all the queues
        cashierPattern();
        if (Queue1[0] == null) {
            System.out.print(" X \t");
        } else {
            System.out.print(" 0 \t");
        }
        if (Queue2[0] == null) {
            System.out.print("\t  X");
        } else {
            System.out.print("\t  0");
        }
        if (Queue3[0] == null) {
            System.out.print("\t       X ");
        } else {
            System.out.print("\t       0 ");
        }
        System.out.println("");
        if (Queue1[1] == null) {
            System.out.print(" X \t");
        } else {
            System.out.print(" 0 \t");
        }
        if (Queue2[1] == null) {
            System.out.print("\t  X");
        } else {
            System.out.print("\t  0");
        }
        if (Queue3[1] == null) {
            System.out.print("\t       X ");
        } else {
            System.out.print("\t       0 ");
        }
        System.out.println("");

        if (Queue2[2] == null) {
            System.out.print("\t\t  X");
        } else {
            System.out.print("\t\t  O");
        }
        if (Queue3[2] == null) {
            System.out.print("\t\t   X");
        } else {
            System.out.print("\t\t   0");
        }
        System.out.println("");

        if (Queue3[3] == null) {
            System.out.print("\t\t\t\t   X");
        } else {
            System.out.print("\t\t\t\t   0");
        }
        System.out.println("");

        if (Queue3[4] == null) {
            System.out.print("\t\t\t\t   X");
        } else {
            System.out.print("\t\t\t\t   0");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("X - Not Occupied  0 - Occupied");
        i = original_i;
        j = original_j;
        k = original_k;

    }

    // Method to remove a customer from a queue
    private static void removeCustomer(Scanner input) {
        String name=null;
        try {
            System.out.println("Enter Customer Name :");
            name = input.next();
            System.out.println("Enter Which Queue :");
            int queueOption = input.nextInt();
            foundCustomer = false;
            if (queueOption < 1 || queueOption > 3) {
                System.out.println("Invalid Queue Entered!");
            } else if (queueOption == 1) {
                for (i = 0; i < 2; i++) {
                    if (Queue1[i] != null && Queue1[i].equals(name)) {
                        Queue1[i] = null;
                        foundCustomer = true;
                        System.out.println("Customer " + name + " Has been Removed");
                        queue1Size += 1;
                        break;
                    }
                }
            } else if (queueOption == 2) {
                for (j = 0; j < 3; j++) {
                    if (Queue2[j] != null && Queue2[j].equals(name)) {
                        System.out.println("Customer " + name + " Has been Removed");
                        Queue2[j] = null;
                        foundCustomer = true;
                        queue2Size += 1;
                        break;
                    }
                }
            } else if (queueOption == 3) {
                for (k = 0; k < 5; k++) {
                    if (Queue3[k] != null && Queue3[k].equals(name)) {
                        System.out.println("Customer " + name + " Has been Removed");
                        Queue3[k] = null;
                        queue3Size += 1;
                        foundCustomer = true;
                        break;
                    }
                }
            }
            if (foundCustomer) {
                // Shifting customers
                if (queueOption == 1) {
                    for (int element = i; element < 1; element++) {
                        Queue1[element] = Queue1[element + 1];
                    }
                    Queue1[1]=null;
                    Queue1[1]=waitingQue.get(0);
                    waitingQue.remove(0);
                    //Queue1[1] = null; // Set the last element to null
                } else if (queueOption == 2) {
                    for (int element = j; element < 2; element++) {
                        Queue2[element] = Queue2[element + 1];
                    }
                    Queue2[2]=null;
                    Queue2[2]=waitingQue.get(0);
                    waitingQue.remove(0);
                } else if (queueOption == 3) {
                    for (int element = k; element < 4; element++) {
                        Queue3[element] = Queue3[element + 1];
                    }
                    Queue3[4] = null; // Set the last element to null
                    Queue3[4]=waitingQue.get(0);
                    waitingQue.remove(0);
                }
            } else {
                System.out.println("Customer not found in the queue.");
                i = original_i;
                j = original_j;
                k = original_k;
            }

        }catch(InputMismatchException e){
            System.out.println("Pls Enter an Integer");
            input.next();
        }
        for (Customer c:customerDetails){
            if (name== c.getFirstName()){
                customerDetails.remove(c);
            }
        }

    }

    // Method to print empty queues
    private static void printEmptyQueues() {
        cashierPattern();
        if (Queue1[0] == null) {
            System.out.print(" X \t");
        } else {
            System.out.print("   \t");
        }
        if (Queue2[0] == null) {
            System.out.print("\t  X");
        } else {
            System.out.print("\t   ");
        }
        if (Queue3[0] == null) {
            System.out.print("\t       X ");
        } else {
            System.out.print("\t         ");
        }
        System.out.println("");
        if (Queue1[1] == null) {
            System.out.print(" X \t");
        } else {
            System.out.print("   \t");
        }
        if (Queue2[1] == null) {
            System.out.print("\t  X");
        } else {
            System.out.print("\t   ");
        }
        if (Queue3[1] == null) {
            System.out.print("\t       X ");
        } else {
            System.out.print("\t         ");
        }
        System.out.println("");

        if (Queue2[2] == null) {
            System.out.print("\t\t  X");
        } else {
            System.out.print("\t\t   ");
        }
        if (Queue3[2] == null) {
            System.out.print("\t\t   X");
        } else {
            System.out.print("\t\t    ");
        }
        System.out.println("");

        if (Queue3[3] == null) {
            System.out.print("\t\t\t\t   X");
        } else {
            System.out.print("\t\t\t\t    ");
        }
        System.out.println("");

        if (Queue3[4] == null) {
            System.out.print("\t\t\t\t   X");
        } else {
            System.out.print("\t\t\t\t    ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("X - Not Occupied  0 - Occupied");
        i = original_i;
        j = original_j;
        k = original_k;
    }

    // Method to remove served customers from queues
    private static void removeServedCustomers(Scanner input) {
        String nameToServe=null;
        try {
            if (remainingStock == 0) {
                System.out.println("--- Burger Stock is over !---- ");
            } else {
                System.out.println("Enter Queue Number");
                foundCustomer = false;
                int queueNum = input.nextInt();
                if (queueNum < 1 || queueNum > 3) {
                    System.out.println("Invalid Queue Entered");

                } else if (queueNum == 1) {
                    if (Queue1[0] != null && !Queue1[0].equals("remove")) {
                        System.out.println("Customer has been served");
                        nameToServe=Queue1[0];
                        Queue1[0] = "remove";
                        foundCustomer = true;
                        queue1Size++;
                        System.out.println(burgerStocks(true));
                    }
                } else if (queueNum == 2) {
                    if (Queue2[0] != null && !Queue2[0].equals("remove")) {
                        System.out.println("Customer has been served");
                        nameToServe=Queue2[0];
                        Queue2[0] = "remove";
                        foundCustomer = true;
                        System.out.println(burgerStocks(true));
                        queue2Size++;
                    }
                } else if (queueNum == 3) {
                    if (Queue3[0] != null && !Queue3[0].equals("remove")) {
                        System.out.println("Customer has been served");
                        nameToServe=Queue3[0];
                        Queue3[0] = "remove";
                        foundCustomer = true;
                        queue3Size++;
                        System.out.println(burgerStocks(true));
                    }
                }
                if (remainingStock < 10) {
                    System.out.println("\nStock is Lower than 10 !!!");
                }
                if (foundCustomer) {
                    // Shifting customers
                    if (queueNum == 1) {
                        for (int element = 0; element < Queue1.length - 1; element++) {
                            Queue1[element] = Queue1[element + 1];
                        }
                        Queue1[Queue1.length - 1] = null;
                        Queue1[1]=waitingQue.get(0);
                        waitingQue.remove(0);
                    } else if (queueNum == 2) {
                        for (int element = 0; element < Queue2.length - 1; element++) {
                            Queue2[element] = Queue2[element + 1];
                        }
                        Queue2[Queue2.length - 1] = null;
                        Queue2[1]=waitingQue.get(0);
                        waitingQue.remove(0);
                    } else if (queueNum == 3) {
                        for (int element = 0; element < Queue3.length - 1; element++) {
                            Queue3[element] = Queue3[element + 1];
                        }
                        Queue3[Queue3.length - 1] = null;
                        Queue3[1]=waitingQue.get(0);
                        waitingQue.remove(0);
                    }
                } else {
                    System.out.println("Customer not found in the queue.");
                    i = original_i;
                    j = original_j;
                    k = original_k;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter an integer");
            input.next();
        }
        for (Customer c: customerDetails){
            if (Objects.equals(nameToServe, c.getFirstName())){
                remainingStock-=c.getNoOfBurgerCount();
            }
        }
    }

    // Method to sort customer names in alphabetical order
    private static void SortCustomerNames() {
        String[] CustomerNames = new String[10];
        int element = 0;
        String tempVar;
        for (String Customer : Queue1) {
            if (Customer != null) {
                CustomerNames[element] = Customer;
                element++;
            }
        }
        for (String Customer : Queue2) {
            if (Customer != null) {
                CustomerNames[element] = Customer;
                element++;
            }
        }
        for (String Customer : Queue3) {
            if (Customer != null) {
                CustomerNames[element] = Customer;
                element++;
            }
        }
        for (int i = 0; i < CustomerNames.length - 1; i++) {
            for (int j = 0; j < CustomerNames.length - i - 1; j++) {
                if (CustomerNames[j] != null && CustomerNames[j + 1] != null && CustomerNames[j].compareToIgnoreCase(CustomerNames[j + 1]) > 0) {
                    tempVar = CustomerNames[j];
                    CustomerNames[j] = CustomerNames[j + 1];
                    CustomerNames[j + 1] = tempVar;
                }
            }
        }
        System.out.println("Customers Sorted In Alphabetical Order: ");
        for (String name : CustomerNames) {
            if (name != null) {
                System.out.println(name + "  ");
            }
        }
    }

    // Method to store program data into a file
    private static void storedata() {
        int element = 0;
        for (String Customer : Queue1) {
            QueueData[element] = Customer;
            element++;
        }
        for (String Customer : Queue2) {
            QueueData[element] = Customer;
            element++;
        }
        for (String Customer : Queue3) {
            QueueData[element] = Customer;
            element++;
        }
        try {
            FileWriter Storedata = new FileWriter("storedata.txt");
            for (int index = 0; index < 10; index++) {
                Storedata.write(QueueData[index] + "\n");
            }
            Storedata.close();
            System.out.println("File Saved Successfully");
        } catch (IOException e) {
            System.out.println("An Error Occurred when writing" + e.getMessage());

        }
    }

    // Method to load program data from a file
    private static void loadData() {
        try {
            int index=0;
            File rf = new File("storedata.txt");
            Scanner input = new Scanner(rf);
            while (input.hasNextLine()) {
                QueueData [index] = input.nextLine();
                index++;
            }
            input.close();
            System.out.println("Stored Queue Data Loaded : "+ Arrays.toString(QueueData));
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred when reading the file: " + e.getMessage());
        }
    }

    // Method to add burgers to the stock
    private static void AddStocks(Scanner input){
        try{System.out.println("Enter the amount of Stocks to be Added : ");
            int stocks = input.nextInt();
            if(stocks<0 || stocks+remainingStock>50){
                System.out.println("Given Stock cannot be added ");
            }else{
                System.out.println("Stock has been Added Successfully ");
                remainingStock+=stocks;
            }
        }catch(Exception e){
            System.out.println("Please enter an Integer ");
            input.next();
        }
    }
    private static void displayQueueValue() {
        System.out.println("Income of each queue");
        System.out.println("--------------------");
        System.out.println("Income of queue 1 : Rs."+countValue(Queue1));
        System.out.println("Income of queue 2 : Rs."+countValue(Queue2));
        System.out.println("Income of queue 3 : Rs."+countValue(Queue3));
    }
    private static int countValue(String[] array){
        int total=0;
        int burgerCount=0;
        for (String value : array) {
            for (Customer c:customerDetails){
                if (c.getFirstName().equals(value)){
                    burgerCount=c.getNoOfBurgerCount();
                }
            }
            if (value != null) {
                total+=650*burgerCount;
            }
        }
        return total;
    }
    private static void launchFoodFaveApplication() {
        FoodFaveApplication.launch(FoodFaveApplication.class);
    }
}
