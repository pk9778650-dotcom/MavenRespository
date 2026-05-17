package com.pageObjectManager;

import com.utility.FileReaderManager;
import pageobjectmodel.LoginPage;
import pageobjectmodel.SearchProduct;

public class PageObjectManager {

    private LoginPage loginPage;
    private FileReaderManager fileReader;
    private static PageObjectManager pageObjectManager;
    private SearchProduct searchProduct;

    public LoginPage getLoginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public SearchProduct getSearchProduct() {
        if (searchProduct == null) {
            searchProduct = new SearchProduct();
        }
        return searchProduct;
    }

    public FileReaderManager getFileReader() {
        if (fileReader == null) {
            fileReader = new FileReaderManager();
        }
        return fileReader;
    }
    public static PageObjectManager getPageObjectManager(){
        if(pageObjectManager == null){
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }
}
