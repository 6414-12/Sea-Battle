package com.finance.jwt.security.authentication;

import com.finance.jwt.domain.OpenAccessToken;
import com.finance.jwt.domain.token.TokenMetadata;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@RequiredArgsConstructor
public class AccessAuthenticationServiceImpl implements AccessAuthenticationService {
  private final AuthenticationManager authenticationManager;
  private final TokenMetadata tokenMetadata;

  @Override
  public OpenAccessToken login(UsernamePasswordAuthenticationToken authentication) {
    authentication = (UsernamePasswordAuthenticationToken) authenticationManager.authenticate(authentication);
    UserDetailsExtend principal = (UserDetailsExtend) authentication.getPrincipal();

    Claims claims = new DefaultClaims(Map.of(
      "authorities", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList(),
      "userId", principal.getId()
    ));
    claims.setSubject(principal.getUsername());

    return OpenAccessToken.generate(claims, tokenMetadata);
  }
}
