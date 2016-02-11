package com.codeundone.advancedrecyclerview.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DummyData {

    public static List<DummyData> createDummyDataListSorted() {
        final List<DummyData> list = createDummyDataList();
        Collections.sort(list, new Comparator<DummyData>() {
            @Override
            public int compare(DummyData lhs, DummyData rhs) {
                return lhs.title.compareToIgnoreCase(rhs.title);
            }
        });
        return list;
    }

    public static List<DummyData> createDummyDataList() {
        return Arrays.asList(
                new DummyData("Bacon", "ipsum", "dolor"),
                new DummyData("amet", "frankfurter", "meatball"),
                new DummyData("pork", "belly", "strip"),
                new DummyData("steak", "ham", "hock"),
                new DummyData("doner", "alcatra", "pork"),
                new DummyData("chop", "beef", "ribs"),
                new DummyData("Beef", "salami", "flank"),
                new DummyData("sirloin", "ribeye", "Landjaeger"),
                new DummyData("leberkas", "tail", "cow"),
                new DummyData("hamburger", "pork", "loin"),
                new DummyData("rump", "picanha", "meatball"),
                new DummyData("andouille", "beef", "ribs"),
                new DummyData("flank", "sausage", "andouille"),
                new DummyData("Turkey", "salami", "corned"),
                new DummyData("beef", "chicken", "shankle"),
                new DummyData("sausage", "capicola", "fatback"),
                new DummyData("Meatball", "tail", "venison"),
                new DummyData("hamburger", "chuck", "shank"),
                new DummyData("pork", "loin", "shankle"),
                new DummyData("drumstick", "Fatback", "hamburger"),
                new DummyData("salami", "porchetta", "biltong"),
                new DummyData("boudin", "bacon", "pork"),
                new DummyData("loin", "Pork", "belly"),
                new DummyData("pork", "beef", "ribs"),
                new DummyData("shoulder", "doner", "ham"),
                new DummyData("ground", "round", "landjaeger"),
                new DummyData("Rump", "cow", "jowl"),
                new DummyData("ball", "tip", "strip"),
                new DummyData("steak", "brisket", "biltong")
        );
    }

    public String title;
    public String desc;
    public String meta;

    public DummyData(String title, String desc, String meta) {
        this.title = title;
        this.desc = desc;
        this.meta = meta;
    }
}
