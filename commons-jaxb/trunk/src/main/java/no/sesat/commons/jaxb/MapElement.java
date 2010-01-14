/*
 * Copyright (2009) Schibsted ASA
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

import javax.xml.bind.annotation.XmlTransient;

/** Must be overridden to be useful as a peer to MapAdapter
 * As JAXB instantiates the XmlAdapter classes when constructing its JaxbContext
 *  the generics are meaningless in any final class.
 * But they are still useful though as a constraints in the polymorphism,
 *  that is the generics are for subclasses to take advantage of, not client code.
 *
 * Remember to override getKey() and getValue() and annotate with XmlElement or equivalent.
 *
 * See MapStringStringElement for a simple subclass example.
 *
 * @param <K> The type of Map.Entry.Key
 * @param <V> The type of Map.Entry.Value
 */
@XmlTransient
public abstract class MapElement<K,V> {

    protected K key;
    protected V value;

    public abstract K getKey();
    public abstract V getValue();

    public abstract void setKey(K key);
    public abstract void setValue(V value);

}
