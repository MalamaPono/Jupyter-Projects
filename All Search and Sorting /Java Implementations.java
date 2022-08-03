public class MyClass {
    public static void main(String args[]) {
        
        // Bubble Sort
        public static void bubbleSort(int[] num){
            for(int i = 0; i < num.length-1; i++){
                for(int j = 0; j < num.length-1-i; j++){
                    if(num[j] > num[j+1]){
                        int temp = num[j];
                        num[j] = num[j+1];
                        num[j+1] = temp;
                    }
                }
            }
        }
        
        // Insertion Sort
        
        public static void insertionSort(int[] array){
            for(int currentPos = 1; currentPos < array.length; currentPos++){
                int checkPos = currentPos;
                int temp = array[currentPos];
                
                while(checkPos > 0 && temp < array[checkPos-1]){
                    array[checkPos] = array[checkPos-1]; //not removing any elements, just changing the value in them
                    checkPos--;
                }
                array[checkPos] = temp;
            }
        }
        
        // Selection Sort
        
        public static int[] selectionSort(int[] num){
            for(int i = 0; i < num.length-1; i++){
                int min = num[i];
                int minLoc = i;
                for(int j = i+1; j < num.length; j++){
                    if(num[j] < min){
                        min = num[j];
                        minLoc = j;
                    }
                }
                int temp = num[i];
                num[i] = min;
                num[minLoc] = temp;
                
            }
            return num;
        }
        
        // Merge Sort
        
        public static void mergeSort(ArrayList<Integer> intList, int low, int high){ //divides list in breakable parts usually uses recursion
            int middle;
            if(low < high){
                middle = (low + high)/2;
                mergeSort(intList, low, middle);
                mergeSort(intList, middle+1, high);
                merge(intList, low, middle, high);
                
            }
        }
    
        public static void merge(ArrayList<Integer> intList, int low, int middle, int high){ //puts it all back together usually through iteration and loops
            
            //set pointer positions
            int lowPointer = low;
            int highPointer = middle+1;
            int correctLoc = low;
            
            //copy original ArrayList to seporte temp ArrayList
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for(int i = 0; i < intList.size(); i++){
                tempList.add(intList.get(i));
            }
            
            //copy the lowest element from each half IN ORDER
            while(lowPointer <= middle && highPointer <= high){
                if(tempList.get(lowPointer) <= tempList.get(highPointer)){
                    intList.set(correctLoc, tempList.get(lowPointer));
                    correctLoc++;
                    lowPointer++;
                }else{
                    intList.set(correctLoc, tempList.get(highPointer));
                    correctLoc++;
                    highPointer++;
                }
            }
            
            //copy remaining elements from first half(if any)
            while(lowPointer <= middle){
                intList.set(correctLoc, tempList.get(lowPointer));
                correctLoc++;
                lowPointer++;
            }
        }
        
        // Quick Sort
        
        public static void quickSort(int[] num, int left, int right){
        
            if(left >= right){
                return;
            }
            
            int pivotValue = num[(left+right)/2];
            int partitionIndex = partition(num, left, right, pivotValue);
            
            quickSort(num,left,partitionIndex-1);
            quickSort(num,partitionIndex,right);
            
        }
    
        public static int partition(int[] num, int left, int right, int pivotValue){
            
            while(left <= right){
                
                while(num[left] < pivotValue){
                    left++;
                }
                
                while(num[right] > pivotValue){
                    right--;
                }
                
                if(left <= right){
                    int temp = num[left];
                    num[left] = num[right];
                    num[right] = temp;
                    right--;
                    left++;
                }
                
            }
            
            return left;
        }
        
        // Binary Search 
        
        public static int binarySearchRecursive(int[] num, int low, int high, int target){
            int mid = (low + high)/2;
            if(low <= high){
                if(target > num[mid]){
                    return binarySearchRecursive(num, mid+1, high, target);
                }else if(target < num[mid]){
                    return binarySearchRecursive(num, low, mid-1, target);
                }else{
                    return mid;
                }
            }else{
                return -1;
            }
        }
    
        public static int binarySearchIterative(int[] num, int target){
            int low = 0;
            int high = num.length-1;
            while(low <= high){
                int mid = (low+high)/2;
                if(target > num[mid]){
                        low = mid+1;
                }else if(target < num[mid]){
                    high = mid -1;
                }else{
                    return mid;
                }
            }
            return -1;
        }
        
        // Linear Search
        public static int linearSearch(int[] num, int target){
            for(int i = 0; i < num.length; i++){
                if(num[i] == target){
                    return i
                }
            }
        }
        
        }
}