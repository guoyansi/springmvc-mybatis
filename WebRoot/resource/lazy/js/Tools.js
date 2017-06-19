bg.ajax=function(opts){
	var d={
		load:true,//加载动画
		loadText:"",
		contentType:'application/json',
		data:{},
		type:"post",
		dataType:"json",
		async:true,
		error:function(){
			//alert("数据操作失败!");
			$.ui_dialog({
				type:"e",
				con:"连接服务器失败！",
			});
		},
		complete:function(){
			 //手动关闭加载动画
			 $.ui_load_close();
		 }
	};
	opts = $.extend({}, d, opts);
	opts.data=JSON.stringify(opts.data);
	if(opts.load){
		$.ui_load({
			icon:1,
			msg:opts.loadText
		});
	}
	var success=opts.success;
	opts.success=function(){};
	$.ajax(opts).done(function(data){
		//ajax请求时 session失效
		if(data.status&&data.status==3){
			$.ui_dialog({
				type:"e",
				con:data.msg,
				btn:[{name:"确定",action:function(){
					window.location.href=data.href;
				}}]
			});
		}else{
			success(data);
		}
	});
};

/**
 * 页面跳转,刷新页面前的拦截
 * form的submit和window.location.href的拦截,
 * 用于记录滚动条的位置
 * isRecordScroll 是否记录滚动条 
 * 执行form的submit和window.location.href的操作
 */
bg.goPage=function(isRecordScroll,callback){
	if(window.sessionStorage){
		if(typeof isRecordScroll=="function"){
			callback=isRecordScroll;
			isRecordScroll=false;
		}
		var doc=$(document);
		if(typeof isRecordScroll=="boolean"&&isRecordScroll){
			var scrollTop=doc.scrollTop();
			var scrollLeft=doc.scrollLeft();
			window.sessionStorage.setItem("scrollTop",scrollTop);
			window.sessionStorage.setItem("scrollLeft",scrollLeft);
		}else{
			window.sessionStorage.removeItem("scrollTop");
			window.sessionStorage.removeItem("scrollLeft");
		}
	}
	callback();
};
$(function(){
	/*设置滚动条*/
	if(!window.sessionStorage){
		return ;
	}
	var scrollTop=window.sessionStorage.getItem("scrollTop");
	var scrollLeft=window.sessionStorage.getItem("scrollLeft");
	if(scrollTop&&scrollLeft){
		scrollTop=Number(scrollTop);
		scrollLeft=Number(scrollLeft);
		var doc=$(document);
		doc.scrollTop(scrollTop);
		doc.scrollLeft(scrollLeft);
		window.sessionStorage.removeItem("scrollTop");
		window.sessionStorage.removeItem("scrollLeft");
	}
});