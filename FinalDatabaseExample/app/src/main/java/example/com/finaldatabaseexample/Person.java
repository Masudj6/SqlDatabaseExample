package example.com.finaldatabaseexample;

/**
 * Created by Admin on 3/24/17.
 */

public class Person {


    private int id;
    private String name;
    private  String mobile;

    public Person(int id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public Person(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
