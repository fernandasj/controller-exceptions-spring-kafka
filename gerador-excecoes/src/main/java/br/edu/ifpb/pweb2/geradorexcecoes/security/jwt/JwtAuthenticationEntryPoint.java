package br.edu.ifpb.pweb2.geradorexcecoes.security.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        final String expiredMsg = (String) request.getAttribute("expired");
        final String msg = (expiredMsg != null) ? expiredMsg : "Unauthorized";
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, msg);

        if (expiredMsg != null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, expiredMsg);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Detalhes de login inválidos");
        }

    }

}
