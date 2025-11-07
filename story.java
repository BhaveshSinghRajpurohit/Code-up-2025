import java.util.Scanner;
public class story {
    // Traveller problem
    public static int traveler(int arr[],int energy){
        System.out.println("enter the inital energy :");
        int initialenergy = energy;
        int x = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            x = x + arr[i];
            if (x <= initialenergy) {
                count++;
            }
        }
        return count;
    }

    // Prefix and suffix sum
    public static int sum(int arr[],int n){
        int y = 0;
        int ss[] = new int[n];
        int ps[] = new int[n];
             for (int i = 0; i < n; i++) {
            y = y + arr[i];
            ps[i] = y;
        }
        int z = 0;
             for (int j = n - 1; j >= 0; j--) {
        z = z + arr[j];
        ss[j] = z;
        }
         System.out.println();
         System.out.print("the suffix sum array is :");
         for (int m = 0; m < n; m++) {
        System.out.print(ss[m] + " ");
        }
             System.out.println();
             System.out.print("the prefix sum array is :");
             for (int m = 0; m < n; m++) {
            System.out.print(ps[m] + " ");
        }
             System.out.println();
         int x = 0;
         for (int k = 0; k < n; k++) {
             if (ps[k] == ss[k]) {
                 return k;
             }
         }
         return -1;
}

//  Flip the minimum
    public static int flip(int arr[]){
        int result =0;
        int ans=0;
        for (int i =0;i<arr.length;i++){
            if(arr[i]!=0 && arr[i]!=1){
                return -1;
            }
            if(arr[i]==1){
                result++;
            }
        }
        int sum = arr.length - result;
        ans = sum;
        if(sum>result) {
            ans = result;
        }
        return ans ;
    }

    // unique element
    public static int unique(int arr[]){
        for(int i=0;i<arr.length;i++){
            int a=0;
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j] && i!=j){
                    a=1;
                    break;
                }
            }
            if(a==0) return arr[i];
        }
        return -1;
    }
    // Smart Pair Finder
    public static int pair(int arr[],int m){
       Scanner sc = new Scanner(System.in);
        boolean flag= false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == m && i != j) {
                    flag = true;
                    break;
                }
                if(flag) break;
            }
        }
        if (flag == true) {
            return 1;
        } else {
           return 0;
        }
    }

    //The Minimalist Painter
    public static int painter(int arr[]){
        int min=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i< arr.length;i++){
            sum+=arr[i];
            if(arr[i]>min)  min=arr[i];
        }
        return (sum-min);
    }


public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String options = """
                           0. program end
                           1. The efficient traveler.
                           2. Sum equals at prefix and suffix.
                           3. Minimum number of flips.
                           4. The odd one out.
                           5. Pair finder.
                           6  The Minimalist Painter.""";
        System.out.println(options);
        int choice =1;
        try{
            while(choice!=0) {
            System.out.print("enter the choice : ");
            choice = sc.nextInt();
            if(choice==0){
                System.out.println("program end");
                return;
            }
            System.out.print("enter the size of array : ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("enter the elements of array :");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("the array is :");
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.println("enter the initial energy :");
                    int energy = sc.nextInt();
                    int brr = traveler(arr, energy);
                    System.out.println("no of cities visited is = " + brr);
                    break;

                case 2:
                    int crr = sum(arr, n);
                    if (crr == -1) System.out.println("prefix and suffix sum is not equal");
                    else System.out.println("suffix and prefix sum equals at =" + crr);
                    break;
                case 3:
                    int drr = flip(arr);
                    if (drr == -1) System.out.println("enter only 0 or 1");
                    else System.out.println("no of flips required is =" + drr);
                    break;
                case 4:
                    int err = unique(arr);
                    if (err == -1) System.out.println("no unique element found");
                    else System.out.println("unique element is =" + err);
                    break;
                case 5:
                    System.out.println("enter the target value : ");
                    int m = sc.nextInt();
                    int frr = pair(arr, m);
                    if (frr == 1) System.out.println("pair is present = true");
                    else System.out.println("pair is absent = false");
                    break;
                case 6:
                    int grr = painter(arr);
                    System.out.println("minimum time will be : " + grr);
                    break;
                default:
                    System.out.println("Invalid input");
                }
            }
        } catch (Exception e){
            System.out.println("invalid input");
        }
    }
}
