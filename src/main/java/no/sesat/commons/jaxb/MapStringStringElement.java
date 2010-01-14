package no.sesat.commons.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/** Useful implementation for serialising Map<String,String> types.
 *
 * @version $Id$
 */
public final class MapStringStringElement extends MapElement<String,String>{

    @XmlAttribute
    @Override
    public String getKey(){
        return key;
    }

    @XmlElement
    @Override
    public String getValue(){
        return value;
    }

    @Override
    public void setKey(final String key) {
        this.key = key;
    }

    @Override
    public void setValue(final String value) {
        this.value = value;
    }

}