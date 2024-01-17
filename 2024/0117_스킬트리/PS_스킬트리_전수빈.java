import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashSet<Character> hash = new HashSet<>();
        char[] c = skill.toCharArray();
        for(int i=0;i<c.length;i++){
            hash.add(c[i]);
        }
        for(int i=0;i<skill_trees.length;i++){
            Queue<Character> q = new LinkedList<>();
            for(int j=0;j<skill_trees[i].length();j++){
                if(hash.contains(skill_trees[i].charAt(j))){
                    q.add(skill_trees[i].charAt(j));
                }
            }
            int size = q.size();
            boolean pass = true;
            for(int j=0;j<size;j++){
                if(c[j]!=q.poll()){
                    pass =false;
                }
            }
            if(pass)answer++;
        }
        return answer;
    }
}