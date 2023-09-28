public class Engineer extends Officer {
    private String trainingIndustry;

    public Engineer(int id, String name, int age, String sex, String address, String trainingIndustry) {
        super(id, name, age, sex, address);
        this.trainingIndustry = trainingIndustry;
    }

    public void setTrainingIndustry(String trainingIndustry) {
        this.trainingIndustry = trainingIndustry;
    }

    public String getTrainingIndustry() {
        return trainingIndustry;
    }

    public String getDataEngineer() {
        String data = String.valueOf(getId()) + "|" + getName() + "|" + String.valueOf(getAge()) + "|" + getSex() + "|" + getAddress() + "|" + getTrainingIndustry();
        return data;
    }
}
