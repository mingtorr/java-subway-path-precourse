package subway.domain;

import subway.repository.SectionRepository;

import java.util.List;

public class FindResult {

    private final List<Station> stations;
    private final List<Section> sections;

    public FindResult(List<Station> stations) {
        this.stations = stations;
        this.sections = SectionRepository.findSectionsByStationList(stations);
    }

    public int getSumOfDistance() {
        return sections.stream().mapToInt(section -> section.getDistance().getDistance()).sum();
    }

    public int getSumOfTravelTime() {
        return sections.stream().mapToInt(section -> section.getDistance().getTravelTime()).sum();
    }

    public List<Station> getStations() {
        return stations;
    }
}
