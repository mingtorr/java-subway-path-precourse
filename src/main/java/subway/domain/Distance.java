package subway.domain;

import subway.utils.ValidationUtil;

public class Distance {
    private final int distance;
    private final int travelTime;

    private final String ERROR_WRONG_INPUT_DISTANCE = "[Error] 소요 시간 및 거리는 양수만 입력할 수 있습니다.";

    public Distance(int distance, int travelTime) {
        validatePositive(distance, travelTime);
        this.distance = distance;
        this.travelTime = travelTime;
    }

    public int getDistance() {
        return distance;
    }

    public int getTravelTime() {
        return travelTime;
    }

    private void validatePositive(int distance, int travelTime) {
        if (ValidationUtil.isNotPositive(distance)) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT_DISTANCE);
        }

        if (ValidationUtil.isNotPositive(travelTime)) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT_DISTANCE);
        }
    }
}
