package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
    }
}

/*
11.2. Добавь класс UndoListener реализующий интерфейс UndoableEditListener в пакет listeners.
Этот класс будет следить за правками, которые можно отменить или вернуть.
11.3. Добавь в класс UndoListener:
11.3.1. Поле UndoManager undoManager.
11.3.2. Конструктор, который принимает UndoManager и инициализирует поле класса.
11.3.3. Метод undoableEditHappened(UndoableEditEvent e). Он должен из переданного события получать правку и добавлять ее в undoManager.
 */
