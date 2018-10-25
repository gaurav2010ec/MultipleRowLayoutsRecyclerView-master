package com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy;

import com.alexzh.tutorial.multiplerowlayoutsrecyclerview.dummy.model.CityEvent;

import java.util.ArrayList;
import java.util.List;

public final class DummyData {

    public static List<CityEvent> getData() {
        List<CityEvent> list = new ArrayList<>();

        list.add(new CityEvent("London", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Droidcon", "Droidcon in London", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Some event", "Some event 1 in London", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Some event", "Some event 2 in London", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Some event", "Some event 3 in London", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Amsterdam", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Droidcon", "Droidcon in Amsterdam", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Droidcon", "Aroidcon in Amsterdam", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Droidcon", "Broidcon in Amsterdam", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Droidcon", "Froidcon in Amsterdam", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Berlin", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Droidcon", "Some event 2 in  Berlin", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Droidcon", "Some event 3 in  Berlin", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Droidcon", "Some event 4 in  Berlin", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Droidcon", "Some event 6 in  Berlin", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Droidcon", "Some event 8 in  Berlin", CityEvent.EVENT_TYPE));
        return list;
    }

}
