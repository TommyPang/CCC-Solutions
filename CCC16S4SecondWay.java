import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * CCC '16 S4 - Combining Riceballs
 * Question URL: Dynamic Programming
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc16s4
 * @author Milliken high school -> http://mmhs.ca/ccc/index.htm
 */
public class CCC16S4SecondWay {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] riceballs;
    static int [][] count;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        riceballs = new int[N]; count = new int[N][N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            riceballs[i] = Integer.parseInt(st.nextToken());
            max = Math.max(riceballs[i], max);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count[i][j] = -1;
            }
        }
        for (int range=2;range<=N;range++)
        {
            int maxStart = N-range+1;
            for (int firstStartIndex=0;firstStartIndex<maxStart;firstStartIndex++)
            {
                int lastEndIndex = firstStartIndex + range - 1;

                // Search for two block solutions (first,last)
                boolean found = search_range_for_two_blocks(firstStartIndex,lastEndIndex);

                // If we found a solution with the simple solver don't do any more work
                if (found) continue;

                // Search for solutions with three blocks (first, middle, last) when we have at least 3 balls
                if (range > 2)
                    search_range_for_three_blocks(firstStartIndex,lastEndIndex);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, count[i][j]);
            }
        }
        System.out.println(max);
    }
    static void add_solution(int startIndex, int endIndex, int ballCount)
    {
        count[startIndex][endIndex] = ballCount;
    }

    static boolean can_be_combined(int startIndex, int endIndex)
    {
        if (startIndex == endIndex)
            return true;
        else
            return count[startIndex][endIndex] != -1;
    }
    static int get_range_count(int startIndex, int endIndex)
    {
        if (startIndex == endIndex)
            return riceballs[startIndex];
        else
            return count[startIndex][endIndex];
    }

    static boolean search_range_for_two_blocks(int firstStartIndex, int lastEndIndex)
    {
        for (int lastStartIndex = firstStartIndex+1; lastStartIndex <= lastEndIndex; lastStartIndex++)
        {
            // Define the first range
            int firstEndIndex = lastStartIndex-1;

            // Skip starting ranges that cannot be combined
            if (!can_be_combined(firstStartIndex, firstEndIndex))
                continue;

            // Skip ending ranges that cannot be combined
            if (!can_be_combined(lastStartIndex, lastEndIndex))
                continue;

            // We need to know the first range count
            int firstCount = get_range_count(firstStartIndex,firstEndIndex);

            // We need to know the last range count
            int lastCount = get_range_count(lastStartIndex,lastEndIndex);

            // We can only combine if the first range count is the same as the last range count
            if (firstCount != lastCount)
                continue;

            // Compute the combined number of rice balls
            int rangeCount = firstCount + lastCount;

            // We have found a solution - lets add it to the our DP container
            add_solution(firstStartIndex,lastEndIndex,rangeCount);

            // Only one solution is important - we don't have to keep looking for another
            return true;
        }

        // We did not find a solution
        return false;
    }

    static void search_range_for_three_blocks(int firstStartIndex, int lastEndIndex)
    {
        for (int middleStartIndex = firstStartIndex+1; middleStartIndex < lastEndIndex; middleStartIndex++)
        {
            // Define the end of the first block
            int firstEndIndex = middleStartIndex-1;

            // Skip first range if it cannot be combined
            if (!can_be_combined(firstStartIndex, firstEndIndex))
                continue;

            // We need to know the starting range count
            int firstCount = get_range_count(firstStartIndex,firstEndIndex);

            for (int lastStartIndex = middleStartIndex+1; lastStartIndex <= lastEndIndex; lastStartIndex++)
            {
                // Define the end of them middle block
                int middleEndIndex = lastStartIndex -1;

                // Skip middle range that cannot be combined
                if (!can_be_combined(middleStartIndex, middleEndIndex))
                    continue;

                // Skip last range that cannot be combined
                if (!can_be_combined(lastStartIndex, lastEndIndex))
                    continue;

                // We need to know the last range count
                int lastCount = get_range_count(lastStartIndex,lastEndIndex);

                // We can only combine if the first range count is the same as the last range count
                if (firstCount != lastCount)
                    continue;

                // We need the middle range count so we can compute the full range count
                int middleCount = get_range_count(middleStartIndex,middleEndIndex);
                int rangeCount = firstCount + middleCount + lastCount;

                // We have found a solution - lets add it to the our DP container
                add_solution(firstStartIndex,lastEndIndex,rangeCount);

                // Only one solution is important - we don't have to keep looking for another
                return;
            }
        }
    }
}
