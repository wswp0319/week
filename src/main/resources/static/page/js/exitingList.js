layui.config({
    base: "js/"
}).use(['form', 'layer', 'jquery', 'laypage'], function () {
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery;
    //加载页面数据
    var newsData = '';
    $.get("/getExitings", function (data) {

        var newArray = [];
        //单击首页“待审核文章”加载的信息
        if ($(".top_tab li.layui-this cite", parent.document).text() == "待审核文章") {
            if (window.sessionStorage.getItem("addNews")) {
                var addNews = window.sessionStorage.getItem("addNews");
                newsData = JSON.parse(addNews).concat(data);
            } else {
                newsData = data;
            }
            for (var i = 0; i < newsData.length; i++) {
                if (newsData[i].newsStatus == "待审核") {
                    newArray.push(newsData[i]);
                }
            }
            newsData = newArray;
            newsList(newsData);
        } else {    //正常加载信息
            // console.log(data);
            // console.log(data.data);
            newsData = data.data;
            if (window.sessionStorage.getItem("addNews")) {
                var addNews = window.sessionStorage.getItem("addNews");
                newsData = JSON.parse(addNews).concat(newsData);
            }
            //执行加载数据的方法
            newsList();
        }
    })

    //查询
    $(".search_btn").click(function () {
        var newArray = [];

        if (($(".search_input").val() != '') || $(".start_data").val() != '' || $(".end_data").val() != '') {
            var index = layer.msg('查询中，请稍候', {icon: 16, time: false, shade: 0.8});
            var dept = $(".search_input").val();
            var planStartDate = $(".start_data").val();
            var planEndDate = $(".end_data").val();
            // console.log(dept + "          " + sd + "         " + ed);
            setTimeout(function () {
                $.ajax({
                    // url : "../../json/newsList.json",
                    url: "/getExitings",
                    type: "get",
                    dataType: "json",
                    data: {dept: dept, planStartDate: planStartDate, planEndDate: planEndDate},
                    success: function (data) {
                        newsData = data.data;
                        if (window.sessionStorage.getItem("addNews")) {
                            var addNews = window.sessionStorage.getItem("addNews");
                            newsData = JSON.parse(addNews).concat(newsData);
                        }
                        //执行加载数据的方法
                        newsList();
                    }
                })
                layer.close(index);
            }, 500);
        } else {
            layer.msg("请输入需要查询的内容");
        }
    })

    //添加文章
    //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
    $(window).one("resize", function () {
        $(".newsAdd_btn").click(function () {
            var index = layui.layer.open({
                title: "添加文章",
                type: 2,
                content: "newsAdd.html",
                success: function (layero, index) {
                    setTimeout(function () {
                        layui.layer.tips('点击此处返回文章列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    }, 500)
                }
            })
            layui.layer.full(index);
        })
    }).resize();


    //审核文章
    $(".audit_btn").click(function () {
        var $checkbox = $('.news_list tbody input[type="checkbox"][name="checked"]');
        var $checked = $('.news_list tbody input[type="checkbox"][name="checked"]:checked');
        if ($checkbox.is(":checked")) {
            var index = layer.msg('审核中，请稍候', {icon: 16, time: false, shade: 0.8});
            setTimeout(function () {
                for (var j = 0; j < $checked.length; j++) {
                    for (var i = 0; i < newsData.length; i++) {
                        if (newsData[i].newsId == $checked.eq(j).parents("tr").find(".news_del").attr("data-id")) {
                            //修改列表中的文字
                            $checked.eq(j).parents("tr").find("td:eq(3)").text("审核通过").removeAttr("style");
                            //将选中状态删除
                            $checked.eq(j).parents("tr").find('input[type="checkbox"][name="checked"]').prop("checked", false);
                            form.render();
                        }
                    }
                }
                layer.close(index);
                layer.msg("审核成功");
            }, 2000);
        } else {
            layer.msg("请选择需要审核的文章");
        }
    })

    //批量删除
    $(".batchDel").click(function () {
        var $checkbox = $('.news_list tbody input[type="checkbox"][name="checked"]');
        var $checked = $('.news_list tbody input[type="checkbox"][name="checked"]:checked');
        if ($checkbox.is(":checked")) {
            layer.confirm('确定删除选中的信息？', {icon: 3, title: '提示信息'}, function (index) {
                var index = layer.msg('删除中，请稍候', {icon: 16, time: false, shade: 0.8});
                setTimeout(function () {
                    //删除数据
                    for (var j = 0; j < $checked.length; j++) {
                        for (var i = 0; i < newsData.length; i++) {
                            if (newsData[i].newsId == $checked.eq(j).parents("tr").find(".news_del").attr("data-id")) {
                                newsData.splice(i, 1);
                                newsList(newsData);
                            }
                        }
                    }
                    $('.news_list thead input[type="checkbox"]').prop("checked", false);
                    form.render();
                    layer.close(index);
                    layer.msg("删除成功");
                }, 2000);
            })
        } else {
            layer.msg("请选择需要删除的文章");
        }
    })
   

    //全选
    form.on('checkbox(allChoose)', function (data) {
        var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
        child.each(function (index, item) {
            item.checked = data.elem.checked;
        });
        form.render('checkbox');
    });

    //通过判断文章是否全部选中来确定全选按钮是否选中
    form.on("checkbox(choose)", function (data) {
        var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
        var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
        if (childChecked.length == child.length) {
            $(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
        } else {
            $(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
        }
        form.render('checkbox');
    })

    //是否展示
    form.on('switch(isShow)', function (data) {
        var index = layer.msg('修改中，请稍候', {icon: 16, time: false, shade: 0.8});
        console.log(data);
        console.log(data.elem.value);
        var dailyId = data.elem.value;
        var checked = data.elem.checked;
        var claim = null;
        if (checked == true) {
            claim = 1;
        } else {
            claim = 0;
        }

        $.ajax({
            type: 'post',
            url: '/updateClaim',
            dataType: 'json',
            data: {dailyId: dailyId, claim: claim},
            success: function (result) {
                setTimeout(function () {
                    layer.close(index);
                    layer.msg(result.msg);
                }, 500);
            }
        });


    });

    //操作
    $("body").on("click", ".news_edit", function () {  //编辑
        var _this = $(this);
        console.log("--------------");
        $.ajax({
            type: 'get',
            url: '/canEdit',
            dataType: 'json',
            async: false,
            data: {dailyId: _this.attr("data-id")},
            success: function (result) {
                if (!result.success) {
                    layer.msg(result.msg);
                    return;
                } else {
                    location.href = "/editQuantity?quantityId=" + _this.attr("data-id");
                }
            }
        });

    })

    $("body").on("click", ".news_collect", function () {  //收藏.
        if ($(this).text().indexOf("已收藏") > 0) {
            layer.msg("取消收藏成功！");
            $(this).html("<i class='layui-icon'>&#xe600;</i> 收藏");
        } else {
            layer.msg("收藏成功！");
            $(this).html("<i class='iconfont icon-star'></i> 已收藏");
        }
    })


    $("body").on("click", ".news_del", function () {  //删除
        var _this = $(this);
        //_this.parents("tr").remove();
        // console.log(_this.attr("data-id"));
        layer.confirm('确定删除此信息？', {icon: 3, title: '提示信息'}, function (index) {

            $.ajax({
                type: 'post',
                url: '/delOneQuantity',
                dataType: 'json',
                data: {quantityId: _this.attr("data-id")},
                success: function (result) {
                    if (!result.success) {
                        layer.msg(result.msg);
                        return;
                    }
                    for (var i = 0; i < newsData.length; i++) {
                        if (newsData[i].id == _this.attr("data-id")) {
                            // console.log(result);
                            newsData.splice(i, 1);
                            newsList(newsData);
                        }
                    }
                }
                // error: alert()
            })
            layer.close(index);
        });
    })

    function newsList(that) {
        //渲染数据
        function renderDate(data, curr) {
            var dataHtml = '';
            if (!that) {
                currData = newsData.concat().splice(curr * nums - nums, nums);
            } else {
                currData = that.concat().splice(curr * nums - nums, nums);
            }

            if (currData.length != 0) {
                for (var i = 0; i < currData.length; i++) {
                    // console.log(currData[i].id);
                    var flag = ""
                    if (+currData[i].claim == '1') {
                        flag = "checked";
                    }
                    /**
                     <th>粮食种类</th>
                     <th>出库量</th>
                     <th>总数量</th>
                     <th>出库时间</th>
                     <th>备注</th>
                     id
                     grainNumber
                     outNum
                     outTime
                     isactive
                     remark

                     */


                    dataHtml += '<tr>'
                        + '<input type="hidden" name="dailyId" value=' + currData[i].id + ' >'
                        + '<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
                        + '<td align="left">' + currData[i].grainNumber + '</td>'
                        + '<td align="left">' + currData[i].outNum + '</td>'
                        + '<td>' + currData[i].outTime + '</td>'
                        // + '<td>' + currData[i].totalQuantity + '</td>'
                        // + '<td>' + currData[i].difference + '</td>'
                        // + '<td>' + currData[i].gradient + '</td>'
                        // // + '<td><img src=\"images/userface3.jpg\" width="165" height="60" /> </td>'
                        // // + '<td><img src=\"images/2616.jpg\" width="165" height="60" /> </td>'
                        // + '<td>' + currData[i].createTime + '</td>'
                        // + '<td>' + currData[i].updateTime + '</td>'
                        // + '<td>' + currData[i].checker + '</td>'
                        // + '<td><input type="checkbox" name="show" value=' + currData[i].id + ' lay-skin="switch" lay-text="是|否" lay-filter="isShow"' + flag + '></td>'
                        + '<td>' + currData[i].remark + '</td>'


                        // + '<td>'
                        // // + '<a class="layui-btn layui-btn-mini news_edit" data-id="' + currData[i].id + '"><i class="iconfont icon-edit"></i>编辑</a>'
                        // // + '<a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="' + currData[i].id + '"><i class="layui-icon">&#xe640;</i> 删除</a>'
                        // + '</td>'
                        + '</tr>';
                }
            } else {
                dataHtml = '<tr><td colspan="4">呀,数据居然不见了,请稍后重试一下吧!</td></tr>';
            }
            return dataHtml;
        }

        //分页
        var nums = 10; //每页出现的数据量
        if (that) {
            newsData = that;
        }
        laypage({
            cont: "page",
            pages: Math.ceil(newsData.length / nums),
            jump: function (obj) {
                $(".news_content").html(renderDate(newsData, obj.curr));
                $('.news_list thead input[type="checkbox"]').prop("checked", false);
                form.render();
            }
        })
    }
})
