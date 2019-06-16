package com.denghb;

/**
 * @Auther: denghb
 * @Date: 2019-06-13 22:47
 */
public class Commodity {

    private Integer id;

    private String name;

    private Integer weight;

    private Integer floatWeight;

    private Integer num;

    public Commodity(Commodity c, int num) {
        this.id = c.id;
        this.name = c.name;
        this.weight = c.weight;
        this.floatWeight = c.floatWeight;
        this.num = num;
    }

    public Commodity(Integer id, String name, Integer weight, Integer floatWeight, Integer num) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.floatWeight = floatWeight;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getFloatWeight() {
        return floatWeight;
    }

    public void setFloatWeight(Integer floatWeight) {
        this.floatWeight = floatWeight;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", floatWeight=" + floatWeight +
                ", num=" + num +
                '}';
    }
}
