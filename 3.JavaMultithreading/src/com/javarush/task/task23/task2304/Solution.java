package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/* 
Inner 3
*/
public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

/*
5. Метод refreshAllData в классе TaskDataProvider должен сохранять в список tasks результат работы метода getFakeTasks класса MockDB.
6. Метод refreshAllData в классе NameDataProvider должен сохранять в список names результат работы метода getFakeNames класса MockDB.
*/
    private class TaskDataProvider implements DbDataProvider<Task>{
        @Override
        public void refreshAllData(Map criteria) {
            MockDB mockDB = new MockDB();
            Solution.this.tasks=mockDB.getFakeTasks(criteria);
        }

    }

    private class NameDataProvider implements DbDataProvider<String>{
        @Override
        public void refreshAllData(Map criteria) {
            MockDB mockDB = new MockDB();
            Solution.this.names=mockDB.getFakeNames(criteria);
        }
    }


    public static void main(String[] args) {

    }
}
