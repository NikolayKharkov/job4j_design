package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class FormatXML {
    public static void main(String[] args) throws Exception {
        District msk = new District(new Region("Central"),
                "Moscow Area",
                false,
                8000000,
                new String[]{"Taldom", "Istra", "Ruza"});
        JAXBContext context = JAXBContext.newInstance(District.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(msk, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            District result = (District) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
