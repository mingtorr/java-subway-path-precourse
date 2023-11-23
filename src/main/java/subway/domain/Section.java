package subway.domain;

import subway.repository.GraphRepository;
import subway.repository.StationRepository;

public class Section {

    private final Station startStation;
    private final Station endStation;
    private final Distance distance;

    public Section(String startStation, String endStation, Distance distance) {
        this.startStation = StationRepository.findByName(startStation);
        this.endStation = StationRepository.findByName(endStation);
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
