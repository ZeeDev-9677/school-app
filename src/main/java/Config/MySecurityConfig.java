/*
 * package Config;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfiguration; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityCustomizer;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class MySecurityConfig extends
 * WebSecurityConfiguration {
 * 
 * private List<WebSecurityCustomizer> webSecurityCustomizers;
 * 
 * @Autowired(required = false) void
 * setWebSecurityCustomizers(List<WebSecurityCustomizer> webSecurityCustomizers)
 * {
 * 
 * this.webSecurityCustomizers = webSecurityCustomizers;
 * this.webSecurityExpressionHandler();
 * 
 * 
 * } }
 */