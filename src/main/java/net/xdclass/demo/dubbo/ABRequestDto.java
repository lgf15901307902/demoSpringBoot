package net.xdclass.demo.dubbo;


import java.io.Serializable;

/**
 * 描述:RequestDto的实体类
 * @author:  AB040446
 * @创建时间: 2017-02-04
 */
public class ABRequestDto  implements Serializable{
	private static final long serialVersionUID = -482677701835530698L;
	private String tranNo;//交易码（head中获取）：必传，日志收集用
	private String sysClientCode;//服务端系统代码（head中获取）：必传，日志收集用
	private String requestXML;//请求xml：必传，日志收集用
	private int callIndex;//调用序号：必传，日志收集用
 
	public String getTranNo() {
		return tranNo;
	}
	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}
	public String getSysClientCode() {
		return sysClientCode;
	}
	public void setSysClientCode(String sysClientCode) {
		this.sysClientCode = sysClientCode;
	}
	public String getRequestXML() {
		return requestXML;
	}
	public void setRequestXML(String requestXML) {
		this.requestXML = requestXML;
	}
	public int getCallIndex() {
		return callIndex;
	}
	public void setCallIndex(int callIndex) {
		this.callIndex = callIndex;
	}
	 
 	
}