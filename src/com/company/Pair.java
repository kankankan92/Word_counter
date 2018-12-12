package com.company;

public class Pair implements Comparable<Pair> {

    private int count;
    private String word;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(Pair pair) {
        if (this.getCount() == pair.getCount()) {
            if (this.getWord().compareTo(pair.getWord()) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.getCount() > pair.getCount()) {
            return -1;
        } else
            return 1;
    }
}
