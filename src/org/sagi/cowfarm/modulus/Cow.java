package org.sagi.cowfarm.modulus;

public class Cow {

    private int id;
    private String NickName;
    private int generation;
    private Cow mother;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public Cow getMother() {
        return mother;
    }

    public void setMother(Cow mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        String cowInfo;
        cowInfo = this.getNickName() + (this.getMother() != null?" [" + this.getMother().getNickName() + "]":"");
        return cowInfo;
    }
}
