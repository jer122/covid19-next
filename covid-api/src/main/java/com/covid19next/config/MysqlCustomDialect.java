package com.covid19next.config;

import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

public class MysqlCustomDialect extends MySQL57Dialect {
    public MysqlCustomDialect() {
        super();
        registerFunction("group_concat", new StandardSQLFunction("group_concat", new StringType()));
    }
}
