package fcu.android.backend.upload;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FileLocationContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	//String rootPath = System.getProperty("user.dir") + "/shop";
    	ServletContext ctx = servletContextEvent.getServletContext();
    	//String relativePath = ctx.getInitParameter("img.dir");
    	File file = new File("D:\\FoodOrder\\src\\main\\webapp\\img\\shops");
    	if(!file.exists()) file.mkdirs();
    	System.out.println("File Directory created to be used for storing files");
    	ctx.setAttribute("FILES_DIR_FILE", file);
    	ctx.setAttribute("FILES_DIR", "D:\\FoodOrder\\src\\main\\webapp\\img\\shops");
    }

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		//do cleanup if needed
	}
	
}