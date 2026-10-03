import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class POSproj {
    
        ArrayList<ArrayList<MenuItem>> categories = new ArrayList<>();
        ArrayList<MenuItem> friedChickenMenu = new ArrayList<>();
        ArrayList<MenuItem> groupMealsMenu = new ArrayList<>();
        ArrayList<MenuItem> sidesMenu = new ArrayList<>();
        ArrayList<MenuItem> beverageMenu = new ArrayList<>();
        ArrayList<MenuItem> dessertsMenu = new ArrayList<>();
    

    public int a = 1;
    public int b = 1;
    public double totalPrice = 0;
    public Scanner sc = new Scanner(System.in);
    
    public double cash = 0;
     ArrayList<MenuItem> drinks = new ArrayList<>();
    ArrayList<ArrayList<MenuItem>> cart = new ArrayList<>();
    ArrayList<MenuItem> pendingCart = new ArrayList<>();
    ArrayList<Transaction> transHistory = new ArrayList<>();
   
    

    public static void main(String[] args) throws Exception {
        POSproj1 app = new POSproj1();
        app.initializeMenu();
        app.dashBoard();
        
    }
    public void header(){
        System.out.println("==================================================================================");
        System.out.println("|                                                                                |");
        System.out.println("|                                   LUNA DINER                                   |");
        System.out.println("|                WELCOME TO THE BEST FRIED CHICKEN PLACE IN TOWN!                |");
        System.out.println("|                                                                                |");
        System.out.println("==================================================================================");
    }
    

    public void dashBoard(){
        boolean running = true;

        while(running){
            pendingCart.clear();
            header();

            System.out.println("\n=========================================================================================");
            System.out.println("| [1][ FRIED CHICKEN MENU ] [2][ GROUP BUNDLES ] [3][ SIDES MENU ] [4][ DESSERTS MENU ] |");
            System.out.println("| [5][ BEVERAGE MENU ]      [6][ CART ]          [7][ HISTORY ]    [8][ ADMIN PANEL]    |");
            System.out.println("=========================================================================================");

            a = 1;
            startMenu();
        }
        
    }
    public void initializeMenu(){

        categories.add(friedChickenMenu);
        categories.add(groupMealsMenu);
        categories.add(sidesMenu);
        categories.add(dessertsMenu);
        categories.add(beverageMenu);

        drinks.add(new MenuItem("COKE ", 0, 0, false));
        drinks.add(new MenuItem("COKE ZERO", 0, 0, false));
        drinks.add(new MenuItem("ICED TEA", 0, 0, false));
        drinks.add(new MenuItem("PINEAPPLE JUICE", 0, 0, false));
        drinks.add(new MenuItem("COKE FLOAT [ + PHP 15 ]", 15, 0, false));

        friedChickenMenu.add(new MenuItem("1 PC CHICKEN ALA CARTE", 99, 100, false));
        friedChickenMenu.add(new MenuItem("1 PC CHICKEN W/ DRINKS", 119, 100, true, 1));
        friedChickenMenu.add(new MenuItem("1 PC CHICKEN W/ DRINKS AND SIDE", 159, 100, true, 1));
        friedChickenMenu.add(new MenuItem("2 PC CHICKEN ALA CARTE", 199, 100, false));
        friedChickenMenu.add(new MenuItem("2 PC CHICKEN W/ DRINKS", 219, 100, true, 2));
        friedChickenMenu.add(new MenuItem("2 PC CHICKEN W/ DRINKS AND SIDE", 259, 100, true, 2));

        groupMealsMenu.add(new MenuItem("3 PC FIESTA FAMILY BUNDLE", 699, 100, true, 3));
        groupMealsMenu.add(new MenuItem("6 PC FIESTA FAMILY BUNDLE", 899, 100, true, 6));
        groupMealsMenu.add(new MenuItem("8 PC CHICKEN BUCKET", 999, 100, false));
        groupMealsMenu.add(new MenuItem("9 PC FIESTA FAMILY BUNDLE", 1099, 100, true, 9));
        groupMealsMenu.add(new MenuItem("12 PC FIESTA FAMILY BUNDLE", 1399, 100, true, 12));
        groupMealsMenu.add(new MenuItem("15 PC FIESTA FAMILY BUNDLE", 1699, 100, true, 15));
        groupMealsMenu.add(new MenuItem("MEGA PARTY BUCKET 20 PC", 2199, 100, true, 20));

        sidesMenu.add(new MenuItem("3 PC SHANGHAI", 99, 100, false));
        sidesMenu.add(new MenuItem("3 PC LUMPIANG TOGUE", 99, 100, false));
        sidesMenu.add(new MenuItem("EXTRA MOTIVATIONAL RICE", 35, 100, false));
        sidesMenu.add(new MenuItem("SMALL FRIES", 49, 100, false));
        sidesMenu.add(new MenuItem("MEDIUM FRIES", 69, 100, false));
        sidesMenu.add(new MenuItem("LARGE FRIES", 99, 100, false));
        sidesMenu.add(new MenuItem("HALO HALO", 79, 100, false));

        beverageMenu.add(new MenuItem("ICED TEA LARGE", 59, 100, false));
        beverageMenu.add(new MenuItem("COKE ZERO", 49, 100, false));
        beverageMenu.add(new MenuItem("STRAWBERRY MILKSHAKE", 129, 100, false));
        beverageMenu.add(new MenuItem("MANGO MILKSHAKE", 129, 100, false));
        beverageMenu.add(new MenuItem("CHOCO MILKSHAKE", 129, 100, false));
        beverageMenu.add(new MenuItem("LYCHEE FRUIT TEA", 79, 100, false));
        beverageMenu.add(new MenuItem("STRAWBERRY FRUIT TEA", 79, 100, false));

        dessertsMenu.add(new MenuItem("FOUR SEASON SUNDAE", 89, 100, false));
        dessertsMenu.add(new MenuItem("CHOCOLATE SUNDAE", 49, 100, false));
        dessertsMenu.add(new MenuItem("MANGO GRAHAM PARFAIT", 99, 100, false));
        dessertsMenu.add(new MenuItem("PEACH MANGO PIE", 45, 100, false));
        dessertsMenu.add(new MenuItem("DUBAI CHEWY COOKIE", 65, 100, false));
        dessertsMenu.add(new MenuItem("ILOCOS EMPANADA", 110, 100, false));
        dessertsMenu.add(new MenuItem("STRAWBERRY SHORT CAKE", 75, 100, false));

    }
   
        ArrayList<ArrayList<MenuItem>> displayMenu(){
        return categories;
    }
    
    public int category = 0;
    public void startMenu(){
        pendingCart.clear();
        category = category() - 1;

if (category == 5) {
    if(cart.isEmpty()){
        System.out.println(" ___                                                                __    ___ \r\n" + //
                        "|  _|   _____ _____ _____ _____    _____ _____ _____ _____ __ __   |  |  |_  |\r\n" + //
                        "| |    |     |  _  | __  |_   _|  |   __|     |  _  |_   _|  |  |  |  |    | |\r\n" + //
                        "| |    |   --|     |    -| | |    |   __| | | |   __| | | |_   _|  |__|    | |\r\n" + //
                        "| |_   |_____|__|__|__|__| |_|    |_____|_|_|_|__|    |_|   |_|    |__|   _| |\r\n" + //
                        "|___|                                                                    |___|");
                        System.out.println("[ CLICK ANYWHERE TO EXIT ! ]");
                        sc.nextLine();
    }else{
        showCart();
    }
    return;
} else if (category == 6) {
    transHist();
    return;
}else if(category == 7){
    adminPanel();
    return;
} else if (category >= 0 && category < categories.size()) {
} else {
    return;
}

        System.out.println("==========[ MENU ]===============================[ PRICE ]=[ STOCK ]=========");

        ArrayList<MenuItem> selectedCategory = categories.get(category);
        for(POSproj1.MenuItem item : selectedCategory){
            System.out.printf(
                "|  [%d] %-40s - PHP %-7.2f x%-1d LEFT%n",
                a++,
                item.name,
                item.price,
                item.stock
            );
        }
        a = 1;
        System.out.println(
            "|  [" + (selectedCategory.size() + 1) +   "] RETURN TO MENU "
        );

        System.out.println("=============================================================================");
        int itemChoice = itemChoiceIndex(selectedCategory.size()) - 1;
        if(itemChoice == selectedCategory.size()){
            return;
        }
        if(itemChoice < 0 ||  itemChoice >= selectedCategory.size()){
            return;
        }
        MenuItem selectedItem = selectedCategory.get(itemChoice);
        pendingCart.add(selectedItem);
        if(selectedItem.hasDrinks){
            int drinkCount = 0;

            while(drinkCount < selectedItem.drinkQuan){
                System.out.println("=========[ SELECT DRINKS ]==========");
                System.out.println(
                    "===============[" +
                    drinkCount +
                    "/" +
                    selectedItem.drinkQuan +
                    "]================"
                );

                a = 1;

                for(POSproj1.MenuItem drink : drinks){
                    System.out.printf(
                        "[%d] %-40s%n",
                        a++,
                        drink.name
                    );
                }
                System.out.println("[" + (drinks.size() + 1) + "] RETURN TO MENU");
                int selectedDrink = drinkChoice() - 1;
                int returnDrink = drinks.size();
                if(selectedDrink >= 0 && selectedDrink < drinks.size()){
                    MenuItem drinkOrder = drinks.get(selectedDrink);
                    pendingCart.add(drinkOrder);
                    drinkCount++;
                }else if(selectedDrink == returnDrink){
                    pendingCart.clear();
                    return;
                }else{
                    System.out.println("! ENTER VALID NUMBER !");
                    sc.nextLine();
                }
            }
        }
        ArrayList<MenuItem> orderCart = new ArrayList<>(pendingCart);
        cart.add(orderCart);
        header();
        totalPrice = 0;
        for (MenuItem item : pendingCart){
            item.stock--;
        }
        for(ArrayList<MenuItem> order : cart){
            for(MenuItem cartItem : order){
                totalPrice+= cartItem.price;
            }
        }
        
                    showCart();
                    
       
    }
    public void adminPanel(){
        System.out.println("====[ ENTER ADMIN PIN ]=====");
        int pin = 0;
        try {
            pin = sc.nextInt();
        } catch (InputMismatchException e) {
        }
        System.out.println(pin);
    }
    
    public void showCart(){
        int d = 1;
        System.out.println("==[   ITEM NAME  ]====================[ PRICE ]====");
         for(ArrayList<MenuItem> order : cart){
            for(MenuItem cartItem : order){
            if(cartItem.price == 0){
            System.out.printf(" -   %s%n",cartItem.name);
                }else{
                        System.out.printf("[%d] %-35s - PHP %.2f%n",
                        d++,cartItem.name,cartItem.price);
                        }
                }
                    }
                    System.out.println("======================================[ TOTAL ]====");
            System.out.println("                                      PHP - "+ totalPrice);
            System.out.println("===================================================");
            System.out.println("[1][PURCHASE] [2][ADD MORE ITEM] [3][VOID ITEM] [4][CANCEL]");
            int purchaseConfirm = 0;
             try {
            purchaseConfirm = sc.nextInt();
            
        } catch (InputMismatchException e) {
        }
        switch (purchaseConfirm) {
            case 1 :
                checkCash();
                break;
            case 2 :
                break;
            case 3:
                voidMethod();
                break;
            case 4: 
            cancel();
            
            break;
        }

    }
    public void cancel(){
        
        for (ArrayList<MenuItem> cancelItem : cart) {
            for (MenuItem cancelItem1 : cancelItem) {
                cancelItem1.stock++;
                
            }
            
        }
        cart.clear();
    }
    public void voidMethod(){
    System.out.println("[ SELECT ITEM TO VOID ! ]\n[" + (cart.size() + 1) + "][ RETURN TO MENU ]");
    int voidItemIndex = voidItem()-1;

    
    if (voidItemIndex>= 0 && voidItemIndex < cart.size()){
        ArrayList<MenuItem> voidItemName = cart.get(voidItemIndex);
    for(MenuItem voidedItem : voidItemName){
        voidedItem.stock++;
        totalPrice-= voidedItem.price;
    }
        cart.remove(voidItemIndex);
        System.out.println(" [ ITEM REMOVED ! ]");
    }
    else {
        System.out.println("[ RETURNING TO MENU.. ]");
    }
}
    public void checkCash(){
        int c = 1;
        System.out.println("==========[ CHECK OUT ]==========");
        for(ArrayList<MenuItem> order : cart){
            for(MenuItem cartItem : order){
            if(cartItem.price == 0){
            System.out.printf(" -   %s%n",cartItem.name);
                }else{
                        System.out.printf("[%d] %-35s - PHP %.2f%n",
                        c++,cartItem.name,cartItem.price);
                        }
                }
                    }
        System.out.println("==============================[ TOTAL ] : PHP " + totalPrice + " =====");
        System.out.println("[ ENTER AMOUNT : ]");
        System.out.println("[1][ RETURN TO MENU ]");
        cash = change();
        if(cash>=totalPrice){
            System.out.println("==============================[ THANKYOU FOR YOUR PURCHASE ]====================================");
            System.out.println("  ___ _   _ ___  ___ _  _   _   ___ ___   ___ _   _  ___ ___ ___ ___ ___ ___ _   _ _      _ \r\n" + //
                                " | _ \\ | | | _ \\/ __| || | /_\\ / __| __| / __| | | |/ __/ __| __/ __/ __| __| | | | |    | |\r\n" + //
                                " |  _/ |_| |   / (__| __ |/ _ \\\\__ \\ _|  \\__ \\ |_| | (_| (__| _|\\__ \\__ \\ _|| |_| | |__  |_|\r\n" + //
                                " |_|  \\___/|_|_\\\\___|_||_/_/ \\_\\___/___| |___/\\___/ \\___\\___|___|___/___/_|  \\___/|____| (_)\r\n" + //
                                "                                                                                            ");
        transHistory.add(new Transaction(cart, cash));
        cart.clear();
        
        }else{
            System.out.println("==============================[ ERROR MESSAGE: 404 ]====================================");
            System.out.println("  ___ _  _ ___ _   _ ___ ___ ___ ___ ___ ___ _  _ _____   ___ _   _ _  _ ___  ___   _ \r\n" + //
                                " |_ _| \\| / __| | | | __| __|_ _/ __|_ _| __| \\| |_   _| | __| | | | \\| |   \\/ __| | |\r\n" + //
                                "  | || .` \\__ \\ |_| | _|| _| | | (__ | || _|| .` | | |   | _|| |_| | .` | |) \\__ \\ |_|\r\n" + //
                                " |___|_|\\_|___/\\___/|_| |_| |___\\___|___|___|_|\\_| |_|   |_|  \\___/|_|\\_|___/|___/ (_)\r\n" + //
                                "                                                                                      ");
                                System.out.println("[ CLICK ANY KEY TO EXIT ! ]");
                                sc.nextLine();
                                sc.nextLine();
        }
        
    }
public void transHist() {
    if (transHistory.isEmpty()) {
        System.out.println("\n[ NO TRANSACTION HISTORY AVAILABLE ]\n");
        System.out.println("[ PRESS ENTER TO RETURN ]");
        sc.nextLine();
        return;
    }
    int transActCounter = 1;
    for (Transaction trans : transHistory) {
        double transPrice = 0;

        System.out.printf("==============[ ORDER #%d ]===========%n", transActCounter++);

        for (ArrayList<MenuItem> orderGroup : trans.orders) {
            for (MenuItem item : orderGroup) {
                if (item.price == 0) {
                    System.out.printf("  - %-30s%n", item.name);
                } else {
                    System.out.printf("%-30s - PHP %.2f%n", item.name, item.price);
                    transPrice += item.price;
                }
            }
        }

        System.out.println("===[ SUMMARY ]=========================");
        System.out.printf("TOTAL: PHP %.2f%n", transPrice);
        System.out.printf("CASH:  PHP %.2f%n", trans.cashPaid);
        System.out.printf("CHANGE:  PHP %.2f%n%n", trans.cashPaid-transPrice);
    }

    System.out.println("[ PRESS ENTER TO RETURN TO MAIN MENU ]");
    sc.nextLine();
}
    public double change(){
        double cashIn = 0;
        try {
            cashIn = sc.nextInt();
        } catch (InputMismatchException e) {
        }
        return cashIn;

    }
    public int voidItem(){
        int voidItemIndex = 0;
        try{
            voidItemIndex = sc.nextInt();
        }catch(InputMismatchException e){
            return cart.size()+1;
        }
        return voidItemIndex;

    }
  
    public int drinkChoice(){
        int drinkIndex = 0;

        try{
            drinkIndex = sc.nextInt();
        }catch(InputMismatchException e){
            sc.next();
            return -1;
        }

        if(drinkIndex >= 1 && drinkIndex <= drinks.size() + 1){
            return drinkIndex;
        }else{
            return -1;
        }
    }

  public int category(){
    int catSize = displayMenu().size();
    int categoryIndex = 0;

    while(true){
        try{
            categoryIndex = sc.nextInt();
            sc.nextLine();

            if(categoryIndex >= 1 && categoryIndex <= catSize+3){
                return categoryIndex;
            }else{
                System.out.println("! ENTER VALID NUMBER !");
            }

        }catch(InputMismatchException e){
            sc.next();
            System.out.println("! ENTER VALID NUMBER !");
        }
    }
}
    public int itemChoiceIndex(int menuSize){
        int itemIndex = 0;
        try{
            itemIndex = sc.nextInt();
        }catch(InputMismatchException e){
            sc.next();
            return 0;
        }

        if(itemIndex >= 1 && itemIndex <= menuSize + 1){
            return itemIndex;
        }else{
            return 0;
        }
    }

    class MenuItem {
        String name;
        double price;
        int stock;
        boolean hasDrinks;
        int drinkQuan;
        boolean available = true;

        MenuItem(
            String name,
            double price,
            int stock,
            boolean hasDrinks,
            int drinkQuan
        ){
            this.name = name;
            this.price = price;
            this.stock = stock;
            this.hasDrinks = hasDrinks;
            this.drinkQuan = drinkQuan;
            this.available = true;
        }

        MenuItem(
            String name,
            double price,
            int stock,
            boolean hasDrinks
        ){
            this.name = name;
            this.price = price;
            this.stock = stock;
            this.hasDrinks = hasDrinks;
            this.drinkQuan = 0;
            this.available = true;
        }
    }
    class Transaction {
    ArrayList<ArrayList<MenuItem>> orders;
    double cashPaid;

    Transaction(ArrayList<ArrayList<MenuItem>> orders, double cashPaid) {
        this.orders = new ArrayList<>(orders); 
        this.cashPaid = cashPaid;
    }
}
}
