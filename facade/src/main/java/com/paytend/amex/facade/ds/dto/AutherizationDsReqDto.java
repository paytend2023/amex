package com.paytend.amex.facade.ds.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author XX
 * 
 */
@Data
@Builder
public class AutherizationDsReqDto {

    /**
     * 卡号	string(13-19)
     */
    private String acctNumber;

    /**
     * 账户类型,
     * 可选值：
     * • 01 =不适用
     * • 02 =Credit
     * • 03 = Debit
     */
    private String acctType;

    /**
     * 收单机构号(DS分配的)
     */
    private String acquirerBIN;
    /**
     * 收单机构指定的商户标识符（收单行的商户号）
     */
    private String acquirerMerchantID;
    /**
     * 地址匹配指示器；
     * 可选值：
     * • Y = 发货地址与帐单地址一致
     * • N=发货地址与账单地址不一致
     */
    private String addrMatch;
    /**
     * 持卡人账单地址城市
     */

    private String billAddrCity;
    /**
     * 持卡人账单地址国家,ISO 3166的三位数字代码
     */
    private String billAddrCountry;
    /**
     * 持卡人账单地址第1行
     */
    private String billAddrLine1;
    /**
     * 持卡人账单地址第2行
     */
    private String billAddrLine2;
    /**
     * billAddrLine3
     */
    private String billAddrLine3;
    /**
     * billAddrPostCode
     */
    private String billAddrPostCode;
    /**
     * billAddrState
     */
    private String billAddrState;
    /**
     * 浏览器接受头
     */
    private String browserAcceptHeader;
    /**
     * 浏览器屏幕颜色深度
     * 可选值：
     * • 1 = 1 bit
     * • 4 = 4 bits
     * • 8 = 8 bits
     * • 15 =15 bits
     * • 16 = 16 bits
     * • 24 = 24 bits
     * • 32 = 32 bits
     * • 48 = 48 bits
     */
    private String browserColorDepth;
    /**
     * 浏览器IP地址 ，接收值为IPV4 /IPV6的地址
     */
    private String browserIP;
    /**
     * 启用浏览器Js
     * 可选值：
     * • true
     * • false
     */
    private String browserJavaEnabled;

    private String browserJavascriptEnabled;
    /**
     * 浏览器语言
     */
    private String browserLanguage;
    /**
     * 浏览器屏幕高度
     */
    private String browserScreenHeight;
    /**
     * 浏览器屏幕宽度
     */
    private String browserScreenWidth;
    /**
     * 浏览器时区,UTC和持卡人浏览器当地时间之间的时区偏移，以分钟为单位。
     * 请注意，如果本地时区落后于UTC，则偏移量为正，如果超前则为负 。从getTimezoneOffset()方法返回的值
     * 时区偏移值的例子，以分钟为单位：
     * 如果UTC-5小时：
     * •300
     * • +300
     * 如果UTC +5小时：
     * •-300
     */
    private String browserTZ;
    /**
     * 浏览器用户代理
     */
    private String browserUserAgent;
    /**
     * 卡到期日期 ，格式：YYMM
     */
    private String cardExpiryDate;
    /**
     * 持卡人姓名
     */
    private String cardholderName;
    /**
     * 设备通道 ,
     * 可选值：
     * • 01= APP
     * •02=BRW
     * •03 3RI
     */
    private String deviceChannel;
    /**
     * 持卡人电子邮件地址
     */
    private String email;
    /**
     * 持卡人家庭电话号码
     */
    private String homePhone;
    /**
     * 持卡人手机号码
     */
    private String mobilePhone;
    /**
     * 持卡人工作电话号码
     */
    private String workPhone;
    /**
     * 商户类别代码
     */
    private String mcc;
    /**
     * 商户国家代码 ,ISO3166-1标准中的三位数字国家代码
     */
    private String merchantCountryCode;
    /**
     * 商户名称(与ISO 8583中定义的授权信息中使用的名称相同) ，即收单行商户名称，需与acquirerMerchantID对应
     */
    private String merchantName;
    /**
     * 商户风险指标
     */
    private String merchantRiskIndicator;
    /**
     * 消息类别
     * 可选值：
     * • 01 = 支付认证（交易中持卡人认证）-PA
     * • 02 = 非支付认证 （身份验证和账户确认）-NPA
     */
    private String messageCategory;
    /**
     * 消息扩展 ，此字段由每个卡组织设定的灵活参数
     */
    private String messageExtension;
    /**
     * 消息版本,3DS协议版本
     */
    private String messageVersion;
    /**
     * 回调通知URL，接收来自ACS返回的挑战结果信息 （回调的参数看下示例）
     */
    private String notificationURL;
    /**
     * 购物金额；以货币的小单位表示，去掉所有标点符号
     */
    private String purchaseAmount;
    /**
     * 购物货币，按照ISO4217-三位数字代码
     */
    private String purchaseCurrency;
    /**
     * 购物日期和时间 日期时间格式：YYYYMMDDHHMMSS
     */
    private String purchaseDate;
    /**
     * 指示分期付款所允许的最大授权数
     */
    private String purchaseInstalData;
    /**
     * 3RI指标
     * 可选值：
     * • 01 = 循环付款交易
     * • 02 = 分期付款交易
     * •03 = 添加卡片
     * • 04 = 维护卡片信息
     * • 05 = 账户验证
     * •06 = 分批/延时发货
     * •07 = 充值
     * •08 = 邮购
     * •09 = 电话订购
     * •10 = 白名单状态检查
     * •11 = 其他付款
     */
    private String threeRIInd;

