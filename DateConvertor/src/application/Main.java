package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Parent root;

	@Override
	public void start(Stage primaryStage) {
		try {

			root = FXMLLoader.load(super.getClass().getResource("/DateConvertor.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("DateConverteur");
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(
					new Image(getClass().getResourceAsStream("/res/clock.jpg")));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	// public static List<Node> getAllNodes() {
	// List<Node> nodes = new ArrayList<Node>();
	// addAllDescendents(root, nodes);
	// return nodes;
	// }
	//
	// private static void addAllDescendents(Parent parent, List<Node> nodes) {
	// for (Node node : parent.getChildrenUnmodifiable()) {
	// if (node instanceof TextField) nodes.add(node);
	// if (node instanceof Parent) addAllDescendents((Parent) node, nodes);
	// }
	// }

}
