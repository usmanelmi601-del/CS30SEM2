package Mastery;

public class Customer {

    // Fields
    private String firstName;
    private String lastName;

    /**
     * Constructor
     * Initializes customer with first and last name
     */
    public Customer(String fName, String lName) {
        this.firstName = fName.trim();
        this.lastName = lName.trim();
    }

    /**
     * Get first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    /**
     * Set last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    /**
     * Returns full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * String representation of Customer
     */
    @Override
    public String toString() {
        return getFullName();
    }
}