import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class MainPanel extends JPanel{
    String point;
    public MainPanel(){
        setBackground(Color.WHITE);
        invalidate();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

    }

}