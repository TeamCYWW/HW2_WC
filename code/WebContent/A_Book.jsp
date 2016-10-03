<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en">
<head>



	<meta charset="utf-8" />
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
	<meta name="viewport" content="width=device-width" />
	<meta name="keywords" content="botany, responsive, bootstrap, free template, fluid layout, templatemo, html css" />
	<meta name="description" content="Botany Template is free responsive template with a fluid background image." />
	<title>Library</title>
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="templatemo_style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="flexslider.css" type="text/css" media="screen" />
	<link rel="stylesheet" type="text/css" href="jquery/themes/black/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery/demo.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript"	 src="jquery/plugins/datagrid-filter.js"></script>
	
	
	
	
	

</head>
<body class="templatemo_juice_bg">


	<div id="main_container">
		<div class="container" id="home">
			<div class="row col-wrap">			 
				<div id="left_container" class="col col-md-3 col-sm-12">
                	<div class="templatemo_logo">
						<a  href="http://sc.chinaz.com/"><img src="images/templatemo_logo.png" alt="Botany Theme"></a>
					</div>
					<nav id="main_nav">
						<ul class="nav">
							<li class="active"><a href="#">Book Management</a></li>
							<li><a href=logout.action>Logout</a></li>

						</ul>
					</nav> <!-- nav -->	
				</div>
				
				<div id="right_container" class="col col-md-9 col-sm-12">
                
					<div class="row">
                    	<div class="col col-md-12">
                        
                    		<h2>
								<% 
									String username=(String)session.getAttribute("username");
								    Boolean root=(Boolean)session.getAttribute("root");
									if (username!=null && root!=null && root==true)
									{
										out.println("Hello "+username+", you are the administrator.");	
									}
									else
									{
										request.getRequestDispatcher("index.jsp").forward(request,response); 										
									}
								%>
							</h2> 
                         
        				</div>
                    </div>
                    <article class="row">
						<div class="col col-md-12">
						






	<table id="dg" class="easyui-datagrid" style="width:700px;height:450px"
			data-options="singleSelect:true,toolbar:'#tb',pagination:true,url:'jsonBook.action',onClickRow: onClickRow,
			onAfterEdit:onAfterEdit"
			
			>
		<thead>
			<tr>
				<th data-options="field:'isbn',width:80">ISBN</th>
				<th data-options="field:'bookName',width:100,editor:'text'">Title</th>
				<th data-options="field:'authorName',width:80,align:'right',editor:'text'">Author</th>
				<th data-options="field:'price',width:80,align:'right',editor:{type:'numberbox',options:{precision:2}}">Price</th>
				<th data-options="field:'category',width:250,editor:'text'">Category</th>
				<th data-options="field:'store',width:60,align:'center',editor:{type:'numberbox',options:{precision:0}}">Stock</th>


			</tr>
		</thead>
	</table>

	<div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Add</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="edit()">Edit</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchbook()">Find</a>


	</div>

	
	
	<div id="dlg" class="easyui-dialog" title="Add a new book" style="width:400px;height:350px;padding:10px;hide:true"
			data-options="
				iconCls: 'icon-save',
				toolbar: '#dlg-toolbar',
				buttons: '#dlg-buttons'
			">
	<label class="lbInfo">ISBN: </label> 
	<input id="new_isbn" type="text" class="easyui-validatebox" required  /><br /> <br /> 

	<label class="lbInfo">Title: </label> 
	<input id="new_book_name" type="text" class="easyui-validatebox" required  /><br /> <br /> 

	<label class="lbInfo">Author: </label> 
	<input id="new_author_name" type="text" class="easyui-validatebox" required  /><br /> <br /> 

	<label class="lbInfo">Price: </label> 
	<input id="new_price" class="easyui-numberbox" precision="2" value="0" /><br /> <br /> 

	<label class="lbInfo">Label: </label> 
	<select id="new_category" class="easyui-combobox" name="state" style="width:200px;">
		<option value="GV">Video</option>
		<option value="NOVEL">Novel</option>
		<option value="ANIME">Animation</option>
		<option value="LIGHTNOVEL">Light Novel</option>
	</select><br /> <br /> 

	<label class="lbInfo">Stock: </label> 
	<input id="new_store" class="easyui-numberbox" precision="0" value="0"/><br /> <br /> 
				
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="createBook()">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')">Close</a>
	</div>



	
	<div id="dlg2" class="easyui-dialog" title="Find a book" style="width:400px;height:350px;padding:10px;hide:true"
			data-options="
				iconCls: 'icon-save',
				toolbar: '#dlg-toolbar',
				buttons: '#dlg-buttons'
			">
		<label class="lbInfo">Title: </label> 
	<input id="search_isbn" type="text" class="easyui-validatebox"   /><br /> <br /> 

	<label class="lbInfo">Title: </label> 
	<input id="search_book_name" type="text" class="easyui-validatebox" /><br /> <br /> 

	<label class="lbInfo">Author: </label> 
	<input id="search_author_name" type="text" class="easyui-validatebox"   /><br /> <br /> 

	<label class="lbInfo">Price: </label> 
	<select id="search_price_cond" class="easyui-combobox" name="state" style="width:100px;">
		<option value="">Any</option>
		<option value="E">Equals to</option>
		<option value="G">Larger than</option>
		<option value="S">Smaller than</option>
	</select>
	<input id="search_price" class="easyui-numberbox" precision="2" value="0"/><br /> <br /> 
	<label class="lbInfo">Category: </label> 
	<select id="search_category" class="easyui-combobox" name="state" style="width:200px;">
		<option value="ALL">Any</option>
		<option value="GV">Video</option>
		<option value="NOVEL">Novel</option>
		<option value="ANIME">Animation</option>
		<option value="LIGHTNOVEL">Light Animation</option>
	</select><br /> <br /> 

	</div>		
			
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="dosearch()">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg2').dialog('close')">Close</a>
	</div>


	<form name="myform" action="get"></form>

	




						</div>								            
					</article>
	     
				</div>
			</div>
			<footer class="row credit">
				<div class="col col-md-12">
					<div id="templatemo_footer">
						Copyright &copy; 2014.Company name All rights reserved.</div>
				</div>
			</footer>
			
		</div>		
	</div>
	
	
	
	<script type="text/javascript">
	
	
		var editIndex = undefined;
		var chance=0;
		$(function(){
			javascript:$('#dlg').dialog('close');
			javascript:$('#dlg2').dialog('close');

	    var p = $('#dg').datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,
	        pageList: [5,10,15], 
	        beforePageText: '', 
	        afterPageText: 'of {pages} pages', 
	        displayMsg: '({from}-{to}) of {total} records', 
	        /*onBeforeRefresh:function(){
	            $(this).pagination('loading');
	            alert('before refresh');
	            $(this).pagination('loaded');
	        }*/ 
	    });   

		
			
		});
		
		var editIndex = undefined;
		var selectIndex=undefined;
		var editing=false;
		function endEditing(){
			$('#dg').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		}
		function onClickRow(index){
		
			if (editing){
				
				endEditing();
			}
		
			selectIndex=index;
			return;
		}
		function edit(){
			$('#dg').datagrid('selectRow', selectIndex)
				.datagrid('beginEdit', selectIndex);
			editing=true;
			editIndex=selectIndex;
		}

		function append(){
			if (endEditing()){
				document.getElementById("new_isbn").value="";
				document.getElementById("new_book_name").value="";
				document.getElementById("new_author_name").value="";
				document.getElementById("new_price").value="";
				document.getElementById("new_store").value="";
	   			$('#dlg').dialog("open");
			}
		}
		function searchbook(){
   			$('#dlg2').dialog("open");
   			
		}
		function dosearch(){
			 var par="use=search";
			 var flag=false;;
			 var  ISBN=document.getElementById("search_isbn").value;
			 if (ISBN!="") {par+="&isbn="+ISBN;flag=true;}
			 var  book_name=document.getElementById("search_book_name").value;
			 if (book_name!="") {par+="&bookName="+book_name;flag=true;}
			 var  author_name=document.getElementById("search_author_name").value;
			 if (author_name!="") {par+="&authorName="+author_name;flag=true;}
						 
			 var price_cond=$('#search_price_cond').combobox('getValue');
//			 alert(price_cond);
			 var  price=document.getElementById("search_price").value;
 
			 if (price_cond!="") {par+="&priceCond="+price_cond+"&price="+price;flag=true;}
			 var category=$('#search_category').combobox('getValue');
			 if (category!="ALL") {par+="&category="+category;flag=true;}
			 if (flag){par+="&cond=1";}
             sendpost(par,true);

		}
		function removeit(){
			if (selectIndex == undefined){return;}
			

			var a=$('#dg').datagrid('getRows');
			var ISBN=a[selectIndex]['isbn'];
            
			$('#dg').datagrid('cancelEdit', selectIndex)
			.datagrid('deleteRow', selectIndex);

			
			var urlData = "use=delete" + "&isbn=" + ISBN;            
            sendpost(urlData,false);
           	selectIndex = undefined;
			
			
		}


		
		function getRootPath(){
		    //获取当前网址，如： http://localhost:8088/jquery/easyui/login.jsp
		    var curWwwPath = window.document.location.href;
		    //获取主机地址之后的目录，如： jquery/easyui/login.jsp
		    var pathName = window.document.location.pathname;
		    var pos = curWwwPath.indexOf(pathName);
		    //获取主机地址，如： http://localhost:8088
		    var localhostPaht = curWwwPath.substring(0, pos);
		    //获取带"/"的项目名，如：/jquery
		    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		    return (localhostPaht + projectName);
		}
		
		function onAfterEdit(rowIndex, rowData, changes){
	        //获取最后一次提交以来更改的行，type 参数表示更改的行的类型，可能的值是：inserted、deleted、updated，等等。
            //dataGridOper.datagrid('getChanges', 'inserted');//用于判断是增删改的操作
            //当用户完成编辑一行时触发，参数包括rowIndex：编辑行的索引，从 0 开始
            //rowData：编辑行对应的记录 changes：更改的字段/值对
            var urlData = "use=edit" + "&isbn=" + rowData.isbn + "&bookName=" + rowData.bookName + "&authorName=" + rowData.authorName + "&price=" + rowData.price
			+ "&category=" + rowData.category + "&store=" + rowData.store;
            	sendpost(urlData,false);
		}
		
		
		function sendpost(pars,reload){
			
			urlData=pars;

            $.ajax({
                type: "POST",
                url: getRootPath() + '/editBook.action',
                data: urlData,
                dataType: 'text',
                success: function(msgResult){
                	var result=msgResult.split('/');
                    //console.info(msgResult);
                    if (result[0]=="success") {
                        //提交自从被加载以来或最后一次调用acceptChanges以来所有更改的数据,
                        //保持该数据的状态,否则点击取消编辑，将会回到修改前的数据,相当于提交事务
                        //title, msg, icon, fn
                        
                        if (reload){
                        	$("#dg").datagrid("reload"); 
                        	$.messager.alert('System message',"Adding succeeded" ); 
                      }
                        else{
                            $('#dg').datagrid('acceptChanges');
                        	$.messager.alert('System message', result[1]);
                        }
                    }
                    else {
                        $.messager.alert('System message', result[1], 'error');
                        //rolling back
                        $('#dg').datagrid('rejectChanges');
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown){
                    $.messager.alert('System message', 'Time out ' + textStatus, 'info')
                    $('#dg').datagrid('rejectChanges');
                }
            });
		}
		
		
		
		
		
		function getSelected(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.alert('Info', row.itemid+":"+row.productid+":"+row.attr1);
			}
		}
		function getSelections(){
			var ss = [];
			var rows = $('#dg').datagrid('getSelections');
			for(var i=0; i<rows.length; i++){
				var row = rows[i];
//				ss.push('<span>'+row.ISBN+":"+row.book_name+'</span>');
				ss.push('<span>'+$("#dg").datagrid("getRowIndex",rows[i]) +'</span>');
			}
			$.messager.alert('Info', ss.join('<br/>'));
		}
		function createBook(){
			
			 var  ISBN=document.getElementById("new_isbn").value;
			 var  book_name=document.getElementById("new_book_name").value;
			 var  author_name=document.getElementById("new_author_name").value;
			 var  price=document.getElementById("new_price").value;
			 //var  category=document.getElementById("new_category").value;
			 var category=$('#new_category').combobox('getValue');
			 var  store=document.getElementById("new_store").value;
			 if (ISBN== "" || book_name== "" || author_name=="" || price=="") {
				 $.messager.alert("Error ","Required items are empty");
				 return;
			 }

            var urlData = "use=insert" + "&isbn=" + ISBN + "&bookName=" + book_name + "&authorName=" + author_name + "&price=" + price
				+ "&category=" + category + "&store=" + store;
			sendpost(urlData,true);
		}
		
		
		
	</script>	
	
	
	
	
  
</body>
</html>