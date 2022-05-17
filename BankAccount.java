import java.util.Scanner;

public abstract class BankAccount {
    protected String PIN;
    protected double balance;
    public static int numberOfAccounts;

    /**
     * Krijon nje logari bankare me pin random dhe balance 0
     */
    public BankAccount() {
        balance = 0;
        PIN = generateRanodmPIN();
        numberOfAccounts++;
    }

    /**
     * Krijon nje llogari bankare
     * 
     * @param balance Balanca fillestare e llogarise
     * @param PIN     Pini i llogarise bankare 4 shifrore
     */
    public BankAccount(double balance, String PIN) {
        Depozit(balance);
        this.PIN = PIN;
        numberOfAccounts++;
    }

    String generateRanodmPIN() {
        String pin = "";
        for (int i = 0; i < 4; i++) {
            int t = (int) (Math.random() * 10);
            pin += Integer.toString(t);
        }
        return pin;
    }

    /**
     * Shfaq balancen ne ekran
     * 
     * @return Rikthen balancen taj
     */
    public double ShowBalance() {
        System.out.println("Balanca juaj eshte: " + balance);
        return balance;
    }

    /**
     * /**
     * Terhiq para
     * 
     * @param amount Vlera e parave qe do terhiqni
     *
     * @return Kthen true kur behet terheqja me sukses
     */
    public boolean Withdraw(double amount) {
        if (amount < 0)
            System.out.println("Nuk mund te terhiqni vlera negative");

        else if (amount > balance)
            System.out.println("Ju nuk keni balance te mjaftueshme \nBalanca juaj eshte " + balance);
        else {
            balance -= amount;
            System.out.println("Balanca juaj tashme eshte: " + balance);
            return true;
        }
        return false;
    }

    /**
     * Depozito para
     * 
     * @param amount Vlera e parave qe do te depozitosh
     */
    public void Depozit(double amount) {
        if (amount <= 0) {
            System.out.println("Nuk mund te depozitoni vlere negative apo 0");
            return;
        }
        balance += amount;
    }

    /**
     * Ndryshon pinin e acc
     */
    public void ChangePin() {
        System.out.println("Ju lutem vendosni Pinin tuaj");
        Scanner sc = new Scanner(System.in);
        String pin = sc.nextLine();

        if (!PIN.equals(pin)) {
            System.out.println("Pin i gabuar");
            return;
        }
        System.out.println("Ju lutem vendosni nje pin 4 Shfrore");
        PIN = sc.nextLine();
    }

    void hr() {
        System.out.println("\n---------------------------------------------------");
    }
}
