package ru.job4j.ood.spr;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ReportConvertJSONTest {
    @Test
    public void whenReportInJsonFormat() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        store.add(new Employee("Anna", now, now, 87));
        store.add(new Employee("Nick", now, now, 100));
        Report engine = new ReportConvertJSON(store);
        String date = "{\"year\":2017,\"month\":0,\"dayOfMonth\":25,\"hourOfDay\":0,\"minute\":0,\"second\":0}";
        StringBuilder expected = new StringBuilder();
        expected.append("[{");
        expected.append("\"name\":\"Anna\",");
        expected.append("\"hired\":" + date + ",");
        expected.append("\"fired\":" + date + ",");
        expected.append("\"salary\":87.0");
        expected.append("},{");
        expected.append("\"name\":\"Nick\",");
        expected.append("\"hired\":" + date + ",");
        expected.append("\"fired\":" + date + ",");
        expected.append("\"salary\":100.0");
        expected.append("}]");
        assertEquals(expected.toString(), engine.generate(employee -> true));
    }
}