package me.dcal.Lermar.control;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.mapping.Component;

import me.dcal.Lermar.control.permanences.Permanence;
import me.dcal.Lermar.service.TemplateService;
import me.dcal.Lermar.view.RouletteView;
import okhttp3.Route;


// @RestController
public class GameController {
	List<Permanence> permanences = new ArrayList<>();
	RouletteView rouletteView;
	Boolean launchGame = false;
	Permanence activePermanence;
    public GameController() {
		// RouletteView rouletteView = rouletteView;
		
    }

	public void loadPermanence() throws IOException{
		String montantePath = "src/main/resources/permanences";
		List<Path> paths;

		Path path = Paths.get(montantePath);
        paths = listPermanencesFiles(path);
        for (Path pathPerm: paths){
			Permanence perm = new Permanence(pathPerm.getFileName().toString(), readPermanenceFile(pathPerm));
			this.permanences.add(perm);
        }
	}

	private List<String>  readPermanenceFile(Path path){
		List<String> data = new ArrayList<>();
		try {
			File myObj = path.toFile();
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
			  data.add(myReader.nextLine());
			}
			myReader.close();
		  } catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
		return data; 
	}

	public static List<Path> listPermanencesFiles(Path path) throws IOException {

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;

    }

	
	public void setPermanences(Permanence permanence){
		this.permanences.add(permanence);
	}

	public void setActivePermanence(Permanence permanence){
		this.activePermanence = permanence;
	}

	public Permanence getActivePermanence(){
		return this.activePermanence;
	}


	public List<Permanence> getPermanences() throws IOException{
		if (this.permanences == null || this.permanences.size()==0){
			this.loadPermanence();
		}
		return this.permanences;
	}

	
	// TemplateService templateService;


}
