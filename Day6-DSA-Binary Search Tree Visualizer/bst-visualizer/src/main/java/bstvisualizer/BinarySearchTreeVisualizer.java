package bstvisualizer;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BinarySearchTreeVisualizer extends Application {
    private static final int NODE_RADIUS = 20;
    private static final int H_GAP = 50;
    private static final int V_GAP = 50;

    private BinarySearchTree tree = new BinarySearchTree();
    private TreePane treePane = new TreePane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Add controls
        HBox controls = new HBox(10);
        controls.setPadding(new Insets(10));

        TextField inputField = new TextField();
        inputField.setPromptText("Enter node value");

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button searchButton = new Button("Search");

        controls.getChildren().addAll(inputField, addButton, deleteButton, searchButton);

        root.setTop(controls);
        root.setCenter(treePane);

        // Set up button actions
        addButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                tree.add(value);
                treePane.displayTree(tree.getRoot());
            } catch (NumberFormatException ex) {
                inputField.setText("Invalid input");
            }
        });

        deleteButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                tree.delete(value);
                treePane.displayTree(tree.getRoot());
            } catch (NumberFormatException ex) {
                inputField.setText("Invalid input");
            }
        });

        searchButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                TreeNode foundNode = tree.search(tree.getRoot(), value);
                if (foundNode != null) {
                    animateNode(foundNode);
                    inputField.setText("Node found");
                } else {
                    inputField.setText("Node not found");
                }
            } catch (NumberFormatException ex) {
                inputField.setText("Invalid input");
            }
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Binary Search Tree Visualizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void animateNode(TreeNode node) {
        // Get the node's circle from the tree pane
        Circle circle = treePane.getNodeCircle(node);
        if (circle != null) {
            FillTransition fillTransition = new FillTransition(Duration.seconds(0.5), circle);
            fillTransition.setFromValue(Color.LIGHTBLUE);
            fillTransition.setToValue(Color.YELLOW);
            fillTransition.setCycleCount(6);  // Blink 3 times
            fillTransition.setAutoReverse(true);
            fillTransition.play();
        }
    }

    class TreePane extends Pane {
        public void displayTree(TreeNode root) {
            this.getChildren().clear();
            if (root != null) {
                displayTree(root, getWidth() / 2, V_GAP, getWidth() / 4);
            }
        }

        private void displayTree(TreeNode root, double x, double y, double hGap) {
            if (root == null) return;

            Circle circle = new Circle(x, y, NODE_RADIUS);
            circle.setFill(Color.LIGHTBLUE);
            circle.setStroke(Color.BLACK);
            Text text = new Text(x - 8, y + 5, root.value + "");

            root.circle = circle;  // Associate the circle with the TreeNode

            this.getChildren().addAll(circle, text);

            if (root.left != null) {
                Line line = new Line(x - hGap, y + V_GAP, x, y);
                this.getChildren().add(line);
                displayTree(root.left, x - hGap, y + V_GAP, hGap / 2);
            }

            if (root.right != null) {
                Line line = new Line(x + hGap, y + V_GAP, x, y);
                this.getChildren().add(line);
                displayTree(root.right, x + hGap, y + V_GAP, hGap / 2);
            }
        }

        public Circle getNodeCircle(TreeNode node) {
            return node.circle;
        }
    }
}
