package my.json;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description: 模型标签关联用户表
 * @author: sxd-fengshuo
 * @create: 2021-10-15
 **/
@Data
@NoArgsConstructor
public class ActvModuleCustEntity implements Serializable {
    private static final long serialVersionUID = -8860937698202866816L;

    public ActvModuleCustEntity(String moduleId, String custId, String custName, String potentialCustomer,
                                String ifEdit, String createUser, Date createTime) {
        this.moduleId = moduleId;
        this.custId = custId;
        this.custName = custName;
        this.potentialCustomer = potentialCustomer;
        this.ifEdit = ifEdit;
        this.createUser = createUser;
        this.createTime = createTime;
    }

    /**
     * id
     */

    private Integer moduleCustId;

    /**
     * id
     */
    private String custId;
    /**
     * 客户名称
     */
    private String custName;
    /**
     * 活动编号
     */
    private String moduleId;
    /**
     * 责任人
     */
    private String chargePerson;

    /**
     * 机构名称
     */
    private String chargeOrg;

    /**
     * 责任人
     */
    private String chargePersonCode;

    /**
     * 机构code
     */
    private String chargeOrgCode;

    /**
     * 金融机构行业分类编码
     */
    private String fcrmCustCode;

    /**
     * 金融机构行业分类名称
     */

    private String fcrmCustName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 客户是否有效
     */
    private Integer ifEffective;
    /**
     * 推荐产品
     */
    private String predictItemId;

    /**
     * 产品得分
     */
    private String weightedScore;
    /**
     * 购买潜力预测
     */
    private String predictReal;

    /**
     * 错误信息提示
     */
    private List<String> errorMessage;

    /**
     * 是否为潜客   0为否1为是
     */
    private String potentialCustomer;

    /**
     * 户数增加
     */
    private String custNumAdd;

    /**
     * 财务规模提升
     */
    private String finScaleImpro;

    /**
     * 财务收入增加
     */
    private String finIncomeImpro;

    /**
     * 是否可编辑
     */
    private String ifEdit;

    @Override
    public boolean equals(Object obj) {
        ActvModuleCustEntity u = (ActvModuleCustEntity) obj;
        return custId.equals(u.custId);
    }

    @Override
    public int hashCode() {
        String in = custId;
        return in.hashCode();
    }
}
