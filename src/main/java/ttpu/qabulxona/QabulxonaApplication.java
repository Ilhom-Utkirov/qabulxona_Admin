package ttpu.qabulxona;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class QabulxonaApplication {//extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(QabulxonaApplication.class, args);
    }

    /*
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(QabulxonaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(QabulxonaApplication.class, args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(QabulxonaApplication.class).bannerMode(Banner.Mode.OFF);
    }
    */

/* //from stack overflow
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(Application.class).bannerMode(Banner.Mode.OFF);
    }
*/
}
