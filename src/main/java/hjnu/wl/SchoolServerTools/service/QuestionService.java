package hjnu.wl.SchoolServerTools.service;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 23:20

import com.alibaba.fastjson.JSON;
import hjnu.wl.SchoolServerTools.dao.QuestionDao;
import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.domain.Question;
import hjnu.wl.SchoolServerTools.util.GetNowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    public String releaseQuestion(String quizzerId,String question,String notices)
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
    public PostNum getAllQuestions()
    {
        ArrayList<Question> list = questionDao.getAllQuestions();
        String json = JSON.toJSONString(list);
        PostNum postNum = new PostNum(list.size(),json);
        return postNum;
    }

    /**分页查询**/
    public PostNum getLimitQuestions(int n,int m)
    {
        ArrayList<Question> list = questionDao.getLimitQuestions(n,m);
        String json = JSON.toJSONString(list);
        PostNum postNum = new PostNum(list.size(),json);
        return postNum;
    }

    /**获得问题总数**/
    public int getCount()
    {
        return questionDao.getCount();
    }

    /***
     * 根据id查询问题
     * 测试通过
     */
    public PostNum getQuestionById(int questionId)
    {
        Question question = questionDao.getQuestionById(questionId);
        String json = JSON.toJSONString(question);

        PostNum postNum = new PostNum("null".equals(json)?0:1,json);
        return postNum;
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