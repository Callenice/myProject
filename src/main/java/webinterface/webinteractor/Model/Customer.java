package webinterface.webinteractor.Model;

public class Customer {
    private final long PNO;
    private String firstName;
    private String lastName;

    public Customer(long PNO, String firstName, String lastName) {
        this.PNO = PNO;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getPersonalNumber() {
        return PNO;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "personalNumber=" + PNO +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
