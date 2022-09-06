package me.dcal.Lermar.control;

import org.springframework.web.bind.annotation.RestController;

import org.hibernate.mapping.Component;
import me.dcal.Lermar.service.TemplateService;
import me.dcal.Lermar.view.RouletteView;
import okhttp3.Route;


// @RestController
public class GameController {

	RouletteView rouletteView = null;
    public GameController(RouletteView rouletteView) {
		// RouletteView rouletteView = rouletteView;
		
    }

	// TemplateService templateService;


}