    /**
     * 在此日期之后将不 再执行任何授权 ，日期格式：YYYYMMDD
     */
    private String recurringExpiry;
    /**
     * 表示两次授权之间的最小天数
     */
    private String recurringFrequency;
    /**
     * 持卡人发货地址城市
     */
    private String shipAddrCity;
    /**
     * 持卡人发货地址国家 ,ISO 3166-1中三位数字国家代码
     */
    private String shipAddrCountry;
    /**
     * 持卡人发货地址第1行
     */
    private String shipAddrLine1;
    /**
     * 持卡人发货地址第2行
     */
    private String shipAddrLine2;
    /**
     * 持卡人发货地址第3行
     */
    private String shipAddrLine3;
    /**
     * 持卡人发货地址邮政编码
     */
    private String shipAddrPostCode;
    /**
     * 持卡人发货地址州，按照ISO 3166-2 标准
     */
    private String shipAddrState;
    /**
     * 3DS方法完成指标，
     * 可选值：
     * • Y=成功完成
     * • N 没有成功完成
     * • U =不可用-3DS方法URL不存在于与持卡人帐号相关的卡片范围的PRes信息数据中
     */
    private String threeDSCompInd;

    /**
     *  	3DS请求者身份验证指示器
     * 可选值：
     * • 01=付款交易,
     * •02=循环交易,
     * •03=分期交易,
     * •04=添加卡,
     * •05=维护卡,
     * •06=持卡人验证作为EMV令牌ID&V的一部分
     */
    private String threeDSRequestorAuthenticationInd;

    private String threeDSRequestorAuthenticationInfo;
    /**
     * 3DS请求者挑战指标，表示此交易是否要求挑战
     * 例如：01-PA，一个3DS申请人可能对该交易有顾虑，并要求进行质疑。对于02-NPA，在向钱包添加新卡时，可能需要质疑。对于地方/区域授权或其他变量
     * 可选值：
     * • 01=没有偏好，
     * •02=不请求挑战，
     * • 03=请求挑战（3DS请求者要求），
     * • 04=请求挑战（强制），
     * • 05=不要求挑战(已执行了交易性风险分析)，
     * • 06=不要求挑战（只是数据分享），
     * • 07= 不要求挑战（已执行了较强的消费者身份验证），
     * • 08= 不要求挑战（如果不要求挑战，则利用白名单豁免），
     * • 09=要求挑战（如果要求挑战，则要求白名单提示）
     */
    private String threeDSRequestorChallengeInd;
    /**
     * 3DS Requestor解耦最大时间
     * 表示3DS请求者等待ACS提供解耦认证事务结果的最长时间(分钟)。
     * 接受1至10080之间的数值
     */
    private String threeDSRequestorDecMaxTime;
    /**
     * 3DS Requestor解耦请求指示器
     * 指示3DS请求者是否请求ACS使用解耦身份验证，并在ACS确认使用时同意使用解耦身份验证
     * 可选值：
     * • Y = 如果需要挑战，则支持并首选解耦身份验证
     * • N = 不使用解耦的身份验证
     * 注意：如果没有提供该元素，预期的动作是ACS解释为N，不使用解耦认证
     */
    private String threeDSReqAuthMethodInd;
    /**
     * 事务类型；
     * 可选值
     * •01 = 货物/服务采购
     * • 03 = 检查验收
     * •10 = 账户资金（例如：充值钱包，加载预付卡或为个人对个人转账提供资金）
     * •11 = 准现金交易
     * •28 = 预付费激活和加载
     */
    private String transType;
    /**
     * SDK应用程序ID
     */
    private String sdkAppID;
    /**
     * SDK加密数据
     */
    private String sdkEncData;
    /**
     * SDK临时公钥（QC）
     */
    private String sdkEphemPubKey;
    /**
     * SDK最大超时时间，大于5分钟
     */
    private String sdkMaxTimeout;
    /**
     * SDK参考编号
     */
    private String sdkReferenceNumber;
    /**
     * SDK事务ID
     */
    private String sdkTransID;
    /**
     * 白名单状态,使ACS、DS和3DS请求者之间能够进行可信受益人/白名单状态的通信
     * 可选值：
     * • Y = 3DS请求者被持卡人列入白名单
     * • N = 持卡人未将3DS请求人列入白名单
     * • E = 发卡机构确定不符合条件
     * • P = 正在等待持卡人的确认
     * • R = 持卡人拒绝
     * • U = 白名单状态未知，不可用，或不适用
     */
    private String whiteListStatus;
    /**
     * 白名单信息文本,由系统设置白名单状态来填充
     * 可选值：
     * •01 = 3DS服务器
     * •02 = DS
     * •03 = ACS
     */
    private String whiteListStatusSource;

    private String requestUrl;

    @Tolerate
    public AutherizationDsReqDto() {
    }
}
