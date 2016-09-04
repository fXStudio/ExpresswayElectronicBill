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
	    		<legend>Task Viewer & Edit</legend>
		    </fieldset>
	    </div>
	    
	    <div id="layout" class="pure-g">
	        <div class="pure-u-1 pure-u-md-3-4"">
	        	<table id="example" class="display" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th></th>
			                <th>First name</th>
			                <th>Last name</th>
			                <th>Position</th>
			                <th>Office</th>
			                <th width="18%">Start date</th>
			                <th>Salary</th>
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
        <script src="javascript/dataTables.buttons.min.js"></script>
        <script src="javascript/dataTables.select.min.js"></script>
        <script src="javascript/dataTables.editor.min.js"></script>
        <script type="text/javascript" language="javascript" class="init">
        	var editor; 
			$(document).ready(function() {
				editor = new $.fn.dataTable.Editor( {
			        ajax: "../php/staff.php",
			        table: "#example",
			        fields: [ {
			                label: "First name:",
			                name: "first_name"
			            }, {
			                label: "Last name:",
			                name: "last_name"
			            }, {
			                label: "Position:",
			                name: "position"
			            }, {
			                label: "Office:",
			                name: "office"
			            }, {
			                label: "Extension:",
			                name: "extn"
			            }, {
			                label: "Start date:",
			                name: "start_date",
			                type: "datetime"
			            }, {
			                label: "Salary:",
			                name: "salary"
			            }
			        ]
			    } );
			    // Activate an inline edit on click of a table cell
			    $('#example').on( 'click', 'tbody td:not(:first-child)', function (e) {
			        editor.inline( this );
			    } );
			 
			    $('#example').DataTable( {
			        dom: "Bfrtip",
			        columns: [
			            {
			                data: null,
			                defaultContent: '',
			                className: 'select-checkbox',
			                orderable: false
			            },
			            { data: "first_name" },
			            { data: "last_name" },
			            { data: "position" },
			            { data: "office" },
			            { data: "start_date" },
			            { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) }
			        ],
			        select: {
			            style:    'os',
			            selector: 'td:first-child'
			        },
			        buttons: [
			            { extend: "create", editor: editor },
			            { extend: "edit",   editor: editor },
			            { extend: "remove", editor: editor }
			        ]
			    } );
			} );
		</script>
    </body>
</html>
