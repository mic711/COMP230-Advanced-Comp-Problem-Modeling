import java.util.ArrayList;
import java.util.*;
import java.io.*;
   
public class PhoneDirectory implements java.io.Serializable { //that Serializable used for loading and reading objects 
  
  //arraylist used to store a phone directory (theDirectory) with names and numbers
  private ArrayList<DirectoryEntry> theDirectory;
  
  public PhoneDirectory() {
    this.theDirectory = new ArrayList<DirectoryEntry>();
  }
  
  public ArrayList<DirectoryEntry> getDirectory() {
    return this.theDirectory;
  }
  
  public void setDirectory(ArrayList<DirectoryEntry> dir){
    this.theDirectory = dir;
  }
  
  public String addOrChangeEntry(String name, String number) {
    DirectoryEntry entry = this.searchEntry(name);
  
    if (entry != null) {
      String pastNumber = entry.getNumber();
      entry.setNumber(number);
      System.out.println("Update successfull");
    }
    else {
      theDirectory.add(new DirectoryEntry(name, number));
      System.out.println("Insert successfull");
    }
    
    return null;
  }
      
  public DirectoryEntry searchEntry(String name) {
    int index = theDirectory.indexOf(new DirectoryEntry(name, ""));
    
    if (index != -1) {
      return theDirectory.get(index);
    }
    else {
      return null;
    }
  }
  
  public DirectoryEntry removeEntry(String name) {
    DirectoryEntry entry = searchEntry(name);
    if (entry != null) {
      theDirectory.remove(entry);
      return entry;
    }
    return null;
  }
  
  public void displayAllEntries() {
    if (theDirectory.size() != 0) {
      System.out.println("The entries in the Directory are:");
      for (DirectoryEntry dir : this.theDirectory) {
        System.out.println(dir.toString());
      }
    }
    else {
      System.out.println("Phonebook is currently empty!");
    }
  }
  
  public static PhoneDirectory load(String filename){
    PhoneDirectory curDir = null;
    try {
      FileInputStream in = new FileInputStream(filename);
      ObjectInputStream oj = new ObjectInputStream(in);
      curDir = (PhoneDirectory) oj.readObject();
      oj.close();
      in.close();
    }
    catch (ClassNotFoundException ex1) {
      System.out.println("Class not found");
      System.err.println(ex1);
    }
    catch (IOException ex2) {
      System.out.println("File not found");
      System.err.println(ex2);
    }
    return curDir;
  }
  
  public static void write(String filename, PhoneDirectory dir) {
    try {
      FileOutputStream out = new FileOutputStream(filename);
      ObjectOutputStream oj = new ObjectOutputStream(out);
      oj.writeObject(dir);
      oj.close();
      out.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("Error opening the file");
      System.exit(0);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
