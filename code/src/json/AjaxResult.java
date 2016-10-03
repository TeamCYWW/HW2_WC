package json;

public class AjaxResult {
	public Boolean success;
	public String message;
	
	public AjaxResult(Boolean success,String message){
		this.success=success;
		this.message=message;
	}
	
	public AjaxResult(){
	}
}
