
package mainpkg;

//import user.Person;

import java.util.ArrayList;
import java.util.Scanner;
import user.Employee;
import user.Faculty;
import user.Person;
import user.Staff;
import user.Student;


/**
 *
 * @author USER
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Person p = new Person("Alim","10-11-1986","A+","Male");
//        p.showPersonInfo();
//        p.setPersonInfo();
//        p.showPersonInfo();
//          Employee ahsan;
//        ahsan = new Employee() {};
//        ahsan.showEmpInfo();
//        ahsan.setEmpInfo();
//        ahsan.showEmpInfo();
//        Faculty ahsan;
//        ahsan = new Faculty() {};
//        ahsan.showFacultyInfo();
//        ahsan.setFacultyInfo();
//        ahsan.showFacultyInfo();
//        ahsan.showEmployeeInfo();
          int ch, empCount =0, tempId=0;
          ArrayList<Employee> empList = new ArrayList<Employee>();
          ArrayList<Person> pList = new ArrayList<Person>();
          Scanner s = new Scanner(System.in);
          do {
            System.out.println("Enter [1] to add a Faculty.");
            System.out.println("Enter [2] to search a faculty & show info.");
            System.out.println("Enter [3] to add a Staff.");
            System.out.println("Enter [4] to search a staff & show info.");
            System.out.println("Enter [5] to see total overtime amount of all staffs.");
            System.out.println("Enter [6] to see total no of publications of all faculties.");
            System.out.println("Enter [7] to see all employee info.");
            System.out.println("Enter [8] to add a student.");
            System.out.println("Enter [9] to show a student info.");
            System.out.println("Enter [10] to show an employee info.");
            System.out.println("Enter [11] to show all user's info.");
            System.out.println("Enter [12] to ask a student to calculate cgpa.");
            System.out.println("Enter [13] to ask an eplooyee to send report to supervisor.");
        
            System.out.println("Enter [20] to exit.");
            System.out.print("Enter your choice...");
            ch = s.nextInt();
                switch(ch){
                    case 1:
                        Faculty f = new Faculty();
                        f.setFacultyInfo();
                        empList.add(f);
                        pList.add(f);
                        empCount++;
                        break;
                    case 2:
                        System.out.print("Enter Faculty Id: ");
                        tempId = s.nextInt();
                        for(Employee e: empList){
                            if(tempId==e.geteId()) e.showEmployeeInfo() ;
                        }
                        break;
                    case 3:
                        Staff st = new Staff();
                        st.setStaffInfo();
                        empList.add(st);
                        pList.add(st);
                        empCount++;
                        break;
                    case 4:
                        System.out.print("Enter Staff Id: ");
                        tempId = s.nextInt();
                        for(Employee e: empList){
                            if(tempId==e.geteId()) e.showEmployeeInfo() ;
                        }
                        break;
                    case 5:
                        int totalAmount = 0; Staff stt;
                        for(Employee e: empList){
                            if ( e instanceof Staff){
                                stt = (Staff)e;
                                totalAmount += stt.getOverTimeHour()*stt.getOverTimeRate();
                            }
                        }
                        System.out.println("Total Overtime Amount Of All Staff: "+totalAmount);
                        break;
                    case 6:
                        int totalPublication = 0; Faculty ff;
                        for(Employee e: empList){
                            if ( e instanceof Faculty){
                                ff = (Faculty)e;
                                totalPublication += ff.getPubList().size();
                            }
                        }
                        System.out.println("Total Publication Of All Faculty: "+totalPublication);
                        break;
                    case 7:
                        for(Employee e: empList){
                             e.showEmployeeInfo() ;
                        }
                        System.out.println("Total Emoloyee: "+empCount);
                        break;
                    case 8:
                        Student stud = new Student();
                        stud.setStudentInfo();
                        pList.add(stud);
                        break;
                    case 9:
                        System.out.print("Enter Student Id: ");
                        tempId = s.nextInt();
                        for(Person e: pList){
                            if(tempId==e.getId()) e.showInfo() ;
                        }
                        break;
                    case 10:
                        System.out.print("Enter Employee Id: ");
                        tempId = s.nextInt();
                        for(Person e: pList){
                            if(tempId==e.getId()) e.showInfo() ;
                        }
                        break;
                    case 11:
                        for(Person e: pList){
                             e.showInfo() ;
                        }
                        break;
                    case 12:
                        Student sq;
                        System.out.print("Enter Student Id to Calculate CGPA: ");
                        tempId = s.nextInt();
                        for(Person e: pList){
                            if(tempId==e.getId()) {
                                if(e instanceof Student){
                                    sq = (Student)e;
                                    sq.calcCgpa();
                                }
                                else
                                    System.out.println("Wrong ID Given.!! This Id Belongs To An Employee.");
                            }
                        }
                        break;
                    case 13:
                        Employee em;
                        System.out.print("Enter Employee Id to Send Report: ");
                        tempId = s.nextInt();
                        for(Person e: pList){
                            if(tempId==e.getId()) {
                                if(e instanceof Employee){
                                    em = (Employee)e;
                                    em.sendReportToSupervisor();
                                }
                                else
                                    System.out.println("Wrong ID Given.!! This Id Belongs To An Student.");
                            }
                        }
                        break;
                }
          } while(ch != 20);
    }  
}
