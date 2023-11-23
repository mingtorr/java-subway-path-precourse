package subway.domain;

import subway.utils.ValidationUtil;

import java.util.Arrays;

public enum PathCriteria {

    SHORTEST_DISTANCE("1", "최단 거리"),
    MINIMUM_TIME("2", "최소 시간"),
    BACK_MENU("b", "돌아가기");

    private final String menuName;
    private final String command;
    private final static String ERR_WRONG_INPUT_PATH_CRITERIA = "[ERROR] 유효하지 않은 범위의 입력입니다.";

    PathCriteria(String command, String menuName) {
        this.command = command;
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getCommand() {
        return command;
    }

    public static void validateSelectCriteria(String command) {
        if (ValidationUtil.isNotNullOrBlank(command)) {
            throw new IllegalArgumentException(ERR_WRONG_INPUT_PATH_CRITERIA);
        }
        if (validateCommandRange(command)) {
            throw new IllegalArgumentException(ERR_WRONG_INPUT_PATH_CRITERIA);
        }
    }

    private static boolean validateCommandRange(String value) {
        return Arrays.stream(PathCriteria.values()).anyMatch(pathCriteria -> pathCriteria.getCommand().equals(value));
    }

    public String toString() {
        return command + ". " + menuName;
    }

    public static boolean isOptionForFindPath(PathCriteria pathCriteria) {
        return !PathCriteria.BACK_MENU.equals(pathCriteria);
    }

    public static PathCriteria findByCommand(String command) {
        return Arrays.stream(PathCriteria.values())
                .filter(pathCriteria -> pathCriteria.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_WRONG_INPUT_PATH_CRITERIA));
    }
}