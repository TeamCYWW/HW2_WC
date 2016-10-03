<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">

	
	<title>Library</title>
	<link rel="stylesheet" href="css/flexi-background.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/styles.css" type="text/css" media="screen" />

	<link rel="stylesheet" type="text/css" href="jquery/themes/metro/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery/demo.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery/plugins/datagrid-filter.js"></script>
	
</head>
<body>
	<div id="box">
		<img src="images/logo.png" class="logo" alt="yourlogo" />
		<h1>
	     <s:if test="msg==null">Welcome</s:if>	
	     <s:else><s:property value="msg"></s:property> </s:else>
		</h1>
		<form METHOD=POST ACTION="login.action">
			<input type="text" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Username':this.value;" name="username" value="username" />
			<input type="password" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Password':this.value;" name="password" value="password">
			<input type="submit" name="use" value="Log In" />
			<input type="button" name="use" value="Register" onclick="javascript:$('#dlg').dialog('open')" />

		</form>
	<div style="margin:20px 0;">
	</div>
	</div>

	<div id="dlg" class="easyui-dialog" title="Add new user" style="width:300px;height:270px;padding:10px;hide:true"
			data-options="
				iconCls: 'icon-save',
				toolbar: '#dlg-toolbar',
				buttons: '#dlg-buttons'
			">
	<label class="lbInfo">User name: </label> 
	<input id="new_name" type="text" class="easyui-validatebox" required  /><br /> <br /> 

	<label class="lbInfo">Password: </label> 
	<input id="new_password" type="text" class="easyui-validatebox" required  /><br /> <br /> 

	<label class="lbInfo">Email: </label> 
	<input id="new_email" type="text" class="easyui-validatebox" /><br /> <br /> 

	<label class="lbInfo">Nickname: </label> 
	<input id="new_nickname" type="text" class="easyui-validatebox" /><br /> <br /> 
				
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="createUser()">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')">Close</a>
	</div>
<script>
	$(function(){
		javascript:$('#dlg').dialog('close');
	});
	
	function getRootPath(){
	    //get current website, e.g. http://localhost:8088/jquery/easyui/login.jsp
	    var curWwwPath = window.document.location.href;
	    //get directory, e.g. jquery/easyui/login.jsp
	    var pathName = window.document.location.pathname;
	    var pos = curWwwPath.indexOf(pathName);
	    //get server address，e.g. http://localhost:8088
	    var localhostPaht = curWwwPath.substring(0, pos);
	    //get project name including "/"，e.g. /jquery
	    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	    return (localhostPaht + projectName);
	}
	
	
	function sendpost(pars){
		
		urlData=pars;

        $.ajax({
            type: "POST",
            url: getRootPath() + '/register.action',
            data: urlData,
            dataType: 'text',
            success: function(msgResult){
                //console.info(msgResult);
                if (msgResult == "success") {
                    $.messager.alert('System message', 'Registration succeeded');
            		$('#dlg').dialog('close');

                    }
                
                else {
                    $.messager.alert('System message', 'Registration failed, user name already exists', 'error');
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                $.messager.alert('System message', 'Registration failed:' + textStatus, 'info')
            }
        });
	}
	
	
	


	
	function createUser(){
		
		 var  name=document.getElementById("new_name").value;
		 var  password=document.getElementById("new_password").value;
		 var  email=document.getElementById("new_email").value;
		 var  nickname=document.getElementById("new_nickname").value;
		 if (name==""||password=="")
		 {
	 		alert("Username and password cannot be empty")	;
	 		return;
	     }
		 
         var urlData = "use=insert" + "&name=" + name + "&password=" + password +
         "&root=T" + "&email=" + email + "&nickname=" + nickname;
         sendpost(urlData,true);
		
	}
	
	

</script>
</body>
</html>