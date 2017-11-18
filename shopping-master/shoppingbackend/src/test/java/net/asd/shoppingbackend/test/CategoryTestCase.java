package net.asd.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.asd.shoppingbackend.dao.CategoryDAO;
import net.asd.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.asd.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory(){
	 * 
	 * category = new Category(); category.setName("Laptop");
	 * category.setDescription("This is a description for LapTop");
	 * category.setImageURL("CAT_105.png");
	 * assertEquals("Succesfuly added a category to the table",true,categoryDAO.add(
	 * category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("Succesfuly fetched  a single category from the table"
	 * ,"Television",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1); category.setName("Television");
	 * assertEquals("Succesfuly updated a single category in the table",true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Succesfuly deleted a single category in the table",true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Succesfuly fetched a list of categories from the table",3,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {
		// add operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is a description for LapTop");
		category.setImageURL("CAT_1.png");
		assertEquals("Succesfuly added a category to the table", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("This is a description for Television");
		category.setImageURL("CAT_2.png");
		assertEquals("Succesfuly added a category to the table", true, categoryDAO.add(category));

		//fetching and updating category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Succesfuly updated a single category in the table", true, categoryDAO.update(category));
		
		//delete the category
		assertEquals("Succesfuly deleted a single category in the table",true,categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Succesfuly fetched a list of categories from the table",1,categoryDAO.list().size());
	}

}
