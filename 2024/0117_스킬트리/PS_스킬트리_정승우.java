class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            int idx = 0;
            boolean check = false;
            String[] skills = skill_trees[i].split("");

            for(String str : skills){
                if(idx == skill.indexOf(str))  {
                    idx++;
                }

                else if(idx < skill.indexOf(str)){
                    check = true;
                    break;
                }
            }
            if(!check) {
                answer++;
            }
        }
        return answer;
    }
}