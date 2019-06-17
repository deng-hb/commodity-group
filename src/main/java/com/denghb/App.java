package com.denghb;

import java.util.*;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        List<Commodity> input = new ArrayList<Commodity>();
        input.add(new Commodity(1, "光明牛奶", 241, 5, 2));
        input.add(new Commodity(2, "可口可乐", 356, 5, 3));
        input.add(new Commodity(3, "农夫山泉", 513, 5, 4));
        input.add(new Commodity(4, "脉动饮料", 756, 5, 5));
//        input.add(new Commodity(5, "红牛饮料", 485, 5, 20));

        Set<String> union = new HashSet<>();

        long start = System.currentTimeMillis();
        // 全组合 weight , 商品列表
        List<CommodityGroup> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            Commodity c = input.get(i);
            for (int n = 1; n <= c.getNum(); n++) {
                int w = c.getWeight() * n;
                List<Commodity> cList = Arrays.asList(new Commodity(c, n));
                output.add(new CommodityGroup(w, cList));
                union.add(c.getId() + ":" + n + ";");

                doGroup(i, input, union, cList, output);
            }

        }

//        Collections.sort(output);

        for (CommodityGroup cc : output) {
            System.out.println(cc);
        }

        Set<Integer> set = new HashSet<>();
        for (CommodityGroup cc : output) {
            if (set.contains(cc.getWeight())) {
                System.out.println("############################" + cc.getWeight());
            }
            set.add(cc.getWeight());
        }

        System.out.println(String.format("size:%d;merge:%d;%dms\n\n", output.size(), set.size(), (System.currentTimeMillis() - start)));


        for (CommodityGroup cc : output) {
            if (cc.getWeight() >= 560) {
                System.out.println(cc);
                break;
            }
        }

    }

    private static void doGroup(int i, List<Commodity> input, Set<String> union, List<Commodity> cList, List<CommodityGroup> output) {

        for (int next = 1; next < input.size(); next++) {
            List<Commodity> c2List = new ArrayList<Commodity>(cList);
            for (int j = i + next; j < input.size(); j++) {
                Commodity c = input.get(j);
                for (int n = 1; n <= c.getNum(); n++) {

                    // 存在的改变数量
                    boolean exist = false;
                    for (Commodity c2 : c2List) {
                        if (c2.getId().intValue() == c.getId()) {
                            exist = true;
                            c2.setNum(n);
                            break;
                        }
                    }
                    if (!exist) {
                        c2List.add(new Commodity(c, n));
                    }

                    int weight = 0;
                    List<Commodity> c3List = new ArrayList<Commodity>();

                    String key = "";
                    for (Commodity c2 : c2List) {
                        weight += c2.getNum() * c2.getWeight();
                        c3List.add(new Commodity(c2, c2.getNum()));// 防止对象引用
                        key += c2.getId() + ":" + c2.getNum() + ";";
                    }

                    if (!union.contains(key)) {
                        union.add(key);
                        output.add(new CommodityGroup(weight, c3List));
                    }
                    if (c.getNum() > 1) {
                        doGroup(j, input, union, c2List, output);
                    }
                }
            }

        }
    }
}
