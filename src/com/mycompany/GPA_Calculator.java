import java.util.Scanner;
public class Main {
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //asking the user for number of courses this semester
        System.out.print("Enter number of courses this semester: ");
        int n = sc.nextInt();
        sc.nextLine();
        //initiliazing variables we will use in calculating gpa
        String grade;
        String Coursename;
        String[] courses = new String[n];
        double[] grades = new double[n];
        int[] hours = new int[n];
        int credit;
        double gradepoint = 0.0;
        double totalpoint = 0.0;
        double totalcredit = 0.0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter course number " + (i + 1) + " name: ");
            Coursename = sc.nextLine();
            courses[i] = Coursename;
            //asking for the grade letter and checking if input is valid
            while (true) {
                System.out.print("Enter grade letter of the course named " + Coursename + " :");
                 grade = sc.nextLine().toUpperCase().trim();
            if (grade.matches("^[ABCD][+-]?$|^F$")) {
                break;
            } else{
                System.out.println("Invalid grade, please try again");
            }
            }
            //asking for credit hours of the course and checking if input is valid
            while (true) {
                System.out.print("Enter credit hours of the course: ");
                credit = sc.nextInt();
                sc.nextLine();
                if (credit < 0) {
                    System.out.println("Invalid credit hours, please try again");
                }
                else {
                    break;
                }
            }
            //turning grade letter into points
            if(grade.equals("A+")){
               gradepoint = 4.0;
            }
            else if(grade.equals("A")){
                gradepoint = 4.0;
            }
            else if(grade.equals("A-")){
                gradepoint = 3.7;
            }
            else if(grade.equals("B+")){
                gradepoint = 3.3;
            }
            else if(grade.equals("B")){
                gradepoint = 3.0;
            }
            else if(grade.equals("B-")){
                gradepoint = 2.7;
            }
            else if(grade.equals("C+")){
                gradepoint = 2.3;
            }
            else if(grade.equals("C")){
                gradepoint = 2.0;
            }
            else if(grade.equals("C-")){
                gradepoint = 1.7;
            }
            else if(grade.equals("D+")){
                gradepoint = 1.3;
            }
            else if(grade.equals("D")){
                gradepoint = 1.0;
            }
            else if(grade.equals("D-")){
                gradepoint = 0.7;
            }
            else if (grade.equals("F")){
                gradepoint = 0.0;
            }
            grades[i] = gradepoint;
            hours[i] = credit;
            totalpoint += (gradepoint*credit);
            totalcredit += credit;
            }
        //report about whole semester
        System.out.println("Report about semester :" );
        for (int i = 0; i < n; i++) {
        System.out.println(courses[i] + " " + grades[i] + " " + hours[i] );

        }
        //calculating GPA after getting totalpoint and totalcredit hours
        double GPA = totalpoint / totalcredit;
        System.out.println("Total number of hours you took this semester: " + totalcredit);
        System.out.println("Your GPA equals = " + GPA);
        if (GPA >=3.0) {
            System.out.println("You are an excellent student" );
        } else if (GPA >= 2.0) {
            System.out.println("Good student" );
        } else if (GPA < 2.0) {
            System.out.println("Work and study hard " );
        }
        sc.close();
        }

    }

