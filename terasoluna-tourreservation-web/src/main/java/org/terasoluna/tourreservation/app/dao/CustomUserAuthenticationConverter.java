package org.terasoluna.tourreservation.app.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.terasoluna.tourreservation.domain.model.OauthUser;

public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
    private String userClaimName = USERNAME; // (1)

    @Override
    public void setUserClaimName(String claimName) {
        this.userClaimName = claimName;
    }

    @Override
    public Map<String, ?> convertUserAuthentication(
            Authentication authentication) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put(userClaimName, authentication.getName());
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
            response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        }
        return response;
    }

    // (2)
    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(userClaimName)) {
            Collection<? extends GrantedAuthority> authorities = getAuthorities(map);
            OauthUser user = new OauthUser(
                    (String) map.get(userClaimName),
                    (String) map.get("company_id"),
                    (String) map.get("business_id"),
                    (String) map.get("client_id")); // (3)

            // omitted

            return new UsernamePasswordAuthenticationToken(user, "N/A", authorities); // (4)
        }
        return null;
    }
}