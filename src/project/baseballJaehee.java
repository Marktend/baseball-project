package project;

import java.util.Random;
import java.util.Scanner;

public class baseballJaehee {
    public static void main(String[] args) {
        // 무작위 숫자 배열하기
        Random rand = new Random();

        int[] datas = new int[3];
        for (int i = 0; i < datas.length; i++) {
            int x = (int) (rand.nextInt(10));
            // 중복 없도록
            for (int j = 0; j < datas.length; j++) {
                if (datas[j] != x) {
                    datas[i] = x;
                } else {
                    break;
                }
            }
            System.out.println(datas[i] + ""); // 테스트를 위해 임시로 주석처리 해제
        }

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");



        // 게임 시작
        // 사용자가 숫자 입력
        int[] input = new int[3];
        int tryNum = 0;
        int ball = 0;
        int strike = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < 3; i++) {
                input[i] = scanner.nextInt();
            }
            tryNum++;
            System.out.println(tryNum + "번째 시도 : " + input[0] + input[1] + input[2]);

            // 입력한 숫자와 정답을 비교
            for (int i = 0; i < 3; i++) {
                if (input[i] == datas[0] || input[i] == datas[1] || input[i] == datas[2]) {
                    ball++;
                }
                if (input[i] == datas[i]) {
                    strike++;
                }
            }

            if (ball != 3 && strike != 3) {
                System.out.println(ball + "B" + strike + "S");
                ball = 0;
                strike = 0;
            }

            if (strike == 3) {
                System.out.println(strike + "S");
                // 종료 문구 출력
                System.out.println(tryNum + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }

            if (ball == 3) {
                System.out.println(ball + "B");
                ball = 0;
            }

        }
    }
}