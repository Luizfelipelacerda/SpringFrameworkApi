package org.example;


import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception {
        // Configura o contexto Spring para a aplicação
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("org.example.Config"); // Defina o pacote onde estão suas configurações Spring

        // Configura o Tomcat embutido
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // Define o contexto do Tomcat
        Context ctx = tomcat.addContext("", System.getProperty("java.io.tmpdir"));

        // Configura o DispatcherServlet do Spring
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        Tomcat.addServlet(ctx, "dispatcher",  dispatcherServlet);
        ctx.addServletMapping("/", "dispatcher");

        // Inicia o Tomcat embutido
        tomcat.start();
        tomcat.getServer().await();
    }
}
