package linos;
public class Faculty extends User {
    private String department;

    public Faculty(String id, String name, String email, String password) {
        super(id, name, email, password);
        this.department = "";
    }

    


}
