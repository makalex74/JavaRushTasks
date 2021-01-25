package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 102;
    }
    public String getDescription() {
        //return "Я - молдавская курица.";
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}
