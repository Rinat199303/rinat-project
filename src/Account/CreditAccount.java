package Account;

public class CreditAccount extends Account{
    public Limit limit;
    public CreditAccount(long balance, Limit limit){
        this.balance = balance;
        this.limit = limit;
    }
    public CreditAccount(Limit limit){
        balance = 0;
        this.limit = limit;
    }
    @Override
    public boolean add(long amount) {
        if (balance + amount > 0){
            return false;
        }else {
            balance += amount;
            return true;
        }
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount > limit.getLim()){
            balance -= amount;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Ваш кредитный счет " + balance + " ваш лимит " + limit;
    }
}
