package Tests.NEP;

import Actions.NepActions;
import Tests.GenericTest;
import Utils.PropertiesFile.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.IOException;


public class ChangeUpdatedIntervals extends GenericTest {


    private NepActions action;

    @Factory(dataProvider = "getData")
    public ChangeUpdatedIntervals(Object dataToSet) {
        super(dataToSet);
        action = new NepActions();

    }


    @Test(priority = 1)

    //How often to check for updates.
    public void UpdatePeriod() throws Exception {


        action.LaunchApplication(data.get("Browser"));
        action.SetApplicationUrl(PropertiesFile.getCurrentClusterLink());

        action.Login(PropertiesFile.getUserName(), PropertiesFile.getPassword());

        action.GotoCentComSearch(PropertiesFile.getCurrentClusterLink());

        action.ClickOnIDRadioButton();

        SetCustomerID();

        ClickOnSearch();

        ClickOnCustomer();

        ClickOnAgentTab();

        UpdatePeriodTime();

        ReportPeriodConfig();

        CommitClickConf();

        PublishClickConf();

        ContinueButtonConf();

        Thread.sleep(1000);

        action.CloseApplication();


        Thread.sleep(2000);


    }
    @Test(priority=2)
    public void AssertData() throws Exception {

        StopTrustWaveService();

        Thread.sleep(2000);

        StartTrustWaveService();




        Thread.sleep(5000);

}

    @Test(priority=3)

    public void RestoreData() throws Exception {

        ConfigJsonAssert();
        AssertForReports();

        action.LaunchApplication(data.get("Browser"));
        action.SetApplicationUrl(PropertiesFile.getCurrentClusterLink());

        action.Login(PropertiesFile.getUserName(), PropertiesFile.getPassword());

        action.GotoCentComSearch(PropertiesFile.getCurrentClusterLink());

        action.ClickOnIDRadioButton();

        SetCustomerID();

        ClickOnSearch();

        ClickOnCustomer();

        ClickOnAgentTab();

        RestoreUpdatePeriod();

        RestoreReportPeriod();

        CommitClickConf();

        PublishClickConf();

        ContinueButtonConf();

        action.CloseApplication();


    }



    //Clicks on customer ID radio button
    public void ClickOnIDRadioButton() throws Exception {

        action.ClickOnIDRadioButton();


    }

    //Type the customer ID in the search box

    public void SetCustomerID() throws Exception {


        action.TypeCustomerID(data.get("CustomerID"));


    }


    public void ClickOnSearch() throws Exception {

        action.ClickOnSearchButton();

    }


    //Click On the selected customer + click on configuration icon
    public void ClickOnCustomer() throws Exception {


        action.ClickOnTheCustomer();


    }


    //Clicks on the Agent tab on the customer configuration screen
    public void ClickOnAgentTab() throws Exception{

        action.ClickOnAgentTab();

    }

    //check for updates (change the Update period).

    public void UpdatePeriodTime() throws IOException, InterruptedException {



        action.UpdatePeriodConf();
    }




    //Clicks and change the Report period  (How often to send data.)
    public void ReportPeriodConfig() throws IOException, InterruptedException {



        action.ReportPeriodConf();

    }

    //Clicks on commit button
    public void CommitClickConf() throws IOException, InterruptedException{

        Thread.sleep(8000);

        action.ClickOnCommit();
    }



    //Click on Publish button

    public void PublishClickConf() throws IOException, InterruptedException{

        Thread.sleep(8000);

        action.ClickOnPublish();
    }




    //Click on continue button

    public void ContinueButtonConf() throws IOException, InterruptedException{

Thread.sleep(8000);

        action.ClickOnContinue();
    }


//Restore Update period
    public void RestoreUpdatePeriod() throws IOException, InterruptedException {



        action.RestoreUpdatePeriod();
    }


    //Restore Report period
    public void RestoreReportPeriod() throws IOException, InterruptedException {
        action.RestoreReportPeriodPage();


    }
//Stop the Trustwave service

    public void StopTrustWaveService() throws IOException, InterruptedException {

        action.StopTrustWaveService(10);
    }

    //Start the Trustwave service

    public void StartTrustWaveService() throws IOException, InterruptedException {

        Thread.sleep(3000);

        action.StartTrustWaveService(10);
    }



    //verifying the updated period
    public void ConfigJsonAssert()throws IOException, InterruptedException {



        action.ConfigJsonAssertUpdatePeriod(data.get("Update period Interval"));
    }



    //verifying the Report period

    public void  AssertForReports()throws IOException, InterruptedException {

        action.ConfigAssertJsonReportPeriod(data.get("Report Interval"));
    }



//
//    @AfterMethod
//    public void Close() throws Exception {
//        afterMethod();
//        action.CloseApplication();
//
//    }


}



