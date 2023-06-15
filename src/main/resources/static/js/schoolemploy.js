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

function fetchLostItems() {
    $.ajax({
        url: "http://localhost/schoolEmploy/getAll",
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
            "<h5 class=\"card-title\">"+arr[i].jobName+"</h5>\n" +
            "<p class=\"card-text\">"+arr[i].hrName+"</p>\n" +
            "<p class=\"card-text\">工资:"+arr[i].salary+"</p>\n" +
            "<p class=\"card-text\">电话:"+arr[i].hrPhoneNumber+"</p>\n" +
            "<p class=\"card-text\"><small class=\"text-muted\">"+arr[i].companyName+"</small> </p>\n" +
            "<p class=\"card-text\">要求:"+arr[i].jobPower+"</p>\n" +
            "<p class=\"card-text\">工作内容:"+arr[i].jobContent+"</p>\n" +
            "<p class=\"card-text\">备注:"+arr[i].jobNotices+"</p>\n" +
            "</div>" +
            "<img width='300px' height='180px' alt=\"th\" src='http://localhost/download/"+arr[i].image +"'><br>\n" +
            arr[i].releaseTime+
            "</div>"
    }
    userData.append(temp);
}

function postLostItem() {
    var formData = new FormData($("#postForm")[0]);

    $.ajax({
        url: "http://localhost/schoolEmploy/release", // 根据实际情况替换为API的URL
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