package com.commons.utils;

import org.modelmapper.ModelMapper;

/**
 * The Class CustomMapper.
 */
public class CustomMapper {

    /**
     * Mapper.
     *
     * @param source the source
     * @param target the target
     * @return the object
     */
    public static Object mapper(Object source, Class<?> target) {
        return new ModelMapper().map(source, target);
    }

}
