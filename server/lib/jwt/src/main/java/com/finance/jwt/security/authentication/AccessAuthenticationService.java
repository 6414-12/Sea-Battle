package com.finance.jwt.security.authentication;

import com.finance.jwt.domain.OpenAccessToken;
import com.finance.jwt.domain.token.TokenMetadata;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AccessAuthenticationService {
  OpenAccessToken login(UsernamePasswordAuthenticationToken authentication);
}
