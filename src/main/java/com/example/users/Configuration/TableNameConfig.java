package com.example.users.Configuration;

import org.hibernate.boot.model.naming.*;
import org.hibernate.engine.jdbc.env.spi.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

/**
 * Переназначение спрингового генератора имен на значение из application.properties
 * В данном варианте переназназначает имя таблицы по-умолчанию для UserEntity
 */
@Configuration
public class TableNameConfig {
    /**
     * Берем значение userTableName из application.properties
     */
    @Value("${user.table.name}")
    private String userTableName;

    @Bean
    public PhysicalNamingStrategyStandardImpl physicalNamingStrategyStandard() {
        return new PhysicalNamingImpl();
    }

    class PhysicalNamingImpl extends PhysicalNamingStrategyStandardImpl {
        /**
         *
         * @param name - перехватываем имя entity - класса и
         *             в случае совпадения с искомым - заменяем
         *             на userTableName, взятый из пропертей
         */
        @Override
        public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
            switch (name.getText()) {
                case "UserEntity":
                    return new Identifier(userTableName, name.isQuoted());
                default:
                    return super.toPhysicalTableName(name, context);
            }
        }
    }
}
