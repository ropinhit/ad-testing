package com.cafetownsend.test.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JenkinsStep {
    WebDriver driver = Hooks.driver;

    @When("^I go to the '(.+)' page$")
    public void iGoToTheHttpsStagingDeerbergDeDePage(String url) throws Throwable {
        driver.get(url);
    }

    @And("^I click all link from menu$")
    public void iGetAllLinkFromMenu() throws Throwable {
        WebElement menuE = driver.findElement(By.id("nav"));
        try {
            List<WebElement> no = menuE.findElements(By.tagName("a"));
            int noOfLinks = no.size();
            System.out.println(noOfLinks);

            List<String> allLinks = new ArrayList<String>();
            for (WebElement linkE : no) {
                allLinks.add(linkE.getAttribute("href"));
            }
            int count = 1;
            for (String perLink : allLinks) {
                if (perLink != null) {
                    if (!perLink.isEmpty()) {
                        if (perLink.contains("neu-in-sale-bekleidung")||perLink.contains("sonstiges")||perLink.contains("blog") || perLink.contains("/mode/") || perLink.contains("spangenschuhe") || perLink.contains("/service/"))
                            continue;
                        System.out.println(perLink);
                        count++;
                        driver.get(perLink);
                        verifyPageEmpty(perLink);

                        int totalPages = getTotalPage();
                        if (totalPages == 1) continue;
                        else {
                            if (totalPages == 2) {
                                enterNumberOfPage(2);
                                verifyPageEmpty(driver.getCurrentUrl());
                            } else {
                                //Verify random page
                                int randomPageNumber = getRandomNumber(totalPages);
                                enterNumberOfPage(randomPageNumber);
                                verifyPageEmpty(driver.getCurrentUrl());

                                //Verify the last page
                                enterNumberOfPage(totalPages);
                                verifyPageEmpty(driver.getCurrentUrl());
                            }
                        }
                    }
                }
            }
            System.out.println(count);

        } catch (Exception e) {
            Assert.assertFalse("broken link: "+driver.getCurrentUrl(),true);
            System.out.println("error: " + e);
        }
    }


    public void verifyPageEmpty(String link) {
        WebElement entryProductE = driver.findElement(By.id("entry-inside-id"));
        List<WebElement> productlistE = entryProductE.findElements(By.xpath("./div[contains(@class,'product_container')]"));
        int size = productlistE.size();
        System.out.println("size: " + productlistE.size());
        System.out.println("link: " + driver.getCurrentUrl());
        Assert.assertTrue("page is empty:" + link, size > 0);
    }


    public int getRandomNumber(int totalPage) {
        int randomNO = 1;
        Random r = new Random();
        randomNO = r.nextInt((totalPage - 2) + 1) + 2;
        return randomNO;
    }

    public int getTotalPage() {
        WebElement e = driver.findElement(By.className("pagination-total-page"));
        e.getText();
        return Integer.parseInt(e.getText());
    }

    public void enterNumberOfPage(int pageNumber) throws InterruptedException {
        WebElement currentPageTextBoxEl = driver.findElement(By.id("currentPageTxt"));
        currentPageTextBoxEl.clear();
        currentPageTextBoxEl.sendKeys(String.valueOf(pageNumber));
        currentPageTextBoxEl.sendKeys(Keys.ENTER);
        Thread.sleep(500);
    }
}
