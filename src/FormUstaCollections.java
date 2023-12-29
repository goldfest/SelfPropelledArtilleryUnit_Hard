import javax.swing.*;
import java.awt.*;

//готовая лаба 3

public class FormUstaCollections {
    FrameDopClassParameters frameDopClassParameters;
    private JPanel MainPanel;
    private JPanel pictureBoxCollections;
    private JPanel Instruments;
    private JButton ButtonAddUsta;
    private JTextField textFieldNumber;
    private JButton ButtonRefreshCollection;
    private JButton ButtonRemoveUsta;
    private JButton ButtonCreateRandomUsta;
    public DrawingUsta usta;
    UstaGenericCollection<DrawingUsta, DrawingObjectUsta> _usta;

    public JPanel getPictureBoxCollections() {
        return MainPanel;
    }

    public FormUstaCollections() {
        _usta = new UstaGenericCollection<>(700, 430);


        ButtonAddUsta.addActionListener(e -> {
            FrameUstaBat frameElectricUsta = new FrameUstaBat();
            frameElectricUsta.setVisible(true);
            frameElectricUsta._formUstaCollection.ButtonSelectUsta.addActionListener(e2 -> {
                usta = frameElectricUsta._formUstaCollection._drawingUsta;
                frameElectricUsta.dispose();
                if (usta != null) {
                    //проверяем, удалось ли нам загрузить объект
                    if (_usta.AddOverload(usta) != -1) {
                        JOptionPane.showMessageDialog(getPictureBoxCollections(), "Объект добавлен");
                        Refresh();
                    } else {
                        JOptionPane.showMessageDialog(getPictureBoxCollections(), "Не удалось добавить объект");
                    }
                }
            });
        });

        ButtonCreateRandomUsta.addActionListener(e->{
            if(frameDopClassParameters!=null) frameDopClassParameters.dispose();
            frameDopClassParameters = new FrameDopClassParameters();
            frameDopClassParameters.setVisible(true);
        });

        ButtonRemoveUsta.addActionListener(e -> {
            try {
                int pos = Integer.parseInt(textFieldNumber.getText());
                if (_usta.SubOverload(pos) != null) {
                    Refresh();
                    JOptionPane.showMessageDialog(this.getPictureBoxCollections(),
                            "Объект удален",
                            "Успех",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this.getPictureBoxCollections(),
                            "Не удалось удалить объект",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this.getPictureBoxCollections(),
                        "Неверное значение",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        ButtonRefreshCollection.addActionListener(e -> {
            Refresh();
        });

    }
    public void Refresh() {
        Graphics g = pictureBoxCollections.getGraphics();
        pictureBoxCollections.paint(g);
        _usta.ShowLocomotives((Graphics2D) g);
    }
}
