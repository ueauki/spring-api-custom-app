package com.app.api.external.oauth.model;

import com.app.domain.member.Member;
import com.app.domain.member.constant.MemberType;
import com.app.domain.member.constant.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OauthAttribute {

    private String name;
    private String email;
    private String profile;
    private MemberType memberType;

    public Member toMemberEntity(MemberType memberType, Role role) {
        return Member.builder()
                .memberName(name)
                .email(email)
                .memberType(memberType)
                .profile(profile)
                .role(role)
                .build();
    }

}
