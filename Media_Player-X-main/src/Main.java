import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

//This is our main class where we call our mediaplayer application to run
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mediaplayer.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case K:
                        controller.myPlayPause.OnButton();
                        break;
                    case Q:
                        controller.stopMedia();
                        break;
                    case A:
                        controller.backward();
                        break;
                    case D:
                        controller.forward();
                        break;
                    case W:
                        controller.myVolSlider.onUPclick();
                        break;
                    case S:
                        controller.myVolSlider.onDOWNclick();
                        break;
                    case F:
                        primaryStage.setFullScreen(true);
                        break;
                    default:
                        break;
                }
            }
        });
        primaryStage.setScene(scene);
        Image icon = new Image("file:res/icon.png");
        primaryStage.getIcons().add(icon);
        String title = "MediaX";
        primaryStage.setTitle(title);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}