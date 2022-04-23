/*


Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Example 1:

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
Example 2:

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
Example 3:

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
Example 4:

Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.



*/



public class BackSpace{
    public static void main(String[] args) {
        System.out.println(compare("xy#z", "xzz#"));
        System.out.println(compare("xy#z", "xyz#"));
        System.out.println(compare("xp#", "xyz##"));
        System.out.println(compare("xywrrmp", "xywrrmu#p"));
    }
    public static  boolean compare(String s1,String s2){
        int index1=s1.length()-1,index2=s2.length()-1;
        while(index1>=0 && index2>=0){
            int id1=getNextValidCharIndex(s1,index1);
            int id2=getNextValidCharIndex(s2,index2);
            if(id1<0 && id2<0)
                return true;
            if(id1<0 || id2<0)
                return false;
            if(s1.charAt(id1)!=s2.charAt(id2))
                return false;
            index1=id1-1;
            index2=id2-1;
        }
        return true;
    }
    public static int getNextValidCharIndex(String s,int id){
        int backspace=0;
        while(id>=0){
            if(s.charAt((id))=='#')
                backspace++;
            else if(backspace>0)
                backspace--;
            else
                break;
            id--;
        }
        return id;
    }
}
