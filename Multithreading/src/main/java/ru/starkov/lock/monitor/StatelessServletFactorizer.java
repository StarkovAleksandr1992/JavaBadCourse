package ru.starkov.lock.monitor;


import ru.starkov.util.ThreadSafe;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

@ThreadSafe
//Этот класс потокобезопасен, так как не имеет состояния.
public class StatelessServletFactorizer extends HttpServlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }

    protected BigInteger extractFromRequest(ServletRequest req) {
        try {
            BufferedReader reader = req.getReader();
            return new BigInteger(reader.readLine(), 10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected BigInteger[] factor(BigInteger i) {
        return null;
    }

    protected void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
