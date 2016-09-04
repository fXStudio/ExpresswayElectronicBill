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

	<div class="l-content">
	    <div class="pricing-tables pure-g">
	        <div class="pure-u-1 pure-u-md-1-3">
	            <div class="pricing-table pricing-table-free">
	                <div class="pricing-table-header">
	                    <h2>Remote Server</h2>
	
	                    <span class="pricing-table-price">
	                        FTP<span>FTP Connnect Config</span>
	                    </span>
	                </div>
	                <a class="button-choose pure-button" href="ftpconfig">View & Edit</a>
	            </div>
	        </div>
	
	        <div class="pure-u-1 pure-u-md-1-3">
	            <div class="pricing-table pricing-table-biz">
	                <div class="pricing-table-header">
	                    <h2>Database Server</h2>
	
	                    <span class="pricing-table-price">
	                        DB<span>Database Connection Config</span>
	                    </span>
	                </div>
	                <a class="button-choose pure-button" href="dbconfig">View & Edit</a>
	            </div>
	        </div>
	
	        <div class="pure-u-1 pure-u-md-1-3">
	            <div class="pricing-table">
	                <div class="pricing-table-header">
	                    <h2>Scheduled Task</h2>
	
	                    <span class="pricing-table-price">
	                        Task<span>System Task Config</span>
	                    </span>
	                </div>
	                <a class="button-choose pure-button" href="taskconfig">View & Edit</a>
	            </div>
	        </div>
	        
	        <div class="pure-u-1 pure-u-md-1-3">
	            <div class="pricing-table pricing-table-statis">
	                <div class="pricing-table-header">
	                    <h2>Visualization Statis</h2>
	
	                    <span class="pricing-table-price">
	                        Statis<span>Data Statistics Report</span>
	                    </span>
	                </div>
	                <a class="button-choose pure-button" href="statisticview">View</a>
	            </div>
	        </div>
	        
	        <div class="pure-u-1 pure-u-md-1-3">
	            <div class="pricing-table pricing-table-log">
	                <div class="pricing-table-header">
	                    <h2>System Run Log</h2>
	
	                    <span class="pricing-table-price">
	                        LOG<span>System Runtime Log</span>
	                    </span>
	                </div>
	                <a class="button-choose pure-button" href="logview">View</a>
	            </div>
	        </div>
	        
	        <div class="pure-u-1 pure-u-md-1-3">
	            <div class="pricing-table pricing-table-manual">
	                <div class="pricing-table-header">
	                    <h2>Scheduled Task</h2>
	
	                    <span class="pricing-table-price">
	                        Manual<span>Manual Execute Job</span>
	                    </span>
	                </div>
	                <a class="button-choose pure-button" href="manualjob">Edit</a>
	            </div>
	        </div>
	    </div>

    	<!--  Load Javascript library -->
        <script src="javascript/jquery-1.11.0.min.js"></script>
        <script src="javascript/jquery-ui.min.js"></script>
    </body>
</html>
