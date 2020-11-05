package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void exit(){
        controller.exit();
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void init(){
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);
    }

    public void selectedTabChanged(){

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", htmlScrollPane);
        JScrollPane plainScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", plainScrollPane);
        tabbedPane.setPreferredSize(new Dimension(500, 500));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar,BorderLayout.NORTH);

    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }
    public boolean canRedo() {
        return undoManager.canRedo();
    }
    public void undo(){
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(this, "Самый Крутой HTML редактор", "О программе", JOptionPane.INFORMATION_MESSAGE);
    }
}

/*
HTML Editor (14)
14.1. Добавь в класс представления метод selectHtmlTab(). Он должен:
14.1.1. Выбирать html вкладку (переключаться на нее).
14.1.2. Сбрасывать все правки с помощью метода, который ты реализовал ранее.
14.2. Добавь в класс контроллера геттер для модели, в нашем случае это поле document.
14.3. Добавь в представление метод update(), который должен получать документ у контроллера и устанавливать его в панель редактирования htmlTextPane.
14.4. Добавь в представление метод showAbout(), который должен показывать диалоговое окно с информацией о программе.
Информацию придумай сам, а вот тип сообщения должен быть JOptionPane.INFORMATION_MESSAGE.


Требования:
1. Класс View должен содержать публичный метод selectHtmlTab(), который должен выбирать вкладку и сбрасывать все правки.
2. Класс Controller должен содержать геттер для поля document.
3. Класс View должен содержать публичный метод update(), который должен устанавливать документ в панель редактирования.
4. Класс View должен содержать публичный метод showAbout(), который должен показывать диалоговое окно с информацией о программе.


HTML Editor (9)
9.1. Реализуй метод initMenuBar(). Он должен:
9.1.1. Создавать новый объект типа JMenuBar. Это и будет наша панель меню.
9.1.2. С помощью MenuHelper инициализировать меню в следующем порядке: Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
9.1.3. Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому, как это мы делали с панелью вкладок.
9.2. Добавь конструктор класса View. Он должен устанавливать внешний вид и поведение (look and feel) нашего приложения такими же, как это определено в системе.
Конструктор не должен кидать исключений, только логировать их с помощью ExceptionHandler.

Подсказа: для реализации задания используй класс UIManager.

Запусти приложение, теперь ты должен видеть панель с меню вверху окна. Некоторые из пунктов меню (например: Вырезать, Копировать, Вставить, Стиль (частично), Выравнивание, Цвет, Шрифт) должны уже работать. Убедись, что все работает и только затем продолжи разработку.

Требования:
1. В методе initMenuBar() должно создаваться новое меню (объект типа JMenuBar).
2. В методе initMenuBar() c помощью MenuHelper должно быть проинициализировано меню в следующем порядке: Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
3. В методе initMenuBar() должно добавляться новосозданное меню в верхнюю часть панели контента текущего фрейма, используя метод getContentPane().
4. В конструкторе класса View, через класс UIManager, должен устанавливаться внешний вид и поведение (look and feel).


HTML Editor (6)
Реализуй метод инициализации панелей редактора initEditor(). Он должен:
6.1. Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane.
Найди и используй подходящий метод.
6.2. Создавать новый локальный компонент JScrollPane на базе htmlTextPane.
6.3. Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта.
6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane.
6.5. Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом из предыдущего пункта.
6.6. Устанавливать предпочтительный размер панели tabbedPane.
6.7. Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений в tabbedPane.
6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
Получить панель контента текущего фрейма можно с помощью метода getContentPane(), его реализация унаследовалась от JFrame.
Подумай, метод с какими параметрами необходимо вызвать, чтобы панель с вкладками отображалась по центру панели контента текущего фрейма.
После запуска приложения можно будет увидеть текущие результаты: две независимые закладки (HTML и Текст), в каждой из которых можно набирать свой текст.

Требования:
1. В методе initEditor() для компонента htmlTextPane должен устанавливаться тип контента "text/html" через сеттер setContentType.
2. В методе initEditor() должен создаваться новый локальный компонент JScrollPane через конструктор принимающий htmlTextPane.
3. В методе initEditor() для компонента tabbedPane должна добавляться вкладка с именем "HTML" и созданным компонентом JScrollPane на базе htmlTextPane.
4. В методе initEditor() должен создаваться новый локальный компонент JScrollPane через конструктор принимающий plainTextPane.
5. В методе initEditor() для компонента tabbedPane должна добавляться вкладка с именем "Текст" и созданным компонентом JScrollPane на базе plainTextPane.
6. В методе initEditor() для компонента tabbedPane должен устанавливаться предпочтительный размер панели, через сеттер setPreferredSize.
7. В методе initEditor() для компонента tabbedPane должен добавляться слушатель TabbedPaneChangeListener через метод addChangeListener.
8. Метод initEditor() должен добавлять по центру панели контента текущего фрейма нашу панель с вкладками, через getContentPane().add().

HTML Editor (4)
4.1. Объяви методы initMenuBar() и initEditor() в классе View. Они будут отвечать за инициализацию меню и панелей редактора.
4.2. Объяви в представлении метод initGui(). Он будет инициализировать графический интерфейс.
Вызови из него инициализацию меню initMenuBar(), инициализацию редактора initEditor() и метод pack(), реализацию которого мы унаследовали от класса JFrame.
Разберись что делает метод pack().
4.3. Реализуй метод init() представления. Он должен:
4.3.1. Вызывать инициализацию графического интерфейса initGui().
4.3.2. Добавлять слушателя событий нашего окна. В качестве подписчика создай и используй объект класса FrameListener.
В качестве метода для добавления подписчика используй подходящий метод из класса Window от которого наследуется и наш класс через классы JFrame и Frame.
4.3.3. Показывать наше окно. Используй метод setVisible с правильным параметром.
На этом этапе приложение при запуске должно показывать окно, которое можно растягивать, разворачивать, закрыть и т.д.

Требования:
1. Класс View должен содержать метод public void initMenuBar().
2. Класс View должен содержать метод public void initEditor().
3. Класс View должен реализовывать метод public void initGui().
4. Реализуй метод init() класса View, согласно задания.


HTML Editor (3)
Графический интерфейс будет представлять собой окно, в котором будет меню и панель с двумя вкладками.
На первой вкладке будет располагаться текстовая панель, которая будет отрисовывать html страницу.
На ней можно будет форматировать и редактировать текст страницы.
На второй вкладке будет редактор, который будет отображать код html страницы,
в нем будут видны все используемые html теги. В нем также можно будет менять текст страницы, добавлять и удалять различные теги.
3.1. Добавь и проинициализируй поля в классе представления:
3.1.1. JTabbedPane tabbedPane - это будет панель с двумя вкладками.
3.1.2. JTextPane htmlTextPane - это будет компонент для визуального редактирования html.
Он будет размещен на первой вкладке.
3.1.3. JEditorPane plainTextPane - это будет компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое).
3.2. Добавь класс FrameListener в пакет listeners. Он должен:
3.2.1. Быть унаследован от WindowAdapter.
3.2.2. Иметь поле View view.
3.2.3. В конструкторе принимать View и инициализировать внутреннее поле.
3.2.4. Иметь переопределенный метод windowClosing(WindowEvent windowEvent), который должен вызывать exit() у представления.


Требования:
1. Класс View должен содержать приватное проинициализированое поле JTabbedPane tabbedPane.
2. Класс View должен содержать приватное проинициализированое поле JTextPane htmlTextPane.
3. Класс View должен содержать приватное проинициализированое поле JEditorPane plainTextPane.
4. Класс FrameListener должен быть создан в отдельном файле.
5. Класс FrameListener должен содержать приватное поле View view.
6. Класс FrameListener должен содержать конструктор с одним параметром, инициализирующий поле view.
7. В классе FrameListenerМетод должен быть метод windowClosing(WindowEvent windowEvent).
 */
