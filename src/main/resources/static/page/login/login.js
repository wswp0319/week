layui.config({
    base: "js/"
}).use(['form', 'layer'], function () {
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;
    //video背景
    $(window).resize(function () {
        if ($(".video-player").width() > $(window).width()) {
            $(".video-player").css({
                "height": $(window).height(),
                "width": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        } else {
            $(".video-player").css({
                "width": $(window).width(),
                "height": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        }
    }).resize();

    //登录按钮事件
    form.on("submit(login)", function (data) {
        // alert(data.field.username);
        // alert(data.field.password);
        console.log(data);

        var username = data.field.username;
        var password = data.field.password;

        $.ajax({
            // url : "../../json/newsList.json",
            url: "/join",
            type: "post",
            dataType: "json",
            /**
             * `plan_start_date` varchar(255) DEFAULT NULL COMMENT '计划开始时间',
             `plan_end_date`
             */
            data: {username: username, password: password},
            success: function (data) {
                if (data.success) {
                    location.href = "/index";
                } else {
                    // popup({type:'error',msg:'账户或密码错误！',delay:2000,bg:true,clickDomCancel:true});
                    layer.msg(data.msg);
                }
            },
            error: function (result, status, e) {
                alert("请求异常，请联系管理员");
            }
        })

        // window.location.href = "/index";
        return false;
    });
})

