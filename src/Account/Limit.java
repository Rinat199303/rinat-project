package Account;

public class Limit {
    private int lim;

    public Limit(int lim){
        this.lim = lim;
    }

    public void setLim(int lim){
        boolean set = lim > 0;
        if(set)lim = 0;
        else this.lim = lim;
    }
    public int getLim(){
        return lim;
    }

    @Override
    public String toString() {
        return  ""+lim;
    }
}
