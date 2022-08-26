package my.json;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 组件信息表
 *
 * @author sujian
 * @email 1491096411@qq.com
 * @date 2020-09-03 11:12:29
 */
@Data
public class ModuleInfoVo extends ModuleInfoEntity {
    private static final long serialVersionUID = 1L;
    //@ApiModelProperty(value = "是否提交")
    private boolean isCommit;
    //@ApiModelProperty(value = "下次执行时间")
    private String nextExcuteTime;
    /*//@ApiModelProperty(value = "客户总数")
    private Long customerTotal;*/
    //@ApiModelProperty(value = "页码")
    private Integer page;
    //@ApiModelProperty(value = "每页条数")
    private Integer limit;
    //@ApiModelProperty(value = "创建人")
    private Integer moduleCreateBy;
    /*//@ApiModelProperty(value = "渠道ID")
    private Integer channelId;*/
    //@ApiModelProperty(value = "活动开始日期")
    private String campStartDt;
    //@ApiModelProperty(value = "活动结束日期")
    private String campEndDt;
    //@ApiModelProperty(value = "组件大类名称")
    private String moduleTypeParentName;
    //@ApiModelProperty(value = "名单名称")
    private String moduleSheetName;

    /**
     * 子波次渠道id
     */
    //@TableField(exist = false)
    private Integer channelIdSec;
    /**
     * 子波次渠道编码
     */
    //@TableField(exist = false)
    private String channelCodeSec;
    /**
     * 子波次渠道名称
     */
    //@TableField(exist = false)
    private String channelNameSec;
    /**
     * 子波次渠道类型
     */
    //@TableField(exist = false)
    private String channelTypeSec;
    /**
     * 子波次发送开始时间-短信渠道
     */
    //@TableField(exist = false)
    private String smsStartSenddtSec;
    /**
     * 子波次发送结束时间-短信渠道
     */
    //@TableField(exist = false)
    private String smsEndSenddtSec;
    /**
     * 子波次活动分配方式
     */
    //@TableField(exist = false)
    private String campAssignSec;
    /**
     * 子波次运行时间方式
     */
    //@TableField(exist = false)
    private String runTimeSec;
    /**
     * 已选标签拼接sql使用
     */
    /**
     * 标志组件计算总数是否完成
     */
    private Integer countFalg;


    // 短信参数传递所需
    private Integer messageId;

    /**
     * 短信类型
     */
    private String messageType;
    /**
     * 发送方式
     */
    private String messageSendMode;
    /**
     * 参数类型
     */
    private String messageParamType;
    /**
     * 回复编码
     */
    private String replyCode;

    /**
     * 回复编码传送MA
     */
    private String replyCodeMa;

    /**
     * 回复内容处理
     */
    private String replySolveMode;
    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date messageStartDate;
    /**
     * 结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date messageEndDate;
    /**
     * 短信主题
     */
    private String messageTopic;
    /**
     * 短信内容
     */
    private String messageContent;


    /**
     * CRM目标客群信息   CRM_SUM_ARR
     */
    private String crmSumArr;
    /**
     * 二波次短信发送时间
     */
    private String smsSenddtSec;
    /**
     * 二波次短信发送日期
     */
    private String smsSenddaySec;
    /**
     * 二波次的话术内容
     */
    private String moduleFollowedTalkContent;
    /**
     * 机构分行code
     */
    private String coreBrId;
//============手机银行渠道---广告区字段---start======sujian20210406-version========//
    /**
     * 广告位类型(01，开屏，02弹屏，03首页顶部，04首页中部，05财富顶端，06生活频道，07热门活动，08弹窗广告，09我的成长，10新客专区，12小程序头部，13权益平台，14我的频道广告)
     */
    private String bannerType;
    /**
     * 广告起止时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bannerStartDt;
    /**
     * 广告结束时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bannerEndDt;
    /**
     * 广告链接
     */
    private String bannerLink;
    /**
     * 客户标签
     */
    private String bannerRemark;


