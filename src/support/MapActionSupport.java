package support;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class MapActionSupport extends ActionSupport{

	/**
	 * 自定义ActionSupport
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> dataMap;
	
	public void setDataMap(String code, Object data) {
		dataMap = new HashMap<String, Object>();
		dataMap.put("code", code);
		dataMap.put("data", data);
	}

	public void setServeErrorData() {
		setDataMap("500", "对不起，服务器发生错误！");
	}
	
	public void setEmptyErrorData(){
		setDataMap("400.1", "内容不能为空");
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}
