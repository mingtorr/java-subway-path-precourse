package subway.view;

import subway.domain.MainMenu;

public class OutputView {

    private static final String MSG_MENU_SELECTION = "## 원하는 기능을 선택하세요.";

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printMainMenuList() {
        System.out.println("## 메인 화면");
        MainMenu[] values = MainMenu.values();

        for (MainMenu menu : values) {
            System.out.println(menu.toString());
        }
        System.out.println("\n");
    }

    public static void printMenuSelection() {
        System.out.println(MSG_MENU_SELECTION);
    }
}
