package readCSV;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

	private JFrame frame;

	@Override
	public void run() {
		frame = new JFrame("Title");
		frame.setPreferredSize(new Dimension(200, 100));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setVisible(false);

		int cell = readCSV.getWholeSheet().get(0).get(0).length() - 1;

		String[][] myArray = new String[readCSV.getWholeSheet().toArray().length - 1][cell];

		for (int i = 1; i < readCSV.getWholeSheet().toArray().length; i++) {
			ArrayList<String> row = new ArrayList<>();
			row = readCSV.getWholeSheet().get(i);
			myArray[i - 1] = row.toArray(new String[cell]);
		}
		// Interface design
		JFrame jf = new JFrame();
		JTable table = new JTable(myArray, myArray[0]);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		table.setBounds(20, 30, 60, 100);
		JScrollPane scrollPane = new JScrollPane(table);
		jf.add(scrollPane);
		jf.setSize(1080, 720);
		table.setAutoCreateRowSorter(true);
		jf.setVisible(true);
		jf.setTitle("CSV List");

	}

	public void createTable(ArrayList<ArrayList<String>> sheet) {

	}
}
