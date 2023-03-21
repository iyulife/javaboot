package io.javaboot.admin.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import io.javaboot.core.exception.JavaBootException;
import io.javaboot.core.utils.LogUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import static io.javaboot.core.enums.StatusEnum.F;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/15 17:13
 */
@Configuration
public class SecuritySecureConfig {

    private final String adminContextPath;

    /**
     * 注入 adminServerProperties
     *
     * @param adminServerProperties
     */
    public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        http.authorizeHttpRequests((authorize) -> setAuthorize(authorize, successHandler)
        ).httpBasic(withDefaults());
        return http.build();
    }

    /**
     * 拦截 spring boot admin 请求
     *
     * @param authorize
     * @param successHandler
     */
    private void setAuthorize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorize, SavedRequestAwareAuthenticationSuccessHandler successHandler) {
        try {
            authorize
                    .requestMatchers(adminContextPath + "/assets/**").permitAll()
                    .requestMatchers(adminContextPath + "/login").permitAll()
                    .requestMatchers(adminContextPath + "/actuator/health").permitAll()
                    .requestMatchers(adminContextPath + "/actuator").permitAll()
                    .requestMatchers(adminContextPath + "/instances").permitAll()
                    /**
                     * 其他都需要登录
                     */
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
                    .logout().logoutUrl(adminContextPath + "/logout").and()
                    .httpBasic().and()
                    /**
                     * csrf禁用
                     */
                    .csrf().disable();
        } catch (Exception e) {
            throw new JavaBootException(String.valueOf(F.getCode()), LogUtil.stackTrace(e));
        }
    }
}
