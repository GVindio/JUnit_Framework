package testPages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class TestPages extends TestBase {

	@FindBy(name = "allbox")
	WebElement ToggleAll;

	@FindBy(name = "data")
	WebElement dataInput;

	@FindBy(xpath = "//input[@value='Add']")
	WebElement addBtn;

	@FindBy(xpath = "//ul[contains(@style,'list-style-type')]")
	WebElement unorderedList;

	@FindBy(name = "todo[1]")
	WebElement singleItem;

	@FindBy(xpath = "//input[@value='Remove']")
	WebElement removeItem;

	public TestPages() {
		PageFactory.initElements(driver, this);

	}

	public void checkToggleAll() {
		ToggleAll.click();

	}

	public void addItems() {

		int i = 0;
		while (i < 2) {

			int min = 0;
			int max = 10000000;
			int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

			String random = String.valueOf(random_int);

			dataInput.sendKeys("Hello Moon".concat(random));
			addBtn.click();

			i++;
		}

	}

	public boolean verifyChecked() {

		List<WebElement> elements = driver
				.findElements(By.xpath("//ul[contains(@style,'list-style-type')]//li//input"));

		// System.out.println(elements.size());

		int selected = 0;

		Iterator<WebElement> elementIterator = elements.iterator();
		while (elementIterator.hasNext()) {
			// System.out.println(elementIterator.next().isSelected());

			if (elementIterator.next().isSelected() == true) {
				selected++;
			}

		}

		System.out.println("Found " + elements.size() + " checkboxes");
		System.out.println("Found " + selected + " checkboxes were selected");

		if (selected == elements.size()) {
			return true;
		} else
			return false;

	}

	public void singleItemCheckBox() {
		singleItem.click();

	}

	public void removeSingleItem() {
		removeItem.click();
	}

	public void verifyItemRemoved() {
		List<WebElement> Element = driver.findElements(By.name("todo[1]"));
		if (Element.size() != 0) { // If list size is non-zero, element is present

			System.out.println("Element not Removed");
		} else { // Else if size is 0, then element is not present

			System.out.println("Element Removed");
		}

	}

	public void removeAllItems() {
		removeItem.click();
	}
	
	public void verifyAllItemsRemoved() {
		List<WebElement> Element = driver.findElements(By.partialLinkText("todo[0]"));
	
		
		if (Element.size() != 0) { // If list size is non-zero, element is present

			System.out.println("All Elements not Removed");
		} else { // Else if size is 0, then element is not present

			System.out.println("Elements Removed");
		}

	
	
}
}