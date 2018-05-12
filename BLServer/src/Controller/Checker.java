package Controller;
import java.util.ArrayList;

import Model.*;
public class Checker {
	
public Checker() {
	
}

public String findSuitablePallet(ArrayList<Palet> palets,Part part) {
	String palid = "";
	
	if(palets.size()!=0) {
		for(int i=palets.size()-1;i>=0;i--) {
			if(palets.get(i).getMaxWeight()>=(palets.get(i).getWeight()+part.getWeight())){
				palid = ""+ palets.get(i).getId();
			} else palid= "nopal";
		}
	} else palid = "nopal";
	
	
	return palid;
	
}



}
