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

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/** Small and simple wrappers to typical jaxb operations.
 *
 * @version $Id$
 */
public final class JaxbUtility {

    // Constants -----------------------------------------------------

    // Attributes ----------------------------------------------------
    // Static --------------------------------------------------------

    /** JAXBContext.newInstance(..) is a slow operation.
     * @deprecated It is better the client creates the JAXBContent once and re-uses it to the other marshal method.
     */
    public static String marshal(final Object obj, final Class... classes) throws JAXBException {
        return marshal(JAXBContext.newInstance(classes), obj);
    }

    public static String marshal(final JAXBContext context, final Object obj) throws JAXBException {

        final StringWriter out = new StringWriter();
        context.createMarshaller().marshal(obj, out);
        return out.toString();
    }

    /** JAXBContext.newInstance(..) is a slow operation.
     * @deprecated It is better the client creates the JAXBContent once and re-uses it to the other unmarshal method.
     */
    public static <T extends Object> T unmarshal(final String xml, final Class<T> clazz) throws JAXBException{

        return (T)unmarshal(JAXBContext.newInstance(clazz), xml);
    }

    public static Object unmarshal(final JAXBContext context, final String xml) throws JAXBException{

        return context.createUnmarshaller().unmarshal(new StringReader(xml));
    }

    // Constructors --------------------------------------------------

    private JaxbUtility(){}

    // Public --------------------------------------------------------
    // Package protected ---------------------------------------------
    // Protected -----------------------------------------------------
    // Private -------------------------------------------------------
    // Inner classes  ------------------------------------------------
}
