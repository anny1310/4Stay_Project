package com.fourstay.step_definitions;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.DBUtilIty;
import com.fourstay.utilities.DBUtilIty.DBType;
import cucumber.api.java.en.Then;

public class DDTGeneral_AccSet_StepDefs {
	SignUpPage signUpPage = new SignUpPage();

	@Then("^verify first name, last name,phone number for each user is correctly displayed$")

	public void verify_first_name_last_name_phone_number_for_each_user_is_correctly_displayed() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		signUpPage.profileButton.click();
		Thread.sleep(2000);
		signUpPage.editProfile.click();
		Thread.sleep(3000);

		String name = signUpPage.accountName.getAttribute("value");
		String lastName = signUpPage.accountLastName.getAttribute("value");
		String phoneNumber = signUpPage.phoneNumb.getAttribute("value");

		DBUtilIty.establishConnection(DBType.MYSQL);
		List<String[]> queryResultList = DBUtilIty
				.runSQLQuery("select first_name,last_name,email,phone_number from employees");
		DBUtilIty.closeConnections();

		List<String[]> actualData = new ArrayList<>();
		for (int rowNum = 0; rowNum < queryResultList.size(); rowNum++) {
			String[] rowData = queryResultList.get(rowNum);
			String dataName = rowData[0];
			String dataLastName = rowData[1];
			String dataPhone = rowData[3].replace(".", "");
			if (dataName.equals(name) && dataLastName.equals(lastName) && dataPhone.equals(phoneNumber)) {
				actualData.add(rowData);
			}
		}

		for (int a = 0; a < actualData.size(); a++) {
			String[] rowData2 = actualData.get(a);
			String dataName1 = rowData2[0];
			String dataLastName1 = rowData2[1];
			String dataPhone1 = rowData2[3].replace(".", "");

			Assert.assertEquals(name, dataName1);
			Assert.assertEquals(lastName, dataLastName1);
			Assert.assertEquals(phoneNumber, dataPhone1);
		}

	}

}
