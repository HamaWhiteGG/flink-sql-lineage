package com.hw.lineage.server.interfaces.enhanced;

import com.hw.lineage.server.application.dto.UserDTO;
import com.hw.lineage.server.application.service.UserService;
import com.hw.lineage.server.interfaces.config.SecurityConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.hw.lineage.common.util.Constant.DEFAULT_USER_ID;
import static com.hw.lineage.common.util.Constant.INITIAL_CAPACITY;

/**
 * A {@link EnhancedParametersFilter} is used by {@link SecurityConfig#securityFilterChain(HttpSecurity)}
 *
 * @description: EnhancedParametersFilter
 * @author: HamaWhite
 * @version: 1.0.0
 */
public class EnhancedParametersFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     * Add the userId parameter in the request parameter
     *
     * @param request  The request to process
     * @param response The response associated with the request
     * @param chain    Provides access to the next filter in the chain for this
     *                 filter to pass the request and response to for further
     *                 processing
     * @throws IOException      ...
     * @throws ServletException ...
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            Map<String, String> additionalMap = buildAdditionalParameters();
            EnhancedHttpRequestWrapper httpRequestWrapper = new EnhancedHttpRequestWrapper((HttpServletRequest) request, additionalMap);
            // pass the request along the filter chain
            chain.doFilter(httpRequestWrapper, response);
        } else {
            chain.doFilter(request, response);
        }
    }


    /**
     * Add the userId parameter in the request parameter
     *
     * Unlike {@link UserService}, authentication is empty if not logged in, and authentication of
     * {@link UserService} is AnonymousAuthenticationToken (Principal is anonymousUser)
     */
    private Map<String, String> buildAdditionalParameters() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, String> additionalMap = new HashMap<>(INITIAL_CAPACITY);
        // add userId parameter, tenantId may be added later
        if (authentication != null) {
            UserDTO userDTO = (UserDTO) authentication.getPrincipal();
            additionalMap.put("userId", userDTO.getUserId().toString());
        } else {
            // since the front end does not yet support login, the default userId is set to 0
            additionalMap.put("userId", DEFAULT_USER_ID.toString());
        }
        return additionalMap;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
