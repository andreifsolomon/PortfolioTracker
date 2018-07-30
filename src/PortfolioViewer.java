import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PortfolioViewer extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Portfolio");
		// defining the axes
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Price");
		// creating the chart
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		lineChart.setTitle("Profit");
		// defining a series
		XYChart.Series series = new XYChart.Series();
		series.setName("My Portfolio");
		
		// populating the series with data
		
		try {
			List<Leg> importTransactionsFromCSV = TransactionImporter.importTransactionsFromCSV();
			
			for (Leg transaction : importTransactionsFromCSV) {
				
				Double stockPrice = 0.0;//transaction.getStockPrice();
				
				Double sum = StockCalculator.calculate(importTransactionsFromCSV, stockPrice);
				
				series.getData().add(new XYChart.Data(stockPrice, sum));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(series);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}