package subway.repository;

import subway.domain.Section;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static List<Section> getSections () {
        return Collections.unmodifiableList(sections);
    }

    public static boolean deleteLineByName(String name) {
        return sections.removeIf(section -> Objects.equals(section.getStartStation().getName(), name));
    }

    public static void deleteAll() {
        sections.clear();
    }

    public static void addAll(List<Section> list) {
        sections.addAll(list);
    }


    public static List<Section> findSectionsByStationList(List<Station> stationList) {
        List<Section> foundSections = new ArrayList<>();

        for (int i = 0; i < stationList.size() - 1; i++) {
            Station currentStation = stationList.get(i);
            Station nextStation = stationList.get(i + 1);

            Optional<Section> section = SectionRepository.getSectionByStations(currentStation, nextStation);
            section.ifPresent(foundSections::add);
        }

        return foundSections;
    }


    public static Optional<Section> getSectionByStations(Station startStation, Station endStation) {
        return sections.stream()
                .filter(section -> section.getStartStation().equals(startStation) && section.getEndStation().equals(endStation))
                .findFirst();
    }
}
