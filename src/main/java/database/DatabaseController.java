package database;

import product.Product;

public class DatabaseController {

	/**
	 * 
	 * A hard coded database for now...
	 * 
	 */

	// Generated using a python script(Got this list from
	// https://simple.wikipedia.org/wiki/List_of_fruits)
	public static Product[] products = { new Product("Açaí", 10.0d, "1This is a fruit.", "Açaí.jpg"),
			new Product("Akee", 10.0d, "2This is a fruit.", "Akee.jpg"),
			new Product("Apple", 10.0d, "3This is a fruit.", "Apple.jpg"),
			new Product("Apricot", 10.0d, "4This is a fruit.", "Apricot.jpg"),
			new Product("Avocado", 10.0d, "5This is a fruit.", "Avocado.jpg"),
			new Product("Banana", 10.0d, "6This is a fruit.", "Banana.jpg"),
			new Product("Bilberry", 10.0d, "7This is a fruit.", "Bilberry.jpg"),
			new Product("Blackberry", 10.0d, "8This is a fruit.", "Blackberry.jpg"),
			new Product("Blackcurrant", 10.0d, "9This is a fruit.", "Blackcurrant.jpg"),
			new Product("Blueberry", 10.0d, "10This is a fruit.", "Blueberry.jpg"),
			new Product("Boysenberry", 10.0d, "11This is a fruit.", "Boysenberry.jpg"),
			new Product("Currant", 10.0d, "12This is a fruit.", "Currant.jpg"),
			new Product("Cherry", 10.0d, "13This is a fruit.", "Cherry.jpg"),
			new Product("Cloudberry", 10.0d, "14This is a fruit.", "Cloudberry.jpg"),
			new Product("Coconut", 10.0d, "15This is a fruit.", "Coconut.jpg"),
			new Product("Cranberry", 10.0d, "16This is a fruit.", "Cranberry.jpg"),
			new Product("Damson", 10.0d, "17This is a fruit.", "Damson.jpg"),
			new Product("Date", 10.0d, "18This is a fruit.", "Date.jpg"),
			new Product("Durian", 10.0d, "19This is a fruit.", "Durian.jpg"),
			new Product("Elderberry", 10.0d, "20This is a fruit.", "Elderberry.jpg"),
			new Product("Feijoa", 10.0d, "21This is a fruit.", "Feijoa.jpg"),
			new Product("Fig", 10.0d, "22This is a fruit.", "Fig.jpg"),
			new Product("Gooseberry", 10.0d, "23This is a fruit.", "Gooseberry.jpg"),
			new Product("Grape", 10.0d, "24This is a fruit.", "Grape.jpg"),
			new Product("Raisin", 10.0d, "25This is a fruit.", "Raisin.jpg"),
			new Product("Grapefruit", 10.0d, "26This is a fruit.", "Grapefruit.jpg"),
			new Product("Guava", 10.0d, "27This is a fruit.", "Guava.jpg"),
			new Product("Honeyberry", 10.0d, "28This is a fruit.", "Honeyberry.jpg"),
			new Product("Huckleberry", 10.0d, "29This is a fruit.", "Huckleberry.jpg"),
			new Product("Jabuticaba", 10.0d, "30This is a fruit.", "Jabuticaba.jpg"),
			new Product("Jackfruit", 10.0d, "31This is a fruit.", "Jackfruit.jpg"),
			new Product("Jambul", 10.0d, "32This is a fruit.", "Jambul.jpg"),
			new Product("Jostaberry", 10.0d, "33This is a fruit.", "Jostaberry.jpg"),
			new Product("Jujube", 10.0d, "34This is a fruit.", "Jujube.jpg"),
			new Product("Kiwifruit", 10.0d, "35This is a fruit.", "Kiwifruit.jpg"),
			new Product("Kumquat", 10.0d, "36This is a fruit.", "Kumquat.jpg"),
			new Product("Lemon", 10.0d, "37This is a fruit.", "Lemon.jpg"),
			new Product("Lime", 10.0d, "38This is a fruit.", "Lime.jpg"),
			new Product("Loganberry", 10.0d, "39This is a fruit.", "Loganberry.jpg"),
			new Product("Loquat", 10.0d, "40This is a fruit.", "Loquat.jpg"),
			new Product("Longan", 10.0d, "41This is a fruit.", "Longan.jpg"),
			new Product("Lychee", 10.0d, "42This is a fruit.", "Lychee.jpg"),
			new Product("Mango", 10.0d, "43This is a fruit.", "Mango.jpg"),
			new Product("Mangosteen", 10.0d, "44This is a fruit.", "Mangosteen.jpg"),
			new Product("Marionberry", 10.0d, "45This is a fruit.", "Marionberry.jpg"),
			new Product("Melon", 10.0d, "46This is a fruit.", "Melon.jpg"),
			new Product("Cantaloupe", 10.0d, "47This is a fruit.", "Cantaloupe.jpg"),
			new Product("Honeydew", 10.0d, "48This is a fruit.", "Honeydew.jpg"),
			new Product("Watermelon", 10.0d, "49This is a fruit.", "Watermelon.jpg"),
			new Product("Mulberry", 10.0d, "50This is a fruit.", "Mulberry.jpg"),
			new Product("Nectarine", 10.0d, "51This is a fruit.", "Nectarine.jpg"),
			new Product("Nance", 10.0d, "52This is a fruit.", "Nance.jpg"),
			new Product("Orange", 10.0d, "53This is a fruit.", "Orange.jpg"),
			new Product("Clementine", 10.0d, "54This is a fruit.", "Clementine.jpg"),
			new Product("Mandarine", 10.0d, "55This is a fruit.", "Mandarine.jpg"),
			new Product("Tangerine", 10.0d, "56This is a fruit.", "Tangerine.jpg"),
			new Product("Papaya", 10.0d, "57This is a fruit.", "Papaya.jpg"),
			new Product("Passionfruit", 10.0d, "58This is a fruit.", "Passionfruit.jpg"),
			new Product("Peach", 10.0d, "59This is a fruit.", "Peach.jpg"),
			new Product("Pear", 10.0d, "60This is a fruit.", "Pear.jpg") };

}
/*
 * 
 * 
 * private static Connection connection;
 * 
 * public DatabaseController() { try { //
 * Class.forName("com.mysql.jdbc.Driver"); Properties connectionProperties = new
 * Properties(); connectionProperties.put("user", "root");
 * connectionProperties.put("password", ""); connection =
 * DriverManager.getConnection("jdbc:mysql://localhost/learn",
 * connectionProperties);
 * 
 * // /*Statement statement = connection.createStatement(); // // ResultSet
 * resultSet = statement.executeQuery("" + "SELECT " + "* " + "FROM " +
 * "Products"); // // ResultSetMetaData rsmd = resultSet.getMetaData(); // int
 * columnsNumber = rsmd.getColumnCount(); // // // Iterate through the data in
 * the result set and display it. // // while (resultSet.next()) { // // Print
 * one row // for (int i = 1; i <= columnsNumber; i++) { // //
 * System.out.print(resultSet.getString(i) + " "); // Print one element of a row
 * // // } // // System.out.println();// Move to the next line to print the next
 * row. // // }
 * 
 * } catch (Exception e) {
 * LoggerFactory.getLogger("FATAL ERROR!").error("Connecting to database failed"
 * ); e.printStackTrace(); }
 * 
 * LoggerFactory.getLogger("good news!").info("Database connection successful");
 * }
 * 
 * public static ResultSet getResultSetFromQuery(String query) { try { Statement
 * statement = connection.createStatement(); ResultSet resultSet =
 * statement.executeQuery(query); resultSet.close(); statement.close(); return
 * resultSet; } catch (SQLException e) {
 * LoggerFactory.getLogger("FATAL ERROR!").error("Querying to database failed");
 * e.printStackTrace(); } return null; }
 * 
 * public static void cleanUp() { try { connection.close(); } catch
 * (SQLException e) {
 * LoggerFactory.getLogger("small problem").warn("Cleanup failed");
 * e.printStackTrace(); } } }
 */
