import javax.swing.JLabel;

public class StatusBar extends JLabel {
	private static final long serialVersionUID = 5578387481446278467L;

    public StatusBar() {
        super();
        setMessage("Program jest gotowy do użycia.");
    }
    
    public void setMessage(String message) {
        setText(" "+message);        
    }        
}
