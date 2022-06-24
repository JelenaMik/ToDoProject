import controller.MyList;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JOptionPane.showMessageDialog(null, "Welcome to ToDo application!");

        MyList mylist = new MyList();

        mylist.transferDataFromFile();

        String userInput = "";
        do {
            System.out.println("Please choose an activity: ");
            System.out.println("""
                    1. Add ToDo
                    2. View All ToDos
                    3. View pending ToDos
                    4. Mark ToDo as done
                    5. Delete ToDo
                    6. Sort ToDos by due date
                    7. Write all ToDo to file
                    8. Read ToDos from file
                    9. Erase file content
                    """);
            userInput = scanner.nextLine();

            switch(userInput){
                case "quit":
                    System.out.println("Exiting Aplication!");;
                    break;
                case "1":
                    System.out.println("Add new ToDo");
                    mylist.addToDo();
                    break;
                case "2":
                    System.out.println("View All ToDos");
                    mylist.seeToDos();
                    break;
                case "3":
                    System.out.println("View pending ToDos");
                    mylist.pendingItems();
                    break;
                case "4":
                    System.out.println("Mark ToDo as done");
                    mylist.markCompleted();
                    break;

                case "5":
                    System.out.println("Delete ToDo");
                    mylist.removeToDo();
                    break;
                case "6":
                    System.out.println("ToDos sorted by due day");
                    mylist.sortByDays();
                    break;
                case "7":
                    mylist.copyToDosToFile();
                    JOptionPane.showMessageDialog(null, "ToDos was successfully copied to file!");
                    break;
                case "8":
                    System.out.println("ToDoes from file: ");
                    mylist.readFile();
                    break;
                case "9":
                    mylist.eraseFileContent();
                    break;
            }

        }while(!userInput.equalsIgnoreCase("quit"));

    }

}
