package readCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readCSV {

	private static String COMMA_DELIMITER = ",";
	private static ArrayList<ArrayList<String>> wholeSheet = new ArrayList<>();
	static String ourString = "";
	static String holder = "";
	static boolean weHave = false;

	public static ArrayList<ArrayList<String>> getWholeSheet() {

		if (wholeSheet.isEmpty()) {
			loadCSV();
		}

		return wholeSheet;

	}

	// Upload the CSV file
	public static void loadCSV() {

		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNext()) {

				wholeSheet.add(getRows(scanner.nextLine()));

			}
			// Error handler
		} catch (FileNotFoundException e) {
			System.out.println(e);

			e.printStackTrace();

		}
		for (int i = 0; i < wholeSheet.size(); i++) {

			List<String> localValues = wholeSheet.get(i);
			System.out.println(localValues.size());
		}

	}

	// Handel's quotation marks
	private static ArrayList<String> getRows(String row) {

		ArrayList<String> rowValues = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(row)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);

			while (rowScanner.hasNext()) {

				ourString = rowScanner.next();

				holder += ourString;
				if (!ourString.isEmpty()) {
					if (ourString.charAt(0) == '"') {
						weHave = true;
						continue;
					}
				}
				if (!holder.isEmpty()) {
					if (holder.charAt((holder.length() - 1)) == '"') {
						weHave = false;
					}
				}

				rowValues.add(holder);

				if (!weHave) {
					holder = "";
				}
			}

			return rowValues;
		}

	}

	public static void printCSV() {
		for (ArrayList<String> row : wholeSheet) {

			System.out.println(row);

		}

	}

}
