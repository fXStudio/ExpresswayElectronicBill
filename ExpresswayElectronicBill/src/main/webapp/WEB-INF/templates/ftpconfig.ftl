<!DOCTYPE html>
<html>
    <head>
        <!-- Http Header Infomation -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Language" content="zh-cn" />
        <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
        <meta http-equiv="Expires" content="0">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache" content="no-cache">
        <meta name="author" content="fxstudio.com.cn" />
        <meta name="description" content="ExpresswayElectronicBill" />
        <meta name="keywords" content="ExpresswayElectronicBill,Management,FXStudio"/>
        <meta name="Copyright" content="Copyright fxstudio.com.cn All Rights Reserved."/>

        <title>ExpresswayElectronicBill</title>
        
	    <!-- WebPage Style Desc -->
	    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="styles/normalize.css">
		<link rel="stylesheet" href="styles/pure-min.css">
	    
	    <!--[if lte IE 8]>
    		<link rel="stylesheet" href="styles/grids-responsive-old-ie-min.css">
		<![endif]-->
		
		<!--[if gt IE 8]><!-->
    		<link rel="stylesheet" href="styles/grids-responsive-min.css">
		<!--<![endif]-->
		
        <link rel="stylesheet" href="styles/electronicbill.css">
    </head>

    <body>
    	<div class="pure-menu pure-menu-horizontal pure-menu-fixed">
		    <a href="mainboard" class="pure-menu-heading">System Board</a>
		    <ul class="pure-menu-list">
		        <li class="pure-menu-item"><a href="mainboard" class="pure-menu-link">Home</a></li>
		        <li class="pure-menu-item"><a href="#" class="pure-menu-link">User Info</a></li>
		        <li class="pure-menu-item"><a href="/" class="pure-menu-link">Sign Out</a></li>
		    </ul>
		</div>
		
		<div class="header_container pure-u-1 pure-u-md-3-4">
		    <fieldset class="func_header">
	    		<legend>FTP Connnection Config</legend>
		    </fieldset>
	    </div>
	    
	    <div id="layout" class="pure-g">
	        <div class="pure-u-1 pure-u-md-3-4"">
			    <form class="pure-form pure-form-aligned">
			        <div class="pure-control-group">
			            <label for="name">Server Address</label>
			            <#if model["serverAddress"]??>
			            	<input id="serverAddress" type="text" value="${model["serverAddress"]}">
			            <#else>
			            	<input id="serverAddress" type="text">
			            </#if>
			        </div>
			
			        <div class="pure-control-group">
			            <label for="email">Username</label>
			            <#if model["username"]??>
			            	<input id="username" type="text" value="${model["username"]}">
			            <#else>
			            	<input id="username" type="text">
			            </#if>
			        </div>
			
			        <div class="pure-control-group">
			            <label for="password">Password</label>
			            <#if model["password"]??>
			            	<input id="password" type="text" value="${model["password"]}">
			            <#else>
			            	<input id="password" type="text">
			            </#if>
			        </div>
			
			        <div class="pure-control-group">
			            <label for="foo">FTP Port</label>
			            <#if model["port"]??>
			            	<input id="port" type="text" value="${model["port"]}">
			            <#else>
			            	<input id="port" type="text">
			            </#if>
			        </div>
			        
			        <div class="pure-control-group">
			            <label for="foo">Remote Directory</label>
			            <#if model["remoteDir"]??>
			            	<input id="remoteDir" type="text" value="${model["remoteDir"]}">
			            <#else>
			            	<input id="remoteDir" type="text">
			            </#if>
			        </div>
			        
			        <div class="pure-control-group">
			            <label for="foo">Local Directory</label>
			            <#if model["localDir"]??>
			            	<input id="localDir" type="text" value="${model["localDir"]}">
			            <#else>
			            	<input id="localDir" type="text">
			            </#if>
			        </div>
			
			        <div class="pure-controls">
			            <button type="submit" class="pure-button pure-button-default">Test</button>
			            <button type="submit" class="pure-button pure-button-primary">Submit</button>
			        </div>
				</form>
	        </div>
	        
	        <div class="pure-u-1 pure-u-md-1-4 sidebar">
	        	<p>
	        		Bootstrap中文网 -- www.bootcss.com 创建于2012年。起因是国内没有较好的关于Bootstrap的中文教程和交流渠道，因此，我们对Bootstrap的文档进行了翻译整理，并且建立了QQ群和微博（@bootcss），方便更多热爱这个CSS框架的攻城师们分享、交流自己在前端设计、开发方面的心得。
        		</p>
        		<p>
	        		Bootstrap是Twitter推出的一个用于前端开发的开源工具包。它由Twitter的设计师Mark Otto和Jacob Thornton合作开发,是一个CSS/HTML框架。目前,Bootstrap最新版本为3.0 
        		</p>
	        </div>
        </div>

    	<!--  Load Javascript library -->
        <script src="javascript/jquery-1.11.0.min.js"></script>
        <script src="javascript/jquery-ui.min.js"></script>
    </body>
</html>
