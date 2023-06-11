package hjnu.wl.SchoolServerTools.dao;

import hjnu.wl.SchoolServerTools.domain.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.ArrayList;

/***
 * @author wule
 * 二手货
 */
@Mapper
public interface TransactionsDao
{
    /***
     * 发布二手货
     * 测试通过
     */
    @Insert("insert into transaction(sellerId,phoneNumber,goodsName,goodsPrice,goodsDescribe,goodsImage,releaseTime,state) values(#{sellerId},#{phoneNumber},#{goodsName},#{goodsPrice},#{goodsDescribe},#{goodsImage},#{releaseTime},#{state})")
    boolean releaseTransaction(String sellerId,String phoneNumber,String goodsName,String goodsPrice,String goodsDescribe,String goodsImage,String releaseTime,String state);

    /***
     * 查询所有二手货信息
     * 测试通过
     */
    @Select("select * from transaction where state='1' order by releaseTime")
    ArrayList<Transaction> getAllTransactions();

    /**查询二手货总数**/
    @Select("select count(transactionId) from transaction where state='1'")
    int getCount();

    /**分页查询二手货**/
    @Select("select * from transaction where state='1' order by  releaseTime limit #{n},#{m}")
    ArrayList<Transaction> getLimitTransactions(int n,int m);

    /***
     * 根据id查询二手货信息
     * 测试通过
     */
    @Select("select * from transaction where transactionId=#{transactionId} and state='1'")
    Transaction getTransactionById(int transactionId);

    /***
     * 删除二手货售卖信息
     * 测试通过
     */
    @Update("update transaction set state='0' where transactionId=#{transactionId}")
    boolean deleteTransaction(int transactionId);
}