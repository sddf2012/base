package my.bean.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2022/5/18 下午5:30
 */
@Component
public class CdA {
    private String name="abc";

    @Autowired
    private CdB cdb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CdB getCdb() {
        return cdb;
    }

    public void setCdb(CdB cdb) {
        this.cdb = cdb;
    }
}
