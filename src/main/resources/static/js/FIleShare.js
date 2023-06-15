$(document).ready(function() {
    // 当页面加载完成时执行以下代码
    // 获取并展示
    fetchLostItems();

    getCookie("edu.hjnu.wl-userId");
    // 提交表单
    $("#postForm").submit(function(event) {
        event.preventDefault();
        postLostItem();
    });
});

function fetchLostItems() {
    $.ajax({
        url: "http://localhost/fileShare/getAll", // 根据实际情况替换为API的URL
        method: "GET",
        success: function(response) {
            // 处理成功响应，将帖子展示在页面上
            displayLostItems(response);
        },
        error: function() {
            // 处理错误响应
            alert("获取帖子失败，请稍后重试。");
        }
    });
}

function displayLostItems(msg)
{
    //获取tbody
    let userData = $("#fileShareDiv");
    let temp = '';
    let fileShare = msg;
    userData.empty();//清空
    for (let i = 0; i < fileShare.length; i++) {
        temp += "<div style=\"float: left;margin-left: 20px;margin-top: 20px;border:black solid 1px;\">\n" +
            "  <div>帖子id："+ fileShare[i].fileShareId +"</div>\n" +
            "  <div>用户id："+ fileShare[i].sharerId +"</div>\n" +
            "  <div>描述："+ fileShare[i].notices +"</div>\n" +
            "  <a type='button' href='http://localhost/download/"+ fileShare[i].fileId +"'>下载资源</a><br>\n" +
            fileShare[i].shareTime+
            "</div>"
    }
    userData.append(temp);
}

function postLostItem() {
    var formData = new FormData($("#postForm")[0]);

    $.ajax({
        url: "http://localhost/fileShare/release", // 根据实际情况替换为API的URL
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

function getCookie(name) {
    var cookieArr = document.cookie.split(";");

    for(var i = 0; i < cookieArr.length; i++) {
        var cookiePair = cookieArr[i].split("=");
        var cookieKey = cookiePair[0].trim();

        if(cookieKey === name) {
            $("#userId").val(cookiePair[1]);
        }
    }
    return null;
}