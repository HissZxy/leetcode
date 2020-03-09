/**
 * 1.编程https://www.cnblogs.com/woxiaosade/p/10592061.html
 * 2.观察https://www.cnblogs.com/yzm10/p/10595165.html
 * 
 * @description TODO
 * @author frontier
 * @time 2019年4月9日 上午11:19:05
 *
 */
class Node {
	int step;
	String path;
	int x, y;

	public Node(int step, String path, int x, int y) {
		super();
		this.step = step;
		this.path = path;
		this.x = x;
		this.y = y;
	}
}

public class D迷宫 {
	static Scanner in = new Scanner(System.in);
	static int n, m;
	static char[][] maze = new char[60][60];
	static boolean[][] vis = new boolean[60][60];
	static int[] X = { 1, 0, 0, -1 };// 增量数组，方向向量，直接按字典序排列
	static int[] Y = { 0, -1, 1, 0 };
	static String[] d = { "D", "L", "R", "U" };

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/JavaA/s10/5.txt"));
		n = in.nextInt();
		m = in.nextInt();
		for (int i = 1; i <= n; ++i) {
			String temp = in.next();
			for (int j = 1; j <= m; ++j) {
				maze[i][j] = temp.charAt(j - 1);
			}
		}
		bfs();
	}

	static boolean check(int x, int y) {
		if (x < 1 || x > n || y < 1 || y > m)
			return false;
		if (vis[x][y] || maze[x][y] == '1')
			return false;
		return true;
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, "", 1, 1));
		while (!q.isEmpty()) {
			Node top = q.poll();
			vis[top.x][top.y] = true;
			if (top.x == n && top.y == m) {
				System.out.println(top.step + " " + top.path);
				return;
			}
			for (int i = 0; i < 4; ++i) {
				int newX = top.x + X[i];
				int newY = top.y + Y[i];
				if (check(newX, newY)) {
					Node temp = new Node(top.step + 1, top.path + d[i], newX, newY);
					q.offer(temp);
				}
			}
		}
	}
}