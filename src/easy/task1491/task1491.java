class Solution {
    public double average(int[] salary) {
        double res = 0;
        Arrays.sort(salary);
        for(int i = 2; i < salary.length - 1; ++i){
            salary[i] += salary[i - 1]; 
        }
        return (double)salary[salary.length - 2] / (salary.length - 2);
    }
}
