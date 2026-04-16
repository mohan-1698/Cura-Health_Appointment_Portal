package com.srm.hackathon.curahealth.dataproviders;

import org.testng.annotations.DataProvider;

import com.srm.hackathon.curahealth.utils.ExcelUtil;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        String filePath = "src/test/resources/testdata/LoginData.xlsx";
        String sheetName = "Sheet1";

        return ExcelUtil.getTestData(filePath, sheetName);
    }
}