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
	public static Product[] products = { new Product(0, "Açaí", 10.0d, "0This is a fruit.", "Açaí.jpg"),
			new Product(1, "Akee", 10.0d, "1This is a fruit.", "Akee.jpg"),
			new Product(2, "Apple", 10.0d, "2This is a fruit.", "Apple.jpg"),
			new Product(3, "Apricot", 10.0d, "3This is a fruit.", "Apricot.jpg"),
			new Product(4, "Avocado", 10.0d, "4This is a fruit.", "Avocado.jpg"),
			new Product(5, "Banana", 10.0d, "5This is a fruit.", "Banana.jpg"),
			new Product(6, "Bilberry", 10.0d, "6This is a fruit.", "Bilberry.jpg"),
			new Product(7, "Blackberry", 10.0d, "7This is a fruit.", "Blackberry.jpg"),
			new Product(8, "Blackcurrant", 10.0d, "8This is a fruit.", "Blackcurrant.jpg"),
			new Product(9, "Blueberry", 10.0d, "9This is a fruit.", "Blueberry.jpg"),
			new Product(10, "Boysenberry", 10.0d, "10This is a fruit.", "Boysenberry.jpg"),
			new Product(11, "Currant", 10.0d, "11This is a fruit.", "Currant.jpg"),
			new Product(12, "Cherry", 10.0d, "12This is a fruit.", "Cherry.jpg"),
			new Product(13, "Cloudberry", 10.0d, "13This is a fruit.", "Cloudberry.jpg"),
			new Product(14, "Coconut", 10.0d, "14This is a fruit.", "Coconut.jpg"),
			new Product(15, "Cranberry", 10.0d, "15This is a fruit.", "Cranberry.jpg"),
			new Product(16, "Damson", 10.0d, "16This is a fruit.", "Damson.jpg"),
			new Product(17, "Date", 10.0d, "17This is a fruit.", "Date.jpg"),
			new Product(18, "Durian", 10.0d, "18This is a fruit.", "Durian.jpg"),
			new Product(19, "Elderberry", 10.0d, "19This is a fruit.", "Elderberry.jpg"),
			new Product(20, "Feijoa", 10.0d, "20This is a fruit.", "Feijoa.jpg"),
			new Product(21, "Fig", 10.0d, "21This is a fruit.", "Fig.jpg"),
			new Product(22, "Gooseberry", 10.0d, "22This is a fruit.", "Gooseberry.jpg"),
			new Product(23, "Grape", 10.0d, "23This is a fruit.", "Grape.jpg"),
			new Product(24, "Raisin", 10.0d, "24This is a fruit.", "Raisin.jpg"),
			new Product(25, "Grapefruit", 10.0d, "25This is a fruit.", "Grapefruit.jpg"),
			new Product(26, "Guava", 10.0d, "26This is a fruit.", "Guava.jpg"),
			new Product(27, "Honeyberry", 10.0d, "27This is a fruit.", "Honeyberry.jpg"),
			new Product(28, "Huckleberry", 10.0d, "28This is a fruit.", "Huckleberry.jpg"),
			new Product(29, "Jabuticaba", 10.0d, "29This is a fruit.", "Jabuticaba.jpg"),
			new Product(30, "Jackfruit", 10.0d, "30This is a fruit.", "Jackfruit.jpg"),
			new Product(31, "Jambul", 10.0d, "31This is a fruit.", "Jambul.jpg"),
			new Product(32, "Jostaberry", 10.0d, "32This is a fruit.", "Jostaberry.jpg"),
			new Product(33, "Jujube", 10.0d, "33This is a fruit.", "Jujube.jpg"),
			new Product(34, "Kiwifruit", 10.0d, "34This is a fruit.", "Kiwifruit.jpg"),
			new Product(35, "Kumquat", 10.0d, "35This is a fruit.", "Kumquat.jpg"),
			new Product(36, "Lemon", 10.0d, "36This is a fruit.", "Lemon.jpg"),
			new Product(37, "Lime", 10.0d, "37This is a fruit.", "Lime.jpg"),
			new Product(38, "Loganberry", 10.0d, "38This is a fruit.", "Loganberry.jpg"),
			new Product(39, "Loquat", 10.0d, "39This is a fruit.", "Loquat.jpg"),
			new Product(40, "Longan", 10.0d, "40This is a fruit.", "Longan.jpg"),
			new Product(41, "Lychee", 10.0d, "41This is a fruit.", "Lychee.jpg"),
			new Product(42, "Mango", 10.0d, "42This is a fruit.", "Mango.jpg"),
			new Product(43, "Mangosteen", 10.0d, "43This is a fruit.", "Mangosteen.jpg"),
			new Product(44, "Marionberry", 10.0d, "44This is a fruit.", "Marionberry.jpg"),
			new Product(45, "Melon", 10.0d, "45This is a fruit.", "Melon.jpg"),
			new Product(46, "Cantaloupe", 10.0d, "46This is a fruit.", "Cantaloupe.jpg"),
			new Product(47, "Honeydew", 10.0d, "47This is a fruit.", "Honeydew.jpg"),
			new Product(48, "Watermelon", 10.0d, "48This is a fruit.", "Watermelon.jpg"),
			new Product(49, "Mulberry", 10.0d, "49This is a fruit.", "Mulberry.jpg"),
			new Product(50, "Nectarine", 10.0d, "50This is a fruit.", "Nectarine.jpg"),
			new Product(51, "Nance", 10.0d, "51This is a fruit.", "Nance.jpg"),
			new Product(52, "Orange", 10.0d, "52This is a fruit.", "Orange.jpg"),
			new Product(53, "Clementine", 10.0d, "53This is a fruit.", "Clementine.jpg"),
			new Product(54, "Mandarine", 10.0d, "54This is a fruit.", "Mandarine.jpg"),
			new Product(55, "Tangerine", 10.0d, "55This is a fruit.", "Tangerine.jpg"),
			new Product(56, "Papaya", 10.0d, "56This is a fruit.", "Papaya.jpg"),
			new Product(57, "Passionfruit", 10.0d, "57This is a fruit.", "Passionfruit.jpg"),
			new Product(58, "Peach", 10.0d, "58This is a fruit.", "Peach.jpg"),
			new Product(59, "Pear", 10.0d, "59This is a fruit.", "Pear.jpg") };

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
