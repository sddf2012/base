package my.domain;

/**
 * @author liu peng bo
 * @date 2022/5/2 下午3:23
 */
public class LiHuaCat extends Cat {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "LiHuaCat{" +super.toString()+
                "address='" + address + '\'' +
                '}';
    }
}
