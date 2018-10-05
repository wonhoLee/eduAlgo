package me.algo.programmers;

import java.util.Arrays;

public class Test2_shipyard {

	public static void main(String[] args) {
		int no = 4;
		int[] works = {4,3,3};	//12
		//int no = 2;
		//int[] works = {3,3,3};	//17
		
		System.out.println(solution(no, works));

	}

	//�����ؼ� Ǯ��
	public static int solution(int no, int[] works) {
        int result = 0;
        
        Arrays.sort(works);
        int max = works[works.length-1];

        while(no>0) {
            for(int j=works.length-1; j>=0; j--) {
                if (no<=0) break;
                if(max == works[j]) {
                    if(works[j]>0) {
                         works[j]--;
                    } 
                    no--;

                }
            }
            max--;
            if(max == 0) break;
        }

        for (int i = 0; i < works.length; i++) {
			result += works[i] * works[i];
		}

        return result;
    }
	
	//CASE 4 : ���������� ȿ���� ����
	/*public static int solution(int no, int[] works) {
        int result = 0;
        
        while(no > 0) {
        	Arrays.sort(works);
        	if(works[works.length-1] == 0) {
        		break;
        	}else {
        		works[works.length-1] --;
            	no--;
        	}
        }

        for (int i = 0; i < works.length; i++) {
			result += Math.pow(works[i], 2);
		}

        return result;
    }*/
	
	//CASE3 : ����
	/*public static int solution(int no, int[] works) {
        int result = 0;
        
        while(no > 0) {
        	Arrays.sort(works);
        	works[works.length-1] --;
        	no--;
        }

        for (int i = 0; i < works.length; i++) {
			result += Math.pow(works[i], 2);
		}

        return result;
    }*/
	
	//CASE2 : ����
	/*public static int solution(int no, int[] works) {
        int result = 0;
        
        while(no > 0) {
        	Arrays.sort(works);
        	if(works[0] == works[works.length-1]) {
        		works[0]--;
        		no--;
        	}else {
        		works[works.length-1] --;
        		no--;
        	}
        }

        for (int i = 0; i < works.length; i++) {
			result += Math.pow(works[i], 2);
		}

        return result;
    }*/
	
	//CASE1 : ����
	/*public static int solution(int no, int[] works) {
        int result = 0;
        
        while(no > 0) {
        	Arrays.sort(works);
        	if(works[0] == works[works.length-1]) {
        		works[0] = works[0] - 1;
        		no--;
        	}else {
        		int nTemp = works[works.length-1] - works[0];
        		if(nTemp > no) {
        			works[works.length-1] = works[works.length-1] - no;
        			no = 0;
        		}else {
        			works[works.length-1] = works[works.length-1] - nTemp;
        			no = no - nTemp;
        		}
        	}
        }

        for (int i = 0; i < works.length; i++) {
			result += Math.pow(works[i], 2);
		}

        return result;
    }*/
}
