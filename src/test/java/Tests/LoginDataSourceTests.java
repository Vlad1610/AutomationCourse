package Tests;

import ObjectModels.LoginModel;
import PageObjects.LoginPage;
import Utils.ExcelReader;
import Utils.Tools;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LoginDataSourceTests extends BaseTest {
    String browser = "chrome";
    LoginPage loginPage;

    @DataProvider(name = "jsonDp")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we start json deserialization of json into LoginModel obj
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src\\test\\resources\\Data\\testdata.json");

        LoginModel[] lms = objectMapper.readValue(file, LoginModel[].class);

        for (LoginModel lm : lms)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDp")
    public void loginWithJsonAsDataSource(LoginModel lm) {
        loginLm(lm);
    }

    //###############################################XML###############
    @DataProvider(name = "xmlDp")
    public Iterator<Object[]> xmlDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
        File file = new File("src\\test\\resources\\Data\\testdata.xml");
        LoginModel loginModel = unMarshalLoginModel(file);
        dp.add(new Object[]{loginModel});
        return dp.iterator();
    }

    private LoginModel unMarshalLoginModel(File f) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(LoginModel.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            return (LoginModel) jaxbUnMarshaller.unmarshal(f);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test(dataProvider = "xmlDp")
    public void loginWithXMLAsDataSource(LoginModel lm) {
        loginLm(lm);
    }

    //#####################################CSV#######################
    @DataProvider(name = "csvDp")
    public Iterator<Object[]> csvDpCollection() throws IOException, CsvException {
        Collection<Object[]> dp = new ArrayList<>();
        File file = new File("src\\test\\resources\\Data\\testdata.csv");
        Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> csvData = csvReader.readAll();
        int usernamePoz = 0, passwordPoz = 1, userERRPoz = 2, passwordErr = 3;

        for(int i = 0; i < csvData.size(); i++) {
            LoginModel lm = new LoginModel(csvData.get(i)[usernamePoz], csvData.get(i)[passwordPoz], csvData.get(i)[userERRPoz], csvData.get(i)[passwordErr]);
            dp.add(new Object[]{lm});
        }

        return dp.iterator();
    }

    @Test(dataProvider = "csvDp")
    public void loginWithCSVAsDataSource(LoginModel lm) {
        loginLm(lm);
    }

    //#####################################XLSX#######################
    @DataProvider(name = "xlsx")
    public Iterator<Object[]> xlsxDpCollection() throws Exception {
        Collection<Object[]> dp = new ArrayList<>();
        File file = new File("src\\test\\resources\\Data\\testdata.xlsx");
        int usernamePoz = 0, passwordPoz = 1, userERRPoz = 2, passwordErr = 3;
        String[][] excelData = ExcelReader.readExcelFile(file,"",true,true);

        for(int i = 0; i < excelData.length; i++) {
            LoginModel lm = new LoginModel(excelData[i][usernamePoz], excelData[i][passwordPoz], excelData[i][userERRPoz],
                    excelData[i][passwordErr]);
            dp.add(new Object[]{lm});
        }

        return dp.iterator();
    }

    @Test(dataProvider = "xlsx")
    public void loginWithXLSXAsDataSource(LoginModel lm) {
        loginLm(lm);
    }

    //#####################################MYSQL#######################
    @DataProvider(name = "mysql")
    public Iterator<Object[]> mysqlDpCollection() throws Exception {
//        show DB connection details
        System.out.println("Use dbHostname:"+dbHostname);
        System.out.println("Use dbUser:"+dbUser);
        System.out.println("Use dbPort:"+dbPort);
        System.out.println("Use dbSchema:"+dbSchema);
        Collection<Object[]> dp = new ArrayList<>();
//        db connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://"+dbHostname+":"+dbPort+
                "/"+dbSchema, dbUser,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM login_negative");
        while (resultSet.next()){
            LoginModel lm = new LoginModel(getEscapedElement(resultSet,"username"),
                    getEscapedElement(resultSet,"password"),
                    getEscapedElement(resultSet,"usernameErr"),
                    getEscapedElement(resultSet,"passwordErr"));
            dp.add(new Object[]{lm});
        }
        return dp.iterator();
    }

    @Test(dataProvider = "mysql")
    public void loginWithSQLAsDataSource(LoginModel lm) {
        loginLm(lm);
    }
    //   login with loginModel
    private void loginLm(LoginModel lm) {
        System.out.println(lm);
        login(lm.getAccount().getUsername(), lm.getAccount().getPassword(), lm.getUserError(), lm.getPasswordError());
    }

    private void login(String username, String password, String usernameErr, String passErr) {
        System.out.println("Login with username:" + username + "/password:" + password + "=> on browser:" + browser);
        driver.get(baseUrl);

        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Login Finished, verify error message");
        Assert.assertEquals(loginPage.geUsernameErr(), usernameErr);
        Assert.assertEquals(loginPage.getPassErr(), passErr);
    }

    private String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }
}