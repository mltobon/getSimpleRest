package org.example.port.outbound;

import java.util.List;

public interface RestServicePort {
    List<String> getHobbiesList();

    String getUserCleanInfo();
}
