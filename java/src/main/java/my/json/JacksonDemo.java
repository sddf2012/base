package my.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author liu peng bo
 * @date 2022-8-4 14:11
 */
public class JacksonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        String a="{\"moduleId\":\"CAMP202112171643001\",\"customerGroupList\":[{\"moduleCustId\":null,\"custId\":\"2005812848\",\"custName\":\"WHB测试新增1\",\"moduleId\":\"CAMP202207191437002\",\"chargePerson\":\"WHB测试新增3\",\"chargeOrg\":\"郑州分行新乡支行\",\"chargePersonCode\":\"11001961\",\"chargeOrgCode\":\"1171\",\"fcrmCustCode\":\"C3\",\"fcrmCustName\":\"股份制商业银行\",\"createUser\":\"超级管理员\",\"ifEffective\":null,\"predictItemId\":null,\"weightedScore\":null,\"predictReal\":null,\"errorMessage\":null,\"potentialCustomer\":\"0\",\"custNumAdd\":\"1\",\"finScaleImpro\":\"1000\",\"finIncomeImpro\":\"100\",\"ifEdit\":\"0\"}],\"realTimeRuleCode\":\"CI0180\",\"moduleSucessCriteriaJson\":{\"ruleDatas\":\"[{\\\"sucessCriteriaGroupName\\\":\\\"票据资管\\\",\\\"sucessCriteriaGroupCode\\\":\\\"NCW025\\\",\\\"sucessCriteriaSonGroupList\\\":[{\\\"sucessCriteriaCode\\\":\\\"A01\\\",\\\"sucessCriteriaDescribe\\\":\\\"户数增加（单位：户）\\\",\\\"sucessCriteriaDataType\\\":\\\"NUMBER\\\",\\\"sucessCriteriaFrameType\\\":\\\"input\\\",\\\"columnName\\\":null,\\\"sucessCriteriaValue\\\":null},{\\\"sucessCriteriaCode\\\":\\\"A02\\\",\\\"sucessCriteriaDescribe\\\":\\\"财务规模提升（单位：元）\\\",\\\"sucessCriteriaDataType\\\":\\\"NUMBER\\\",\\\"sucessCriteriaFrameType\\\":\\\"input\\\",\\\"columnName\\\":null,\\\"sucessCriteriaValue\\\":null},{\\\"sucessCriteriaCode\\\":\\\"A03\\\",\\\"sucessCriteriaDescribe\\\":\\\"财务收入增加（单位：元）\\\",\\\"sucessCriteriaDataType\\\":\\\"NUMBER\\\",\\\"sucessCriteriaFrameType\\\":\\\"input\\\",\\\"columnName\\\":null,\\\"sucessCriteriaValue\\\":null}],\\\"parentGroupCode\\\":\\\"OTC\\\",\\\"parentGroupName\\\":\\\"场外业务\\\",\\\"A01\\\":\\\"\\\",\\\"A02\\\":\\\"\\\",\\\"A03\\\":\\\"\\\",\\\"A01s\\\":\\\"1\\\",\\\"A02s\\\":\\\"1000\\\",\\\"A03s\\\":\\\"100\\\"},{\\\"sucessCriteriaGroupName\\\":\\\"投资保本理财\\\",\\\"sucessCriteriaGroupCode\\\":\\\"NCW012\\\",\\\"sucessCriteriaSonGroupList\\\":[{\\\"sucessCriteriaCode\\\":\\\"A01\\\",\\\"sucessCriteriaDescribe\\\":\\\"户数增加（单位：户）\\\",\\\"sucessCriteriaDataType\\\":\\\"NUMBER\\\",\\\"sucessCriteriaFrameType\\\":\\\"input\\\",\\\"columnName\\\":null,\\\"sucessCriteriaValue\\\":null},{\\\"sucessCriteriaCode\\\":\\\"A04\\\",\\\"sucessCriteriaDescribe\\\":\\\"平台规模提升（单位：元）\\\",\\\"sucessCriteriaDataType\\\":\\\"NUMBER\\\",\\\"sucessCriteriaFrameType\\\":\\\"input\\\",\\\"columnName\\\":null,\\\"sucessCriteriaValue\\\":null},{\\\"sucessCriteriaCode\\\":\\\"A05\\\",\\\"sucessCriteriaDescribe\\\":\\\"平台收入增加（单位：元）\\\",\\\"sucessCriteriaDataType\\\":\\\"NUMBER\\\",\\\"sucessCriteriaFrameType\\\":\\\"input\\\",\\\"columnName\\\":null,\\\"sucessCriteriaValue\\\":null}],\\\"parentGroupCode\\\":\\\"OTC\\\",\\\"parentGroupName\\\":\\\"场外业务\\\",\\\"A01\\\":\\\"\\\",\\\"A04\\\":\\\"\\\",\\\"A05\\\":\\\"\\\",\\\"A01s\\\":\\\"1\\\",\\\"A04s\\\":\\\"1000\\\",\\\"A05s\\\":\\\"100\\\"}]\"},\"mManager\":0,\"aManager\":0,\"feedbackDates\":\"\",\"customerTotal\":1,\"moduleName\":\"实时规则test\",\"moduleDescribe\":\"\",\"moduleTypeCode\":\"100000001\",\"campStartDt\":\"2022-07-19\",\"campEndDt\":\"2022-07-26\",\"moduleChannelHighConfig\":\"FN2\",\"checkList\":[],\"ifFeedback\":\"0\",\"feedbackNum\":0,\"approveResult\":\"\",\"moduleApproveTime\":\"\",\"moduleApproveDepart\":\"FCRM-0\",\"moduleApproveName\":\"\",\"moduleApproveComment\":\"\"}";
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ModuleInfoVo vo= objectMapper.readValue(a,ModuleInfoVo.class);
        System.out.println(1);
    }
}
