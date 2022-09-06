package me.dcal.Lermar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dcal.Lermar.model.TemplateItem;

// import java.util.Optional;


@Repository
public interface  TemplateRepository extends JpaRepository<TemplateItem,String>
{
	// Optional<TemplateItem> findById(String username);
}
