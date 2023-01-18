import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElectionStatistics {
	
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public ElectionStatistics() {
	}
	
	public static void main(String []args) {
		
		ElectionStatistics stats = new ElectionStatistics();
		
		while(true) {
		
		System.out.println("Command: ");
		Scanner sc = new Scanner(System.in);
		
		String command = sc.next();
		
		switch(command) {
		
		case "entercandidate": stats.createCandidate(sc);
		break;
		
		case "castvote" : stats.castVote(sc);
		break;
		
		case "countvote": stats.countVote(sc);
		break;
		
		case "listvote": stats.listVote();
		break;
		
		case "getwinner": stats.getWinner();
		break;
		
		}
		
		}
	}
	private void createCandidate(Scanner sc) {
		
		System.out.println("Enter candidate Name");
		String candidateName = sc.next();
		map.put(candidateName, 0);
		
	}
	private void castVote(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("Name of candidate to cast vote: ");
		String candidateName = sc.next();
		
		if(map.containsKey(candidateName)) {
			
			map.put(candidateName, map.get(candidateName)+1);
		} else {
			System.out.println(candidateName + " is not a valid candidate");
		}
		
	}
	private void countVote(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter candidate Name to get vote count: ");
		String candidateName = sc.next();
		
		if(map.containsKey(candidateName)) {
			
			System.out.println(candidateName + " votes "+ map.get(candidateName));
		} else {
			System.out.println(candidateName + " is not a valid candidate");
		}	
	}

	private void listVote() {
		// TODO Auto-generated method stub
		System.out.println("Results");
		
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			System.out.println("Candidate: "+ entry.getKey() + "Vote"+ entry.getValue());
		}	
	}
	
	private void getWinner() {
		
		int winner = Integer.MIN_VALUE;
		String candidateName = null;
	
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			
			if(entry.getValue() > winner) {
				candidateName = entry.getKey();
				winner = entry.getValue();
			}
		}
		
		System.out.println("Winner: "+ candidateName + "Total votes: "+ winner);	
	}
	
}
