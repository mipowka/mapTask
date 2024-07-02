package mapTask;

import java.util.*;


public class MapTask2 {
    public static void main(String[] args) {
        // Создайте Map, содержащую информацию о количестве студентов, обучающихся в каждом курсе на факультете.
        Map<Integer,Integer> studentsGrade = new HashMap<>();

        Student st1 = new Student(1,4,"Oleg");
        Student st2 = new Student(1,2,"Nikita");
        Student st3 = new Student(4,3,"Sofia");
        Student st4 = new Student(4,5,"Natasha");
        Student st5 = new Student(3,4,"Ivan");

        //создаем лист студентов
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(st1);
        listOfStudents.add(st2);
        listOfStudents.add(st3);
        listOfStudents.add(st4);
        listOfStudents.add(st5);

        //добавляем курс на котором учатся студенты в наш map
        for (Student student : listOfStudents) {
            studentsGrade.put(student.course,studentsGrade.getOrDefault(student.course,0)+1);
        }

        System.out.println(studentsGrade);

        //_________________________________________________________
        Map<Student,Integer> mapOfStudentsGrades = new HashMap<>();

        mapOfStudentsGrades.put(st1,st1.grade);
        mapOfStudentsGrades.put(st2,st2.grade);
        mapOfStudentsGrades.put(st3,st3.grade);
        mapOfStudentsGrades.put(st4,st4.grade);
        mapOfStudentsGrades.put(st5,st5.grade);

        System.out.println(gradeMore4(mapOfStudentsGrades));//метод с оценками выше 4
    }
    //Напишите метод, который принимает на вход Map с оценками студентов и возвращает список студентов, у которых средний балл выше 4.
    public static List<Student> gradeMore4(Map<Student, Integer> studentsMap){

        Set<Map.Entry<Student,Integer>> entrySet = studentsMap.entrySet();

        List<Student> listOfStudentsWithGrade4Plus = new ArrayList<>();

        for (Map.Entry<Student, Integer> student : entrySet) {
            if (student.getValue() >= 4){
                listOfStudentsWithGrade4Plus.add(student.getKey());
            }
        }

        return listOfStudentsWithGrade4Plus;
    }
}

class Student{
    String name;
    int course;
    int grade;

    public Student(int course, int grade, String name) {
        this.course = course;
        this.grade = grade;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + course +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}' + '\n';
    }
}
