import java.util.*;
public class Solution{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int studentId, sub1, sub2, sub3;
    String studentName;
    Student[] student = new Student[4];
    for(int i=0;i<student.length;i++) {
      studentId = s.nextInt();s.nextLine();
      studentName = s.nextLine();
      sub1 = s.nextInt();
      sub2 = s.nextInt();
      sub3 = s.nextInt();
      student[i] = new Student(studentId, studentName, sub1, sub2, sub3);
    }
    s.close();
    int passedStudents = findPassedStudentCount(student);
    Student stu = getTopStudent(student);
    
    if(passedStudents == 0)
      System.out.println("No Students Passed");
    else
      System.out.println(passedStudents);
    
    if(stu == null)
      System.out.println("No one has passed");
    else
      System.out.println(stu.getStudentId()+"#"+stu.getStudentName());
  }
  public static int findPassedStudentCount(Student[] students) {
    int count = 0;
    for(int i=0;i<students.length;i++) {
      if(students[i].getSub1() >= 60 && students[i].getSub2() >= 60 && students[i].getSub3()>=60)
        count++;
    }
    return count;
  }
  public static Student getTopStudent(Student[] students) {
    int count = 0;
    for(int i=0;i<students.length;i++) {
      if(students[i].getSub1() >= 60 && students[i].getSub2() >= 60 && students[i].getSub3()>=60)
        count++;
    }
    if(count == 0) return null;
    Student[] s = new Student[count];
    count = 0;
    for(int i=0;i<students.length;i++) {
      if(students[i].getSub1() >= 60 && students[i].getSub2() >= 60 && students[i].getSub3()>=60)
        s[count++] = students[i];
    }
    int sum = s[0].getSub1()+s[0].getSub2()+s[0].getSub3();
    for(int i=1;i<s.length;i++) {
      if(s[i].getSub1()+s[i].getSub2()+s[i].getSub3() >= sum)
        sum = s[i].getSub1()+s[i].getSub2()+s[i].getSub3();
    }
    for(int i=0;i<s.length;i++) {
      if(sum == s[i].getSub1()+s[i].getSub2()+s[i].getSub3())
        return s[i];
    }
    return null;
  }
}
class Student{
  int studentId, sub1, sub2, sub3;
  String studentName;
  Student(int studentId, String studentName, int sub1, int sub2, int sub3){
    this.studentId = studentId;
    this.studentName = studentName;
    this.sub1 = sub1;
    this.sub2 = sub2;
    this.sub3 = sub3;
  }
  int getStudentId() {
    return studentId;
  }
  String getStudentName() {
    return studentName;
  }
  int getSub1() {
    return sub1;
  }
  int getSub2() {
    return sub2;
  }
  int getSub3() {
    return sub3;
  }
}
