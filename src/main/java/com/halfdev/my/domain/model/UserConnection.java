package com.halfdev.my.domain.model;

import com.halfdev.my.domain.ProviderType;
import com.halfdev.my.interfaces.security.social.github.GithubUserDetails;
import com.halfdev.my.interfaces.security.social.google.GoogleUserDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserConnection {

    private long id;
    private String email;
    private ProviderType provider;
    private String providerId;
    private String displayName;
    private String profileUrl;
    private String imageUrl;
    private String accessToken;
    private long expireTime;

//    public static UserConnection valueOf(FacebookUserDetails userDetails) {
//        return UserConnection.builder()
//                .expireTime(userDetails.getExpiration())
//                .accessToken(userDetails.getAccessToken())
//                .providerId(userDetails.getId())
//                .provider(ProviderType.FACEBOOK)
//                .email(userDetails.getEmail())
//                .displayName(userDetails.getName())
//                .imageUrl("https://graph.facebook.com/" + userDetails.getId() + "/picture?type=large&redirect=true")
//                .profileUrl("")
//                .build();
//    }

    public static UserConnection valueOf(GithubUserDetails userDetails) {
        return UserConnection.builder()
                .expireTime(userDetails.getExpiration())
                .accessToken(userDetails.getAccessToken())
                .providerId(userDetails.getId())
                .email(userDetails.getEmail()).displayName(userDetails.getName())
                .imageUrl(userDetails.getAvatarUrl())
                .provider(ProviderType.GITHUB)
                .profileUrl("")
                .build();
    }

    public static UserConnection valueOf(GoogleUserDetails userDetails) {
        return UserConnection.builder()
                .expireTime(userDetails.getExpiration())
                .accessToken(userDetails.getAccessToken())
                .providerId(userDetails.getSub())
                .email(userDetails.getEmail())
                .displayName(userDetails.getName())
                .imageUrl(userDetails.getPicture())
                .provider(ProviderType.GOOGLE)
                .profileUrl(userDetails.getProfile())
                .build();
    }
}
