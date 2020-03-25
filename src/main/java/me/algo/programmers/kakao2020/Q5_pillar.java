package me.algo.programmers.kakao2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Q5_pillar {
    public static void main(String[] args) {
        int n = 5;
//        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

        Q5_pillar q5_pillar = new Q5_pillar();
        int[][] result = q5_pillar.solution(n, build_frame);
        for (int[] resultDetail : result) {
            System.out.println(Arrays.toString(resultDetail));
        }
    }

    HashMap<String, Integer> result = new HashMap<>();

    public int[][] solution(int n, int[][] build_frame) {
        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];
            String key = String.valueOf(x) + "_" + String.valueOf(y) + "_" + String.valueOf(a);

            //벽면을 벗어나게 기둥,보를 설치하는 경우는 없음
            if (a == 0) {   //0은 기둥
                if (y + 1 > n) continue;
            } else {
                if (x + 1 > n) continue;
                //바닥에 보를 설치하는 경우는 없음
                if (y == 0) continue;
            }

            if (b == 1) {
                result.put(key, 1);
                if (!check()) {
                    result.remove(key);
                }
            } else {
                result.remove(key);
                if (!check()) {
                    result.put(key, 1);
                }
            }
        }

        return hashmapToArray(result);
    }

    public Boolean check() {
        for (String key : result.keySet()) {
            String[] keyArray = key.split("_");
            int x = Integer.parseInt(keyArray[0]);
            int y = Integer.parseInt(keyArray[1]);
            int a = Integer.parseInt(keyArray[2]);
            Boolean resultValue = false;

            if (a == 0) {
                if (y == 0) resultValue = true;
                if (result.containsKey(String.valueOf(x - 1) + "_" + String.valueOf(y) + "_" + String.valueOf(1)))
                    resultValue = true;
                if (result.containsKey(String.valueOf(x) + "_" + String.valueOf(y) + "_" + String.valueOf(1)))
                    resultValue = true;
                if (result.containsKey(String.valueOf(x) + "_" + String.valueOf(y - 1) + "_" + String.valueOf(0)))
                    resultValue = true;
            } else {  //보는 한쪽 끝 부분이 기둥위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 함
                if (result.containsKey(String.valueOf(x) + "_" + String.valueOf(y - 1) + "_" + String.valueOf(0)))
                    resultValue = true;
                if (result.containsKey(String.valueOf(x + 1) + "_" + String.valueOf(y - 1) + "_" + String.valueOf(0)))
                    resultValue = true;
                if (result.containsKey(String.valueOf(x - 1) + "_" + String.valueOf(y) + "_" + String.valueOf(1)) && result.containsKey(String.valueOf(x + 1) + "_" + String.valueOf(y) + "_" + String.valueOf(1)))
                    resultValue = true;
            }

            if(!resultValue) return false;
        }

        return true;
    }

    public int[][] hashmapToArray(HashMap<String, Integer> target) {
        int[][] resultValue = new int[target.size()][3];
        int nCnt = 0;
        for (String key : target.keySet()) {
            String[] keyStr = key.split("_");
            int[] resultDetail = {Integer.parseInt(keyStr[0]), Integer.parseInt(keyStr[1]), Integer.parseInt(keyStr[2])};
            resultValue[nCnt] = resultDetail;
            nCnt++;
        }

        sortArray(resultValue);
        return resultValue;
    }

    public void sortArray(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int x1 = o1[0];
                int y1 = o1[1];
                int a1 = o1[2];

                int x2 = o2[0];
                int y2 = o2[1];
                int a2 = o2[2];

                if (x1 < x2) {
                    return -1;
                } else if (x1 == x2) {
                    if (y1 < y2) {
                        return -1;
                    } else if (y1 == y2) {
                        if (a1 == 0) {
                            return -1;
                        } else {
                            return 1;
                        }
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });
    }
}
