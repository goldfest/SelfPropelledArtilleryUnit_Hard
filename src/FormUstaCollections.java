import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.util.Stack;

//готовая лаба 3

public class FormUstaCollections {
    FormUstaBat formustabat;
    private JPanel MainPanel;
    private JPanel pictureBoxCollections;
    private JPanel Instruments;
    private JButton ButtonAddUsta;
    private JTextField textFieldNumber;
    private JButton ButtonRefreshCollection;
    private JButton ButtonRemoveUsta;
    private JButton ButtonCreateRandomUsta;
    private JTextField textBoxStorageName;
    private JButton ButtonAddObject;
    private JList listBoxStorage;
    private JButton ButtonRemoveObject;
    private JButton Button_OpenFormRemovedUsta;
    public DrawingUsta usta;
    final UstaGenericStorage _storage;
    FrameUstaBat _frameRemovedUsta;
    private Stack<DrawingUsta> _stackRemoveObjects;
    FrameDopClassParameters frameDopClassParameters;
    public JPanel getPictureBoxCollections() {
        return MainPanel;
    }

    public FormUstaCollections() {
        formustabat = new FormUstaBat();
        _storage = new UstaGenericStorage(700,430);
        _stackRemoveObjects = new Stack<>();
        listBoxStorage.addListSelectionListener(this::listBoxObjectsSelectedIndexChanged);

        ButtonAddObject.addActionListener(e ->
        {
            String NameStorage = textBoxStorageName.getText();
            if (NameStorage.equals("")) {
                JOptionPane.showMessageDialog(this.getPictureBoxCollections(),
                        "Где данные? Напиши хоть что-нибудь",
                        "Ошибка",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            _storage.AddSet(NameStorage);
            ReloadObjects();
            Refresh();
        });

        ButtonRemoveObject.addActionListener(e ->
        {
            if (listBoxStorage.getSelectedIndex() == -1) {
                return;
            }
            JOptionPane.showMessageDialog(this.getPictureBoxCollections(), "Коллекция удалена", "Удаление", JOptionPane.INFORMATION_MESSAGE);
            _storage.DelSet((String) listBoxStorage.getSelectedValue()); //ТУТ СТРИНГ ОБРАТИ ВНИМАНИЕ КАК-НИБУДЬ
            ReloadObjects();
        });

        ButtonAddUsta.addActionListener(e -> {
            if (listBoxStorage.getSelectedIndex() == -1)
                return;
            var obj = _storage.get(listBoxStorage.getSelectedValue().toString()); //  ТУТ ЕЩЕ РАЗ - ОБРАТИ ВНИМАНИЕ НА СТРИНГ
            if (obj == null) {
                return;
            }
            FrameUstaBat frameUstaBat = new FrameUstaBat();
            frameUstaBat.setVisible(true);
            frameUstaBat._formUstaCollection.ButtonSelectUsta.addActionListener(e2 -> {
                usta = frameUstaBat._formUstaCollection._drawingUsta;
                frameUstaBat.dispose();
                if (usta != null) {
                    //проверяем, удалось ли нам загрузить объект
                    if (obj.AddOverload(usta)!= -1) {
                        JOptionPane.showMessageDialog(getPictureBoxCollections(), "Объект добавлен");
                        Refresh();
                    } else {
                        JOptionPane.showMessageDialog(getPictureBoxCollections(), "Не удалось добавить объект");
                    }
                }
            });
        });

        ButtonCreateRandomUsta.addActionListener(e -> {
            if (frameDopClassParameters != null) frameDopClassParameters.dispose();
            frameDopClassParameters = new FrameDopClassParameters();
            frameDopClassParameters.setVisible(true);
        });

        ButtonRemoveUsta.addActionListener(e -> {
            if (listBoxStorage.getSelectedIndex() == -1) {
                return;
            }
            var obj = _storage.get(listBoxStorage.getSelectedValue().toString());
            if (obj == null) {
                return;
            }
            int pos;
            try {
                pos = Integer.parseInt(textFieldNumber.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.getPictureBoxCollections(),
                        "Неверное значение",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            Object[] options = {"Да", "Нет"};
            int n = JOptionPane.showOptionDialog(this.getPictureBoxCollections(),
                    "Удалить объект?",
                    "Все серьезно",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (n == 1) {
                return;
            }
            DrawingUsta removedUsta = obj.SubOverload(pos);
            if (removedUsta != null) {
                _stackRemoveObjects.push(removedUsta);
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
        });

        ButtonRefreshCollection.addActionListener(e -> {
            Refresh();
        });

        Button_OpenFormRemovedUsta.addActionListener(e -> {
            if(_stackRemoveObjects.empty()) {
                JOptionPane.showMessageDialog(this.getPictureBoxCollections(),
                        "Вы ничего не удалили, кажется...",
                        "ой",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            FrameUstaBat RemUsta = new FrameUstaBat();
            RemUsta._formUstaCollection.ChangeUsta(_stackRemoveObjects.pop());
        });

    }

    private void ReloadObjects() {
        int index = listBoxStorage.getSelectedIndex();
        listBoxStorage.setListData(_storage.Keys().toArray());
        if (listBoxStorage.getModel().getSize() > 0 && (index == -1 || index >= listBoxStorage.getModel().getSize())) {
            listBoxStorage.setSelectedIndex(0);
        } else if (listBoxStorage.getModel().getSize() > 0 && index > -1 && index < listBoxStorage.getModel().getSize()) {
            listBoxStorage.setSelectedIndex(index);
        }
        listBoxStorage.invalidate();
    }

    private void listBoxObjectsSelectedIndexChanged(ListSelectionEvent e) {
        Refresh();
    }

    public void Refresh() {
        if (listBoxStorage.getSelectedIndex() == -1) {
            return;
        }
        var obj = _storage.get(listBoxStorage.getSelectedValue().toString());
        if (obj == null) {
            return;
        }
        Graphics g = pictureBoxCollections.getGraphics();
        pictureBoxCollections.paint(g);
        obj.ShowLocomotives((Graphics2D) g);
    }
}
