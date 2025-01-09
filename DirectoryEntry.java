import java.io.*;
import java.util.*;

public class DirectoryEntry implements Serializable {
  String name;
  String number;
  
  //default constructor
  public DirectoryEntry() {
    name="";
    number ="";
  }
  
  //non-default constructor
  public DirectoryEntry(String name, String number) {
    this.name = name;
    this.number = number;
  }
  
  public String getNumber() {
    return number;
  }
  
  public void setNumber(String number) {
    this.number = number;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public boolean equals(Object obj) {
    DirectoryEntry other = (DirectoryEntry) obj;
    if (name.equalsIgnoreCase(other.name)) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public String toString() {
    return name + ":" + number;
  }
}
