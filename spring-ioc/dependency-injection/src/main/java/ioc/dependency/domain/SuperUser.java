package ioc.dependency.domain;


import ioc.dependency.annotation.Super;

/**
 * description: SuperUser <br>
 * date: 2021/4/23 18:43 <br>
 * version: 1.0 <br>
 * @author EDZ
 */
@Super
public class SuperUser extends User {
    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
