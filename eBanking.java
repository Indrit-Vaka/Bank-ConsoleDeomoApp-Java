import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class eBanking extends BankAccount {

    public static eBanking[] accounts = new eBanking[100];
    static int count = 0;
    private String name;
    private String IBN;
    public static boolean allAccountCreated;
    List<Transations> transations = new ArrayList<>();

    public eBanking(String name) {
        balance = 0;
        this.name = name;
        PIN = generateRanodmPIN();
        addCommonDetalis();
    }
    

  
    public eBanking(String name, String pin, double balance) {
        Depozit(balance);
        this.name = name;
        PIN = pin;
        addCommonDetalis();
        if(allAccountCreated){
            welcome();
            hr();
        }
    }

    void addCommonDetalis() {
        accounts[count] = this;
        IBN = this.toString();
        numberOfAccounts++;
        count++;
    }
    private void welcome() {
        System.out.printf("Hello %s Welcome to eBanking", name);
        hr();
        detalis(); // shfaqin detajet e cdo obj
        menu();
    }

    private void menu() {
        int n;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Ju lutem shtypni "
                    + "\n\t1 qe te shfqni Balancen"
                    + "\n\t2 qe te depozitoni para"
                    + "\n\t3 qe te terhiqni para"
                    + "\n\t4 qe te ndryshoni PIN-in"
                    + "\n\t5 qe te transferoni para te nje person tjeter"
                    + "\n\t6 qe te shikoni tranziksionet qe keni bere"
                    + "\n\t10 qe te hyni si admin"
                    + "\n\t   cdo nr tjeter qe te mbyllni applikacionin");
            n = sc.nextInt();
            sc.nextLine();//konsumojme rrjeshtin
            hr();
            switch (n) {

                case 1:
                    ShowBalance();
                    break;
                case 2:
                    System.out.println("Ju lutem vendosni vleren qe do depozitoni");
                    Double amount = sc.nextDouble();
                    Depozit(amount);
                    addTransactions(amount, "Depozitim");
                    break;
                case 3:
                    System.out.println("Ju lutem vendosni vleren qe do terhiqni");
                    amount = sc.nextDouble();
                    Withdraw(amount);
                    addTransactions(amount, "Terheqje");
                    break;
                case 4:
                    ChangePin();
                    break;
                case 5:
                    System.out.println("Ju lutem vendosni Vleren qe deshironi te transferoni");
                    amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ju lutem vendosni nr e llogarise ku do i transferoni");
                    String accNumber = sc.nextLine();
                    transfer(amount, accNumber);
                    addTransactions(amount, "Transferte Dalese");
                    break;
                case 6:
                    showTransactions();
                    break;
                    case 10:
                    admin();
                    break;
                default:
                    return;
            }
            hr();
        }
    }
    void admin(){
        System.out.println("Shtypni \n\t1 per te pare listen e llogarive te krijuara");
        Scanner sc = new Scanner(System.in);
        
        if(sc.nextInt() == 1){
            hr();
            System.out.println("\nName: \t\tPIN\t\tBalance");
            for (int i = 0; i < accounts.length; i++) {
                try {
                    System.out.printf("%n%s \t\t%s\t\t%f", 
                    accounts[i].name,
                    accounts[i].PIN,
                    accounts[i].balance
                    );
                } catch (Exception e) {
                    //TODO: handle exception
                }
               
            }
        }

    }
    void transfer(double amount, String accNumber) {
        hr();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                System.out.println("Nuk ekziston nje llogari me ate numer");
                return;
            }
            if (accNumber.equals(accounts[i].IBN)) {
                if (Withdraw(amount)) {
                    accounts[i].Depozit(amount);
                    System.out.println("Transferta u krye me sukses");
                }
                return;
            }

        }
        System.out.println("Nuk ekziston nje llogari me ate numer");
        hr();
    }
    void detalis() {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null)
                return;
            System.out.printf("\n%s: \n\tPini juaj eshte: %s \n\tNr i llogarise tuaj eshte: %s\n",
                    accounts[i].name,
                    accounts[i].PIN,
                    accounts[i].IBN);
        }
        hr();
    }

    void showTransactions() {
        if (transations.size() == 0) {
            System.out.println("nuk keni bere transiksione");
            return;
        }
        System.out.println("Data \t\t\tVlera\t\t\tLloji");
        for (var item : transations) {
            System.out.printf("%s \t %f \t\t%s\n",
                    item.dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                    item.amount,
                    item.note);
        }
    }

    void addTransactions(double amount) {
        addTransactions(amount, "----");
    }

    void addTransactions(double amount, String note) {
        var transaction = new Transations();
        transaction.dateTime = LocalDateTime.now();
        transaction.amount = amount;
        transaction.note = note;
        transations.add(transaction);
        SaveTransactrions();
    }

    void SaveTransactrions(){
        for (var tr : transations) {
            FileIV.Append("Transactions.txt", tr.dateTime + " "+ tr.amount+" "+ tr.note );
        }
    }
}

class Transations {
    public LocalDateTime dateTime;
    public double amount;
    public String note;
}
