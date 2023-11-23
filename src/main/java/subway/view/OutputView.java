package subway.view;

import subway.domain.MainMenu;
import subway.domain.PathCriteria;
import subway.domain.Station;

import java.sql.SQLOutput;
import java.util.List;

public class OutputView {

    private static final String MSG_MENU_SELECTION = "## 원하는 기능을 선택하세요.";
    private static final String MSG_PRINT_MAIN_MENU = "## 메인 화면";
    private static final String MSG_PRINT_PATH_CRITERIA = "## 경로 기준";
    private static final String MSG_PRINT_START_STATION = "## 출발역을 입력하세요.";
    private static final String MSG_PRINT_END_STATION = "## 출발역을 입력하세요.";
    private static final String MSG_FIND_RESULT_HEADER = "## 조회 결과";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printMainMenuList() {
        System.out.println(MSG_PRINT_MAIN_MENU);
        MainMenu[] values = MainMenu.values();

        for (MainMenu menu : values) {
            System.out.println(menu.toString());
        }
        System.out.println("\n");
    }

    public static void printMenuSelection() {
        System.out.println(MSG_MENU_SELECTION);
    }

    public static void printPathCriteria() {
        System.out.println(MSG_PRINT_PATH_CRITERIA);
        PathCriteria[] values = PathCriteria.values();

        for (PathCriteria criteria : values) {
            System.out.println(criteria.toString());
        }
        System.out.println("\n");
    }

    public static void printPathCriteriaSelection() {
        System.out.println(MSG_MENU_SELECTION);
    }

    public static void printInputStartStation() {
        System.out.println(MSG_PRINT_START_STATION);
    }
    public static void printInputEndStation() {
        System.out.println(MSG_PRINT_END_STATION);
    }

    public static void printFindResult(int distance , int TravelTime) {
        System.out.println(MSG_FIND_RESULT_HEADER);
        System.out.println("[INFO] ---");
        System.out.printf("[INFO] 총 거리: %dkm", distance);
        System.out.printf("[INFO] 총 소요 시간: %d분", TravelTime);
        System.out.println("[INFO] ---");
    }

    public static void printVisitStations(List<Station> stationList) {
        stationList.forEach(station -> System.out.println(station.getName()));
    }
}
