package com.twu.biblioteca.widgets;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated
 * Created by Peizhen Zheng on 2016/4/21.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BeanColumn {
    String name();  //column name for the table header
    int index();  //index in the table
}
