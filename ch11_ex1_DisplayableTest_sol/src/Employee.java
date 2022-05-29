public class Employee implements DepartmentConstants, Displayable {

    private int department;
    private String firstName;
    private String lastName;

    public Employee(int department, String lastName, String firstName) {
        this.department = department;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    @Override
    public String toString() {
        String text = "";
        text += firstName + " " + lastName;
        String dept = switch (department) {
            case ADMIN -> "Administration";
            case EDITORIAL -> "Editorial";
            case MARKETING -> "Marketing";
            default -> "";
        };
        text += " (" + dept + ")";
        return text;
    }
}