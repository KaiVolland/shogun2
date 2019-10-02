package de.terrestris.shoguncore.util.bean;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

/**
 * Credits go to http://stackoverflow.com/a/3521314
 *
 * @author Nils Bühner
 */
public class NullAwareBeanUtilsBean extends BeanUtilsBean {

    @Override
    public void copyProperty(Object dest, String name, Object value)
        throws IllegalAccessException, InvocationTargetException {
        if (value == null) {
            return;
        }
        super.copyProperty(dest, name, value);
    }

}
