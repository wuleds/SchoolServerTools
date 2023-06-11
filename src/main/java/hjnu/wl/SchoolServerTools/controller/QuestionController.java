package hjnu.wl.SchoolServerTools.controller;
//汉江师范学院 数计学院 吴乐创建于2023/6/8 0:20

import hjnu.wl.SchoolServerTools.domain.PostNum;
import hjnu.wl.SchoolServerTools.domain.Question;
import hjnu.wl.SchoolServerTools.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/question")
public class QuestionController
{
    public static QuestionService questionService;
    @Autowired
    public void setQuestionService(QuestionService questionService)
    {
        QuestionController.questionService = questionService;
    }

    /**发布问题**/
    @RequestMapping("/release")
    @ResponseBody
    public String releaseQuestion(Question question)
    {
        String quizzerId = question.getQuizzerId();
        String questionContext = question.getQuestion();
        String notices = question.getNotices();

        return questionService.releaseQuestion(quizzerId,questionContext,notices);

    }

    /**回答问题**/
    @RequestMapping("/answer")
    @ResponseBody
    public String answerQuestion(Question question)
    {
        int questionId = question.getQuestionId();
        String answererId = question.getAnswererId();
        String answer = question.getAnswer();

        return questionService.answerQuestion(questionId,answererId,answer);
    }

    /**分页查询**/
    @RequestMapping("/limit")
    @ResponseBody
    public PostNum getLimit(int n, int m)
    {
        return questionService.getLimitQuestions(n,m);
    }

    /**获取问题总数**/
    @RequestMapping("/getCount")
    @ResponseBody
    public int getCount()
    {
        return questionService.getCount();
    }

    /**获取所有问题**/
    @RequestMapping("/getAll")
    @ResponseBody
    public PostNum getAll()
    {
        return questionService.getAllQuestions();
    }

    /**根据Id获取问题**/
    @RequestMapping("/getById")
    @ResponseBody
    public PostNum getById(int questionId)
    {
        return questionService.getQuestionById(questionId);
    }

    /**删除问题**/
    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteQuestion(int questionId)
    {
        return questionService.deleteQuestion(questionId);
    }
}