    private String equitiesLabelListJson;
    /**
     * 权益开启时间时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date equitiesStartTime;
    /**
     * 是否开启权益(0否1是)
     */
    private Integer startEquities;
    /**
     * 名单类型
     */
    private String cpmMdtype;
    /**
     * 补充点数
     */
    private Integer cpmAddNum;
    /**
     * 权益分类
     */
    private String cpmType;
    /**
     * 权益代码
     */
    private String cpmCode;
    /**
     * 权益点数
     */
    private String cpmCode02;
    //============活动---权益字段---end==============//
    /**
     * 二波次外呼运行时间
     */
    private String callRunDateSec;
    /**
     * 预定义客群信息
     */
    private String predefJson;
    //============代发营销快速响应渠道---start
    private String cbsContent01;
    //============厅堂pad渠道---start

    //@ApiModelProperty(value = "渠道")
    private String clueChannel;

    //@ApiModelProperty(value = "营销线索主题")
    private String clueTopic;
    //============厅堂pad渠道---end


    //============微信通知渠道---start

    //@ApiModelProperty(value = "模板类型")
    private String templateType;

    //@ApiModelProperty(value = "输入标题")
    private String headlineWf;

    //@ApiModelProperty(value = "输入风险类型")
    private String riskTypes;

    //@ApiModelProperty(value = "输入风险提示内容")
    private String riskTips;

    //@ApiModelProperty(value = "备注")
    private String remarksWf;

    //@ApiModelProperty(value = "是否发送链接")
    private String sendLink;

    //@ApiModelProperty(value = "发送时间")
    private Date startTime;

    //============微信通知渠道---end
    //@ApiModelProperty(value = "审核详情渠道展示")
    private String channelInfoForm;

    //@ApiModelProperty(value = "高级筛选条件")

    //@ApiModelProperty(value = "画布序号")
    private Integer moduleCanvas;

    //@ApiModelProperty(value = "微信动账|核心动账list")
    private List<String> transCodes;
    /**
     * 微信动账 话术编号 CONTENT_ID01
     */
    private String contentId01;
    /**
     * 微信动账 话术摘要 CONTENT_ABSTRACT01
     */
    private String contentAbstract01;
    /**
     * 标签规则定义-标签排序规则和结果集行数自定义
     */
    //@ApiModelProperty("标签规则定义-标签排序规则和结果集行数自定义")
    /**
     * 多个多波次json字符串
     */
    //@ApiModelProperty("多个多波次json字符串")

    /**
     * 主活动编号
     */
    //@ApiModelProperty("主活动编号")
    private String mainModuleId;

    //===========APP消息推送模板-BEGIN===========
    private String appmsgTitle;    //APP消息推送标题
    private String appmsgType;        //APP消息类型  （1：公告类  2：精准推送类 103：权益助手)
    //@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private String appmsgDate;        //APP消息推送日期
    private String appmsgCont;        //APP消息推送正文
    private String appmsgSensitive;        //是否敏感 (1：敏感 2：非敏感)
    private String appmsgSendtype;        //定时推送设置（0：即时   99：指定日期    1：T+1    2：T+2   3：T+3  4：T+4  5：T+5）
    private String appmsgSendtime;        //APP消息推送时间
    private String appmsgBanner;        //APP消息推送活动BANNER
    private String appmsgImage;        //APP消息推送图片
    //private String appmsgBtntext;        //内页按钮文字（已废弃）
    private String appmsgInnercont;        //内页悬浮话术
    //private String appmsgInnerjump;        //内页跳转地址（已废弃）
    private String appmsgLinkTem;        //超链接模板选择
    private String appmsgLink;        //APP消息推送链接
    //@ApiModelProperty("APP消息推送链接2（2.0）")
    private String appmsgLinkTwo;
    //@ApiModelProperty("app推送按钮个数")
    private Integer appmsgBtnNum;
    //@ApiModelProperty("营销内页按钮样式0")
    private String appmsgTypeZero;
    //@ApiModelProperty("营销内页按钮样式1")
    private String appmsgTypeOne;
    //@ApiModelProperty("营销内页的跳转地址")
    private String appmsgInnerJumpOne;
    //@ApiModelProperty("营销内页的按钮文字")
    private String appmsgBtnTextOne;
    //@ApiModelProperty("按钮个数1：营销内页的跳转地址（2.0）")
    private String appmsgInnerjumpThreea;
    //@ApiModelProperty("营销内页按钮样式2")
    private String appmsgTypeTwo;
    //@ApiModelProperty("营销内页的跳转地址2-1")
    private String appmsgInnerJumpTwoa;
    //@ApiModelProperty("营销页内的按钮文字2-1")
    private String appmsgBtnTextTwoa;
    //@ApiModelProperty("营销内页的跳转地址2-2")
    private String appmsgInnerJumpTwob;
    //@ApiModelProperty("营销内页的按钮文字2-2")
    private String appmsgBtnTextTwob;
    //@ApiModelProperty("按钮个数2：营销内页的跳转地址2-1（2.0）")
    private String appmsgInnerjumpThreeb;
    //@ApiModelProperty("按钮个数2：营销内页的跳转地址2-2（2.0）")
    private String appmsgInnerjumpThreec;
    //@ApiModelProperty("APP消息推送-免打扰服务号")
    private String appmsgNoNotify;

