import java.util.Random;
import java.lang.Math;

public class CreateGameName {
    public static void main(String[] args) {
    	String[] themes = new String[4];
	    themes[0] = "cowboy ";
	    themes[1] = "farm ";
	    themes[2] = "woods ";
	    themes[3] = "zombie ";
	    String[] types = new String[3];
	    types[0] = "tag";
	    types[1] = "chase";
	    types[2] = "ball-game";
	    String[] state = new String[2];
	    state[0] = "weirdo ";
	    state[1] = "normal ";
  		for (int i = 0; i < 10; ++i) {
	      	Random rand = new Random();
	      	int upperbound=4;
	      	int int_random = rand.nextInt(upperbound); 
	      	String pickedtheme = themes[int_random];
	      	Random rand1 = new Random();
	      	int upperbound1=2;
	      	int int_random1 = rand1.nextInt(upperbound1); 
	      	String pickedstate = state[int_random1];
	      	Random rand2 = new Random(); 
	      	int upperbound2=2;
	      	int int_random2 = rand2.nextInt(upperbound2); 
	      	String pickedtype = types[int_random2];
	      	init.gens[i] = pickedtheme + pickedstate + pickedtype;
	    }
	    ScoreandMax.scores();
	    Reusegen.generate();
	    ScoreandMax.scores();
	    int maxint = init.scores[0];
	    int maxindex = 0;
	    for (int i = 0; i < init.scores.length; ++i) {
	    	if (init.scores[i] > maxint) {
	    		maxint = init.scores[i];
	    		maxindex = i;
	    	}
	    }
	    System.out.println(init.gens[maxindex]);
	}
}

public class ScoreandMax {
	public static void scores() {
		String maximum = "";
		String[] goodtitles = new String[3];
    	goodtitles[0] = "farm";
    	goodtitles[1] = "woods";
    	goodtitles[2] = "zombie";
    	String[] goodtypes = new String[2];
    	goodtypes[0] = "tag";
    	goodtypes[1] = "chase";
	    for (int i = 0; i < init.gens.length; ++i) {
	    	init.scores[i] = 0;
	    	String[] strlist = init.gens[i].split(" ", 5);
	    	for (int i1 = 0; i1 < goodtitles.length; ++i1) {
	    		if (goodtitles[i1].equals(strlist[0])) {
	    			++init.scores[i];
	    		}
	    	}
	    	if (strlist[1].equals("weirdo")) {
	    		++init.scores[i];
	    	}
	    	for (int i1 = 0; i1 < goodtypes.length; i1 ++) {
	    		if (goodtypes[i1].equals(strlist[2])) {
	    			++init.scores[i];
	    		}
	    	}
	    }
	    int maxint = init.scores[0];
	    int maxindex = 0;
	    for (int i = 0; i < init.scores.length; ++i) {
	    	if (init.scores[i] > maxint) {
	    		maxint = init.scores[i];
	    		maxindex = i;
	    	}
	    }
	    for (int i = 0; i < init.scores.length; ++i) {
	    	if (init.scores[i] < Math.round(maxint / 2)) {
	    		init.gens[i] = "";
	    	}
	    }
	}
}

public class Reusegen {
	public static void generate() {
		String[] betters = new String[10];
		int i1 = 0;
		int maxint = init.scores[0];
	    int maxindex = 0;
	    for (int i = 0; i < init.scores.length; ++i) {
	    	if (init.scores[i] > maxint) {
	    		maxint = init.scores[i];
	    		maxindex = i;
	    	}
	    }
		String maximum = init.gens[maxindex];
		for (int i = 0; i < init.gens.length; ++i) {
		 	if (init.gens[i] != "") {
		 		betters[i1] = init.gens[i];
		 		i1++;
		 	}
		}
		for (int i = 0; i < init.gens.length; ++i) {
		 	if (init.gens[i] == "") {
		 		Random rand = new Random();
	      		int upperbound=betters.length-1;
	      		int int_random = rand.nextInt(upperbound); 
	      		String pickedbest = betters[int_random];
	      		String[] pickedbestl = pickedbest.split(" ", 4);
	      		Random rand1 = new Random();
	      		int upperbound1=2;
	      		int int_random1 = rand.nextInt(upperbound);
	      		String[] themes = new String[4];
			    themes[0] = "cowboy ";
			    themes[1] = "farm ";
			    themes[2] = "woods ";
			    themes[3] = "zombie ";
			    String[] types = new String[3];
			    types[0] = "tag";
			    types[1] = "chase";
			    types[2] = "ball-game";
			    String[] state = new String[2];
			    state[0] = "weirdo ";
		    	state[1] = "normal ";
	      		int upperbound2=4;
		      	int int_random2 = rand.nextInt(upperbound2); 
		      	String pickedtheme = themes[int_random2];
		      	Random rand3 = new Random();
		      	int upperbound3=2;
		      	int int_random3 = rand1.nextInt(upperbound3); 
		      	String pickedstate = state[int_random3];
		      	Random rand4 = new Random(); 
		      	int upperbound4=2;
		      	int int_random4 = rand4.nextInt(upperbound4); 
		      	String pickedtype = types[int_random4];
	      		if (int_random1 == 0) {
	      			pickedbestl[int_random1] = pickedtheme;
	      		} else if (int_random1 == 1){
	      			pickedbestl[int_random1] = pickedstate;
	      		} else {
	      			pickedbestl[int_random1] = pickedtype;
	      		}
	      		init.gens[i] = pickedbest;
		 	}
		}
	}
}

public interface init {
	String[] gens = new String[10];
	int[] scores = new int[10];
}
