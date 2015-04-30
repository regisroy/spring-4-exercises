package com.zenika.bean;

public class FinalBean implements IFinal {
	private AuditBean auditBean;
	private String messageType;

	@Override
	public String process() {
		return "SUCCESS";
	}

	@Override
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Override
	public String getMessageType() {
		return messageType;
	}

	@Override
	public String toString() {
		return "FinalBean : " + auditBean.getMessage();
	}

	public void setAuditBean(AuditBean auditBean) {
		this.auditBean = auditBean;
	}
}
