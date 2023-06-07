package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 23:20

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.QuestionDao;
import hjnu.wl.SchoolServerTools.util.GetNowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * 疑难解答
 */
@Service
public class QuestionService
{
    private static QuestionDao questionDao;
    @Autowired
    public void setQuestionDao(QuestionDao questionDao)
    {
        QuestionService.questionDao=questionDao;
    }

    /***
     * 发布问题
     * 测试通过
     */
    public static String releaseQuestion(String quizzerId,String question,String notices)
    {
        try{
            if(question.length() < 1 || question.length() > 100)
                return "QuestionLengthError";
            if(notices.length() < 1 || notices.length() > 100)
                return "NoticesLengthError";
        }catch (NullPointerException e){
            return "NullPointerException";
        }

        if(questionDao.releaseQuestion(quizzerId,question,notices, GetNowTime.getNowTime(),"1"))
            return "ReleaseQuestionSuccess";

        return "ReleaseQuestionFailure";
    }

    /***
     * 回答问题
     * 测试通过
     */
    public String answerQuestion(int questionId,String answererId,String answer)
    {
        try{
            if(answer.length() < 1 || answer.length() > 100)
                return "AnswerLengthError";
        }catch (NullPointerException e){
            return "NullPointerException";
        }

        if(questionDao.answerQuestion(questionId,answererId,answer,GetNowTime.getNowTime()))
            return "AnswerQuestionSuccess";

        return "AnswerQuestionFail";
    }

    /***
     * 查询所有问题
     * 测试通过
     */
    public String getAllQuestions()
    {
        String json = JSON.toJSONString(questionDao.getAllQuestions());
        return json;
    }

    /***
     * 根据id查询问题
     * 测试通过
     */
    public String getQuestionById(int questionId)
    {
        String json = JSON.toJSONString(questionDao.getQuestionById(questionId));
        return json;
    }

    /***
     * 删除问题
     * 测试通过
     */
    public String deleteQuestion(int questionId)
    {
        if(questionDao.deleteQuestion(questionId))
            return "DeleteQuestionSuccess";

        return "DeleteQuestionFail";
    }
}