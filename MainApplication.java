import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
public class MainApplication {
    //validate userInput formats
    static String validate(String message, Scanner scanner,String regex)
    {
        while(true) {
            System.out.print(message);
            String userInput = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            if (pattern.matcher(userInput).matches()) {
                return userInput;
            } else {
                System.out.println("Invalid formats Input");
            }
        }
    }
    //display array 2d
    static void showHall(String[][] arr,char[] alpabet)
    {
        System.out.println("-+".repeat(45));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == null) {
                    System.out.print("|" + alpabet[i] + "-" + (j + 1) + "::" + "AV" + "|   ");
                }else{
                    System.out.print("|" + alpabet[i] + "-" + (j + 1) + "::" + arr[i][j] + "|   ");
                }
            }
            System.out.println();
        }
        System.out.println("-+".repeat(45));
    }
    //for reboot all information about system
    public static void clearArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0 ; j < array[i].length; j++) {
                array[i][j] = null;
            }
        }
    }
    //clear history when user click reboot
    public static void clearArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]=null;
        }
    }
    //return array 2d specific array
    static String[][] mainHall(String[][] hall)
    {
         return hall;
    }
    //history
    static void history(String[] bookingHistory,int n)
    {
        for (int i = 0; i < n; i++) {
            if(bookingHistory[i]==null)
            {
                System.out.println("<<< all array is reboot >>>>");
            }else {
                System.out.println("# User : " + (i + 1));
                System.out.println(bookingHistory[i]);
            }
        }
    }
    static String check(String message)
    {
        if(message.equalsIgnoreCase("a")){
            return "Morning Hall";
        }else if(message.equalsIgnoreCase("b"))
        {
            return "Afternoon Hall";
        }else{
            return "Night";
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("=".repeat(90));
        ClassUI.Welcome();
        System.out.println("=".repeat(90));
        String Row=validate("Please enter number rows for hall=", scanner, "[1-9]+");
        String Col=validate("Please enter number columns for hall=", scanner, "[1-9]+");
        int row=Integer.parseInt(Row);
        int col=Integer.parseInt(Col);
        System.out.println("=".repeat(90));
        System.out.println("<<<< Rows in the Hall is    ="+row+ "  >>>>");
        System.out.println("<<<< Columns in the Hall is ="+col+ "  >>>>");
        System.out.println("=".repeat(90));
        String[][] morning=new String[row][col];
        String[][] afternoon=new String[row][col];
        String[][] night=new String[row][col];
        String[] bookingHistory = new String[100];
        char[] alphabet=new char[26];
        int index=0,n=0;
        int rowIndex = 0,colIndex = 0;
        String[] values;String id = null;
        for(char ch='A';ch<='Z';ch++)
        {
            alphabet[index]=ch;
            index++;
        }
        String op;
        do{
            ClassUI.menu();
            op=validate("Please enter option=",scanner,"[a-zA-Z]");
            switch (op)
            {
                case "A","a"-> {
                    ClassUI.showTime();
                    String message = validate("Please select show time (A |B | C)=", scanner, "[a-cA-C]");
                    System.out.println("-+".repeat(45));
                    String nameHall=check(message);
                    System.out.println("-+".repeat(45));
                    System.out.println(nameHall);
                    //making array 2d for get specific array when user input value
                    String[][] value=switch (message)
                   {
                       case "A","a" -> mainHall(morning);
                       case "B","b" -> mainHall(afternoon);
                       case "C","c" -> mainHall(night);
                       default -> throw new IllegalStateException("Unexpected value: " + message);
                   };
                    //crate array2 to get specific array 2d (morning or afternoon, night)
                    showHall(value,alphabet);
                    //user can input lowercase and uppercase about seat value like A-1,a-2 or single A-1 or a-1
                    ClassUI.role();
                    String option1 =validate("Please enter value: ",scanner,"[A-Za-z]-[1-9](?:\\s*,\\s*[A-Za-z]-[1-9])*");
                    //i need to covert it to uppercase because my expression need only Uppercase
                    String option=option1.toUpperCase();
                    //create it array cus we need to input multiple time
                    values = option.split(",");
                    boolean confirmBooking = false;
                    for (String value1 : values) {
                        String trimmedValue = value1.trim();
                        String[] parts = trimmedValue.split("-");
                        if (parts.length != 2) {
                            System.out.println("Invalid input format: " + trimmedValue);
                            continue;
                        }
                        //validate to get row and columns
                         rowIndex = parts[0].charAt(0) - 'A';
                         colIndex = Integer.parseInt(parts[1]) - 1;
                         //validate if user input seat bigger than size of array if it ture I'll skip this section (protect index out ofBound)
                        if (rowIndex < 0 || rowIndex >= value.length || colIndex < 0 || colIndex >= value[0].length) {
                            System.out.println("-+".repeat(45));
                            System.out.println("Invalid seat selection: " + trimmedValue + ". Please select a valid seat.");
                            System.out.println("-+".repeat(45));
                            continue; // Skip booking this seat and continue with the next one
                        }
                                 if (value[rowIndex][colIndex] == null) {
                                     //check if seat id free or was booking by someone
                                     confirmBooking = true;
                                 } else {
                                     System.out.println("-+".repeat(45));
                                     System.out.println("Seat " + trimmedValue + " is already booked by someone else.");
                                     System.out.println("-+".repeat(45));
                                 }
                        }
                        if (confirmBooking) {
                            String trimmedValue = null;
                            //if it null we need user to input his/her id for our system
                                 System.out.print("Please enter Your id=");
                                 id = scanner.nextLine();
                                 //validate User can input only Yes/No
                                 String info = validate("Please enter <Yes> to confirm booking or <No> to cancel: ", scanner, "^(?:Yes|No)$");
                                 if (info.equalsIgnoreCase("Yes")) {
                                     for (String value1 : values) {
                                         //validate to get row and columns
                                          trimmedValue = value1.trim();
                                         String[] parts = trimmedValue.split("-");
                                         rowIndex = parts[0].charAt(0) - 'A';
                                         colIndex = Integer.parseInt(parts[1]) - 1;
                                         value[rowIndex][colIndex] = "BO";

                                     }
                                     System.out.println("-+".repeat(45));
                                     System.out.println("Seat " + option + " successfully booked.");
                                     System.out.println("-+".repeat(45));
                                 }
                                //create variable fot booking history
                                LocalDate localDate = LocalDate.now();
                                String bookingDetails =nameHall + "   User ID: " + id + ", Time " + localDate + " Seat " + Arrays.toString(values); //text-block
                                bookingHistory[n++] = bookingDetails;//add it to array booking history
                            }
                           //if user called we don't need to add value to array history
                            else {
                                for (String value1 : values) {
                                    String trimmedValue = value1.trim();
                                    System.out.println("-+".repeat(45));
                                    System.out.println("Booking for seat " + trimmedValue + " cancelled.");
                                    System.out.println("-+".repeat(45));
                                }
                            }
                        }
                case "B","b"->{
                    System.out.println("Morning");
                    showHall(morning,alphabet);
                    System.out.println("Afternoon");
                    showHall(afternoon,alphabet);
                    System.out.println("Night");
                    showHall(night,alphabet);
                }
                case "C","c"->ClassUI.showTime();
                case "D","d"->{
                    clearArray(morning);
                    clearArray(afternoon);
                    clearArray(night);
                    clearArray(bookingHistory);
                    System.out.println("-+".repeat(45));
                    System.out.println("<<<< Already reboot >>>>>");
                    System.out.println("-+".repeat(45));
                }
                case "E","e"->{
                    System.out.println("Booking History:");
                    System.out.println("-+".repeat(45));
                    history(bookingHistory,n);
                    System.out.println("-+".repeat(45));
                }
            }
        }while(!op.equalsIgnoreCase("F"));
    }
}