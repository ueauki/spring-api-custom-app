package com.app.api.external.oauth.service;

import com.app.api.external.oauth.model.OauthAttribute;

public interface SocialLoginApiService {
    OauthAttribute getUserInfo(String accessToken);
}
