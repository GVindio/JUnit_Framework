package testCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.OrderWith;

import testBase.TestBase;
import testPages.TestPages;

public class TestCases extends TestBase {

	TestPages testpages;

	@Before
	public void setUp() {

		startBrowser(); // Arrived at page
		testpages = new TestPages();
	}

	@Test
	public void validateToggle() {
		/* 1. Arrived at page 
		 * 2. Add Items 
		 * 3. Click on toggle all 
		 * 4. Verify the all items have been clicked 
		 * Result: When toggle all is checked all other items are also checked */
		testpages.addItems(); // Adding Items
		testpages.checkToggleAll(); // Checking Toggle All box
		boolean verify = testpages.verifyChecked(); // Verifying to see if all elements are checked
		Assert.assertTrue(verify); // Assertion is expected to be true
	}

	@Test
	public void validateSingleListItem() {
		/* 1. Arrived at page 
		 * 2. Check single item 
		 * 3. Verify single item has been checked 
		 * 4. Remove single checked item 
		 * 5. Verify single item has been removed
		 * Result: When single item is checked clicking on remove will delete single item */
		testpages.singleItemCheckBox(); // Checking single item
		testpages.removeSingleItem(); // Removing single item
		testpages.verifyItemRemoved(); // Verifying single item is removed

	}
	
	@Test
	public void validdateAllListItems() {
		/*1. Arrived at page
		2. Check all items
		3. Verify all items have been checked
		4. Remove all checked items
		5. Verify all items have been removed
		Result: When all items are checked clicking on remove will delete all items */
		testpages.checkToggleAll(); // Checking Toggle All box
		testpages.removeAllItems(); // Removing all items
		testpages.verifyAllItemsRemoved(); // Verifying all items removed
		
		
	}

	

	@After
	public void breakDown() {
		 driver.quit();
	}
}
