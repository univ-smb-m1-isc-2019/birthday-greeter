public class Employee {

    private String firstName;
    private String lastName;
    private String email;
    private String birthday;

    public Employee(String firstName,String lastName , String email , String birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    public String getFirstName() {return this.firstName;}
    public String getLastName() {return this.lastName;}
    public String getEmail() {return this.email;}
    public String getBirthday() {return this.birthday;}
}
