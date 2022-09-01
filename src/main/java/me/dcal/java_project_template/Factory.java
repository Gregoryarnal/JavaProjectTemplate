package me.dcal.java_project_template;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import me.dcal.java_project_template.repository.TemplateRepository;

@Service
public class Factory {

	// @Autowired
	// TemplateRepository templateRepository;

	@Autowired
	Factory factory;

	public Factory() {
	}

}
