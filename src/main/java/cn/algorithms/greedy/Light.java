package cn.algorithms.greedy;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 给定一个字符串str，只由‘X’和‘.’两种字符构成。
 * ‘X’表示墙，不能放灯，也不需要点亮
 * ‘.’表示居民点，可以放灯，需要点亮
 * 如果灯放在i位置，可以让i-1，i和i+1三个位置被点亮
 * 返回如果点亮str中所有需要点亮的位置，至少需要几盏灯
 * @Auther: TaoistQu
 * @Date: 2021/07/05/23:29
 */
public class Light {

    public static int minLight1(String road) {
        if (road == null || road.length() == 0) {
            return 0;
        }
        return process(road.toCharArray(), 0, new HashSet<>());
    }

    public static int process(char[] str, int index, HashSet<Integer> lights) {
        if (index == str.length) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] != 'X') {
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else {
            int no = process(str, index + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (str[index] == '.') {
                lights.add(index);
                yes = process(str, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

    public static int minLight2(String road) {
        char[] str = road.toCharArray();
        int i = 0;
        int light = 0;
        while (i < str.length) {
            if (str[i] == 'X') {
                i++;
            } else {
                light++;
                if (i + 1 == str.length) {
                    break;
                } else {
                    if (str[i + 1] == 'X') {
                        i = i + 2;
                    } else {
                        // i+1 -> .
                        // i+2 -> x  i+1 =o
                        // i+2 -> . i+1 =o
                        i = i + 3;
                    }
                }
            }
        }
        return light;
    }

    public static String randomString(int len) {
        char[] res = new char[(int) (Math.random() * len) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.random() < 0.5 ? 'X' : '.';
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        int len = 20;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            String test = randomString(len);
            if (minLight1(test) != minLight2(test)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
