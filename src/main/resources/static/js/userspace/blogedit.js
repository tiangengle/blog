/*!
 * blogedit.html 页面脚本.
 * 
 * @since: 1.0.0 2017-03-26
 * @author Way Lau <https://waylau.com>
 */
"use strict";
//# sourceURL=blogedit.js

// DOM 加载完再执行
$(function() {
	
	// 初始化 md 编辑器
    $("#md").markdown({
        language: 'zh',
        fullscreen: {
            enable: true
        },
        resize:'vertical',
        localStorage:'md',
        imgurl: 'http://localhost:8081',
        base64url: 'http://localhost:8081'
    });
  
    // 初始化标签控件
    $('.form-control-tag').tagEditor({
        initialTags: [],
        maxTags: 5,
        delimiter: ', ',
        forceLowercase: false,
        animateDelete: 0,
        placeholder: '请输入标签'
    });
    
    $('.form-control-chosen').chosen();
 
 	$("#uploadImage").click(function() {
		$.ajax({
		    url: 'http://localhost:8081/upload',
		    type: 'POST',
		    cache: false,
			//new FormData($('#uploadForm')[0])是序列化表单
			//优点就是我们可以异步上传一个二进制文件.
		    data: new FormData($('#uploadformid')[0]),
			//告诉jQuery不要去处理发送的数据
		    processData: false,
			//告诉jQuery不要去设置Content-Type请求头
		    contentType: false,
		    success: function(data){
		    	var mdcontent=$("#md").val();
		    	 $("#md").val(mdcontent + "\n![]("+data +") \n");
 
	         }
	    //$.ajax()如果执行成功，则执行.done()
		}).done(function(res) {
			$('#file').val('');
		//执行失败执行.fail()
		}).fail(function(res) {});
 	})
 
 	// 发布博客
 	$("#submitBlog").click(function() {
 
		// 获取 CSRF Token 
		var csrfToken = $("meta[name='_csrf']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");
		
		$.ajax({
		    url: '/u/'+ $(this).attr("userName") + '/blogs/edit',
		    type: 'POST',
			contentType: "application/json; charset=utf-8",
			//对数据进行序列化
		    data:JSON.stringify({"id":$('#id').val(),
		    	"title": $('#title').val(), 
		    	"summary": $('#summary').val() , 
		    	"content": $('#md').val(),
                "catalog":{"id":$('#catalogSelect').val()},
				"tags": $('.form-control-tag').val()
		    }),
			beforeSend: function(request) {
			    request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token 
			},
			 success: function(data){
				 if (data.success) {
					// 成功后，重定向
					 window.location = data.body;
				 } else {
					 toastr.error("error!"+data.message);
				 }
				 
		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		})
 	})
});