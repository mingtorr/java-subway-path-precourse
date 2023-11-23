package subway.repository;

import subway.domain.Section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
}
