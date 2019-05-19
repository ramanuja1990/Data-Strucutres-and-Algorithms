## Roads and Libraries

### Link to Problem Statement
https://www.hackerrank.com/challenges/torque-and-development/problem


## Solution

Find Clusters of cities using DFS or BFS.
if cost_lib > cost_Road, Build 1 Library and (cities - 1) roads => cost += cLib + ((count - 1) * cRoad);
if cost_road > cost_lib, build library in each city. => cost += count * cLib;


```
package HackerRank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RoadsAndLibraries {
	static LinkedList<Long> output = new LinkedList<Long>();
	static List<List<Integer>> adjList;
	static LinkedList<Boolean> visited;
	static int count;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int numOfTestCases = input.nextInt();  // q is number of test Cases

		for(int testCase = 0; testCase < numOfTestCases; testCase++) {
			int cities = input.nextInt();
			int roads = input.nextInt();
			int cLib = input.nextInt();
			int cRoad = input.nextInt();
			
			visited = new LinkedList<Boolean>();
			adjList = new ArrayList<List<Integer>>();
			for(int city = 0; city < cities; city++) {
				adjList.add(new ArrayList<Integer>());
				visited.add(false);
			}
			
			for(int road = 0; road < roads; road++) {
				int roadFrom = input.nextInt();
				int roadTo = input.nextInt();
				
				adjList.get(roadFrom - 1).add(roadTo - 1);
				adjList.get(roadTo - 1).add(roadFrom - 1);
			}
			
			findRoadsAndLibrarires(cLib, cRoad);
		}
		printoutput();
	}
	public static void printoutput() {
		for(Long out : output) {
			System.out.println(out);
		}
	}
	public static void findRoadsAndLibrarires(int cLib, int cRoad) {
		long cost = 0;
		for(int i = 0; i < adjList.size(); i++) {
			if(!visited.contains(false))
				break;
			if(!visited.get(i)) {
				count = 0;
				DFS(i);
				if(cLib > cRoad)
					cost += cLib + ((count - 1) * cRoad);
				else
					cost += count * cLib;
			}
		}
		
		output.add(cost);
	}
	public static void DFS(int num) {
		visited.set(num, true);
		count++;
		for(int i = 0; i < adjList.get(num).size(); i++) {
			if(!visited.get(adjList.get(num).get(i))) {
				DFS(adjList.get(num).get(i));
			}
		}

	}
}

```