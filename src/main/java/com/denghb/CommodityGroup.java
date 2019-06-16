package com.denghb;

import java.util.List;

/**
 * @Auther: denghb
 * @Date: 2019-06-15 17:00
 */
public class CommodityGroup implements Comparable<CommodityGroup> {

    private Integer weight;

    private List<Commodity> list;

    public CommodityGroup(Integer weight, List<Commodity> list) {
        this.weight = weight;
        this.list = list;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Commodity> getList() {
        return list;
    }

    public void setList(List<Commodity> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CommodityGroup{" +
                "weight=" + weight +
                ", list=" + list +
                '}';
    }

    @Override
    public int compareTo(CommodityGroup o) {
        return weight - o.weight;
    }
}
