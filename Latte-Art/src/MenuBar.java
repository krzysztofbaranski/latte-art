import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 518111316051332941L;
	
	private static JMenuItem MenuItem(String name, KeyStroke ks, 
										ActionListener al) {
		JMenuItem menuItem = new JMenuItem(name);
		if (ks != null) {
			menuItem.setAccelerator(ks);
		}
		if (al != null) {
			menuItem.addActionListener(al);
		}
		return menuItem;
	}
	
	public MenuBar() {
		// Plik
        JMenu plik = new JMenu("Plik");
        plik.setMnemonic(KeyEvent.VK_P);
        
        plik.add(MenuItem("Nowy", KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK), null));
        
        plik.add(MenuItem("Otwórz", KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK), new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser();
						int returnVal = fc.showOpenDialog(MenuBar.this);
				        if (returnVal == JFileChooser.APPROVE_OPTION) {
				            File file = fc.getSelectedFile();
				            
				            //This is where a real application would open the file.
				            MainWindow.getStatusBar().setMessage("Opening: " + file.getName() + ".");
				            MainWindow.getImagePanel().loadImage(file);
				        } else {
				        	MainWindow.getStatusBar().setMessage("Open command cancelled by user.");
				        }
					}
				}));
        
        plik.add(MenuItem("Zapisz", KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK), null));
        
        plik.addSeparator();
 
        plik.add(MenuItem("Właściwości", null, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.getStatusBar().setMessage("Właściwości");
			}
		}));
        
        plik.addSeparator();
        
        plik.add(MenuItem("Zakończ", KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.CTRL_MASK), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.getMainFrame().dispose();
			}
		}));
        
        //Edycja
        JMenu edycja = new JMenu("Edycja");
        edycja.setMnemonic(KeyEvent.VK_E);
        
        edycja.add(MenuItem("Cofnij", KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, ActionEvent.CTRL_MASK), null));
        
        edycja.add(MenuItem("Ponów", KeyStroke.getKeyStroke(
                KeyEvent.VK_Z, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK), null));
        
        edycja.addSeparator();
        
        edycja.add(MenuItem("Wytnij", KeyStroke.getKeyStroke(
                KeyEvent.VK_X, ActionEvent.CTRL_MASK), null));
        
        edycja.add(MenuItem("Kopiuj", KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.CTRL_MASK), null));
        
        edycja.add(MenuItem("Wklej", KeyStroke.getKeyStroke(
                KeyEvent.VK_V, ActionEvent.CTRL_MASK), null));
        
        edycja.addSeparator();
        
        edycja.add(MenuItem("Wyczyść", KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.CTRL_MASK), null));
        
        //Obraz
        JMenu obraz = new JMenu("Obraz");
        obraz.setMnemonic(KeyEvent.VK_O);
        
        obraz.add(MenuItem("Skaluj", KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK), null));
        
        obraz.add(MenuItem("Przytnij", KeyStroke.getKeyStroke(
                KeyEvent.VK_X, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK), null));
        
        obraz.addSeparator();
        
        obraz.add(MenuItem("Filtry", null, null));
        
        obraz.add(MenuItem("Transformacje", null, null));
        
        
        // Widok
        JMenu widok = new JMenu("Widok");
        widok.setMnemonic(KeyEvent.VK_W);
        
        widok.add(MenuItem("Powiększenie", null, null));
        
        widok.add(MenuItem("Pełny Ekran", KeyStroke.getKeyStroke(
                KeyEvent.VK_ENTER, ActionEvent.ALT_MASK), new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JFrame frame = MainWindow.getMainFrame();
						frame.setExtendedState(frame.getExtendedState() | 
													JFrame.MAXIMIZED_BOTH);
					}
				}));
      
        
        // Pomoc
        JMenu pomoc = new JMenu("Pomoc");
        pomoc.setMnemonic(KeyEvent.VK_M);
        
        pomoc.add(MenuItem("O programie", null, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame helpWindow = new JFrame("O programie");
				helpWindow.add(new JLabel("LatteArt 2013."), java.awt.BorderLayout.NORTH);
				helpWindow.add(new JLabel("Grupowy projekt programistyczny"), java.awt.BorderLayout.SOUTH);
				helpWindow.pack();
				helpWindow.setVisible(true);
			}
		}));
        
        // Dołączamy do MenuBar
        add(plik);
        add(edycja);
        add(obraz);
        add(widok);
        add(pomoc);
	}
}