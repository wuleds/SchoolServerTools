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
        url: "http://localhost/transaction/getAll",
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
            "<h5 class=\"card-title\">"+arr[i].goodsName+"</h5>\n" +
            "<p class=\"card-text\">"+arr[i].transactionId+"</p>\n" +
            "<p class=\"card-text\">发布者id:"+arr[i].sellerId+"</p>\n" +
            "<p class=\"card-text\">电话:"+arr[i].phoneNumber+"</p>\n" +
            "<p class=\"card-text\"><small class=\"text-muted\">价格："+arr[i].goodsPrice+"</small> </p>\n" +
            "<p class=\"card-text\">描述:"+arr[i].goodsDescribe+"</p>\n" +
            "</div>" +
            "<img width='300px' height='180px' alt=\"th\" src='http://localhost/download/"+arr[i].goodsImage +"'><br>\n" +
            arr[i].releaseTime+
            "</div>"
    }
    userData.append(temp);
}

function postLostItem() {
    var formData = new FormData($("#postForm")[0]);

    $.ajax({
        url: "http://localhost/transaction/release",
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