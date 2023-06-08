package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 20:49

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.TransactionsDao;
import hjnu.wl.SchoolServerTools.util.GetNowTime;
import hjnu.wl.SchoolServerTools.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 二手货业务
 */
@Service
public class TransactionService
{
    private static TransactionsDao transactionsDao;
    @Autowired
    public void setTransactionsDao(TransactionsDao transactionsDao)
    {
        TransactionService.transactionsDao = transactionsDao;
    }

    /**发布二手货信息
     * 测试通过*/
    public String releaseTransaction(String sellerId,String phoneNumber,String goodsName,String goodsImageMd5,String goodsPrice,String goodsDescribe)
    {
        try{
            if(phoneNumber.length() != 11)
                return "phoneNumberLengthError";
            if(goodsName.length() < 1 || goodsName.length() > 10)
                return "goodsNameLengthError";
            if(goodsPrice.length() < 1 || goodsPrice.length() > 10)
                return "goodsPriceLengthError";
            if(goodsDescribe.length() < 1 || goodsDescribe.length() > 100)
                return "goodsDescribeLengthError";
        }catch (NullPointerException e){
            e.printStackTrace();
            return "NullPointerException";
        }

        if(transactionsDao.releaseTransaction(sellerId,phoneNumber,goodsName,goodsPrice,goodsDescribe,goodsImageMd5, GetNowTime.getNowTime(),"1"))
            return "ReleaseTransactionSuccess";
        return "ReleaseTransactionFail";
    }

    /**查询所有二手货信息
     * 测试通过*/
    public String getAllTransactions()
    {
        String json = JSON.toJSONString(transactionsDao.getAllTransactions());
        return json;
    }

    /**根据id查询二手货信息
     * 测试通过*/
    public String getTransactionById(int transactionId)
    {
        String json = JSON.toJSONString(transactionsDao.getTransactionById(transactionId));
        return json;
    }

    /**删除二手货信息
     *测试通过*/
    public String deleteTransaction(int transactionId)
    {
        if(transactionsDao.deleteTransaction(transactionId))
            return "DeleteTransactionSuccess";
        return "DeleteTransactionFail";
    }
}