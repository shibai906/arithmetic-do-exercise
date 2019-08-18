package com.zhao.leetcode.bisai.bi150;

/**
 * 按字典序排在最后的子串
 *  给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 */
public class LastDictionarySubstring {

    public static void main(String[] args) {

        System.out.println("jlidhumidloagrlvvxdqscegbeaybfhhyaeilzxdpyvvxixrjytdalknkospradmumysbkizziltzjwsxkteykblcvkfivzmtvnsyrfgvojhyzkouscymixrdfmehiwijntzqptqaxgalygtzvwxnsgcnygbjzeqmbactgmckvssvkentpxcnznrbbnkttnzpvlzfmdvvsozaiycumzlizbfxvyucyagclrifczcvzvrkiqiajindjjyxgxflnjcgckruujsbppxtwgwvrrxgniqplynvboqyvrsxnmbjhgoybqophbxmjhhrznezstujjuucvrrvofktxldxfaioyijoayggmvjmgzjflzxmkwxmxnyizampdcfntdfkxxprgfxjduiwrmgdfuprpljgnbzbedqbzhqsbmohbhlszvdzcgbimfurmkwqaignxbeevevonmdgupugcjxvqglqkwqzrlqequliwmfrvidtpprodcbhgkt".length());
        System.out.println("zziltzjwsxkteykblcvkfivzmtvnsyrfgvojhyzkouscymixrdfmehiwijntzqptqaxgalygtzvwxnsgcnygbjzeqmbactgmckvssvkentpxcnznrbbnkttnzpvlzfmdvvsozaiycumzlizbfxvyucyagclrifczcvzvrkiqiajindjjyxgxflnjcgckruujsbppxtwgwvrrxgniqplynvboqyvrsxnmbjhgoybqophbxmjhhrznezstujjuucvrrvofktxldxfaioyijoayggmvjmgzjflzxmkwxmxnyizampdcfntdfkxxprgfxjduiwrmgdfuprpljgnbzbedqbzhqsbmohbhlszvdzcgbimfurmkwqaignxbeevevonmdgupugcjxvqglqkwqzrlqequliwmfrvidtpprodcbhgkt".length());
        System.out.println(lastSubstring("zzczzb"));
    }

    public static String lastSubstring(String s) {

        if(s == null || s.length() < 1) {
            return null;
        }
        int[] arr = new int[]{s.charAt(0),0,1};
        int num = 1;
        for(int i = 1 ; i < s.length(); i ++) {
            if(s.charAt(i) >= arr[0]) {
                if(s.charAt(i) == s.charAt(i - 1)) {
                    num ++;
                    if(num > arr[2]) {
                        arr[1] = i - num + 1 ;
                        arr[2] = num;
                    }
                } else if(s.charAt(i) == s.charAt(arr[1])) {
                    if(arr[2] < 2) {
                        arr[1] = i;
                    }
                    num = 1;
                } else {
                    num = 1;
                    arr[0] = s.charAt(i);
                    arr[1] = i;
                    arr[2] = 1;
                }
            } else {
                if(s.charAt(i - 1) == s.charAt(arr[1]) && num == arr[2] && arr[1] != i  - num) {
                    int a = arr[1] + num, b = i;
                    while (b < s.length() && s.charAt(a) == s.charAt(b)) {
                        a ++;
                        b ++;
                    }
                    if(b < s.length()) {
                        if(s.charAt(b) > s.charAt(a)) {
                            arr[1] = i - num;
                        }
                    }
                }
                num = 1;
            }
        }
        if(arr[2] == 1) {
            for(int i = arr[1] - 1 ; i >= 0 ; i --) {
                if(s.charAt(i) == s.charAt(arr[1])) {
                    arr[1] = i;
                    break;
                }
            }
        }
        return s.substring(arr[1]);
    }

}
