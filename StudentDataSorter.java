//Programmer: John Bedlington
//Date: 3/16/2023
//Class: CS &145
//Assignment #3
//(Based on chp 13 programing challenge) This program will sort given student data into sorted lists
//based on last name student ID, and grade percentage using comparators. The program can take any # of students in a
// .txt file named student_data.txt.
//Took around 4 hrs as I had to teach myself how to use comparators to complete the program.

import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[])
    {
        FileReader inFile;
        Scanner in;

        //variables to store student data
        String lastName;
        String firstName;
        String ID;
        float per;
        char grade;

        //student list
        ArrayList<Student> list = new ArrayList<Student>();

        //to store individual lines of the file
        String line;

        try
        {
            //opening file to read
            inFile = new FileReader("student_data.txt");
            in = new Scanner(inFile);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            return;
        }

        //Reading data from the file line by line
        while( in.hasNext() )
        {
            //reading line
            line = in.nextLine();

            //different parts of student data
            String parts[] = line.split(" ");

            lastName = parts[0];
            firstName = parts[1];
            ID = parts[2];
            per = Float.parseFloat(parts[3]);
            grade = parts[4].charAt(0);

            //adding the student to the list
            list.add(new Student(lastName, firstName, ID, per, grade));
        }

        //sorting by last name
        Collections.sort(list, new SortByLastName());

        System.out.println("List sorted by last name in ascending order : ");
        System.out.println("\n");

        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i) + "\n");

            //reversing the list to sort in descending order
            Collections.reverse(list);
        }

        System.out.println("\nList sorted by last name in descending order : ");
        System.out.println("\n");

        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i) + "\n");
        }

        //sorting by student ID
        Collections.sort(list, new SortByID());

        System.out.println("List sorted by student ID in ascending order : ");

        System.out.println("\n");
        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i) + "\n");

            //reversing the list to sort in descending order
            Collections.reverse(list);
        }
        System.out.println("\nList sorted by student ID in descending order : ");
        System.out.println("\n");

        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i) + "\n");
        }
        //sorting by grade
        Collections.sort(list, new SortByGrade());

        System.out.println("List sorted by grade in ascending order : ");
        System.out.println("\n");

        for (int i=0; i < list.size(); i++) {

            System.out.println(list.get(i) + "\n");
        }
        //reversing the list to sort in descending order
        Collections.reverse(list);

        System.out.println("\nList sorted by grade in descending order : ");
        System.out.println("\n");

        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i) + "\n");
        }

    }
}//end of main class

//class to store student data
class Student
{
    //instance variables for the data
    String lastName;
    String firstName;
    String ID;
    float percentage;
    char grade;

    //the constructor
    public Student(String lname, String fName, String ID, float per, char grade)
    {
        this.lastName = lname;
        this.firstName = fName;
        this.ID = ID;
        this.percentage = per;
        this.grade = grade;
    }

    // function to convert the student data
    // to string for displaying
    public String toString()
    {
        String str = "";

        str += lastName + " " + firstName + " " + ID + " ";
        str += percentage + " " + grade;

        return str;

    }
}//end of student class

// Below are the comparator classes for
// sorting the students data to different columns

class SortByLastName implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // last name
    public int compare(Student a, Student b)
    {
        return a.lastName.compareTo(b.lastName);
    }
}

class SortByFirstName implements Comparator<Student>
{
    // Used for sorting in ascending order of first name
    public int compare(Student a, Student b)
    {
        return a.firstName.compareTo(b.firstName);
    }
}

class SortByID implements Comparator<Student>
{
    // Used for sorting in ascending order of ID
    public int compare(Student a, Student b)
    {
        return a.ID.compareTo(b.ID);
    }
}

class SortByPercentage implements Comparator<Student>
{
    // Used for sorting in ascending order of percentage
    public int compare(Student a, Student b)
    {
        if (a.percentage > b.percentage)
            return 1;
        else if (b.percentage > a.percentage)
            return -1;
        else
            return 0;
    }
}

class SortByGrade implements Comparator<Student>
{
    // Used for sorting in ascending order of percentage
    public int compare(Student a, Student b)
    {
        if (a.grade > b.grade)
            return 1;
        else if (b.grade > a.grade)
            return -1;
        else
            return 0;
    }
}



