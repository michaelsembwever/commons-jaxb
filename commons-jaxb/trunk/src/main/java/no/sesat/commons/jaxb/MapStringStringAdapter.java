package no.sesat.commons.jaxb;

/** Useful implementation for serialising Map<String,String> types.
 *
 * @version $Id$
 */
public final class MapStringStringAdapter extends MapAdapter<MapStringStringElement,String,String>{

    @Override
    public MapStringStringElement newMapElement(final String key, final String value) {
        final MapStringStringElement result = new MapStringStringElement();
        result.setKey(key);
        result.setValue(value);
        return result;
    }

    @Override
    public MapStringStringElement[] newMapElement(int size) {
        return new MapStringStringElement[size];
    }

}