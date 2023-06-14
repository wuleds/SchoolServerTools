$(document).ready(function() {
    // 当页面加载完成时执行以下代码
    // 获取失物招领帖子并展示
    fetchLostItems();

    getCookie("edu.hjnu.wl-userId");
    // 提交发布失物招领的表单
    $("#postForm").submit(function(event) {
        event.preventDefault();
        postLostItem();
    });
});

function fetchLostItems() {
    $.ajax({
        url: "http://localhost/lostFound/getAll", // 根据实际情况替换为API的URL
        method: "GET",
        success: function(response) {
            // 处理成功响应，将帖子展示在页面上
            displayLostItems(response);
        },
        error: function() {
            // 处理错误响应
            alert("获取失物招领帖子失败，请稍后重试。");
        }
    });
}

function displayLostItems()
{
        //获取tbody
        let userData = $("#lostFounds");
        let temp = '';
        $.ajax({
            //请求路径servlet
            url: "http://localhost/lostFound/getAll",
            type: "get",
            dataType: "json",
            async: true,//是否异步
            //请求成功
            success: function (msg){
                let lostFounds = msg;
                userData.empty();//清空
                for (let i = 0; i < lostFounds.length; i++) {
                    temp += "<div style=\"float: left;margin-left: 20px;margin-top: 20px;border:black solid 1px;\">\n" +
                        "  <div>帖子id："+ lostFounds[i].lostFoundId +"</div>\n" +
                        "  <div>用户id："+ lostFounds[i].userId +"</div>\n" +
                        "  <div>物品名:"+ lostFounds[i].thingName +"</div>\n" +
                        "  <div>描述："+ lostFounds[i].thingDescribe +"</div>\n" +
                        "  <div>电话："+ lostFounds[i].phoneNumber +"</div>\n" +
                        "  <img width='300px' height='180px' alt=\"th\" src='http://localhost/download/"+ lostFounds[i].thingImage +"'><br>\n" +
                        lostFounds[i].releaseTime+
                        "</div>"
                }
                userData.append(temp);
            },
            //请求失败
            error: function (e) {
                alert("ERROR")
            }
        })
}

function postLostItem() {
    var formData = new FormData($("#postForm")[0]);

    $.ajax({
        url: "http://localhost/lostFound/release", // 根据实际情况替换为API的URL
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
            alert("发布失物招领失败，请稍后重试。");
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