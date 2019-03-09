layui.config({
    base: "js/"
}).use(['form', 'layer', 'jquery', 'layedit', 'laydate'], function () {
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;

    //创建一个编辑器
    var editIndex = layedit.build('news_content');
    var addNewsArray = [], addNews;
    form.on("submit(addNews)", function (data) {
        /**
         * claim: "on"
         data.field.contentDescription: "1"
         data.field.dailyId: ""
         data.field.demoAddress: "1"
         data.field.lookRole: "2"
         data.field.planB: ""
         data.field.planEndDate: "2018-11-23"
         data.field.planStartDate: "2018-11-23"
         data.field.remarks: ""
         data.field.submitContent: "1"
         data.field.workResult: "1"
         data.field.workSchedule: "100%"
         */
        console.log(data);
        // alert(data);
        //是否添加过信息
        if (window.sessionStorage.getItem("addNews")) {
            addNewsArray = JSON.parse(window.sessionStorage.getItem("addNews"));
        }
        //显示、审核状态
        var claim = data.field.claim == "on" ? 1 : 0;

        var contentDescription = data.field.contentDescription;
        var quantityId = data.field.quantityId;
        var demoAddress = data.field.demoAddress;
        var lookRole = data.field.lookRole;
        var planB = data.field.planB;
        var planEndDate = data.field.planEndDate;
        var planStartDate = data.field.planStartDate;
        var remarks = data.field.remarks;
        var submitContent = data.field.submitContent;
        var workResult = data.field.workResult;
        var workSchedule = data.field.workSchedule;

        // addNews = '{"workResult":"'+$(".newsName").val()+'",';  //文章名称
        // // addNews += '"newsId":"'+new Date().getTime()+'",';	 //文章id
        // addNews += '"newsLook":"'+$(".newsLook option").eq($(".newsLook").val()).text()+'",'; //开放浏览
        // addNews += '"newsTime":"'+$(".newsTime").val()+'",'; //发布时间
        // addNews += '"newsAuthor":"'+$(".newsAuthor").val()+'",'; //文章作者
        // addNews += '"claim":"'+ claim +'",';  //是否展示
        // addNews += '"newsStatus":"'+ newsStatus +'"}'; //审核状态
        // addNewsArray.unshift(JSON.parse(addNews));
        // window.sessionStorage.setItem("addNews",JSON.stringify(addNewsArray));
        //弹出loading
        // var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
        // setTimeout(function () {

        $.ajax({
            type: 'post',
            url: '/addOrUpdateQuantity',
            dataType: 'json',
            data: {
                quantityId: quantityId,
                claim: claim,
                contentDescription: contentDescription,
                demoAddress: demoAddress,
                lookRole: lookRole,
                planB: planB,
                planEndDate: planEndDate,
                planStartDate: planStartDate,
                remarks: remarks,
                submitContent: submitContent,
                workResult: workResult,
                workSchedule: workSchedule
            },
            // data: {claim: claim, contentDescription: contentDescription,​​demoAddress: demoAddress, lookRole: lookRole,planB: planB, planEndDate: planEndDate, planStartDate: planStartDate, remarks: remarks, submitContent: submitContent, workResult: workResult, workSchedule:workSchedule},
            success: function (result) {

            }
        })

        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            top.layer.close(index);
            top.layer.msg("文章添加成功！");
            layer.closeAll("iframe");
            //刷新父页面
            parent.location.reload();
        },2000);
        return false;
    });
    // form.on("submit(addNewsNew)", function (data) {
    //     /**
    //      * claim: "on"
    //      data.field.contentDescription: "1"
    //      data.field.dailyId: ""
    //      data.field.demoAddress: "1"
    //      data.field.lookRole: "2"
    //      data.field.planB: ""
    //      data.field.planEndDate: "2018-11-23"
    //      data.field.planStartDate: "2018-11-23"
    //      data.field.remarks: ""
    //      data.field.submitContent: "1"
    //      data.field.workResult: "1"
    //      data.field.workSchedule: "100%"
    //      */
    //     console.log(data);
    //     // alert(data);
    //     //是否添加过信息
    //     if (window.sessionStorage.getItem("addNews")) {
    //         addNewsArray = JSON.parse(window.sessionStorage.getItem("addNews"));
    //     }
    //     //显示、审核状态
    //     var claim = data.field.claim == "on" ? 1 : 0;
    //
    //     var contentDescription = data.field.contentDescription;
    //     // var =data.field.dailyId: ""
    //     var demoAddress = data.field.demoAddress;
    //     var lookRole = data.field.lookRole;
    //     var planB = data.field.planB;
    //     var planEndDate = data.field.planEndDate;
    //     var planStartDate = data.field.planStartDate;
    //     var remarks = data.field.remarks;
    //     var submitContent = data.field.submitContent;
    //     var workResult = data.field.workResult;
    //     var workSchedule = data.field.workSchedule;
    //
    //     // addNews = '{"workResult":"'+$(".newsName").val()+'",';  //文章名称
    //     // // addNews += '"newsId":"'+new Date().getTime()+'",';	 //文章id
    //     // addNews += '"newsLook":"'+$(".newsLook option").eq($(".newsLook").val()).text()+'",'; //开放浏览
    //     // addNews += '"newsTime":"'+$(".newsTime").val()+'",'; //发布时间
    //     // addNews += '"newsAuthor":"'+$(".newsAuthor").val()+'",'; //文章作者
    //     // addNews += '"claim":"'+ claim +'",';  //是否展示
    //     // addNews += '"newsStatus":"'+ newsStatus +'"}'; //审核状态
    //     // addNewsArray.unshift(JSON.parse(addNews));
    //     // window.sessionStorage.setItem("addNews",JSON.stringify(addNewsArray));
    //     //弹出loading
    //     // var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
    //     // setTimeout(function () {
    //
    //     $.ajax({
    //         type: 'post',
    //         url: '/addOrUpdateDaily',
    //         dataType: 'json',
    //         data: {
    //             claim: claim,
    //             contentDescription: contentDescription,
    //             demoAddress: demoAddress,
    //             lookRole: lookRole,
    //             planB: planB,
    //             planEndDate: planEndDate,
    //             planStartDate: planStartDate,
    //             remarks: remarks,
    //             submitContent: submitContent,
    //             workResult: workResult,
    //             workSchedule: workSchedule
    //         },
    //         // data: {claim: claim, contentDescription: contentDescription,​​demoAddress: demoAddress, lookRole: lookRole,planB: planB, planEndDate: planEndDate, planStartDate: planStartDate, remarks: remarks, submitContent: submitContent, workResult: workResult, workSchedule:workSchedule},
    //         success: function (result) {
    //
    //         }
    //     })
    //
    //     //弹出loading
    //     var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
    //     setTimeout(function(){
    //         top.layer.close(index);
    //         top.layer.msg("文章添加成功！");
    //         layer.closeAll("iframe");
    //         //刷新父页面
    //         parent.location.reload();
    //     },2000);
    //     return false;
    // });
})
