package com.app.api.external.oauth.kakao.service;

import com.app.api.external.oauth.kakao.client.KakaoUserInfoClient;
import com.app.api.external.oauth.kakao.dto.KakaoUserInfoResponseDto;
import com.app.api.external.oauth.model.OauthAttribute;
import com.app.api.external.oauth.service.SocialLoginApiService;
import com.app.domain.member.constant.MemberType;
import com.app.global.jwt.constant.GrantType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class KakaoLoginApiServiceImpl implements SocialLoginApiService {

    private final KakaoUserInfoClient kakaoUserInfoClient;
    private final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf8";


    @Override
    public OauthAttribute getUserInfo(String accessToken) {
        KakaoUserInfoResponseDto kakaoUserInfoResponseDto = kakaoUserInfoClient.getKakaoUserInfo(CONTENT_TYPE, GrantType.BEARER.getType() + " " + accessToken);

        KakaoUserInfoResponseDto.KakaoAccount kakaoAccount = kakaoUserInfoResponseDto.getKakaoAccount();
        String email = kakaoAccount.getEmail();

        return OauthAttribute.builder()
                .email(!StringUtils.hasText(email) ? kakaoUserInfoResponseDto.getId() : email)
                .name(kakaoAccount.getProfile().getNickname())
                .profile(kakaoAccount.getProfile().getThumbnailImageUrl())
                .memberType(MemberType.KAKAO)
                .build();

    }
}
