package com.smart.starter.core.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author guwenchang
 * @date 2019-05-31 14:03
 */
public class PageUtils {


    public static <S, D> Page<D> buildPage(Page<S> page, Class<D> clazz) {
        Page<D> entityPage = new Page<>();
        entityPage.setSize(page.getSize());
        entityPage.setCurrent(page.getCurrent());
        entityPage.setAsc(page.ascs());
        entityPage.setDesc(page.descs());
        return entityPage;
    }



}
