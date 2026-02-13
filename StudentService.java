import java.util.*;

public class StudentService {
    private List<Student> students;

    public StudentService() {
        students = FileUtil.readStudents();
    }

    public void addStudent(Student s) {
        students.add(s);
        FileUtil.writeStudents(students);
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Student s : students) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge() + " | " + s.getMarks() + " | Grade: " + s.calculateGrade());
        }
    }

    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        FileUtil.writeStudents(students);
    }

    public void updateStudent(int id, String name, int age, double marks) {
    for (Student s : students) {
        if (s.getId() == id) {
            s.setName(name);
            s.setAge(age);
            s.setMarks(marks);
            FileUtil.writeStudents(students);
            System.out.println("Student updated successfully");
            return;
        }
    }
    System.out.println("Student not found");
}

}
