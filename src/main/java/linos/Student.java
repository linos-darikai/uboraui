public class Student extends User {
    private String yearGroup;

    public Student(String id, String name, String email, String password) {
        super(id, name, email, password);
        this.yearGroup = "";
    }

}
