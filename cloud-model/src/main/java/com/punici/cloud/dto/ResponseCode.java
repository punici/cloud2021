package com.punici.cloud.dto;

public enum ResponseCode
{
    FAIL(-1, "处理失败"),
    SUCCESS(100, "处理成功"),
    SOFTWARE_UPDATE(162, "客户端强制升级"),
    TOO_MANY_REQUESTS(429, "请求太频繁，请稍后再试"),
    ORDER_SUBMIT_BUSINESS_EXCEPTION(603, "订单校验业务异常"),
    ORDER_VALIDATE_EXCEPTION(604, "订单校验失败"),
    ORDER_PAYSTATUS_SYNC_EXCEPTION(610, "订单支付状态同步失败"),
    ORDER_EXISTS(620, "订单已存在"),
    USER_EXISTS(711, "用户已存在"),
    USER_NOT_BIND(712, "用户已存在，但未绑定当前系统"),
    USER_NOT_EXISTS(713, "用户不存在"),
    FILE_IMPORT_FAIL(818, "文件导入失败"),
    SMS_SEND_FAIL(819, "短信发送失败"),
    CALL_FAIL(820, "接口调用失败"),
    MQ_SEND_FAIL(880, "消息发送失败"),
    LOCK_FAIL(890, "锁异常"),
    SERVER_EXCEPTION(900, "服务器异常，请您稍后访问"),
    BUSINESS_REQPARAM_EXCEPTION(901, "非法请求参数"),
    DATA_NOT_FOUND(902, "无数据记录"),
    CONCURRENT_REQUESTS(903, "并发重复请求"),
    BUSINESS_EXCEPTION(915, "业务异常"),
    JSON_PARSE_EXCEPTION(930, "json解析异常"),
    TOKEN_ABSENT_EXCEPTION(918, "token值为空"),
    TOKEN_EXPIRED_EXCEPTION(919, "登录已过期"),
    FEEDBACK_PROCESSED(920, "该反馈已处理"),
    GENERATE_REPORT_FAILED(1100, "生成报表失败"),
    GENERATED_RESULT_EMPTY(1101, "生成报表失败"),
    CAMPAIGN_STOCK_IS_NONE(1201, "活动库存已抢光"),
    CAMPAIGN_STOCK_LIMIT(1200, "活动库存不足"),
    CREATE_GROUP_COUNT_LIMIT(1202, "用户开团超过指定次数"),
    CREATE_SUPPORTER_COUNT_LIMIT(1203, "超过参与实例次数"),
    HAVE_SUPPORTED_INSTANCE(1204, "已参与实例"),
    CAMPAIGN_GROUPON_GROUP_IS_FULL(1205, "实例已满"),
    INSTANCE_IS_FULL_BUT_NOT_SUCCESS(1206, "实例已满，但未成功"),
    CAMPAIGN_ORDER_NOT_PAID(1207, "活动订单未支付"),
    CAMPAIGN_GROUP_IS_FULL(1208, "活动开团数量已满"),
    JOIN_SUPER_GROUPON_COUNT_IS_FULL(1209, "超级拼团参与次数已满"),
    CAMPAIGN_TX_NOT_CONSISTENCY(1299, "活动数据不一致"),
    DATA_SERVER_PARA_ERROR(1301, "参数错误"),
    DATA_SERVER_SIGN_ERROR(1302, "sign错误"),
    POINTS_NOT_ENOUGH_LIMIT(1400, "积分不足"),
    MS_EXCEPTION(10000, "微服务调用异常"),
    CALL_WARES_ERROR(10001, "调用商品库微服务异常"),
    CALL_USER_ERROR(10002, "调用用户微服务异常"),
    CALL_CAMPAIGN_ERROR(10003, "调用活动微服务异常"),
    CALL_CHANNEL_ERROR(10004, "调用渠道微服务异常"),
    CALL_CART_ERROR(10005, "调用购物车微服务异常"),
    CALL_EXPRESS_ERROR(10006, "调用物流微服务异常"),
    CALL_VIP_ERROR(10007, "调用会员微服务异常"),
    CALL_ORDER_ERROR(10008, "调用订单微服务异常"),
    CALL_SETTLE_ERROR(10009, "调用结算微服务异常"),
    CALL_CS_ERROR(10010, "调用售后微服务异常"),
    BARGAIN_SPONSOR_LIMIT_ERROR(9801, "已参与过该活动，不能重复参与"),
    BARGAIN_HAD_SUPPORTED_ERROR(9802, "已帮好友砍过了"),
    BARGAIN_CURR_SUPPORTED_ERROR(9803, "已帮好友砍过了，明天再来吧"),
    BARGAIN_HAD_FINISHED_ERROR(9804, "砍不动了，已被砍到低价了"),
    BARGAIN_USER_COUNT_LIMIT_ERROR(9805, "砍价人数已达上限"),
    BARGAIN_STOCK_LIMIT_ERROR(9806, "活动太火爆，商品被抢完了"),
    BARGAIN_FOR_SELF_ERROR(9887, "不能给自己砍价"),
    BARGAIN_SPONSOR_RECIVED_ERROR(9886, "好友已砍价成功，你也来参加吧"),
    OMS_SYNC_EXPRESS_ERROR(23700, "OFC同步物流单异常");
    private final Integer code;
    
    private final String desc;
    
    ResponseCode(Integer code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
    
    public Integer getCode()
    {
        return this.code;
    }
    
    public String getDesc()
    {
        return this.desc;
    }
    
    public static ResponseCode getByCode(Integer code)
    {
        ResponseCode s = FAIL;
        ResponseCode[] var2 = values();
        
        for(ResponseCode e : var2)
        {
            if(e.code.equals(code))
            {
                s = e;
                break;
            }
        }
        
        return s;
    }
}
