package exam;

public class test {

    public static void main(String[] args) {
        char[][] map = new char[6][6];
        String str = "FINAL FANTASY";
        String nums = "533432133252324500221413330041230022421333221042130021343200222114333201004213004123004253131053343213325232450022141231004123005342453122105312223412133300213432230053425115310024320034321445311012002214530023425100224112151213330014210041321053142200122100453214150042450012512221004123001114132114222310";
        StringBuilder reOrder = parse(str);//按重复字母和字母顺序进行重排
        int[] count = new int[128];
        char ch = 'A';

        for(int i = 0;i < reOrder.length();i++){
            count[reOrder.charAt(i)]++;//计算已经出现字母的次数
        }

        //计算重排序后的字母
        for(int i = 0;i < 26;i++){
            if(count[ch] > 0 || ch == 'J'){
                ch++;
                continue;
            }
            reOrder.append(ch++);
        }

        int index = 0;
        //映射到二维数组中
        for(int i = 1;i < 6;i++){
            for(int j = 1;j < 6;j++){
                map[i][j] = reOrder.charAt(index++);
            }
        }

        System.out.println(slove(map,nums));
    }

    /**
     * 寻找新的排序规则
     * @return
     */
    private static StringBuilder parse(String str){
        StringBuilder reOrder = new StringBuilder();
        int[] count = new int[128];
        for(char ch : str.toCharArray()){
            if(count[ch] > 0 || !Character.isLetter(ch)) continue;;
            count[ch]++;
            reOrder.append(ch);
        }

        return reOrder;
    }

    /**
     * 将数字转化为字符串
     * @param map
     * @param nums
     * @return
     */
    private static String slove(char[][] map,String nums){
        StringBuilder res = new StringBuilder();

        for(int i = 0;i < nums.length();i+=2){
            String tmp = nums.substring(i,i + 2);
            if(tmp.equals("00")) res.append(" ");
            else if(tmp.equals("10")) res.append("\n");
            else if(tmp.equals("01")) res.append(",");
            else if(tmp.equals("02")) res.append(".");
            else{
                int row = Integer.parseInt(String.valueOf(tmp.charAt(0)));
                int clo = Integer.parseInt(String.valueOf(tmp.charAt(1)));

                char ch = map[row][clo];
                if(ch == 'I'){
                    /**
                     * 目前并未想到判定I/J组合的好的办法，下面的判定条件只是根据当前数据得到
                     * 或许可以有以下解决办法：
                     * 1、为适应不同数据，可以将单词进行收集（github已经有人收集），构建字典树，在生成单词后判定是否有误
                     */
                    if(nums.substring(i + 2,i + 4).equals("51")){
                        ch = 'J';
                    }
                }
                res.append(ch);
            }
        }
        return res.toString();
    }
}
