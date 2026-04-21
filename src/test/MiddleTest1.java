package test;

public class MiddleTest1 { //switch - case 학습
    public static void main(String[] args) {
        int day = 3;
        String dayName;
        dayName = switch (day) {
            case 1 ->  "월요일";
            case 2 -> "화요일";
            case 3 ->  "수요일";
            case 4 ->  "목요일";
            case 5 ->  "금요일";
            case 6,7 ->  "주말이 좋아";
            default -> "잘못된 입력 입니다.";
        };

        // switch (day) {
        //     case 1:
        //         dayName = "월요일";
        //         break;
        //     case 2:
        //         dayName = "화요일";
        //         break;
        //     case 3:
        //         dayName = "수요일";
        //         break;
        //     case 4:
        //         dayName = "목요일";
        //         break;
        //     case 5:
        //         dayName = "금요일";
        //         break;
        //     case 6:
        //     case 7:
        //         dayName = "주말";
        //         break;
        //     default:
        //         dayName = "잘못된 입력";
        //         break;
        // }
        System.out.println(day + "일은 " + dayName + "입니다.");
    }

}