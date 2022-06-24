
package controller;

import org.apache.commons.lang3.StringUtils;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyList{

    private ArrayList<ToDo> todos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Scanner booleanScanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);


    public void addToDo(){

        ToDo todo = new ToDo();

        todo.description = JOptionPane.showInputDialog("Please input ToDo description!" );
        int a = JOptionPane.showConfirmDialog(null,"Is ToDo done?" +
                JOptionPane.YES_OPTION);
        if(a==0){
            todo.isDone = true;
        } else {todo.isDone= false;}
        System.out.println("Enter number of days when ToDo must be done!");
        todo.daysToFinish = Integer.parseInt(JOptionPane.showInputDialog("Number of days to finish this ToDo"));
        this.todos.add(todo);

    }

    public void removeToDo(){

        ToDo toDoToRemove= (ToDo) JOptionPane.showInputDialog(
                   null,
                   "Select ToDo to remove",
                    "Select ToDo",
                   JOptionPane.QUESTION_MESSAGE,
                    null,
                    this.todos.toArray(),
                    this.todos.toArray()[0]
           );
        this.todos.remove(toDoToRemove);
        System.out.println("ToDo was successfully removed!" );

    }

    public void markCompleted(){
        ToDo toDoToMark= (ToDo) JOptionPane.showInputDialog(
                null,
                "Select ToDo to mark as completed",
                "Completed ToDo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                this.todos.toArray(),
                this.todos.toArray()[0]
        );
        if(toDoToMark.getDone()!=true){
            toDoToMark.setDone(true);
            JOptionPane.showMessageDialog(null,"ToDo was successfully marked as completed!" );
        }else JOptionPane.showMessageDialog(null, "ToDo has already completed!");


    }

    public void pendingItems(){
        for (ToDo todo: todos){
            if(todo.getDone()==false){
                System.out.println(todo);
            }
        }
    }

    public void seeToDos(){
        for (ToDo todo: todos){
            System.out.println(todo);
        }
    }

    public void sortByDays(){
        Collections.sort(todos,Comparator.comparing(ToDo::getDaysToFinish));
        seeToDos();

    }

    public void createFile() {
        try {
            File myObj = new File("toDoList.txt");
            myObj.createNewFile();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void copyToDosToFile(){
        try {
            FileWriter myWriter = new FileWriter("toDoList.txt");
            for (ToDo todo: todos){
                myWriter.write(String.valueOf(todo));
                myWriter.write(String.valueOf("\n"));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void eraseFileContent(){
        try {
            FileWriter myWriter = new FileWriter("toDoList.txt");
           myWriter.write("");
            myWriter.close();
            JOptionPane.showMessageDialog(null, "File content was successfully erased!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFile(){
        try {
            File myObj = new File("toDoList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void transferDataFromFile(){
        createFile();
        try {
            File myObj = new File("toDoList.txt");
            Scanner myReader = new Scanner(myObj);
            int i=0;
            while (myReader.hasNextLine()) {

                String str = myReader.nextLine();
                if(str.equals(null)){
                    break;
                }else{
                    i++;
                    String done = String.valueOf(StringUtils.substringBetween(str, "isDone=", ","));
                    Boolean isDone = Boolean.parseBoolean(done);
                    String description = String.valueOf(StringUtils.substringBetween(str, "tion='", "'," ));
                    String day = String.valueOf(StringUtils.substringBetween(str, "nish='", "'"));
                    Integer dueDay = Integer.parseInt(day);

                    ToDo todo = new ToDo(description, isDone, dueDay);
                    this.todos.add(todo);

                }

            }
            JOptionPane.showMessageDialog(null, i + " ToDo was added from file!");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
