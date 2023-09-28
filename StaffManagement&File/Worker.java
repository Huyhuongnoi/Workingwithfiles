public class Worker extends Officer {
    private int rank;

    public Worker(int id, String name, int age, String sex, String address, int rank) {
        super(id, name, age, sex, address);
        this.rank = rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String getDataWorker() {
        String data = String.valueOf(getId()) + "|" + getName() + "|" + String.valueOf(getAge()) + "|" + getSex() + "|" + getAddress() + "|" + String.valueOf(getRank());
        return data;
    }
}
