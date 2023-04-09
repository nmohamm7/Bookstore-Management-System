public class RegularMember extends BookStore {

    private String name;
    private String email;
    private double moneySpent;

    public RegularMember() {

    }
    
    public RegularMember(String name, String email, double moneySpent) {
        this.name = name;
        this.email = email;
        this.moneySpent = moneySpent;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoneySpent() {
        return this.moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

    // iterate through member arraylist and find user inputted name
    public RegularMember findRegMember(String name) {
        RegularMember foundRegMember = regularMembers.get(0);
        for (RegularMember regularMember : regularMembers) {
            if (regularMember.getName().equals(name)) {
                foundRegMember = regularMember;
            }
        }
        return foundRegMember;
    }

    //method to check if user's name exists in member array list
    public static boolean regMemberFound(String name) {
        for (RegularMember member : regularMembers) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Member Profile:" + "\n" + "Name: " + name + "\n" + "Email: " + email + "\n" + "Total Money Spent: " + moneySpent;
    }
}
