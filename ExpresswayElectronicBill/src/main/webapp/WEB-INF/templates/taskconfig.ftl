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
		<link rel="stylesheet" href="styles/jquery.dataTables.min.css">
		<link rel="stylesheet" href="styles/buttons.dataTables.min.css">
		<link rel="stylesheet" href="styles/select.dataTables.min.css">
		<link rel="stylesheet" href="styles/editor.dataTables.min.css">
	    
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
	    		<legend>Task Mangement</legend>
		    </fieldset>
	    </div>
	    
	    <div id="layout" class="pure-g">
	        <div class="pure-u-1 pure-u-md-3-4">
	        	<table id="example" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Job Name</th>
			                <th>Status</th>
			                <th>Cron</th>
			                <th>Desc</th>
			                <th>options</th>
			            </tr>
			        </thead>
		        </table>
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
        <script src="javascript/jquery.dataTables.min.js"></script>
        <script src="javascript/dataTables.select.min.js"></script>
        <script src="javascript/dataTables.editor.min.js"></script>
        <script type="text/javascript" language="javascript" class="init">
        	var editor; 
			$(document).ready(function() {
			    $('#example').DataTable( {
    				"ordering": false,
    				"info": false,
    				"paging": false,
                    "scrollX": true,
			        "ajax": {
			            "url": "datas/taskList",
			            "type": "POST"
			        },
			        columns: [
			            { data: "jobName" },
			            { data: "jobStatus" },
			            { 
			            	data: "cronExpression"
			            },
			            { data: "desc" },
			            {/** Custom Define Column */
				            "targets": -1,
				            "data": null,
				            "defaultContent": "<a class='pure-button pure-button-small pure-button-primary'><i class='fa fa-cog'></i>start</a>"
				        }
			        ],
			        select: {
			            style:    'os',
			            selector: 'td:first-child'
			        },
			        "language": {
						"processing": "玩命加载中...",
						"lengthMenu": "显示 _MENU_ 项结果",
						"zeroRecords": "没有匹配结果",
						"info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
						"infoEmpty": "显示第 0 至 0 项结果，共 0 项",
						"infoFiltered": "(由 _MAX_ 项结果过滤)",
						"infoPostFix": "",
						"search": "搜索:",
						"url": "",
						"paginate": {
							"first":    "首页",
							"previous": "上页",
							"next":     "下页",
							"last":     "末页"
						}
					}
			    });
			} );
		</script>
    </body>
</html>
