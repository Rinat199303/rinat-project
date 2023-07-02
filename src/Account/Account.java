package Account;

public abstract class Account {
    protected long balance;

    public boolean add(long amount){
        return true;
    }
    public boolean pay(long amount){
        return true;
    }
    public boolean transfer(Account account, long amount){
        if (pay(amount) && account.add(amount)){
            return true;
        }else {
            add(amount);
            return false;
        }
    }
    public long getBalance(){
        return balance;
    }
}
