package action;

import com.opensymphony.xwork2.Action;

public class Welcome implements Action{

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
