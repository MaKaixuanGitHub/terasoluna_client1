package org.terasoluna.tourreservation.app.dao;

import java.util.Map;

public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {

        @SuppressWarnings("unchecked")
        Map<String, Object> response = (Map<String, Object>) super.convertAccessToken(token, authentication);
        response.put("business_id","BIDXXX"); // (1)
        // omitted

        return response;
    }
}