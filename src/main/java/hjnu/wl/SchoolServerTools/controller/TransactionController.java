package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/8 0:20

import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.domain.Transaction;
import hjnu.wl.SchoolServerTools.service.TransactionService;
import hjnu.wl.SchoolServerTools.util.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**二手货**/
@CrossOrigin
@Controller
@RequestMapping("/transaction")
public class TransactionController
{
    private static TransactionService transactionService;
    @Autowired
    private void setTransactionService(TransactionService transactionService)
    {
        TransactionController.transactionService = transactionService;
    }

    /**发布二手货**/
    @RequestMapping("/release")
    @ResponseBody
    public String releaseTransaction(@RequestParam("file") MultipartFile file, @ModelAttribute Transaction transaction)
    {
        String sellerId = transaction.getSellerId();
        String phoneNumber = transaction.getPhoneNumber();
        String goodsName = transaction.getGoodsName();
        String goodsPrice = transaction.getGoodsPrice();
        String goodsDescribe = transaction.getGoodsDescribe();
        String goodsImage = "null";

        System.out.println("接收请求");

        // 处理文件
        if (!file.isEmpty()) {
            goodsImage = FileSave.saveFile(file);
        }
        String result = transactionService.releaseTransaction(sellerId,phoneNumber,goodsName,goodsImage,goodsPrice,goodsDescribe);
        System.out.println(result);
        return result;
    }

    /**查询所有二手货信息**/
    @RequestMapping("/getAll")
    @ResponseBody
    public ArrayList<Transaction> getAllTransactions()
    {
        return transactionService.getAllTransactions();
    }

    /**分页查询二手货信息**/
    @RequestMapping("/getTransactionsByPage")
    @ResponseBody
    public PostNum getTransactionsByPage(int n,int m)
    {
        return transactionService.getLimitTransactions(n,m);
    }

    /**查询所有二手货的数量**/
    @RequestMapping("/getTransactionsNum")
    @ResponseBody
    public int getTransactionsNum()
    {
        return transactionService.getCount();
    }

    /**根据id删除二手货信息**/
    @RequestMapping("/deleteTransactionById")
    @ResponseBody
    public String deleteTransactionById(int id)
    {
        return transactionService.deleteTransaction(id);
    }

    /**根据id查询二手货信息**/
    @RequestMapping("/getTransactionById")
    @ResponseBody
    public PostNum getTransactionById(int id)
    {
        return transactionService.getTransactionById(id);
    }
}