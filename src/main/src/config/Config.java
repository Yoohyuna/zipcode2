package config;

import java.io.Reader;
import java.util.Objects;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Config {

    public static SqlSessionFactory sqlsession;


    public static SqlSessionFactory getSqlSession(){
        if (Objects.nonNull(sqlsession)) {

            return sqlsession;
        }

        try {
            if (Objects.isNull(sqlsession)) {
                String resource ="config.xml";
                Reader reader = Resources.getResourceAsReader(resource);
                sqlsession = new SqlSessionFactoryBuilder().build(reader);

                reader.close();
                return sqlsession;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}






