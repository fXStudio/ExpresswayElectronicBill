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
	    		<legend>Statistics Report Viewer</legend>
		    </fieldset>
	    </div>
	    
	    <div id="layout" class="pure-g">
	        <div class="pure-u-1 pure-u-md-3-4"">
	        	<center>
		        	<div class="pure-u-1 pure-u-md-1-4">
			            <div class="statis-panel pricing-table-free">
			                <div class="pricing-table-header">
			                    <h2>Day Upload Bills</h2>
			
			                    <span class="pricing-table-price">
			                        1000<span>Every Day Upload Bills</span>
			                    </span>
			                </div>
			            </div>
			        </div>
			
			        <div class="pure-u-1 pure-u-md-1-4">
			            <div class="statis-panel pricing-table-log">
			                <div class="pricing-table-header">
			                    <h2>Month Upload Bills</h2>
			
			                    <span class="pricing-table-price">
			                        1W<span>Every Month Upload Bills</span>
			                    </span>
			                </div>
			            </div>
			        </div>
			
			        <div class="pure-u-1 pure-u-md-1-4">
			            <div class="statis-panel pricing-table-biz">
			                <div class="pricing-table-header">
			                    <h2>Year Upload Bills</h2>
			
			                    <span class="pricing-table-price">
			                        16W<span>Every Year Upload Bills</span>
			                    </span>
			                </div>
			            </div>
			        </div>
		        </center>
		        <canvas id="myChart" width="400" height="120"></canvas>
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
        <script src="javascript/Chart.min.js"></script>
		<script>
			var ctx = $("#myChart").get(0).getContext("2d");
			var data = {
				labels : ["1","2","3","4","5","6","7","8","9","10","11","12"],
				datasets : [
					{
						label: '单日票据信息上传量',
						backgroundColor: 'rgba(89, 156, 100, 0.5)',
						data : [65,59,590,181,56,1155,40,860,71,96,1135,60]
					}
				]
			}
			var myChart = new Chart(ctx, {
			    type: 'line',
			    data: data,
			    options: {
			        responsive: true
			    }
			});
		</script>
    </body>
</html>
