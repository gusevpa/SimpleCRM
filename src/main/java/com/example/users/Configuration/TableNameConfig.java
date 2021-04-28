package com.example.users.Configuration;

import org.hibernate.boot.model.naming.*;
import org.hibernate.engine.jdbc.env.spi.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class TableNameConfig {

    @Value("${user.table.name}")
    private String userTableName;

    @Bean
    public PhysicalNamingStrategyStandardImpl physicalNamingStrategyStandard() {
        return new PhysicalNamingImpl();
    }

    class PhysicalNamingImpl extends PhysicalNamingStrategyStandardImpl {

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
