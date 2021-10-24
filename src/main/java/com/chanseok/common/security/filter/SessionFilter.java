package com.chanseok.common.security.filter;

import com.chanseok.common.security.service.MemberContext;
import com.chanseok.member.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * SecurityContextHolder 담긴 정보를 Session에 담기 위한 필터
 */
@Slf4j
@Component
public class SessionFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(SecurityContextHolder.getContext().getAuthentication() != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            log.info("principal={}", principal);

            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();
            Object isUser = session.getAttribute("memberDto");

            if(isUser == null) {
                if(!"anonymousUser".equals(principal)) {
                    MemberContext context = (MemberContext) principal;
                    MemberDto memberDto = context.getMemberDto();
                    session.setAttribute("memberDto", memberDto);
                    log.info("session={}", session.getAttribute("memberDto"));
                }
            }
        }
        chain.doFilter(request, response);
    }
}
