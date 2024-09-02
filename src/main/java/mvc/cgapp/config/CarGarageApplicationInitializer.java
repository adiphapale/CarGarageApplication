package mvc.cgapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CarGarageApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?> config[]= {CarGarageConfigClass.class};
		return config;
	}

	@Override
	protected String[] getServletMappings() {
		String mapping[]= {"/"};
		return mapping;
	}

}
