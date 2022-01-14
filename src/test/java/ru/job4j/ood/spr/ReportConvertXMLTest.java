package ru.job4j.ood.spr;

import org.junit.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ReportConvertXMLTest {
    @Test
    public void whenGenerateXmlReportThenValidReport() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        store.add(new Employee("Anna", now, now, 87));
        store.add(new Employee("Nick", now, now, 100));
        Report engine = new ReportConvertXML(store);
        String date =  DatatypeConverter.printDateTime(now);
        StringBuilder expected = new StringBuilder();
        expected.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
        expected.append("<employees>\n");
        expected.append("    <employee>\n");
        expected.append("        <fired>" + date + "</fired>\n");
        expected.append("        <hired>" + date + "</hired>\n");
        expected.append("        <name>Anna</name>\n");
        expected.append("        <salary>87.0</salary>\n");
        expected.append("    </employee>\n");
        expected.append("    <employee>\n");
        expected.append("        <fired>" + date + "</fired>\n");
        expected.append("        <hired>" + date + "</hired>\n");
        expected.append("        <name>Nick</name>\n");
        expected.append("        <salary>100.0</salary>\n");
        expected.append("    </employee>\n");
        expected.append("</employees>\n");
        assertEquals(expected.toString(), engine.generate(employee -> true));
    }
}