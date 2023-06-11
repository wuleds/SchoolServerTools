package hjnu.wl.SchoolServerTools.domain;
//汉江师范学院 数计学院 吴乐创建于2023/6/9 21:40

public class PostNum
{
    private int count;
    private String json;

    public PostNum(){}

    public PostNum(int count,String json)
    {
        this.count = count;
        this.json = json;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}