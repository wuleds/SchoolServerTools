package hjnu.wl.SchoolServerTools.domain;
//汉江师范学院 数计学院 吴乐创建于2023/6/6 22:03

/**
 * @author wule
 * 二手货
 */
public class Transaction
{
    private int transactionId;      //二手货信息id
    private String sellerId;        //卖家id
    private String phoneNumber;     //联系电话
    private String goodsName;       //商品名称
    private String goodsPrice;      //商品价格
    private String goodsDescribe;   //商品描述
    private String goodsImage;      //商品图片
    private String releaseTime;     //发布时间
    private String state;           //状态

    public Transaction(){}

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                ", goodsImage='" + goodsImage + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
