package com.ui.pojo;

public class AddressPOJO {

	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postCode;
	private String homePhone;
	private String otherInfo;
	private String addressAlias;
	private String mobile;
	private String state;

	public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String postCode,
			String homePhone, String otherInfo, String addressAlias, String mobile, String state) {
		super();
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postCode = postCode;
		this.homePhone = homePhone;
		this.otherInfo = otherInfo;
		this.addressAlias = addressAlias;
		this.mobile = mobile;
		this.state = state;
	}

	public String getCompany() {
		return company;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public String getMobile() {
		return mobile;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", postCode=" + postCode + ", homePhone=" + homePhone + ", otherInfo=" + otherInfo
				+ ", addressAlias=" + addressAlias + ", mobile=" + mobile + ", state=" + state + "]";
	}

}
