package com.self_practices.alg;

import java.util.*;

/**
 * Created by Administrator on 2016/4/28.
 */
public class Array_Test {
    public static void main(String args[]) {
        while(true) {
            Scanner cin = new Scanner(System.in);
            String input = cin.nextLine();
            Array_Test m = new Array_Test();
            //m.charCount(input);
            String result = m.process1(input);
            if("".equals(result))
                result = "haha";

            System.out.println(result);
        }
    }

    public static void charCount(String str){
        char[] chs = str.toCharArray();

        TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();

        int count =0;
        for(int x =0;x<chs.length;x++){
            Integer value = tm.get(chs[x]);
            if(value!=null)
                count = value;
            count++;
            tm.put(chs[x], count);
            count = 0;
        }

        Set<Map.Entry<Character, Integer>> entrySet = tm.entrySet();
        Iterator<Map.Entry<Character, Integer>> it1 = entrySet.iterator();
        int min =20;

        while(it1.hasNext()){
            Map.Entry<Character, Integer> me = it1.next();
            Integer value = me.getValue();
            if(min>value)
                min = value;
        }

        Iterator<Map.Entry<Character, Integer>> it2 = entrySet.iterator();
        String temp ="";
        while(it2.hasNext()){
            Map.Entry<Character, Integer> me = it2.next();
            Integer value = me.getValue();
            Character key = me.getKey();

            if(value == min)
                temp = temp+key;
        }

        for(int i = 0;i<temp.length();i++){
            String[] arr = str.split(temp.charAt(i)+"");
            str = "";
            for(String x:arr)
                str = str+x;
        }

        System.out.println(str);
    }



    private static String process3(String s) {
        int length = s.length();

        char c[] = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        //先使用hashmap来统计每个字符的出现次数
        for (int i = 0; i < length; i++) {
            if (hm.get(c[i]) == null)
                hm.put(c[i], 1);
            else {
                int tem = 1 + hm.get(c[i]);
                hm.put(c[i], tem);

            }
        }
        int min = 65535;
        for (int i = 0; i < length; i++) {
            if (hm.get(c[i]) < min)
                min = hm.get(c[i]);

        }
        char cc[] = new char[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (hm.get(c[i]) > min) {
                cc[index] = c[i];
                index++;
            }
        }

        return new String(cc).trim();
    }

    public String process2(String input){
        char[] chars = new char[255];
        char[] in = input.toCharArray();

        Set<Character> set = new HashSet<Character>();//记录所有出现的最大的字符
        int maxCount = 0;//最大的次数
        for (int i = 0; i < in.length; i++) {
            int tempCount = (int)++chars[in[i]];//统计字符出现的次数，数组下标代表字符，数组内容记录次数
            if(tempCount >= maxCount){

                if(tempCount > maxCount)//如果当前的字符次数比最大的大则清除记录
                    set.clear();
                maxCount = tempCount;
                set.add(in[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        Object[] array = set.toArray();//保存所有出现次数最大的字符的数组
        for (int i = 0; i < array.length; i++) { //可能有多个字符出现次数都是最大
            for (int j = 1; j <= maxCount; j++) {//最大的次数
                sb.append((array[i]).toString());
            }
        }

        return sb.toString();
    }

//    public static void main(String[] args){
//        String str = "ddeddeddsqww";
//        String result = process(str);
//        if("".equals(result))
//            result = "jaja";
//        System.out.println(result);
//    }

//    public static String process(String str) {
//        if(str == null || "".equals(str)) return str;
//
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if (map.containsKey(ch)) {
//                int num = map.get(ch);
//                num++;
//                map.put(ch, num);
//            } else
//                map.put(ch, 1);
//        }
//
//        Character k0 = null;
//        Integer v0 = null;
//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry en = (Map.Entry) iter.next();
//            char k = (Character) en.getKey();
//            int v = (Integer) en.getValue();
//
//            if (k0 == null) {
//                k0 = k;
//                v0 = v;
//            } else {
//                if (v < v0) {
//                    v0 = v;
//                    k0 = k;
//                }
//            }
//        }
//
//        Iterator iter1 = map.entrySet().iterator();
//        List<Character> list = new ArrayList();
//        while (iter1.hasNext()) {
//            Map.Entry en = (Map.Entry) iter1.next();
//            char k = (Character) en.getKey();
//            int v = (Integer) en.getValue();
//
//            if(v == v0)
//                list.add(k);
//        }
//
//        for(int k = 0; k < list.size(); k++) {
//            String[] splits = str.split(list.get(k).toString());
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < splits.length; i++) {
//                sb.append(splits[i]);
//            }
//            str = sb.toString();
//        }
//        return str;
//    }


    public static  String process1(String str) {
        if(str == null || "".equals(str)) return str;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                int num = map.get(ch);
                num++;
                map.put(ch, num);
            } else
                map.put(ch, 1);
        }

        Character k0 = null;
        Integer v0 = null;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry en = (Map.Entry) iter.next();
            char k = (Character) en.getKey();
            int v = (Integer) en.getValue();

            if (k0 == null) {
                k0 = k;
                v0 = v;
            } else {
                if (v < v0) {
                    v0 = v;
                    k0 = k;
                }
            }
        }


        Iterator iter1 = map.entrySet().iterator();
        List<Character> list = new ArrayList();
        while (iter1.hasNext()) {
            Map.Entry en = (Map.Entry) iter1.next();
            char k = (Character) en.getKey();
            int v = (Integer) en.getValue();

            if(v == v0)
                list.add(k);
        }

        for(int k = 0; k < list.size(); k++) {
            String[] splits = str.split(list.get(k).toString());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < splits.length; i++) {
                sb.append(splits[i]);
            }
            str = sb.toString();
        }
        return str;
    }
}
