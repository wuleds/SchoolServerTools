$(document).ready(function() {
    // 当页面加载完成时执行以下代码
    // 获取并展示
    fetchLostItems();
    // 提交表单
    $("#postForm").submit(function(event) {
        event.preventDefault();
        postLostItem();
    });
});
let id;
function fetchLostItems() {
    $.ajax({
        url: "http://localhost/question/getAll",
        method: "GET",
        success: function(response) {
            // 处理成功响应，将帖子展示在页面上
            displayLostItems(response);
        },
        error: function() {
            // 处理错误响应
            alert("获取失败，请稍后重试。");
        }
    });
}

function displayLostItems(msg)
{
    //获取tbody
    let userData = $("#list");
    let temp = '';
    let arr = msg;
    userData.empty();//清空
    for (let i = 0; i < arr.length; i++) {
        temp += "<div class=\"card\">" +
            " <div class=\"card-body\">\n" +
            "<h5 class=\"card-title\">"+arr[i].question+"</h5>\n" +
            "<h5 class=\"card-title\">"+arr[i].questionId+"</h5>\n" +
            "<p class=\"card-text\">提问者:"+arr[i].quizzerId+"</p>\n" +
            "<p class=\"card-text\">描述:"+arr[i].notices+"</p>\n" +
            "提问时间："+arr[i].releaseTime;
        if(arr[i].answer!=null)
        {
            temp += "<p class=\"card-text\">回答："+arr[i].answer+"</p>\n" +
                "<p class=\"card-text\">回答者:"+arr[i].answererId+"</p>\n" +
                "</div>" +
                "回答时间："+arr[i].answerTime+
                "</div>";
        }else{
            id = arr[i].questionId;
            temp += "<p class=\"card-text\">暂无回答</p>\n" +
                "<textarea id='answer' name='answer'></textarea>"+
                "<input type='button' value='回答' onclick='answer()'>"+
                "</div>"+
                "</div>";
        }
    }
    userData.append(temp);
}

function answer(){
    let answer = $("#answer").val();
    $.ajax({
        url: "http://localhost/question/answer",
        method: "POST",
        data: {
            answer:answer,
            answererId:"123456",
            questionId:id
        },
        success: function(response) {
            // 处理成功响应，将帖子展示在页面上
            fetchLostItems();
            $("#postForm")[0].reset(); // 清空表单
        },
        error: function() {
            // 处理错误响应
            alert("回答失败，请稍后重试。");
        }
    });
}

function postLostItem() {
    var formData = new FormData($("#postForm")[0]);

    $.ajax({
        url: "http://localhost/question/release",
        method: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function(response) {
            // 发布成功后刷新帖子列表
            fetchLostItems();
            $("#postForm")[0].reset(); // 清空表单
            alert("发布成功！");
        },
        error: function() {
            // 处理错误响应
            alert("发布失败，请稍后重试。");
        }
    });
}