import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class StudentManagement implements Management {

    @Override
    public void displayStudents(List<Student> students, Consumer<Student> con) {
        students.forEach(con);
    }

    @Override
    public void displayStudentsByFilter(List<Student> students, Predicate<Student> pre, Consumer<Student> con) {
        students.stream().filter(pre).forEach(con);
    }

    @Override
    public String returnStudentsNames(List<Student> students, Function<Student, String> fun) {
        StringBuilder names = new StringBuilder();
        for (Student  student : students) {
            names.append(fun.apply(student)).append(", ");
        }
        return names.toString();
    }

   @Override
    public Student createStudent(Supplier<Student> sup) {
        return sup.get();
    }

    @Override
    public List<Student> sortStudentsById(List<Student> students, Comparator<Student> com) {
        List<Student> sortedStudents = new ArrayList<Student>(students);
        sortedStudents.sort(com);
        return sortedStudents;
    }
    
    @Override
    public Stream<Student> convertToStream(List<Student> students) {
        return students.stream();
    }


}
