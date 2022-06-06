import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Connect6 extends Application {
	private char whoseTurn = 'B';
	private int turnOverSwitch = 0; // 흑과 백이 각 2번 씩 번갈아가면서 착수하기 위한 스위치
	private int winStack = 0; // 연달아 이어진 돌이 있을 때마다 1스택 씩 쌓여 5개가 쌓이면 육목이 완성되는 원리

	private Cross[][] cross = new Cross[19][19];
	
	private Label lblStatus = new Label("Black's turn to play");
	
	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		for (int i = 0; i < 19; i++)
			for (int j = 0; j < 19; j++)
				pane.add(cross[i][j] = new Cross(j, i), j, i);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(lblStatus);
		
		Scene scene = new Scene(borderPane, 600, 650);
		primaryStage.setTitle("Connect6");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public class Cross extends Pane {
		private char stone = ' ';
		
		public Cross(int i, int j) {
			if (i == 0 && j == 0)
				setStyle("-fx-background-image: url(/board/left_top.png); -fx-background-position: center");
			else if (i == 18 && j == 0)
				setStyle("-fx-background-image: url(/board/right_top.png); -fx-background-position: center");
			else if (i == 0 && j == 18)
				setStyle("-fx-background-image: url(/board/left_bottom.png); -fx-background-position: center");
			else if (i == 18 && j == 18)
				setStyle("-fx-background-image: url(/board/right_bottom.png); -fx-background-position: center");
			else if (i == 18)
				setStyle("-fx-background-image: url(/board/right.png); -fx-background-position: center");
			else if (i == 0)
				setStyle("-fx-background-image: url(/board/left.png); -fx-background-position: center");
			else if (j == 18)
				setStyle("-fx-background-image: url(/board/bottom.png); -fx-background-position: center");
			else if (j == 0)
				setStyle("-fx-background-image: url(/board/top.png); -fx-background-position: center");
			else if ((i == 3 && j == 3) || (i == 3 && j == 9) || (i == 3 && j == 15) ||
					 (i == 9 && j == 3) || (i == 9 && j == 9) || (i == 9 && j == 15) ||
					 (i == 15 && j == 3) || (i == 15 && j == 9) || (i == 15 && j == 15))
				setStyle("-fx-background-image: url(/board/star.png); -fx-background-position: center");
			else
				setStyle("-fx-background-image: url(/board/cross.png); -fx-background-position: center");
			this.setPrefSize(800, 800);
			this.setOnMouseClicked(e -> handleMouseClick());
		}
		
		public char getStone() {
			return stone;
		}
		
		public void setStone(char c) {
			stone = c;
			
			if (stone == 'B') {
				Ellipse black = new Ellipse(this.getWidth() / 2, this.getHeight() / 2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
				black.centerXProperty().bind(this.widthProperty().divide(2));
				black.centerYProperty().bind(this.heightProperty().divide(2));
				black.radiusXProperty().bind(this.widthProperty().divide(2).subtract(5));
				black.radiusYProperty().bind(this.heightProperty().divide(2).subtract(5));
				black.setStroke(Color.BLACK);
				black.setFill(Color.BLACK);

				getChildren().add(black);
			}
			
			else if (stone == 'W') {
				Ellipse white = new Ellipse(this.getWidth() / 2, this.getHeight() / 2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
				white.centerXProperty().bind(this.widthProperty().divide(2));
				white.centerYProperty().bind(this.heightProperty().divide(2));
				white.radiusXProperty().bind(this.widthProperty().divide(2).subtract(5));
				white.radiusYProperty().bind(this.heightProperty().divide(2).subtract(5));
				white.setStroke(Color.WHITE);
				white.setFill(Color.WHITE);

				getChildren().add(white);
			}
		}
		
		private void handleMouseClick() {
			if (stone == ' ' && whoseTurn != ' ') {
				setStone(whoseTurn);
				
				Media stoneSound = new Media(new File("StoneSound.mp3").toURI().toString());
				new MediaPlayer(stoneSound).play();
				
				turnOverSwitch++;
				
				if (isWon(whoseTurn)) {
					lblStatus.setText(player(whoseTurn) + " won! The game is over.");
					Media endSound = new Media(new File("EndSound.mp3").toURI().toString());
					new MediaPlayer(endSound).play();
					whoseTurn = ' ';
				}
				
				else if (isFull()) {
					lblStatus.setText("Draw! The game is over");
					whoseTurn = ' ';
				}
				
				else {
					if (turnOverSwitch % 2 == 1) {
						whoseTurn = (whoseTurn == 'B') ? 'W' : 'B';
					}
					String turnNum = (turnOverSwitch % 2 == 1) ? "1st" : "2nd";
					lblStatus.setText(player(whoseTurn) + "'s " + turnNum + " turn");
				}
			}
		}
	}
	
	public String player(char c) {
		return (c == 'B') ? "Black" : "White";
	}
	
	public boolean isWon(char stone) {

		// 세로 육목
		for (int i = 0; i < 14; i++)
			for (int j = 0; j < 19; j++) {
				for (int k = 0; k < 5; k++) {
					if (cross[i+k][j].getStone() != ' ' && cross[i+k][j].getStone() == cross[i+k+1][j].getStone()) {
						winStack++;
					}
					else {
						winStack = 0;
						break;
					}
				}
				if (winStack == 5)
					return true;
			}
		
		// 가로 육목
		for (int i = 0; i < 19; i++)
			for (int j = 0; j < 14; j++) {
				for (int k = 0; k < 5; k++) {
					if (cross[i][j+k].getStone() != ' ' && cross[i][j+k].getStone() == cross[i][j+k+1].getStone()) {
						winStack++;
					}
					else {
						winStack = 0;
						break;
					}
				}
				if (winStack == 5)
					return true;
			}
		
		// 우하향 대각선 육목
		for (int i = 0; i < 14; i++)
			for (int j = 0; j < 14; j++) {
				for (int k = 0; k < 5; k++) {
					if (cross[i+k][j+k].getStone() != ' ' && cross[i+k][j+k].getStone() == cross[i+k+1][j+k+1].getStone()) {
						winStack++;
					}
					else {
						winStack = 0;
						break;
					}
				}
				if (winStack == 5)
					return true;
			}
		
		// 좌하향 대각선 육목
		for (int i = 0; i < 14; i++)
			for (int j = 6; j < 19; j++) {
				for (int k = 0; k < 5; k++) {
					if (cross[i+k][j-k].getStone() != ' ' && cross[i+k][j-k].getStone() == cross[i+k+1][j-k-1].getStone()) {
						winStack++;
					}
					else {
						winStack = 0;
						break;
					}
				}
				if (winStack == 5)
					return true;
			}		
		
		return false;
	}
	
	public boolean isFull() {
		for (int i = 0; i < 19; i++)
			for (int j = 0; j < 19; j++)
				if (cross[i][j].getStone() == ' ')
					return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}