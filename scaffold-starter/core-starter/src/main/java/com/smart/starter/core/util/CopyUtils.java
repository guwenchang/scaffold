package com.smart.starter.core.util;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

/**
 *
 * @author guwenchang
 * @date 2019-05-22
 */
public class CopyUtils {

    private static final MapperFacade MAPPERFACADE;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().useAutoMapping(true).mapNulls(true).build();
        MAPPERFACADE = mapperFactory.getMapperFacade();
    }


    public static <S, D> void copyObject(S from, D to) {
        MAPPERFACADE.map(from, to);
    }

    public static <S, D> D copyObject(S from, Class<D> clazz) {
        return MAPPERFACADE.map(from, clazz);
    }


    public static <S, D> List<D> copyList(Iterable<S> source, Class<D> destinationClass) {
        return MAPPERFACADE.mapAsList(source, destinationClass);
    }
}
