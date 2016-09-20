/**
 * 系统登录管理
 */
$(document).ready(function() {
	// 自定义系统函数
	var loginFnc = function() {
		return {
			setFocus: function(){ $(':text:first').focus() },// 设置焦点
			alertMessage: function(){
				// 包裹类的引用
				var warpper = this;
				
				// 显示提示框
				$("#alert_message").jui_alert({
				    containerClass: "alert_message_container ui-widget",
				    messageAreaClass: "jui_alert_message_area ui-state-highlight ui-corner-all alert_message_area",
					message : 'Incorrect username or password.',
					messageBodyClass: "alert_message",
					messageIconClass: "",
					timeout: 0,
					use_effect: {effect_name: "shake", effect_duration: "3000"}
				});
				// 重置焦点
				warpper.setFocus();
				// 绑定提示框的关闭事件
				$('.jui_alert_btn_close').click(function() {warpper.setFocus();});
			}
		};
	} ();
	// 初始化焦点
	loginFnc.setFocus();
	
	// 回车事件
	$('#login-pass').keypress(function(event){
		if(event.keyCode === 13) {
			$('a.btn').get(0).click();
		}
	});

	// 表单提交的事件处理函数
	$('a.btn').click(function() {
		// 用户输入的用户名和密码
		var username = $('#login-name').val();
		var password = $('#login-pass').val();
		
		// 用户名和密码不能为空
		if(username.length > 0 && password.length > 0){
			$.ajax({   
				url: "services/systemLogin",
				dataType: "json",
				data: {"username": username, "password": password},
				timeout: 5000,
				type: 'post',
				success: function(data, textStatus) {
                    if (data.success) {
                    	window.location.href = "mainboard";
                    } else {
    					loginFnc.alertMessage();
                    }  
				},   
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					loginFnc.alertMessage();
				}   
			});
		} else{
			loginFnc.alertMessage();
		}
	});
});