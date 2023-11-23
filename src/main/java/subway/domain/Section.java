package subway.domain;

public class Section {

    private final Station startStation;
    private final Station endStation;
    private final Distance distance;

    public Section(Station startStation, Station endStation, Distance distance) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
    }

    public Station getStartStation() {
        return startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public Distance getDistance() {
        return distance;
    }
}
