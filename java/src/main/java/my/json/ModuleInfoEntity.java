package my.json;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 组件信息表
 *
 * @author sujian
 * @email 1491096411@qq.com
 * @date 2020-09-03 11:12:29
 */
@Data
//@KeySequence(value = "Sequence_module_id", clazz = Integer.class)
public class ModuleInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 组件id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private String moduleId;
    /**
     * 组件大类id
     */
    private Integer moduleParentTypeId;
    /**
     * 组件类型id
     */
    private Integer moduleTypeId;
    /**
     * 组件名称
     */
    private String moduleName;
    /**
     * 组件预定义客群信息
     */
    private String modulePredefCustInfo;
    /**
     * 组件热度标签客群信息
     */
    private String moduleHotlabelInfo;
    /**
     * 组件全量标签客群信息
     */
    private String moduleGloballabelInfo;
    /**
     * 组件白名单信息
     */
    private String moduleWhitelistInfo;
    /**
     * 外部名单筛选条件规则对应交易号
     */
    private String outerCustTranseqno;
    /**
     * 外部名单筛选条件规则  调用中台-麒麟时需要
     */
    private String outerCustlistCriteria;
    /**
     * 组件渠道id
     */
    private Integer channelId;
    /**
     * 组件渠道编码
     */
    private String channelCode;
    /**
     * 组件渠道名称
     */
    private String channelName;
    /**
     * 组件渠道类型
     */
    private String channelType;
    /**
     * 组件渠道状态【0->禁用;1->启用】
     */
    private Integer channelStatus;
    /**
     * 组件渠道备注
     */
    private String channelRemark;
    /**
     * 活动话术详情
     */
    private String talkContent;
    /**
     * 活动话术链接（存放长链接或短链接）
     */
    private String talkLink;
    /**
     * 组件渠道高级设置信息--渠道小类
     */
    private String moduleChannelHighConfig;
    /**
     * 组件控制组
     */
    private String moduleControlPercentage;
    /**
     * 组件预定模式：0-单次执行；1-周期性活动
     */
    private String moduleScheduleMode;
    /**
     * 活动模式执行设置
     */
    private String moduleExecuteSetting;
    /**
     * 沟通模式执行设置
     */
    private String moduleConnectSetting;
    /**
     * 组件创建时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date moduleCreateTime;
    /**
     * 组件创建人
     */
    private Integer moduleCreateBy;
    /**
     * 组件更新时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date moduleUpdateTime;
    /**
     * 组件更新人
     */
    private Integer moduleUpdateBy;
    /**
     * 组件申请时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date moduleApplyTime;
    /**
     * 组件申请人
     */
    private Integer moduleApplyBy;

    /**
     * 组件审批类型 【normal->正常审批;specify->指定专人;skip->无需审批】
     */
    private String moduleApproveType;
    /**
     * 组件来源类型 【portal->门户;outer->外部】
     */
    private String moduleSourceType;
    /**
     * 组件来源名称
     */
    private String moduleSourceName;
    /**
     * 组件审批记录ID
     */
    @Deprecated
    private Integer moduleApproveRecordId;
    /**
     * 组件审批时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date moduleApproveTime;
    /**
     * 组件审批人
     */
    private Integer moduleApproveBy;
    /**
     * 组件描述
     */
    private String moduleDescribe;
    /**
     * 组件预估成功率
     */
    private Integer modulePredictReate;
    /**
     * 组件线下审批通过流程id
     */
    private String moduleOfflineApprovedIds;
    /**
     * 组件审批状态【draft->待提交;approve->待审核;nopass->审核驳回;pass->审核通过】
     */
    private String moduleApproveStatus;
    /**
     * 组件使用状态【on->启用;off->禁用;】
     */
    private String moduleUseStatus;
    /**
     * 组件成功准则设置状态【0->未设置;1->设置】
     */
    private Integer moduleSucessCriteriaState;
    /**
     * 组件成功准则内容
     */
    private String moduleSucessCriteria;
    /**
     * 组件多波次设置状态【0->未设置;1->设置】
     */
    private Integer moduleFollowedScheduleState;
    /**
     * 组件申请机构编码
     */
    private String moduleApplyOrganCode;
    /**
     * 组件申请机构名称
     */
    private String moduleApplyOrganName;
    /**
     * 活动审批部门级别  0:总行 1:分行 2:支行
     */
    private String moduleApproveDeptLevel;
    /**
     * 用户所属上级部门(所属分行)  belongs_branch
     */
    private String belongsBranch;
    /**
     * 组件申请部门编码
     */
    private String moduleApplyDepartCode;
    /**
     * 组件申请部门名称
     */
    private String moduleApplyDepartName;
    /**
     * 组件多波次设置内容(该字段已废弃)
     */
    private String moduleFollowedSchedule;
    /**
     * 组件创建过程页【01->客群与渠道;02->活动定义;03->提交审批】
     */
    private String moduleCreatePage;
    /**
     * 产品生效日期，传播式营销时必输
     */

    private String clueStartDt;
    /**
     * 产品失效日期，传播式营销时必输
     */

    private String clueEndDt;
    /**
     * 产品描述，传播式营销时必输
     */
    private String clueProd01;
    /**
     * 产品话术，传播式营销时必输
     */
    private String clueContent01;
    /**
     * 线索类型，前端不显示，后端传“02”
     */
    private String clueType;
    /**
     * 数据接入开始日期，DIET_外呼时必输
     */
    private String dataStartDt;
    /**
     * 数据接入结束日期，DIET_外呼时必输
     */
    private String dataEndDt;
    /**
     * 业务主题
     */
    private String campObj;
    /**
     * 活动分配方式
     */
    private String campAssign;
    /**
     * 优先级-综合账单渠道 高:1;中:2;低:3
     */
    private String campPriority;
    /**
     * URL-综合账单渠道
     */
    private String campUrl;
    /**
     * 图片编号-综合账单渠道
     */
    private String campPhotoNo;
    /**
     * 短信发送时间
     */
    private String smsSenddt;
    /**
     * 短信发送日期
     */
    private String smsSendday;
    /**
     * 发送开始时间-短信渠道
     */
    private String smsStartSenddt;
    /**
     * 发送结束时间-短信渠道
     */
    private String smsEndSenddt;
    /**
     * 活动开始日期
     */
    // @JsonFormat(locale = "zh", pattern = "yyyyMMdd")
    private String campStartDt;
    /**
     * 活动结束日期
     */
    private String campEndDt;
    /**
     * 成功准则逻辑关系
     */
    private String sucOpt;
    /**
     * 组件删除状态【0->是；1->否】
     */
    private String moduleInfoDeleteStatus;
    /**
     * 组件创建类型
     */
    private String moduleCreateType;
    /**
     * 父组件id
     */
    private String moduleParentModuleId;
    /**
     * sql拼接语句
     */
    private String moduleSqlCondition;
    /**
     * 组件类型名称
     */
    private String moduleTypeName;
    /**
     * 文件内容
     */

    /**
     * 客群来源
     */
    private String moduleCustSource;

    /**
     * 组件cron表达式
     */
    private String moduleExecuteCron;
    /**
     * 提交人
     */
    private Integer moduleSubmitBy;
    /**
     * 创建人名称
     */
    private String moduleCreateName;
    /**
     * 创建人部门
     */
    private String moduleCreateByDepartment;
    /**
     * 距离当前时间
     */
    private String hourInterval;
    /**
     * 修改人名称
     */
    private String moduleUpdateName;
    /**
     * 审批人名称
     */
    private String moduleApproveName;
    /**
     * 成功准则编辑展示
     */
    //@JsonDeserialize(using = Object2StrDeserialize.class)
    private String moduleSucessCriteriaJson;
    /**
     * 组件类型code
     */
    private String moduleTypeCode;
    /**
     * 下一次执行时间
     */
    private String nextExcuteTime;
    /**
     * 活动执行状态
     */
    private String moduleExcuteStatus;
    /**
     * 活动对应客群总数
     */
    private Integer moduleCustomerCount;
    /**
     * 必选成功准则
     */
    private String moduleMustCriteria;
    /**
     * 主要成功准则
     */
    private String moduleMainCriteria;
    /**
     * 次要成功准则1
     */
    private String moduleFrstMinorCriteria;
    /**
     * 次要成功准则2
     */
    private String moduleSecMinorCriteria;
    /**
     * tag分词
     */
    private String moduleTagPartWord;
    /**
     * 是否列入成功达标活动
     */
    private String moduleSucAch;
    /**
     * 实时跟踪模版类型
     */
    private String moduleSucSsmb;
    /**
     * 是否纳入实时评估
     */
    private String moduleIsSucSsgz;
    /**
     * 父波次活动id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private String parentFollowedModuleId;
    /**
     * 活动多波次查询条件SQL
     */
    private String moduleFollowedQuerySql;
    /**
     * 活动多波次json展示
     */
    private String moduleFollowedJson;
    /**
     * 波段次数
     */
    private String commPeriod;
    /**
     * 主活动moduleId
     */
    private String firstFollowedModuleld;
    /**
     * 是否是模板 0 不是模板  1 是模板
     */
    //@TableField(exist = false)
    private Integer isTemplate;
    /**
     * 关联模板id   PARENT_TEMPLATE_ID
     */
    //@TableField(exist = false)
    private String parentTemplateId;

    private String moduleIcon;
    /**
     * 活动客群
     */
    private String moduleCustType;
    /**
     * 主推产品
     */
    private String moduleMainProduct;

    /**
     * 成功准则大类编码，供成功准则大类下拉框回显使用
     */
    private String successRuleParentModel;

    /**
     * 成功准则小类编码，供成功准则小类下拉框回显使用
     */
    private String successRuleModel;

    private String auditFlag;
    /**
     * 交易金额最小值
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal cbsMinamt01;
    /**
     * 交易金额最大值
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal cbsMaxamt01;

    /**
     * 选中的目标客群列表的ListId字符串  用;分割    TARGET_CUSTLISTIDS
     */
    private String targetCustlistids;

    /**
     * CRM目标客群信息  前端传数组字符串
     */
    private String ListId;

    /**
     * CRM目标客群信息数量
     */
    private String MemberCount;

    /**
     * CRM目标客群信息   CRM_SUM_ARR
     */
    private String crmSumArr;

    /**
     * 微信动账 优先级  PRIORITY_LEVEL01 1-999整数
     */
    private Integer priorityLevel01;

    /**
     * 微信动账 交易码  CBS_TXNCD01
     */
    private String cbsTxncd01;


    //===========智能外呼模板-BEGIN===========
    /**
     * 智能外呼模板 业务类型 CC_BUSINESS_TYPE
     */
    private String ccBusinessType;

    /**
     * 智能外呼模板 外拨业务 CC_BUSINESS_ID
     */
    private String ccBusinessId;

    /**
     * 智能外呼模板 流程号  CC_FLOW_ID
     */
    private String ccFlowId;

    /**
     * 智能外呼模板 优先级  PRIORITY 1-999整数
     */
    private Integer priority;

    //===========智能外呼模板-END===========
    /**
     * 推荐客群、白名单、标签、crm目标客群公共json字段
     */
    private String custCommonJson;

    /**
     * 二波次外呼运行时间
     */
    private String callRunDateSec;

    private Integer isRealTime;
    /**
     * 活动模板自定义排序
     */
    private Integer moduleTemplateOrder;
    /**
     * 营销组完成率
     */
    private String YXData;
    /**
     * 对照组完成率
     */
    private String DZData;
    /**
     * 达标数据
     */
    private String dbPercent;
    /**
     * 审批部门code
     */
    private String moduleApproveDepart;

    /**
     * 是否配置实时规则
     */
    private String isRealTimeRule;

    /**
     * 规则类型RULE_TYPE
     */
    private String ruleType;
    /**
     * 规则名称RULE_Name
     */
    private String ruleName;
    /**
     * 标签字段排序sql
     */
    private String sqlConditionFinal;
    /**
     * 标签规则对应的客群总数
     */
    private Integer moduleCustomerOrderCount;

    /**
     * 模型对照组活动的主活动MODULE_ID，非模型对照组活动该值为0
     */
    private String controlFollowedModuleId;

    /**
     * 处理后的标签数据数组——供拼接sql使用
     */
    private String labelTransformInfo;
    /**
     * 活动创建人中文名
     */
    private String moduleCreateFullName;
    /**
     * 渠道任务开始时间
     */
    private String taskRealStartTime;
    /**
     * 渠道任务结束时间
     */
    private String taskRealEndTime;

    /**
     * 历史活动号
     */
    private String hisCampaignCd;
    /**
     * 过滤标志  01 包含  02 排除
     */
    private String filterTypeCd;
    /**
     * 是否允许撤销
     */
    private boolean canCancel = true;
    /**
     * 精准营销的任务类型
     */
    private String finMessTp;
    /**
     * 精准营销的任务优先级
     */
    private String finMessPrty;

    /**
     * 客群分类
     */
    private String customerType;
    /**
     * 目标产品定位大类，码值存储于HIMA_SYS_RULE_CONFIG表的CONFIG_KEY字段
     */
    private String productType;
    /**
     * 目标产品定位小类，码值存储于HIMA_SYS_RULE_CONFIG表的SUB_CONFIG_KEY字段
     */
    private String subProductType;
    /**
     * 业务类型区分：1-零售，2-金融市场，3-对公
     */
    private Integer subSysType;
    /**
     * 待审批机构code
     */
    private String belongsApproveBranch;
    /**
     * 任务反馈率
     */
    private Double taskFeedback;
    /**
     * 目标完成率
     */
    private String completeTarget;
    /**
     * 达标人数
     */
    private String standardNumber;
    /**
     * 触达人数
     */
    private String reachNumber;
    private Integer isSelectManage;

    /**
     * 预定时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date specificTime;

    /**
     * 跟踪开始日期
     */
    private String trackingStartDt;

    /**
     * 跟踪结束日期
     */
    private String trackingEndDt;
    /**
     * 重要程度
     */
    private Integer importDegree;

    /**
     * 是否为转派活动  0代表否1代表是
     */
    private String ifTransfer;
    /**
     * 指派人 存的userId
     */
    private Integer primaryTransferUser;
    /**
     * 指派人 存的username
     */
    private String preTransferorName;
    /**
     * 审批人工号
     */
    private String moduleApproveNum;
    /**
     * 任务单id
     */
    private Integer taskOrderId;
    /**
     * 话术编号
     */
    private String talkNumber;
    /**
     * 营销线索
     */
    private String clueCode;
}
