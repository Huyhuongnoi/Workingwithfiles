public class Staff extends Officer {
    private String job;

    public Staff(int id, String name, int age, String sex, String address, String job) {
        super(id, name, age, sex, address);
        this.job = job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public String getDataStaff() {
        String data = String.valueOf(getId()) + "|" + getName() + "|" + String.valueOf(getAge()) + "|" + getSex() + "|" + getAddress() + "|" + getJob();
        return data;
    }
}
