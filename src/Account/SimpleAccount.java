package Account;

public class SimpleAccount extends Account{
    public SimpleAccount(long balance){
        this.balance = balance;
    }

    @Override
    public boolean add(long amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        if (amount > balance){
            return false;
        }else{
            balance = balance - amount;
            return true;
        }
    }
    public void setBalance(){
        this.balance = balance;
    }

    @Override
    public long getBalance() {
        return super.getBalance();
    }

    @Override
    public String toString() {
        return "Ваш зарплатный счет " + balance;
    }
}
