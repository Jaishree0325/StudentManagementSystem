import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();
                    service.addStudent(new Student(id, name, age, marks));
                    System.out.println("Student added");
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    Student s = service.searchById(sid);
                    System.out.println(s != null ? s : "Not found");
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    service.deleteStudent(sc.nextInt());
                    System.out.println("Deleted");
                    break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("New Age: ");
                    int uage = sc.nextInt();
                    System.out.print("New Marks: ");
                    double umarks = sc.nextDouble();
                    service.updateStudent(uid, uname, uage, umarks);
                    break;

                case 6:
                    System.exit(0);

            }
        }
    }
}
