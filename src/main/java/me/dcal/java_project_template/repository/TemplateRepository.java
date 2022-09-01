package me.dcal.java_project_template.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.java_project_template.model.TemplateItem;

// import java.util.Optional;


@Repository
public interface  TemplateRepository extends JpaRepository<TemplateItem,String>
{
	// Optional<TemplateItem> findById(String username);
}
