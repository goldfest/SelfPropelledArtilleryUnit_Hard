import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FormUstaBat {
    public DrawingUsta _drawingUsta;
    AbstractStrategy _abstractStrategy;
    private JButton buttonCreateUstaBat;
    private JPanel pictureBox;
    private JButton buttonUp;
    private JButton buttonDown;
    private JButton buttonLeft;
    private JButton buttonRight;
    public JComboBox comboBoxStrategy;
    private JButton buttonStep;
    private JButton buttonCreateUsta;
    public JButton ButtonSelectUsta;
    public DrawingUsta SelectedUsta;
    public boolean IsSelect = false;

    public JPanel getPictureBox() {
        return pictureBox;
    }
    public FormUstaBat()
    {
        buttonUp.setName("buttonUp");
        buttonDown.setName("buttonDown");
        buttonLeft.setName("buttonLeft");
        buttonRight.setName("buttonRight");

        buttonCreateUsta.addActionListener(e -> {
            Random rnd = new Random();
            Color color = JColorChooser.showDialog(null, "Цвет", null);
            _drawingUsta = new DrawingUsta(rnd.nextInt(100, 300),
                    rnd.nextInt(1000, 3000), color,
                    pictureBox.getWidth(),
                    pictureBox.getHeight());

            _drawingUsta.SetWheelsCount(rnd.nextInt(3, 7));
            _drawingUsta.SetPosition(rnd.nextInt(10, 100), rnd.nextInt(10, 100));
            Draw();
        });

        buttonCreateUstaBat.addActionListener(e -> {
            Random random = new Random();
            Color color = JColorChooser.showDialog(null, "Цвет", null);
            Color addColor = JColorChooser.showDialog(null, "Цвет2", null);

            _drawingUsta = new DrawingUstaBat(
                    random.nextInt(100, 300),
                    random.nextInt(1000, 3000),
                    color,
                    addColor,
                    random.nextBoolean(),
                    random.nextBoolean(),
                    pictureBox.getWidth(),
                    pictureBox.getHeight()
            );

            _drawingUsta.SetWheelsCount(random.nextInt(2, 5));
            _drawingUsta.SetPosition(random.nextInt(10, 100), random.nextInt(10, 100));
            Draw();
        });

        ButtonSelectUsta.addActionListener(e->{
            SelectedUsta = _drawingUsta;
            IsSelect = true;
//            DialogResult = DialogResult.OK;
        });

        buttonStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (_drawingUsta == null) {
                    return;
                }
                if (comboBoxStrategy.isEnabled()) {
                    switch(comboBoxStrategy.getSelectedIndex())
                    {
                        case 0:
                            _abstractStrategy = new MoveToCenter();
                            break;
                        case 1:
                            _abstractStrategy = new MoveToRigthCorner();
                            break;
                        default:
                            _abstractStrategy = null;
                            break;
                    } ;
                    if (_abstractStrategy == null) {
                        return;
                    }
                    _abstractStrategy.SetData(new
                                    DrawingObjectUsta(_drawingUsta), pictureBox.getWidth(),
                            pictureBox.getHeight());
                    comboBoxStrategy.setEnabled(false);
                }
                if (_abstractStrategy == null) {
                    return;
                }
                _abstractStrategy.MakeStep();
                Draw();
                if (_abstractStrategy.GetStatus() == Status.Finish) {
                    comboBoxStrategy.setEnabled(true);
                    _abstractStrategy = null;
                }
            }
        });


        ActionListener buttonMoveClickedListener = e -> {
            String buttonName = ((JButton) e.getSource()).getName();

            switch (buttonName) {
                case ("buttonUp") -> {
                    _drawingUsta.MoveTransport(DyrectionType.Up);
                }
                case ("buttonDown") -> {
                    _drawingUsta.MoveTransport(DyrectionType.Down);
                }
                case ("buttonLeft") -> {
                    _drawingUsta.MoveTransport(DyrectionType.Left);
                }
                case ("buttonRight") -> {
                    _drawingUsta.MoveTransport(DyrectionType.Right);
                }
            }
            Draw();
        };
        buttonUp.addActionListener(buttonMoveClickedListener);
        buttonDown.addActionListener(buttonMoveClickedListener);
        buttonLeft.addActionListener(buttonMoveClickedListener);
        buttonRight.addActionListener(buttonMoveClickedListener);
    }
    public void Draw() {
        if (_drawingUsta.EntityUsta == null) {
            return;
        }
        Graphics g = pictureBox.getGraphics();
        pictureBox.paint(g);
        _drawingUsta.DrawTransport((Graphics2D) g);
    }
}
