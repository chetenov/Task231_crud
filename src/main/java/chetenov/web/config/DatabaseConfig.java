package chetenov.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConfig {

    @Value("${db.driver}")
    public String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.password}")
    private String password;

    @Value("${db.username}")
    private String username;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hiberDDL;

    @Value("${hibernate.dialect}")
    private String hiberDialect;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setHiberDDL(String hiberDDL) {
        this.hiberDDL = hiberDDL;
    }

    public void setHiberDialect(String hiberDialect) {
        this.hiberDialect = hiberDialect;
    }

    public DatabaseConfig() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getHiberDDL() {
        return hiberDDL;
    }

    public String getHiberDialect() {
        return hiberDialect;
    }

    @Override
    public String toString() {
        return "DatabaseConfig{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", hiberDDL='" + hiberDDL + '\'' +
                ", hiberDialect='" + hiberDialect + '\'' +
                '}';
    }


}
