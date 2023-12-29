import javax.swing.*;

public class FrameDopClassParameters extends JFrame {
    public FormDopClassParameters _formDopClassParameters;

    public FrameDopClassParameters(){
        super();
        setTitle("Random usta");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        _formDopClassParameters = new FormDopClassParameters();
        setContentPane(_formDopClassParameters.getPictureBoxGenerated());
        setDefaultLookAndFeelDecorated(false);
        setLocation(500, 200);
        pack();
        setVisible(true);
    }
}
