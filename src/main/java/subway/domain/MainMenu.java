package subway.domain;

import subway.utils.ValidationUtil;

import java.util.Arrays;

public enum MainMenu {
    PATH_FIND("1", "경로조회"),
    QUIT("Q", "종료");

    private final String menuName;
    private final String command;
    private static final String errorMessage = "[ERROR] 유효하지 않은 범위의 입력입니다.";

    MainMenu(String command, String menuName) {
        this.menuName = menuName;
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public String toString() {
        return command + ". " + menuName;
    }

    public static void validateSelectMenu(String command) {
        if (ValidationUtil.isNotNullOrBlank(command)) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (validateCommandRange(command)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean validateCommandRange(String value) {
        return Arrays.stream(MainMenu.values()).anyMatch(menu -> menu.getCommand().equals(value));
    }

    public static boolean isProgramQuit(String command) {
        return command.equals(QUIT.command);
    }
}
