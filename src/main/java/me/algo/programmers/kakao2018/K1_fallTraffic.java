package me.algo.programmers.kakao2018;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class K1_fallTraffic {

	public static void main(String[] args) {
//		String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};	//1
//		String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};	//2
		String[] lines = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
//		String[] lines = {"2016-09-15 23:59:59.999 0.001s"};

		System.out.println(solution(lines));
	}

	public static int solution(String[] lines) {
		LocalDateTime[][] arrTemp = new LocalDateTime[lines.length][2];
		for (int i = 0; i < lines.length; i++) {
			arrTemp[i] = getLogDateFT(lines[i]);
		}

		int max = 0;
		for (LocalDateTime[] arr : arrTemp) {
			LocalDateTime start = arr[0];
			LocalDateTime startOne = arr[0].plusSeconds(1).minusNanos(1);
			LocalDateTime end = arr[1];
			LocalDateTime endOne = arr[1].plusSeconds(1).minusNanos(1);
			int tempS = 0;
			int tempE = 0;

			for (LocalDateTime[] arr2 : arrTemp) {
				if (ChronoUnit.NANOS.between(start, arr2[0]) >= 0 && ChronoUnit.NANOS.between(arr2[0], startOne) >= 0 ||
						ChronoUnit.NANOS.between(start, arr2[1]) >= 0 && ChronoUnit.NANOS.between(arr2[1], startOne) >= 0 ||
						ChronoUnit.NANOS.between(arr2[0], start) >= 0 && ChronoUnit.NANOS.between(startOne, arr2[1]) >= 0
					) {
					tempS++;
				}

				if (ChronoUnit.NANOS.between(end, arr2[0]) >= 0 && ChronoUnit.NANOS.between(arr2[0], endOne) >= 0 ||
						ChronoUnit.NANOS.between(end, arr2[1]) >= 0 && ChronoUnit.NANOS.between(arr2[1], endOne) >= 0 ||
						ChronoUnit.NANOS.between(arr2[0], end) >= 0 && ChronoUnit.NANOS.between(endOne, arr2[1]) >= 0
				) {
					tempE++;
				}
			}
			max = Math.max(Math.max(tempS, tempE), max);
		}

		return max;
	}


	private static LocalDateTime[] getLogDateFT(String sInput) {
		LocalDateTime[] sRet = new LocalDateTime[2];
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		String sTemp2 = sInput.substring(24, sInput.length() - 1);
		LocalDateTime dTempE = LocalDateTime.parse(sInput.substring(0, 23), dateTimeFormatter);
		LocalDateTime dTempS;
		if (!sTemp2.contains(".")) {
			dTempS = dTempE.minusSeconds(Integer.parseInt(sTemp2));
		} else {
			dTempS = dTempE.minusSeconds(Integer.parseInt(sTemp2.split("\\.")[0]));
			dTempS = dTempS.minusNanos(Integer.parseInt(sTemp2.split("\\.")[1] + "000000"));
		}
		dTempS = dTempS.plusNanos(1000000);

		sRet[0] = dTempS;
		sRet[1] = dTempE;
		return sRet;
	}

	//fail
//	public static int solution(String[] lines) {
//		int answer = 0;
//		LocalDateTime[] laTemp;
//		int nCntS = 0;
//		int nCntE = 0;
//
//		for (int i = 0; i < lines.length; i++) {
//			laTemp = getLogDateFT(lines[i]);
//			for (int j = 0; j < lines.length; j++) {
//				LocalDateTime[] laTempJ = getLogDateFT(lines[j]);
//				if((ChronoUnit.NANOS.between(laTempJ[0], laTemp[1]) >= 0 && ChronoUnit.NANOS.between(laTempJ[1], laTemp[1]) <= 0) ||
//					(ChronoUnit.NANOS.between(laTempJ[0], laTemp[3]) >= 0 && ChronoUnit.NANOS.between(laTempJ[1], laTemp[3]) <= 0) ) {
//					nCntS++;
//				}
//				if((ChronoUnit.NANOS.between(laTempJ[0], laTemp[0]) >= 0 && ChronoUnit.NANOS.between(laTempJ[1], laTemp[0]) <= 0) ||
//						(ChronoUnit.NANOS.between(laTempJ[0], laTemp[2]) >= 0 && ChronoUnit.NANOS.between(laTempJ[1], laTemp[2]) <= 0) ) {
//					nCntE++;
//				}
//			}
//			if(answer < nCntS) {
//				answer = nCntS;
//			}
//			if(answer < nCntE) {
//				answer = nCntE;
//			}
//			nCntS = 0;
//			nCntE = 0;
//		}
//		/*
//
//		�α� ���� �б�
//		���۰� ���ð� ����
//
//		���� �ð� �������� �� ���� - ī��Ʈ
//		�� �ð� ���ִɷ� �� ���� - ī��Ʈ*/
//		return answer;
//	}
//
//	private static LocalDateTime[] getLogDateFT(String sInput) {
//		LocalDateTime[] sRet = new LocalDateTime[4];
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//		String sTemp2 = sInput.substring(24, sInput.length() - 1);
//		LocalDateTime dTempE = LocalDateTime.parse(sInput.substring(0, 23), dateTimeFormatter);
//		LocalDateTime dTempS;
//		if (sTemp2.indexOf(".") == -1) {
//			dTempS = dTempE.minusSeconds(Integer.parseInt(sTemp2));
//		} else {
//			dTempS = dTempE.minusSeconds(Integer.parseInt(sTemp2.split("\\.")[0]));
//			dTempS = dTempS.minusNanos(Integer.parseInt(sTemp2.split("\\.")[1]));
//		}
//		dTempS = dTempS.plusNanos(1000000);
//
//		sRet[0] = dTempS;
//		sRet[1] = dTempE;
//		sRet[2] = dTempS.minusSeconds(1);
//		sRet[3] = dTempE.plusSeconds(1);
//		return sRet;
//	}
}