    //===========APP消息推送模板-END===========

    /* ******************** FCRM渠道-BEGIN ******************** */
    /**
     * 是否反馈
     */
    //@ApiModelProperty("是否反馈")
    private String ifFeedback;

    /**
     * 反馈日期
     */
    //@ApiModelProperty("反馈日期")
    private String feedbackDates;

    /**
     * 反馈日期数量
     */
    //@ApiModelProperty("反馈日期数量")
    private String feedbackNum;

    //@ApiModelProperty(value = "主办")
    private String mManager;

    //@ApiModelProperty(value = "协办")
    private String aManager;
    /* ******************** FCRM渠道-END ******************** */

    //@ApiModelProperty(value = "客群名单")
    private List<ActvModuleCustEntity> customerGroupList;

    //@ApiModelProperty(value = "实时规则代码")
    private String realTimeRuleCode;

    /**
     * 二波次预定时间
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date specificTimeSec;
    private String longLink;
    /**
     * 短链接对应的渠道code
     */
    private String msgType;

    //@ApiModelProperty(value = "一级规则代码")
    private String firRules;
    //@ApiModelProperty(value = "二级规则代码")
    private String secRules;


    //@ApiModelProperty("实时短信渠道小类CODE")
    private String sendModeCd;

    //@ApiModelProperty(value = "金额范围最小值")
    private BigDecimal llAmt;

    //@ApiModelProperty(value = "金额范围最大值")
    private BigDecimal hlAmt;

    //@ApiModelProperty(value = "产品编号")
    private String productCd;

    //@ApiModelProperty(value = "自定义话术")
    private String customContent;

    //@ApiModelProperty(value = "优先级")
    private Integer priority;
    //@ApiModelProperty(value = "交易码显示")
    private List<String> tranCdView;

    //@ApiModelProperty(value = "分配类型")
    private String assignType;
    //@ApiModelProperty(value = "分配规则")
    private String ruleDistribution;
    //@ApiModelProperty(value = "是否周期性活动")
    private String ifPeriodModule;
    //@ApiModelProperty(value = "周期类型枚举")
    private String periodType;
    //@ApiModelProperty(value = "预留字段")
    private String periodInfo;
    //@ApiModelProperty(value = "是否特色反馈")
    private String ifSpecialFeedback;
    //@ApiModelProperty(value = "选项")
    private String type1;
    //@ApiModelProperty(value = "选项对应内容")
    private String info1;
    //@ApiModelProperty(value = "选项")
    private String type2;
    //@ApiModelProperty(value = "选项对应内容")
    private String info2;
    //@ApiModelProperty(value = "选项")
    private String type3;
    //@ApiModelProperty(value = "选项对应内容")
    private String info3;

    //@ApiModelProperty(value = "自定义客群信息")
    /**
     * 执行设置，对应活动信息的moduleExecuteSetting属性
     */
    @Data
    public static class ExecuteSetting {
        /**
         * 周期循环模式：D-按天；W-按周；M-按月，对应CommonEnums.CycleModeEnum
         */
        private String cycleMod;
        /**
         * 周期信息：W：1-7 周日-周六；M：1-31 1-31号 L 月末（多个日期使用逗号分隔）
         */
        private String cycleItem;
        /**
         * 周期执行时间 HH:mm
         */
        private String cycleTime;
    }
}
