package chapter07;

// 2번 과제 공용 클레스
class ScoreInfo {
    String name; // 이름
    int score; // 점수
    int time; // 시간

    public ScoreInfo(String name, int score, int time) {
        this.name = name;
        this.score = score;
        this.time = time;
    }

    @Override
    public String toString() {
        // 이름, 점수, 시간 정보를 문자열로 반환
        // 객체 출력하면 자동으로 toString() 메서드가 호출되어 객체의 정보를 문자열로 표현
        return "(" + name + ", " + score + "점, " + time + "초)";
    }
}
