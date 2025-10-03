import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<ArrayList<Integer>> graph;	//그래프 정보 저장 리스트
	static boolean[][] lineCheck;	//간선 사용 확인
	static boolean[] visited;		//정점 방문 확인
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
    	StringTokenizer st;
    	int count = 1;
    	while(true) {
    		st = new StringTokenizer(br.readLine()," ");
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		if(n==0 && m==0)
    			break;
    		graph = new ArrayList<>();
    		visited = new boolean[n+1];
    		lineCheck = new boolean[n+1][n+1];
    		int treeCount = 0;
            //그래프 정보 초기화
    		for(int i=0;i<=n;i++) 
    			graph.add(new ArrayList<>());
    		//그래프 정보 저장
    		for(int i=0;i<m;i++) {
    			st = new StringTokenizer(br.readLine());
    			int u = Integer.parseInt(st.nextToken());
    			int v = Integer.parseInt(st.nextToken());
    			graph.get(u).add(v);
    			graph.get(v).add(u);
    		}
            //트리인지 BFS를 통해 확인
    		for(int i=1;i<=n;i++) {
    			if(!visited[i])
    				treeCount += bfs(i);
    		}
    		if(treeCount == 0)		//트리가 존재하지 않을 때
    			bw.write("Case " + count + ": No trees.\n");
    		else if(treeCount==1)	//트리가 1개일 때
    			bw.write("Case " + count + ": There is one tree.\n");
    		else		//트리가 1개 이상일 때
    			bw.write("Case " + count + ": A forest of " + treeCount + " trees.\n");
    		
    		count++;
    	}
    	bw.flush();		//결과 출력
    	bw.close();
    	br.close();
    }
    //BFS를 통해서 사이클 존재하는지 확인하여 트리인지 구분하는 함수
    static int bfs(int start) {
    	Queue<Integer> queue = new LinkedList<>();
    	visited[start] = true;	//시작 방문 확인
    	queue.add(start);
    	while(!queue.isEmpty()) {
    		int cur = queue.poll();
            //그래프 인접한 정점 탐색
    		for(int next : graph.get(cur)) {
            	//사이클 발생시
    			if(visited[next]) {
    				if(!lineCheck[cur][next])
    					return 0;
    			}else {
    				visited[next] = true;
    				lineCheck[cur][next] = true;
    				lineCheck[next][cur] = true;
    				queue.add(next);
    			}
    		}
    	}
    	return 1;	//트리이면 1을 반환
    }
}

