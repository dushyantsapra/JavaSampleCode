package com.javaSampleCode.testng;

import org.testng.annotations.DataProvider;

public class DataProviderClassTest {
	@DataProvider
	public Object[][] dataProvider() {
		return new Object[][] { { "A", "B" }, { "C", "D" }, { "1", "2" }, { "3", "4" }, { "5", "6" }, { "7", "8" },
				{ "9", "10" }, { "11", "12" }, { "13", "14" }, { "15", "16" }, { "17", "18" }, { "19", "20" },
				{ "21", "22" }, { "23", "24" } };
	}
}
