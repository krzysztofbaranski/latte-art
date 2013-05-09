import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class MainWindow implements Runnable {
	
	private static JFrame mainFrame;
	private static StatusBar statusBar;
	private static ImagePanel imagePanel;
	
	// getters
	public static JFrame getMainFrame() {
		return mainFrame;
	}
	
	public static StatusBar getStatusBar() {
		return statusBar;
	}
	
	public static ImagePanel getImagePanel() {
		return imagePanel;
	}
	
	public MainWindow() {
    	mainFrame = new JFrame(Config.defaultWindowName);
    	statusBar = new StatusBar();
    	imagePanel = new ImagePanel();
	}
	
    @Override
    public void run() {
        
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainFrame.setMinimumSize(Config.defaultWindowSize);
    	mainFrame.setPreferredSize(Config.defaultWindowSize);
    	mainFrame.setJMenuBar(new MenuBar());
    	
    	JScrollPane scrollPane = new JScrollPane(imagePanel);
    	
    	mainFrame.add(statusBar, BorderLayout.SOUTH);
    	
    	mainFrame.add(scrollPane, BorderLayout.CENTER);
    	
    	mainFrame.setVisible(true);
    }

 
}
