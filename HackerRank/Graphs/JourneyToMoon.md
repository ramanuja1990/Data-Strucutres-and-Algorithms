## Journey To Moon

### Link to the Problem Statement
https://www.hackerrank.com/challenges/journey-to-the-moon/problem

## Solution

### Let n be totalAstronauts. 
### Find group of astronauts from same Country using DFS. Let this be clusterCount
### Multiply clusterCount with totalAstronauts - clusterCount.
### Repeat the above process for all the given input pairs.
### Finally, individual astronauts remain. Find its sum using n/2 * (n+1). That is the possible compbination. => (totalAstronauts - 1) * totalAstronauts / 2
### Sum of all above cases is the Total possible Astonaut Pairs count

```
package HackerRank;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class MoonJourney {
	static List<List<Integer>> adjList;
	static List<Boolean> visited;
	static int clusterCount;
	
	// Complete the journeyToMoon function below.
	static int journeyToMoon(int n, int p, int[][] astronaut) {
		adjList = new ArrayList<List<Integer>>();
		visited = new LinkedList<Boolean>();
		for(int i = 0; i < n; i++){
			adjList.add(new ArrayList<Integer>());
			visited.add(false);
		}

		for(int i = 0; i < p; i++){
			int astronaut1 = astronaut[i][0];
			int astronaut2 = astronaut[i][1];
			adjList.get(astronaut1).add(astronaut2);
			adjList.get(astronaut2).add(astronaut1);
		}
		
		long astronautPairCount = 0;
		long totalAstronauts = n;
		long start = System.currentTimeMillis();
		for(int i = 0; i < astronaut.length; i++){
			if(!visited.get(astronaut[i][0])){
				findCluster(astronaut[i][0]);
				astronautPairCount += clusterCount * (totalAstronauts - clusterCount);
				totalAstronauts -= clusterCount;
				
			}
			if(!visited.get(astronaut[i][1])) {
				findCluster(astronaut[i][1]);
				astronautPairCount += clusterCount * (totalAstronauts - clusterCount);
				totalAstronauts -= clusterCount;
			}
		}
		long temp = (totalAstronauts - 1) * totalAstronauts;
		astronautPairCount += (temp / 2);
		System.out.println("Time Taken: " + (System.currentTimeMillis() - start));
		return 0;
	}

	public static void findCluster(int node){
		clusterCount = 0;
		DFS(node);

	}

	public static void DFS(int node){
		visited.set(node, true);
		clusterCount++;
		for(int j = 0; j < adjList.get(node).size(); j++) {
			if(!visited.get(adjList.get(node).get(j)))
				DFS(adjList.get(node).get(j));
		}

	}
	

	public static void main(String[] args) throws IOException  {
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		String nANdP = scanner.readLine();
		String[] nAndPArray = nANdP.split(" ");
		int n = Integer.parseInt(nAndPArray[0]);
		int p = Integer.parseInt(nAndPArray[1]);
		int[][] astronaut = new int[p][2];
		for(int i = 0; i < p; i++) {
				String astronautItem = scanner.readLine();
				String[] astronautItemString = astronautItem.split(" ");
				astronaut[i][0] = Integer.parseInt(astronautItemString[0]);
				astronaut[i][1] = Integer.parseInt(astronautItemString[1]);
		}
		
		journeyToMoon(n, p, astronaut);
		
	}
}

   
```



