package com.xubao.desktopCover;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xubao
 * @version 1.0
 * @since 2018/4/2
 */
public class DesktopCover extends Application
{
	private Stage stage;
	private AnchorPane anchorPane;
	private Scene scene;
	private Canvas canvas;
	private Image desktopImg;
	private EventHandler mouseEventHandler;

	Rectangle screenSize = getScreenSize();

	private GraphicsContext graphics;

	ByteArrayInputStream bais;

	public DesktopCover()
	{
		Robot robot = null;
		try
		{
			robot = new Robot();

			BufferedImage screenCapture = robot.createScreenCapture(screenSize);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(screenCapture,"png",baos);
			bais = new ByteArrayInputStream(baos.toByteArray());
		}
		catch(AWTException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

	public void init1()
	{
		anchorPane = new AnchorPane();
		//scene = new Scene(anchorPane, screenSize.width, screenSize.height);
		scene = new Scene(anchorPane, 500, 500);
		canvas = new Canvas();
		graphics = canvas.getGraphicsContext2D();
		canvas.heightProperty().bind(scene.heightProperty());
		canvas.widthProperty().bind(scene.widthProperty());
		anchorPane.getChildren().add(canvas);
		System.out.println(stage);
		stage.setScene(scene);

		//initMouseEventHandler();
	}

	public void start(Stage primaryStage) throws Exception
	{
		this.stage = primaryStage;

		this.init1();
		this.showStage();

		drawDesktop();
	}

	public void drawDesktop(){
			GraphicsContext g = canvas.getGraphicsContext2D();
			g.drawImage(new Image(bais),0,0);
	}

	private void initMouseEventHandler()
	{
		final AtomicInteger y = new AtomicInteger();
		mouseEventHandler = new EventHandler<MouseEvent>()
		{

			public void handle(MouseEvent event)
			{
				y.addAndGet(10);
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED)
				{
					showText("鼠标按下", 100, y.get());
					System.out.println("鼠标按下");
				}
				else if(event.getEventType() == MouseEvent.MOUSE_MOVED)
				{
//                    showText("鼠标移动",100,y.get());
//                    System.out.println("鼠标移动");
				}
				else if(event.getEventType() == MouseEvent.MOUSE_RELEASED)
				{
					showText("鼠标释放", 100, y.get());
					System.out.println("鼠标释放");
				}
				else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED)
				{
					//showText("鼠标拖拽",100,y.get());
					System.out.println("鼠标推拽");
				}
			}
		};
	}

	public void setDesktopImg(Image img)
	{
		desktopImg = img;
		drawImg(desktopImg);
	}

	public void drawImg(Image image)
	{
		graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight());
	}

	public void showText(String text, int x, int y)
	{
		graphics.fillText(text, x, y);
	}

	public void setMouseListener()
	{
		canvas.addEventHandler(MouseEvent.ANY, mouseEventHandler);
	}

	public void moveMouseListener()
	{
		canvas.removeEventHandler(MouseEvent.ANY, mouseEventHandler);
	}

	public void showStage()
	{
		stage.setMaximized(true);
//		stage.setWidth(500);
//		stage.setHeight(500);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();

//		setMouseListener();
	}


	public Pane getAnchorPane()
	{
		return anchorPane;
	}


	public Scene getScene()
	{
		return scene;
	}

	public void setScene(Scene scene)
	{
		this.scene = scene;
	}

	public void setAnchorPane(AnchorPane anchorPane)
	{
		this.anchorPane = anchorPane;
	}

	public Canvas getCanvas()
	{
		return canvas;
	}

	public void setCanvas(Canvas canvas)
	{
		this.canvas = canvas;
	}


	public static Rectangle getScreenSize()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height = screenSize.getHeight();
		double width = screenSize.getWidth();

		return new Rectangle((int)width, (int)height);
	}
}
