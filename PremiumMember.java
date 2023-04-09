public class PremiumMember extends RegularMember {

    private boolean isPaid;
    private String paymentMethod;
    private double membershipCost = 19.99;

    public PremiumMember() {
        
    }

    public PremiumMember(String name, String email, double moneySpent, boolean isPaid, String paymentMethod) {
        super(name, email, moneySpent);
        this.isPaid = isPaid;
        this.paymentMethod = paymentMethod;
    }

    public boolean isIsPaid() {
        return this.isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getMembershipCost() {
        return this.membershipCost;
    }

    // iterate through member arraylist and find user inputted name
    public static PremiumMember findPremMember(String name) {
        PremiumMember foundPremMember = premiumMembers.get(0);
        for (PremiumMember premiumMember : premiumMembers) {
            if (premiumMember.getName().equals(name)) {
                foundPremMember = premiumMember;
            }
        }
        return foundPremMember;
    }

    //method to check if user's name exists in member array list
    public static boolean premMemberFound(String name) {
        for (PremiumMember premiumMember : premiumMembers) {
            if (premiumMember.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
