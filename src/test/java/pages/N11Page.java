package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class N11Page {

    public N11Page() {

        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//a[@class=\"btnSignIn\"]")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "#loginButton")
    public WebElement loginButton;

    @FindBy(xpath = " //a[@title='Çıkış Yap']")
    public WebElement exitButton;

    @FindBy(css = "a[title='Hesabım']")
    public WebElement myAccount;

    @FindBy(xpath = "//div[contains(text(),'Geçerli bir e-posta adresi girmelisin.')]")
    public WebElement errorWarning1;

    @FindBy (xpath = "//div[@class='inputField']//div[2]//div[1]")
    public WebElement errorWarning2;

    @FindBy(xpath = "//span[contains(text(),'E-posta adresi veya şifre hatalı, kontrol edebilir')]")
    public WebElement mainErrorWarning;

    @FindBy(id = "searchData")
    public WebElement searchField;

    @FindBy(xpath = "//h3[@class='productName']")
    public WebElement product;

    @FindBy(xpath = "//span[@class='label'][normalize-space()='1 TB']")
    public WebElement oneTbLabel;

    @FindBy(xpath = "//img[@class='lazy cardImage']")
    public WebElement firstProduct;

    @FindBy(xpath = "//button[@class='addBasketUnify']")
    public WebElement addToCardButton;

    @FindBy(xpath = "//i[@class='iconsBasketWhite']")
    public WebElement goToCartButton;

    @FindBy(xpath = "//tr[@class=\"prod  \"]")
    public WebElement productList;

    @FindBy(xpath = "//span[@title='Sil']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[@title=\"n11\"]")
    public WebElement n11Button;

    @FindBy(xpath = "//h2[@class=\"title\"]")
    public WebElement emptyCard;

    @FindBy(xpath = "//a[@class=\"user\"]")
    public WebElement profileMenu;

    @FindBy(xpath = "//a[@class='logoutBtn']")
    public WebElement logoutButton;
}
