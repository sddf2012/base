package my.bean.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * @date 2022/5/18 下午5:31
 */
@Component
public class CdB {
    private String type="123";

    @Autowired
    private CdA cdA;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CdA getCdA() {
        return cdA;
    }

    public void setCdA(CdA cdA) {
        this.cdA = cdA;
    }
}
