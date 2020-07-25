class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName != null ? firstName : "";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName != null ? lastName : "";
    }

    public String getFullName() {
        String fullName;
        fullName = !(firstName + lastName).equals("") ? firstName + " " + lastName : "Unknown";
        return fullName; // write your code here
    }
}