/*
 * Copyright (2009-2010) Schibsted ASA
 *   This file is part of Sesat Commons.
 *
 *   Sesat Commons is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Sesat Commons is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with Sesat Commons.  If not, see <http://www.gnu.org/licenses/>.
 */
package no.sesat.commons.jaxb;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/** Must be overridden.
 * As JAXB instantiates the XmlAdapter classes when constructing its JaxbContext
 *  the generics are meaningless in any final class.
 * But they are still useful as a constraints in the polymorphism,
 *  that is the generics are for subclasses to take advantage of, not client code.
 *
 * See MapStringStringAdapter for a simple subclass example.
 *
 * @param <K> The type of Map.Entry.Key
 * @param <V> The type of Map.Entry.Value
 */
public abstract class MapAdapter<T extends MapElement<K,V>,K,V> extends XmlAdapter<T[],Map<K,V>> {

    public abstract T[] newMapElement(int size);
    public abstract T newMapElement(K key, V value);

    @Override
    public final T[] marshal(final Map<K,V> map) throws Exception {

        final T[] mapElements = newMapElement(map.size());
        int i = 0;
        for (Map.Entry<K,V> entry : map.entrySet()) {
            mapElements[i++] = newMapElement(entry.getKey(), entry.getValue());
        }
        return mapElements;
    }

    @Override
    public final Map<K,V> unmarshal(final T[] elements) throws Exception {

        final Map<K, V> r = new HashMap<K, V>();
        for (MapElement<K,V> mapelement : elements) {
            r.put(mapelement.getKey(), mapelement.getValue());
        }
        return r;
    }
}
