/**
 * 此文件收集的是平时js的工具方法
 * 在正常使用时,引入tool.js即可,而tool.js的内容从这里面拷贝
 */
/***************************ajax拦截********************************/
bg.ajax=function(opts){
	var d={
		load:true,//加载动画
		loadText:"数据处理中...",
		done:true,//是否需要执行成功拦截步骤
		fail:true,//是否需要执行失败统一提示
		always:true,//不管成功和失败,是否都执行always(比如未true:ajax效果在ajax结束后不关闭)
		//contentType:"application/json",
		data:{},
		success:function(data,textStatus,jqXHR){},
		error:function(jqXHR,textStatus,errorThrown){},
		type:"post",
		dataType:"json",
		async:true
	};
	opts = $.extend({}, d, opts);
	//opts.data=JSON.stringify(opts.data);
	if(opts.load){
		$.ui_load({
			icon:1,
			msg:opts.loadText
		});
	}
	var success=opts.success;
	opts.success=function(){};
	$.ajax(opts).done(function(data,textStatus,jqXHR){
		if(!opts.done){
			success(data);
			return;
		}
		//ajax请求时 session失效
		if(data.status==3){
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
	}).fail(function(jqXHR, textStatus, errorThrown){
		if(!opts.fail){
			opts.error(jqXHR,textStatus,errorThrown);
			return;
		}
		alert("连接服务器失败！");
		/*$.ui_dialog({
			type:"e",
			con:"连接服务器失败！",
		});*/
	}).always(function(){
		if(!opts.always){
			return;
		}
		if(opts.load){
			$.ui_load_close();
		}
	});
};
/***************************ajax拦截********************************/

/*********************************************************设置滚动条
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
/**************************设置滚动条**************************************/

/************************常用正则表达式****************************************/
bg.z={
	phone:/^1(3|4|5|7|8)\d{9}$/,//手机号
	email:/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/,//邮箱
	card:/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,//身份证号
	china:/[\u4E00-\u9FA5\uF900-\uFA2D]/,//中文
	englisAndNumber:/^[0-9a-zA-Z]*$/g,//只有数字和字母
};
/************************正则表达式****************************************/