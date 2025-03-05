package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static void main(String[] args) {

		System.out.println(getFakeAddress().toString());
	}

	public static AddressPOJO getFakeAddress() {

		Faker faker = new Faker(Locale.US);
		AddressPOJO addressPOJO

				= new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
						faker.address().streetAddress(), faker.address().city(), faker.address().zipCode(),
						faker.phoneNumber().cellPhone(), "Tesgd", "ABC COLONY", faker.phoneNumber().cellPhone(),
						faker.address().state());

		return addressPOJO;
	}
}
