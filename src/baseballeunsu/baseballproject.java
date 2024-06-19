package baseballeunsu;


import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class baseballproject {
    public static void main(String[] args) {
        Random rand = new Random(); // 랜덤 숫자를 위해 초기화
        Scanner sc = new Scanner(System.in);


        // Set을 활용해 중복을 제거 및 컴퓨터에 3자리수 배열 생성하기 0은제외하고 1~9까지의 숫자로 구성
        Set<Integer> set = new HashSet<>();
        while(set.size() < 3) {
            set.add(rand.nextInt(9) + 1);
        }
        Integer[] cArr = set.toArray(new Integer[0]);

        // 3자리수가 제대로 담겼는지 확인해보기 게임할때 주석처리 후 실행
        for(int i = 0; i < cArr.length; i++) {
            System.out.println(cArr[i]);
        }

        //게임 시작과함께 안내메세지 출력
        System.out.println("숫자가 생성되었습니다. 답을 맞춰보세요.");
        System.out.println("100~999까지 숫자를 입력해주세요.");

        // 몇 번째 시도인지 몇 번째만에 정답을 맞췄는지 카운트해주는 변수
        int count = 1;


        while (true){
            int num = sc.nextInt(); // 사용자의 숫자를 입력받음
            System.out.println(count + "번 째 시도입니다.");
            int[] uArr = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray(); // 사용자의 숫자 int형 데이터를 int[]형 배열로 전환.
            count++; // n번째 시도 +1

            // 스트라이크 볼 변수 선언 및 초기화
            int strike = 0;
            int ball = 0;

            // 컴퓨터의 숫자와 유저의 숫자를 하나씩 비교해 같으면 strike+1 , 아니면 ball+1
            for (int i = 0; i < uArr.length; i++) {
                if(cArr[i] == uArr[i]) {
                    strike++;
                } else {
                    ball++;
                }
            }
            // strike가 3이되면 정답이므로 break를 통해 종료
            if(strike == 3) {
                System.out.println("정답을 맞췄습니다.");
                break;
            }
            // 정답이 아니라면 계속해서 도전 안내메세지 출력.
            else{
                System.out.println(ball + "B" + strike + "S" +"입니다 다시시도하세요.");
            }

        }

        System.out.println(count -1 + "번 째만에 맞췄습니다.");
        System.out.println("게임을 종료합니다.");







    }
}
