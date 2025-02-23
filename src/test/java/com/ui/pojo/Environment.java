package com.ui.pojo;

public class Environment {

	private String url;
	private int MAX_No_OF_ATTEMPTS;

	public int getMAX_No_OF_ATTEMPTS() {
		return MAX_No_OF_ATTEMPTS;
	}

	public void setMAX_No_OF_ATTEMPTS(int mAX_No_OF_ATTEMPTS) {
		MAX_No_OF_ATTEMPTS = mAX_No_OF_ATTEMPTS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
