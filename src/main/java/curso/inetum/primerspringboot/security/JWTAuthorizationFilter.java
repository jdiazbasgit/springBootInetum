package curso.inetum.primerspringboot.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "inetum";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		try {
			if (checkJWTToken(request, response)) {
				Claims claims = validateToken(request);
				if (claims.get("authorities") != null) {
					setUpSpringAuthentication(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			} else {
				SecurityContextHolder.clearContext();
			}

			chain.doFilter(request, response);

			// aqui ponemos codigo para filtrar la respuesta

		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		}
	}

	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}

	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = new ArrayList<>();

		/// (List<GrantedAuthority>) claims.get("authorities");
		List<LinkedHashMap<Integer, String>> coleccion=(List<LinkedHashMap<Integer, String>>) claims.get("authorities");
		
		System.out.println((coleccion.get(0).values().toArray())[1]);

		//for (String grantedAuthority : coleccion.get(0).values()) {

			GrantedAuthority rol = new SimpleGrantedAuthority((String) (coleccion.get(0).values().toArray())[1]);
			authorities.add(rol);
		//}

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities);
		SecurityContextHolder.getContext().setAuthentication(auth);

	}

	private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		return true;
	}

}
