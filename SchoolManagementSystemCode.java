package com.java.sms;

/**
 * This class is responsible for keeping the
 * track of students fees, name ,grade & fees
 * paid.
 *
 */

public class Student {

    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * To create a new student by initializing.
     * Fees for every student is $30,000.
     * Fees paid initially is 0.
     * @param id id for the student: unique.
     * @param name name of the student.
     * @param grade grade of the student.
     */
    public Student(int id, String name,int grade){
        this.feesPaid=0;
        this.feesTotal=30000;
        this.id=id;
        this.name=name;
        this.grade=grade;

    }

    //Not going to alter student's name, student's id.


    /**
     * Used to update the student's grade.
     * @param grade new grade of the student.
     */
    public void setGrade(int grade){
        this.grade=grade;
    }


    /**
     * Keep adding the fees to feesPaid Field.
     * Add the fees to the fees paid.
     * The school is going receive the funds.
     *
     * @param fees the fees that the student pays.
     */
    public void payFees(int fees){
        feesPaid+=fees;
        School.updateTotalMoneyEarned(feesPaid);
    }

    /**
     *
     * @return id of the student.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the grade of the student.
     */
    public int getGrade() {
        return grade;
    }

    /**
     *
     * @return fees paid by the student.
     */
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     *
     * @return the total fees of the student.
     */
    public int getFeesTotal() {
        return feesTotal;
    }

    /**
     *
     * @return the remaining fees.
     */
    public int getRemainingFees(){
        return feesTotal-feesPaid;
    }

    @Override
    public String toString() {
        return "Student's name :"+name+
                " Total fees paid so far $"+ feesPaid;
    }
}
package com.java.sms;

/**
 * This class is responsible for keeping the track
 * of teacher's name, id, salary.
 */
public class Teacher {

    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    /**
     * Creates a new Teacher object.
     * @param id id for the teacher.
     * @param name name of the teacher.
     * @param salary salary of the teacher.
     */
    public Teacher(int id, String name, int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.salaryEarned=0;
    }

    /**
     *
     * @return the id of the teacher.
     */
    public int getId(){
        return id;
    }

    /**
     *
     * @return name of the teacher.
     */
    public String getName(){
        return name;
    }


    /**
     *
     * @return the salary of the teacher.
     */
    public int getSalary(){
        return  salary;
    }

    /**
     * set the salary.
     * @param salary
     */
    public void setSalary(int salary){
        this.salary=salary;
    }

    /**
     * Adds  to salaryEarned.
     * Removes from the total money earned by the school.
     * @param salary
     */
    public void receiveSalary(int salary){
        salaryEarned+=salary;
        School.updateTotalMoneySpent(salary);
    }


    @Override
    public String toString() {
        return "Name of the Teacher: " + name
                +" Total salary earned so far $"
                + salaryEarned;
    }
}
package com.java.sms;

import java.util.List;

/**
 * Many teachers, many students.
 * Implements teachers and student
 * using an ArrayList.
 */
public class School {

    private List<Teacher> teachers;
    private List<Student> students;
    private static int  totalMoneyEarned;
    private static int totalMoneySpent;

    /**
     * new school object is created.
     * @param teachers list of teachers in the school.
     * @param students list of students int the school.
     */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }

    /**
     *
     * @return the list of teachers int the school.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Adds a teacher to the school.
     * @param teacher the teacher to be added.
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     *
     * @return the list of students in the school.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Adds a student to the school
     * @param student the student to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     *
     * @return the total money earned by the school.
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Adds the total money earned by the school.
     * @param MoneyEarned money that is supposed to be  added.
     */
    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    /**
     *
     * @return the total money spent by the school.
     */
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * update the money that is spent by the school which
     * is the salary given by the school to its teachers.
     * @param moneySpent the money spent by school.
     */
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneyEarned-=moneySpent;
     }
}

package com.java.sms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(1,"teacher1",500);
        Teacher teacher2 = new Teacher(2,"teacher2",700);
        Teacher teacher3 = new Teacher(3,"teacher3",600);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        teacherList.add(teacher3);

        Student student1 = new Student(1,"student1",4);
        Student student2 = new Student(2,"student2",12);
        Student student3 = new Student(3,"student3",5);
        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        School college1 = new School(teacherList,studentList);

        Teacher teacher4 = new Teacher(6,"teacher4", 900);

        college1.addTeacher(teacher4);


        student1.payFees(5000);
        student2.payFees(6000);
        System.out.println("college1 has earned $"+ college1.getTotalMoneyEarned());

        System.out.println("------Making SCHOOL PAY SALARY----");
        teacher1.receiveSalary(teacher1.getSalary());
        System.out.println("college1 has spent for salary to " + teacher1.getName()
        +" and now has $" + college1.getTotalMoneyEarned());

        teacher2.receiveSalary(teacher2.getSalary());
        System.out.println("college1 has spent for salary to " + teacher2.getName()
                +" and now has $" + college1.getTotalMoneyEarned());


        System.out.println(student2);

        teacher3.receiveSalary(teacher3.getSalary());

        System.out.println(teacher3);
    }
}