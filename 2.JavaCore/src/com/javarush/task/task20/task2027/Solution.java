package com.javarush.task.task20.task2027;

import javafx.scene.control.ListCell;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
/*
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
*/

        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'a', 'a', 'r', 'o', 'v'},
                {'m', 'm', 'e', 'm', 'o', 'h'},
                {'p', 'e', 'e', 'e', 'e', 'j'}
        };

/*        for (int i = 0; i < crossword.length ; i++) {
            for (int j = 0; j < crossword[i].length ; j++) {
                System.out.print((char)crossword[i][j] +"(" + j +","+ i +")");
            }
            System.out.println();
        }*/

        //List<Cell> listCellsAround  = cellsAroundCell(crossword, new Cell('e',new Crd(4,3)));

        detectAllWords(crossword, "home", "same");
        //detectAllWords(crossword, "m", "e", "a");

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

/*    public static Point findPointForLetter(int[][] crossword, char letter){
        Point point = null;
        for (int i = 0; i < crossword.length ; i++) {
            for (int j = 0; j < crossword[i].length ; j++) {
                if (crossword[i][j] == letter){
                    point = new Point(i,j);
                }
            }
        }
        return point;
    }*/



    public static List<Word> detectWord(int[][] crossword, String word){
        List<Word> resultList = new ArrayList<>();
        List<Cell> cellResultList = new ArrayList<>();
        char[] chArr = word.toCharArray();
        //Список всех встречающихся в массиве первых слогов
        List<CellPair> listCellPair = new ArrayList<>();
        //Находим для первой буквы слова все ячейки в массиве
        List<Cell> listCellsForFirstLetter = findAllCellForLetter(crossword, chArr[0]);
        //Бежим по списку всех ячеек для буквы
        if (word.length() == 1){
            for (Cell cellOne: listCellsForFirstLetter) {
                Word resultWord = new Word(word);
                resultWord.setStartPoint(cellOne.getCrd().getJ(), cellOne.getCrd().getI());
                resultWord.setEndPoint(cellOne.getCrd().getJ(), cellOne.getCrd().getI());
                resultList.add(resultWord);
            }
            return resultList;
        }
        else {
            //Бежим по списку всех ячеек для буквы
            for (int i = 0; i < listCellsForFirstLetter.size(); i++) {
                //Находим для ячейки все ячейки которые её окружают
                List<Cell> listCellsAroundFirst = cellsAroundCell(crossword, listCellsForFirstLetter.get(i));
                for (int j = 0; j < listCellsAroundFirst.size() ; j++) {
                    //Находим вторую букву и записываем в список "Первых слогов"
                    if (listCellsAroundFirst.get(j).getLetter() == chArr[1]){
                        CellPair cellPair = new CellPair(listCellsForFirstLetter.get(i),listCellsAroundFirst.get(j));
                        listCellPair.add(cellPair);
                    }
                }
            }
            //Бежим по списку всех встречающихся в массиве первых слогов
            for (CellPair cellPair: listCellPair) {
                Cell firstCell = cellPair.getFirstCell();
                Cell secondCell = cellPair.getSecondCell();
                cellResultList.add(firstCell);
                cellResultList.add(secondCell);
                //и вычисляем направление слова в массиве
                int lineI = secondCell.getCrd().getI() - firstCell.getCrd().getI();
                int lineJ = secondCell.getCrd().getJ() - firstCell.getCrd().getJ();
                if (chArr.length > 2){
                   //Бежим по буквам слова начиная со второй буквы
                   for (int i = 1; i < chArr.length ; i++) {
                       //Находим для буквы все ячейки в массиве
                       List<Cell> listCellsForLetter = findAllCellForLetter(crossword, chArr[i]);
                       //Бежим по списку всех ячеек для буквы
                       for (Cell cell: listCellsForLetter) {
                            //Находим для ячейки все ячейки которые её окружают
                           List<Cell> listCellsAround  = cellsAroundCell(crossword,cell);
                           //Бежим по всем ячейкам которые её окружают
                           for (Cell cellAround: listCellsAround) {
                               //Если это не последняя буква и в соседней ячейке есть следующая буква
                               if ((i < chArr.length -1)  && (cellAround.getLetter() == chArr[i+1])) {
                                   Cell BeforeCell = cellResultList.get(cellResultList.size()-1);
                                   Cell CurrentCell = cellAround;
                                   //Если текущая ячейка в правильном направлении добавляем ее в список
                                   if ((CurrentCell.getCrd().getI() - BeforeCell.getCrd().getI() == lineI)
                                           && (CurrentCell.getCrd().getJ() - BeforeCell.getCrd().getJ() == lineJ)) {
                                       cellResultList.add(cellAround);
                                   }
                               }
                           }
                       }
                   }
                }
                String resWord = "";
                for (Cell cell: cellResultList) {
                    resWord += cell.getLetter();

                }
                //System.out.println("resWord: "+resWord);
                //System.out.println("word: "+word);
                if (resWord.equals(word)) {
                    Word resultWord = new Word(word);
                    resultWord.setStartPoint(cellResultList.get(0).getCrd().getJ(), cellResultList.get(0).getCrd().getI());
                    resultWord.setEndPoint(cellResultList.get(cellResultList.size() - 1).getCrd().getJ(), cellResultList.get(cellResultList.size() - 1).getCrd().getI());
                    resultList.add(resultWord);
                }
                //System.out.println(resultList);
                cellResultList.clear();
            }
        }
        return resultList;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        if (words.length == 0) return null;

        List<Word> listResult = new ArrayList<>();
        for (String word: words) {
//            if (word.equals("same")) {
                listResult.addAll(detectWord(crossword, word));
//            }
        }

        for (Word word : listResult) {
            System.out.println(word);
        }

        return listResult;
    }

   public static List<Cell> cellsAroundCell(int[][] crossword, Cell cell){
       //System.out.println(crossword[0].length); //6 горизонталь - ось J
       //System.out.println(crossword.length);  //5 вертикаль - ось I
       List<Cell> list = new ArrayList<>();
       //1
       if ((cell.getCrd().getI() > 0) && (cell.getCrd().getI() < crossword.length) &&
           (cell.getCrd().getJ() > 0) && (cell.getCrd().getJ() < crossword[0].length)) {
           list.add(new Cell((char) crossword[cell.getCrd().getI() - 1][cell.getCrd().getJ() - 1], new Crd(cell.getCrd().getI() - 1, cell.getCrd().getJ() - 1)));
       }
       //2
       if ((cell.getCrd().getI() > 0) && (cell.getCrd().getI() < crossword.length) &&
           (cell.getCrd().getJ() >= 0) && (cell.getCrd().getJ() < crossword[0].length)) {
           list.add(new Cell((char) crossword[cell.getCrd().getI() - 1][cell.getCrd().getJ()], new Crd(cell.getCrd().getI() - 1, cell.getCrd().getJ())));
       }
       //3
       if ((cell.getCrd().getI() > 0) && (cell.getCrd().getI() < crossword.length) &&
           (cell.getCrd().getJ() >= 0) && (cell.getCrd().getJ() < crossword[0].length-1)) {
           list.add(new Cell((char) crossword[cell.getCrd().getI() - 1][cell.getCrd().getJ() + 1], new Crd(cell.getCrd().getI() - 1, cell.getCrd().getJ() + 1)));
       }
       //4
       if ((cell.getCrd().getI() >= 0) && (cell.getCrd().getI() < crossword.length) &&
           (cell.getCrd().getJ() >= 0) && (cell.getCrd().getJ() < crossword[0].length-1)) {
           list.add(new Cell((char) crossword[cell.getCrd().getI()][cell.getCrd().getJ() + 1], new Crd(cell.getCrd().getI(), cell.getCrd().getJ() + 1)));
       }
       //5
       if ((cell.getCrd().getI() >= 0) && (cell.getCrd().getI() < crossword.length-1) &&
           (cell.getCrd().getJ() >= 0) && (cell.getCrd().getJ() < crossword[0].length-1)) {
           list.add(new Cell((char) crossword[cell.getCrd().getI() + 1][cell.getCrd().getJ() + 1], new Crd(cell.getCrd().getI() + 1, cell.getCrd().getJ() + 1)));
       }
       //6
       if ((cell.getCrd().getI() >= 0) && (cell.getCrd().getI() < crossword.length-1) &&
               (cell.getCrd().getJ() >= 0) && (cell.getCrd().getJ() < crossword[0].length)){
           list.add(new Cell((char) crossword[cell.getCrd().getI() + 1][cell.getCrd().getJ()], new Crd(cell.getCrd().getI() + 1, cell.getCrd().getJ())));
       }
       //7
       if ((cell.getCrd().getI() >= 0) && (cell.getCrd().getI() < crossword.length-1) &&
               (cell.getCrd().getJ() > 0) && (cell.getCrd().getJ() < crossword[0].length)){
           list.add(new Cell((char) crossword[cell.getCrd().getI() + 1][cell.getCrd().getJ() - 1], new Crd(cell.getCrd().getI() + 1, cell.getCrd().getJ() - 1)));
       }
       //8
       if ((cell.getCrd().getI() >= 0) && (cell.getCrd().getI() < crossword.length) &&
               (cell.getCrd().getJ() > 0) && (cell.getCrd().getJ() < crossword[0].length)) {
           list.add(new Cell((char) crossword[cell.getCrd().getI()][cell.getCrd().getJ() - 1], new Crd(cell.getCrd().getI(), cell.getCrd().getJ() - 1)));
       }

/*       for (Cell item: list) {
           System.out.println("    "+item);
       }*/
       return list;
   }

    public static List<Cell> findAllCellForLetter(int[][] crossword, char letter){
        List<Cell> list = new ArrayList<>();
        for (int i = 0; i < crossword.length ; i++) {
            for (int j = 0; j < crossword[i].length ; j++) {
                if (crossword[i][j] == letter){
                    list.add(new Cell(letter,new Crd(i,j)));
                }
            }
        }
/*        for (Cell cell: list) {
            System.out.println(cell);
        }*/
        return list;
    }

    public static class CellPair{
        Cell firstCell;
        Cell secondCell;

        public CellPair(Cell firstCell, Cell secondCell) {
            this.firstCell = firstCell;
            this.secondCell = secondCell;
        }

        public Cell getFirstCell() {
            return firstCell;
        }

        public Cell getSecondCell() {
            return secondCell;
        }
    }

    public static class Cell {
        private char letter;
        private Crd crd;

        public Cell(char letter, Crd crd) {
            this.letter = letter;
            this.crd = crd;
        }

        public char getLetter() {
            return letter;
        }

        public Crd getCrd() {
            return crd;
        }

        @Override
        public String toString() {
            return letter +"(" + crd.getI() +","+ crd.getJ()+")";
        }
    }

    public static class Crd {
        private int i;
        private int j;

        public Crd(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
