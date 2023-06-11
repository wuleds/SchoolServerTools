package hjnu.wl.SchoolServerTools.dao;
//汉江师范学院 数计学院 吴乐创建于2023/6/7 0:09

import hjnu.wl.SchoolServerTools.domain.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.ArrayList;

/***
 * @author wule
 * 疑难解答
 */
@Mapper
public interface QuestionDao
{
    /***
     * 发布问题
     */
    @Insert("insert into question(quizzerId,question,notices,releaseTime,state) values(#{quizzerId},#{question},#{notices},#{releaseTime},#{state})")
    boolean releaseQuestion(String quizzerId,String question,String notices,String releaseTime,String state);

    /***
     * 回答问题
     */
    @Update("update question set answererId=#{answererId},answer=#{answer},answerTime=#{answerTime} where questionId=#{questionId} and state='1'")
    boolean answerQuestion(int questionId,String answererId,String answer,String answerTime);

    /***
     * 根据id查询问题
     */
    @Select("select * from question where questionId=#{questionId} and state='1'")
    Question getQuestionById(int questionId);

    /***
     * 查询所有问题
     */
    @Select("select * from question where state='1'")
    ArrayList<Question> getAllQuestions();

    /**分页查询**/
    @Select("select * from question where state = '1' limit #{n},#{m} ")
    ArrayList<Question> getLimitQuestions(int n,int m);

    /**查询问题总数**/
    @Select("select count(questionId) from question where state = '1'")
    int getCount();

    /***
     * 删除问题
     */
    @Update("update question set state='0' where questionId=#{questionId}")
    boolean deleteQuestion(int questionId);
}