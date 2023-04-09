import java.util.*;

public class BookStore {

    public static ArrayList<RegularMember> regularMembers = new ArrayList<>();
    public static ArrayList<PremiumMember> premiumMembers = new ArrayList<>();
    public static ArrayList<Product> shoppingCart = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        //creating instance of inventory to access the inventory and member arrays
        Inventory inventory = new Inventory();
        ArrayList<Product> Inventory = inventory.getInventory();
        RegularMember rm = new RegularMember();
        PremiumMember pm = new PremiumMember();

        Scanner scnr = new Scanner(System.in);

        System.out.println("////////////////////////////////////////////////");
        System.out.println("           WELCOME TO NAV'S BOOKSTORE");
        System.out.println("////////////////////////////////////////////////");
        Thread.sleep(500);

        //menu options for bookstore system
        boolean exit = false;
        while (!exit) {
            System.out.println("Please select from one of the following options:");
            Thread.sleep(250);
            System.out.println("\t 1. Register as a Member");
            Thread.sleep(250);
            System.out.println("\t 2. View Member Profile");
            Thread.sleep(250);
            System.out.println("\t 3. View Products");
            Thread.sleep(250);
            System.out.println("\t 4. Restock Product");
            Thread.sleep(250);
            System.out.println("\t 5. Get Inventory Total Value");
            Thread.sleep(250);
            System.out.println("\t 6. Make a Purchase");
            Thread.sleep(250);
            System.out.println("\t 7. Exit");

            int choice = scnr.nextInt();
            System.out.println();

            switch (choice) {
                case 1: //Register as a Member
                    System.out.println("We provide 2 membership options for our customers. Our regular membership is free and our premium is $19.99 per month.");
                    Thread.sleep(250);
                    System.out.println("Would you like to register as a regular or premium member?");
                    Thread.sleep(250);
                    System.out.println("For a regular membership, please enter 1.");
                    Thread.sleep(250);
                    System.out.println("For a premium membership, enter 2");
                    
                    int rOrP = scnr.nextInt();
                    if (rOrP == 1) {
                        System.out.print("\nWhat is your name? ");
                        scnr.nextLine();
                        String name = scnr.nextLine();
                        Thread.sleep(250);
                        if (RegularMember.regMemberFound(name)) { //checks if name input is already in member arraylist
                            System.out.println("\nLooks like you are already a member.\n");
                            break;
                        }
                        System.out.print("\nWhat is the email you would like to register with? ");
                        String email = scnr.nextLine();
                        rm = new RegularMember(name, email, 0.00); // creates new regular member object and adds it to arraylist
                        regularMembers.add(regularMembers.size(), rm);
                        Thread.sleep(250);
                        System.out.println("\nCongratulations " + name + "! You are now a Regular member.\n");
                        Thread.sleep(250);
                    } else if (rOrP == 2) {
                        System.out.print("\nWhat is your name? ");
                        scnr.nextLine();
                        String premName = scnr.nextLine();
                        Thread.sleep(250);
                        System.out.print("\nWhat is the email you would like to register with? ");
                        String premEmail = scnr.nextLine();
                        Thread.sleep(250);
                        System.out.print("\nWhat payment method would you like to use for this membership: debit or credit? ");
                        String paymentMethod = "credit";
                        paymentMethod = scnr.nextLine();
                        Thread.sleep(250);
                        System.out.print("\nYou have until the end of each month to pay the monthly fee. Would you like to pay now? Y or N? ");
                        char prem = scnr.nextLine().charAt(0);
                        boolean payNow = false;
                        if (prem == 'Y' || prem == 'y') {
                            payNow = true;
                        } else if (prem == 'N' || prem == 'n') {
                            payNow = false;
                        } else {
                            System.out.println("Invalid Input");
                        }
                        pm = new PremiumMember(premName, premEmail, 0.00, payNow, paymentMethod); //creates new premium member object and adds it to arraylist
                        premiumMembers.add(premiumMembers.size(), pm);
                        System.out.println("\nCongratulations " + premName + " ! You are now a premium member.\n");
                        Thread.sleep(250);
                    } else {
                        System.out.println("Invalid Input\n");
                    }
                    break;
                case 2: //View Member Profile
                    System.out.print("What is the name of the member profile you would like to view? ");
                    scnr.nextLine();
                    String name;
                    name = scnr.nextLine();
                    System.out.print("\nAre you a regular or premium member. Enter 1 for regular and 2 for premium. ");
                    int option = scnr.nextInt();
                    System.out.println();
                    RegularMember regularMember = new RegularMember();
                    if (option == 1) {
                        if (RegularMember.regMemberFound(name)) { //searches for regular member name in regular member arraylist
                            System.out.println(regularMember.findRegMember(name));
                        } else {
                            System.out.println("Looks like you are not currently a member.\n");
                            break;
                        }
                    } else if (option == 2) {
                        if (PremiumMember.premMemberFound(name)) { //searches for premium member name in premium member arraylist
                            System.out.println(PremiumMember.findPremMember(name));
                        } else {
                            System.out.println("Looks like you are not currently a member.\n");
                            break;
                        }
                    } else {
                        System.out.println("Invalid Input");
                    }
                    System.out.println();
                    break;
                case 3: //View Products

                    //counts how many unique product objects are in the inventory arraylist
                    int bookCount = 0;
                    int cdCount = 0;
                    int dvdCount = 0;
                    for (Product product : Inventory) {
                        if (product instanceof Book) {
                            bookCount++;
                        }
                        if (product instanceof CD) {
                            cdCount++;
                        }
                        if (product instanceof DVD) {
                            dvdCount++;
                        }
                    }
                    System.out.println("Here at Naveed's Bookstore we offer a variety of products for purchase");
                    Thread.sleep(250);
                    System.out.println("There are " + bookCount + " books in the inventory");
                    Thread.sleep(250);
                    System.out.println("There are " + cdCount + " CDs in the inventory");
                    Thread.sleep(250);
                    System.out.println("There are " + dvdCount + " DVDs in the inventory");
                    Thread.sleep(250);
                    System.out.println();
                    System.out.println("Please select from one of the following options:");
                    Thread.sleep(250);
                    System.out.println("\t 1. View Book Inventory");
                    Thread.sleep(250);
                    System.out.println("\t 2. View CD Inventory");
                    Thread.sleep(250);
                    System.out.println("\t 3. View DVD Inventory");
                    Thread.sleep(250);
                    System.out.println("\t 4. View All Product Inventory");
                    Thread.sleep(250);
                    System.out.println("\t 5. Sort Products by Price");

                    int input = scnr.nextInt();

                    switch (input) {
                        case 1: //View Book Inventory
                            System.out.println();
                            for (Product product : Inventory) { //iterates through product inventory arraylist and prints all objects that are of type Book
                                if (product instanceof Book) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            break;
                        case 2: //View CD Inventory
                            System.out.println();
                            for (Product product : Inventory) { //iterates through product inventory arraylist and prints all objects that are of type CD
                                if (product instanceof CD) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            break;
                        case 3: //View DVD Inventory
                            System.out.println();
                            for (Product product : Inventory) { //iterates through product inventory arraylist and prints all objects that are of type DVD
                                if (product instanceof DVD) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            System.out.println();
                            break;
                        case 4: //View All Product Inventory
                            System.out.println("\n----------Books----------\n");
                            for (Product product : Inventory) { //Prints all objects of type Book in inventory arraylist
                                if (product instanceof Book) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            System.out.println("\n----------CDs----------\n");
                            for (Product product : Inventory) { //Prints all objects of type CD in inventory arraylist
                                if (product instanceof CD) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            System.out.println("\n----------DVDs----------\n");
                            for (Product product : Inventory) { ////Prints all objects of type DVD in inventory arraylist
                                if (product instanceof DVD) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            System.out.println();
                            break;
                        case 5: //Sort Products by Price
                            Collections.sort(Inventory);//Sorts all objects in product inventory arraylist based on price
                            System.out.println("Products sorted by price:");
                            for (Product product : Inventory) { //Print sorted list of products
                                System.out.println(product);
                                Thread.sleep(250);
                                System.out.println();
                            }
                            System.out.println();
                            break;
                        default:
                            System.out.println("Invalid Input\n");
                            break;
                    }
                    break;
                case 4: //Restock Product
                    for (Product product : Inventory) { //Prints products in inventory arraylist with product id
                        System.out.println((product.getId() / 2) + ". " + product);
                        Thread.sleep(250);
                        System.out.println();
                    }
                    System.out.print("Enter the product ID to restock: ");
                    int id = (scnr.nextInt() * 2);
                    System.out.print("\nEnter the amount to restock: ");
                    int amount = scnr.nextInt();
                    inventory.restockProduct(id, amount); //adds amount entered to product inventory
                    System.out.println("\nProduct restocked successfully!\n");
                    break;
                case 5: //Get Inventory Total Value

                    // prints total value of inventory monetarily formatted to the hundredth place
                    System.out.println("The total value of all the products that offer here at Nav's Bookstore is " + String.format("$%.2f", inventory.inventoryValue()) + "\n");
                    Thread.sleep(250);
                    break;
                case 6: //Make a Purchase
                    System.out.println("Thank you for shopping at Nav's Bookstore!");
                    Thread.sleep(250);
                    System.out.print("\nWould you like to buy a book? Y or N? ");
                    String buyBookStr = scnr.next();
                    char buyBook = buyBookStr.charAt(0);
                    if (buyBook == 'Y' || buyBook == 'y') {
                        boolean wantBook = true;
                        while (wantBook) {
                            System.out.println("\nHere are the books available for purchase:\n");
                            Thread.sleep(250);
                            for (Product product : Inventory) { //Prints books in product inventory arraylist
                                if (product instanceof Book) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            System.out.print("Which book would you like to buy? ");
                            scnr.nextLine();
                            String whichBooks = scnr.nextLine(); //user input for book they wished to purchase
                            Thread.sleep(250);
                            System.out.print("\nWould you like to purchase a paperback or hardcover version of this book? Enter 1 for paperback and 2 for hardcover. ");
                            int bookType = scnr.nextInt();

                            for (Product product : Inventory) {
                                if (product instanceof Book && whichBooks.equals(product.getName())) {
                                    Book book = (Book) product;
                                    if (bookType == 2) { //if user wanted a hardcover book, increase the price by $4.00
                                        book.setPrice(book.getPrice() + 4.00);
                                    }
                                    shoppingCart.add(product); //add book to shopping cart arraylist
                                }
                            }
                            Thread.sleep(250);
                            System.out.print("\nWould you like to purchase another book? Y or N? ");
                            String moreBooksStr = scnr.next();
                            char moreBooks = moreBooksStr.charAt(0);
                            if (moreBooks == 'Y' || moreBooks == 'y') {
                                wantBook = true;
                            } else if (moreBooks == 'N' || moreBooks == 'n') {
                                wantBook = false;
                            }
                            else {
                                System.out.println("Invalid Input");
                            }
                        }
                    }
                    Thread.sleep(250);
                    System.out.print("\nWould you like to buy a CD? Y or N? ");
                    String buyCDStr = scnr.next();
                    char buyCD = buyCDStr.charAt(0);
                    if (buyCD == 'Y' || buyCD == 'y') {
                        boolean wantCD = true;
                        while (wantCD) {
                            System.out.println("\nHere are the CDs available for purchase:\n");
                            for (Product product : Inventory) { //prints CDs in product inventory arraylist
                                if (product instanceof CD) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            System.out.print("Which CD would you like to buy? ");
                            scnr.nextLine();
                            String whichCD = scnr.nextLine();
                            for (Product product : Inventory) {
                                if (product instanceof CD && whichCD.equals(product.getName())) {
                                    shoppingCart.add(product); //add to shopping cart arraylist
                                }
                            }
                            Thread.sleep(250);
                            System.out.print("\nWould you like to purchase another CD? Y or N? ");
                            String moreCDsStr = scnr.next();
                            char moreCDs = moreCDsStr.charAt(0);
                            if (moreCDs == 'Y' || moreCDs == 'y') {
                                wantCD = true;
                            } else if (moreCDs == 'N' || moreCDs == 'n') {
                                wantCD = false;
                            }
                            else {
                                System.out.println("Invalid Input");
                            }
                        }
                    }
                    Thread.sleep(250);
                    System.out.print("\nWould you like to buy a DVD? Y or N? ");
                    String buyDVDStr = scnr.next();
                    char buyDVD = buyDVDStr.charAt(0);
                    Thread.sleep(250);
                    if (buyDVD == 'Y' || buyDVD == 'y') {
                        boolean wantDVD = true;
                        while (wantDVD) {
                            System.out.println("\nHere are the DVDs available for purchase:\n");
                            for (Product product : Inventory) { //Print DVDs in product inventory arraylist
                                if (product instanceof DVD) {
                                    System.out.println(product.toString());
                                    Thread.sleep(250);
                                    System.out.println();
                                }
                            }
                            System.out.print("Which DVD would you like to buy? ");
                            scnr.nextLine();
                            String whichDVD = scnr.nextLine();
                            for (Product product : Inventory) {
                                if (product instanceof DVD && whichDVD.equals(product.getName())) {
                                    shoppingCart.add(product); //add to shopping cart arraylist
                                }
                            }
                            Thread.sleep(250);
                            System.out.print("\nWould you like to purchase another DVD? Y or N? ");
                            String moreDVDsStr = scnr.next();
                            char moreDVDs = moreDVDsStr.charAt(0);
                            if (moreDVDs == 'Y' || moreDVDs == 'y') {
                                wantDVD = true;
                            } else if (moreDVDs == 'N' || moreDVDs == 'n') {
                                wantDVD = false;
                            }
                            else {
                                System.out.println("Invalid Input");
                            }
                        }
                    }
                    Thread.sleep(250);
                    double subtotal = 0;
                    for (Product product : shoppingCart) { //iterate through shopping cart and add price of each product to subtotal variable
                        subtotal += product.getPrice();
                    }
                    System.out.println();
                    System.out.print("Are you a member? Y or N? ");
                    String isMemberStr = scnr.next();
                    char isMember = isMemberStr.charAt(0);
                    boolean realMember = false;
                    boolean regMember = false;
                    boolean premMember = false;
                    Thread.sleep(250);
                    if (isMember == 'Y' || isMember == 'y') {
                        System.out.println("\n\nAre you a regular or premium member? Enter 1 for regular or 2 for premium");
                        int rorm = scnr.nextInt();

                        if (rorm == 1) {
                            System.out.println();
                            System.out.println("What is your name?");
                            scnr.nextLine();
                            String purchaseName = scnr.nextLine();
                            for (RegularMember RegularMember : regularMembers) { //searches for regular member name in regular members arraylist
                                if (purchaseName.equals(RegularMember))  {
                                    rm = RegularMember;
                                    break;
                                }
                            }
                            realMember = true;
                            regMember = true;
                        } else if (rorm == 2) {
                            System.out.println();
                            System.out.println("What is your name?");
                            scnr.nextLine();
                            String pmPurchaseName = scnr.nextLine();
                            for (PremiumMember PremiumMember : premiumMembers) { //searches for premium member name in premium members arraylist
                                if (pmPurchaseName.equals(PremiumMember)) {
                                    pm = PremiumMember;
                                    break;
                                }
                            }
                            realMember = true;
                            premMember = true;
                        } else {
                            System.out.println("Invalid Input");
                            System.out.println();
                        }
                    } else if (isMember == 'N' || isMember == 'n') {
                        System.out.print("\nWould you like to become a member? Y or N? ");
                        String wantMemberStr = scnr.next();
                        char wantMember = wantMemberStr.charAt(0);
                        if (wantMember == 'Y' || wantMember == 'y') {
                            System.out.println("We provide 2 membership options for our customers. Our regular membership is free and our premium is $19.99 per month.");
                            Thread.sleep(250);
                            System.out.println("Would you like to register as a regular or premium member?");
                            Thread.sleep(250);
                            System.out.println("For a regular membership, please enter 1.");
                            Thread.sleep(250);
                            System.out.println("For a premium membership, enter 2");
                            int rmOrPm = scnr.nextInt();
                            if (rmOrPm == 1) {
                                System.out.print("What is your name? ");
                                scnr.nextLine();
                                name = scnr.nextLine();
                                if (RegularMember.regMemberFound(name)) { ////searches for regular member name in regular members arraylist
                                    System.out.println("Looks like you are already a member.\n");
                                    System.out.println();
                                    break;
                                }
                                System.out.print("\nWhat is the email you would like to register with? ");
                                String email = scnr.nextLine();
                                rm = new RegularMember(name, email, 0.00); //creates new member object and adds to arraylist
                                regularMembers.add(regularMembers.size(), rm);
                                System.out.println("\nCongratulations " + name + "! You are now a Regular member.");
                                System.out.println();
                                Thread.sleep(250);
                            } else if (rmOrPm == 2) {
                                System.out.println("What is your name?");
                                scnr.nextLine();
                                String premName = scnr.nextLine();
                                System.out.print("What is the email you would like to register with?\n");
                                String premEmail = scnr.nextLine();
                                System.out.print("What payment method would you like to use for this membership: cash, credit, or loyalty points?\n");
                                String paymentMethod = "credit";
                                paymentMethod = scnr.nextLine();
                                System.out.print("You have until the end of each month to pay the monthly fee. Would you like to pay now? Y or N?\n");
                                char prem = scnr.nextLine().charAt(0);
                                boolean payNow = false;
                                if (prem == 'Y' || prem == 'y') {
                                    payNow = true;
                                } else if (prem == 'N' || prem == 'n') {
                                    payNow = false;
                                } else {
                                    System.out.println("Invalid Input");
                                }
                                pm = new PremiumMember(premName, premEmail, 0.00, payNow, paymentMethod); //creates new member object and adds it to arraylist
                                premiumMembers.add(premiumMembers.size(), pm);
                                System.out.println("Congratulations " + premName + " ! You are now a premium member.");
                                System.out.println();
                                Thread.sleep(250);
                            } else {
                                System.out.println("Invalid Input");
                                System.out.println();
                            }
                        } else if (wantMember == 'N' || wantMember == 'n') {
                            System.out.println();
                            Thread.sleep(250);
                            System.out.println("That's okay, let's get you checked out!");
                        }
                    }
                    Thread.sleep(250);
                    double discountRate = 0.0;
                    if (regMember) { //sets discount rate for regular members
                        discountRate = .05;
                    }
                    if (premMember) { //sets discount rate for premium members
                        discountRate = .1;
                    }
                    double discountAmount = subtotal * discountRate; //calculates amount discounted
                    double discountedTotal = subtotal - discountAmount; //calculates price after discount is applied
                    double taxRate = .0475; //sets tax rate
                    double taxAmount = discountedTotal * taxRate; //calculates taxed amount added to subtotal
                    double totalAmount = discountedTotal + taxAmount; //calculates total cost after tax is added
                    if (regMember) { //adds total purchase cost to money spent parameter for regular member
                        rm.setMoneySpent(totalAmount);
                    }
                    if (premMember) { //adds total purchase cost to money spent parameter for premium member
                        pm.setMoneySpent(totalAmount);
                    }
                    System.out.println();
                    Thread.sleep(250);
                    System.out.println("Here is the summary of your cart");
                    System.out.println();
                    Thread.sleep(250);
                    System.out.println("--------------------Order Summary--------------------");
                    Thread.sleep(250);
                    System.out.println();
                    System.out.printf("%-40s%-1s", "Description", "Price"); //formats receipt into columns
                    System.out.println();
                    Thread.sleep(250);
                    for (Product product : shoppingCart) { //iterates through shopping cart and prints each purchased item's name and price formatted into columns
                        if (product instanceof CD) {
                            System.out.printf("%-40s%-1s", product.getName(), String.format("$%.2f", product.getPrice()));
                        }
                        else {
                            System.out.printf("%-39s%-1s", product.getName(), String.format("$%.2f", product.getPrice()));
                        }
                        Thread.sleep(250);
                        System.out.println();
                    }

                    //prints cost of purchase in recipt formatted into columns
                    System.out.println();
                    System.out.printf("%34s%12s", "Subtotal:", String.format("$%.2f", subtotal) + "\n");
                    Thread.sleep(250);
                    System.out.printf("%34s%12s", "Discount:", String.format("$%.2f", discountAmount) + "\n");
                    Thread.sleep(250);
                    System.out.printf("%34s%12s", "Sales Tax:", String.format("$%.2f", taxAmount) + "\n");
                    Thread.sleep(250);
                    System.out.printf("%34s%12s", "Total:", String.format("$%.2f", totalAmount) + "\n");
                    Thread.sleep(250);
                    System.out.println();

                    System.out.print("Would you like to continue with your purchase and checkout? Y or N?");
                    String checkout = scnr.next();
                    char checkOut = checkout.charAt(0);
                    System.out.println();
                    if (checkOut == 'Y' || checkOut == 'y') {
                        System.out.println();
                        System.out.println("Order Confirmed!\nThank you so much for shopping at Nav's Bookstore! " +
                                "\nWe've received your order and will contact you " +
                                "\nas soon as your package is shipped and on its way ");
                    }
                    else if (checkOut == 'N' || checkOut == 'n') {
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println();
                    // update the inventory based on customer purchase
                    inventory.updateInventory();
                    break;
                case 7:
                    System.out.println("Thank you for coming to Nav's Bookstore!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    Thread.sleep(500);
                    break;
            }
        }
    }
}
