/*
* A program that maintains a list of names and phone numbers or a phone directory of our friends. Main goal of this project is to utilize java’s array list class to complete our task of building a phone directory.  
* Names: Jared Flejter, Mickie Enad
* Last modified: 4/12/2021
*/
import java.io.*;
import java.util.*;

public class proj4 {
  public static void main(String[] args) {
    boolean run = false;
    Scanner input = new Scanner(System.in);
    PhoneDirectory phoneBook = null;
    
    System.out.println("Here is your phonebook");
    System.out.println("Are you editing a new phonebook or an exisiting one?");
    System.out.println("Enter 1 for new and 2 for exisiting");
    
    String start = input.nextLine();
    
    if((start.charAt(0)) == '2') {
      System.out.println("Enter file to load");
      String filename = input.nextLine();
      phoneBook = PhoneDirectory.load(filename);
      run = true;
    } 
    else if ((start.charAt(0)) == '1') {
      phoneBook = new PhoneDirectory();
      run = true;
    } 
    else {
      System.out.println("Please enter a valid choice (1 or 2)");
    }
    
    while(run) {
      System.out.println("Here are options for your phone directory");
      System.out.println();
      System.out.println("1. Load a previously saved phone directory from file");
      System.out.println("2. Add or change an entry");
      System.out.println("3. Remove an entry");
      System.out.println("4. Search for an entry");
      System.out.println("5. Display all entries");
      System.out.println("6. Save the current phone directory to a file");
      System.out.println("7. Quit the program");
      System.out.println();
      
      String choice = input.nextLine();
      
      switch(choice) {
        case "1":
          phoneBook = null;
          System.out.println("Please enter name of previously saved directory: ");
          String filename = input.nextLine();
          phoneBook = PhoneDirectory.load(filename);
          break;
        case "2":
          System.out.println("Enter name: ");
          String name = input.nextLine();
          System.out.println("Enter number: ");
          String number = input.nextLine();
          phoneBook.addOrChangeEntry(name, number);
          break;
        case "3":
          System.out.println("Enter wanted name to remove: ");
          String nameRemove = input.nextLine();
          phoneBook.removeEntry(nameRemove);
          break;
        case "4":
          System.out.println("Enter wanted name: ");
          String nameSearch = input.nextLine();
          System.out.println(phoneBook.searchEntry(nameSearch).getNumber());
          break;
        case "5":
          phoneBook.displayAllEntries();
          break;
        case "6":
          System.out.println("Please enter name of file you want to save phone directory too: ");
          String filename2 = input.nextLine();
          PhoneDirectory.write(filename2, phoneBook);
          break;
        case "7":
          run = false;
          System.out.println("Goodbye");
          break;
        default:
          System.out.println("Invalid Option");
      }
    }
  }
}
