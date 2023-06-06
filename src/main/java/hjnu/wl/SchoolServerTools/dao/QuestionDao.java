package hjnu.wl.SchoolServerTools.dao;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 0:09

import hjnu.wl.SchoolServerTools.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

/***
 * 疑难解答
 */
@Mapper
public interface QuestionDao
{
    /***
     * 发布问题
     */
    @Insert("insert into question(quizzerId,question,releaseTime,state) values(#{quizzerId},#{question},#{releaseTime},#{state})")
    boolean releaseQuestion(String quizzerId,String question,String releaseTime,String state);

    /***
     * 回答问题
     */
    @Update("update question set answererId=#{answererId},answer=#{answer},answerTime=#{answerTime} where questionId=#{questionId} and state='1'")
    boolean answerQuestion(int questionId,String answererId,String answer,String answerTime);

    /***
     * 查询所有问题
     */
    @Select("select * from question where state='1'")
    ArrayList<Question> getAllQuestions();

    /***
     * 查询所有未回答的问题
     */
    @Select("select * from question where answererId is null and answer is null and state='1'")
    ArrayList<Question> getAllUnansweredQuestions();

    /***
     * 查询所有已回答的问题
     */
    @Select("select * from question where answererId is not null and answer is not null and state='1'")
    ArrayList<Question> getAllAnsweredQuestions();

    /***
     * 删除问题
     */
    @Update("update question set state='0' where questionId=#{questionId}")
    boolean deleteQuestion(int questionId);
}