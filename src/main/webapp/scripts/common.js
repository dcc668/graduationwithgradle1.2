rapidsh = {};
/**
 * 选择传入的form列表里所有的checkbox
 * theForm-传入的表单对象
 */
rapidsh.checkAllBox = function(theForm) {
	for (var i=0;i<theForm.elements.length;i++) {
	    var e = theForm.elements[i];
			var eName = e.name;
	    	if (eName != 'allbox' && 
	            (e.type.indexOf("checkbox") == 0)) {
	        	e.checked = theForm.allbox.checked;		
			}
	}; 
};

/**
 * 设置cookie
 * name-cookie的名字
 * value-cookie的值
 * expire-cookie过期时间
 */
rapidsh.setCookies = function(name, value, expire){
	var date=new Date(); 
	var expireDays=expire; 
	date.setTime(date.getTime()+expireDays*24*3600*1000); 
	var str=name+"="+escape(value);  
	str+="; expires="+date.toGMTString();
	document.cookie=str;
};

/**
 * 获取cookie
 * name-cookie的名字
 */
rapidsh.getCookie = function(name){
	 var cookieArray=document.cookie.split("; "); 
	 for(var i=0;i<cookieArray.length;i++){
	  var arr=cookieArray[i].split("=");    
	  if(arr[0]==name)return unescape(arr[1]); 
	 }
	 return "";
	};

/**
 * 删除cookie
 * name-cookie的名字
 */	
rapidsh.deleteCookie = function(name){
	 this.setCookie(name,"",{expireDays:-1}); 
};

/**
 * 基本的Ajax请求
 * type-请求类型(POST|GET)
 * url-请求地址
 * data-需要传入的参数，e.g:name=John&location=Boston
 * msg-请求执行完成显示提示信息
 */
rapidsh.BasicAjaxRequest = function(type, url, data, msg){
	$.ajax({
		   type: type,
		   url: url,
		   data: data,
		   success: function(msg){
		     alert( msg );
		   }
	});
};

/**
 * 使用css元素的'display:none' 属性实现隐藏和显示
 * 该方法隐藏后在页面山不会占据元素空间大小的位置
 * targetId-传入的元素id
 * */
rapidsh.toggleDisplay = function(targetId){
    if (document.getElementById) {
        target = document.getElementById(targetId);
    	if (target.style.display == "none"){
    		target.style.display = "";
    	} else {
    		target.style.display = "none";
    	}
    }
};

/**
 * 使用css元素的'visibility:hidden' 属性实现隐藏和显示
 * 该方法隐藏元素后，其元素原来的空间位置不变，只是不能看到该元素，显示为空白
 * */
rapidsh.toggleVisibility = function(targetId) {
	if (document.getElementById) {
		target = document.getElementById(targetId);
		if (target.style.visibility == "hidden"){
			target.style.visibility = "visible";
		} else {
			target.style.visibility = "hidden";
		}
	}
};

/**
 * 对列表的记录进行删除、查看、修改的操作
 * formId-form的ID
 * url-请求URL地址
 * type-操作类型，删除(del)、查看(view)、修改(edit)
 * */
rapidsh.actionPerformance = function(formId, url, type) {
	 if( type =="del" ){
		 if( $("input:checked").length >= 1 ){
			 $('#'+formId+'').attr("action", url);
			 $('#'+formId+'').attr("method", "post");
			 $('#'+formId+'').submit();
		 }else{
			 alert("请勾选要删除的记录!!!");
			 return;
		 }
	 }

	 if( type =="edit" || type =="view" ){
		 if( $("input:checked").length==1 ){
			 $('#'+formId+'').attr("action", url);
			 $('#'+formId+'').attr("method", "get");
			 $('#'+formId+'').submit();
		 }else{
			 alert("[查看]/[修改]只能选择一条记录!!!");
			 return;
		 }
	 }
};

/**
 * lookup 弹出窗口，返回数据库里returnfields定义的字段
 * */
rapidsh.lookup = function(urlToOpen){  
	var window_width = screen.availWidth/2;  
	var window_height = screen.availHeight/2;  
	var window_left = (screen.availWidth/2)-(window_width/2);  
	var window_top = (screen.availHeight/2)-(window_height/2);  
	var winParms = "status=no,location=no,directories=no,menubar=no" + ",resizable=yes" + ",height="+window_height+",width="+window_width + ",left="+window_left+",top="+window_top;  
	var newwindow = window.open(urlToOpen,'_blank',winParms);  
	newwindow.focus();  
};
/**
 * 弹出上传文件窗口
 * */
rapidsh.popUpload = function (urlToOpen){
	var window_width = screen.availWidth/2;  
	var window_height = screen.availHeight/2;  
	var window_left = (screen.availWidth/2)-(window_width/2);  
	var window_top = (screen.availHeight/2)-(window_height/2);  
	var winParms = "status=no,location=no,directories=no,menubar=no" + ",resizable=yes" + ",height="+window_height+",width="+window_width + ",left="+window_left+",top="+window_top;  
	var newwindow = window.open(urlToOpen,'_blank',winParms);  
	newwindow.focus();  
};