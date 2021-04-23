package ioc.dependency.demain;

/**
 * description: SuperUser <br>
 * date: 2021/4/23 18:43 <br>
 * version: 1.0 <br>
 * @author EDZ
 */
public class SuperUser extends User {
    private String address;

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
