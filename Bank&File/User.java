import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private String sex;
    private String address;

    public User(String name, int age, String sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String informationUser() {
        return getName() + "\n" + String.valueOf(getAge()) + "\n" + getSex() + "\n" + getAddress();
    }

}
