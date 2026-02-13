import java.io.*;
import java.util.*;

public class FileUtil {
    private static final String FILE_NAME = "students.txt";

    public static List<Student> readStudents() {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Student s = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3])
                );
                list.add(s);
            }
        } catch (IOException e) {
            // file may not exist first time
        }
        return list;
    }

    public static void writeStudents(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}
