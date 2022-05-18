/**
 * BackAccountInterface 
 * Nje interface e nje llogarie bankare tregon se cfare duhet qe te perfshihet me patjeter te nje llogari bankare
 */
public interface BackAccountInterface {
    
    public double ShowBalance();
    public boolean Withdraw(double amount);
    public void Depozit(double amount);
    public void ChangePin();
}