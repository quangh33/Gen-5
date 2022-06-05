var subarraysDivByK = function(A, K) {

    let freq = new Array(K).fill(0); // "moduloK : Times I've seen it so far"


    freq[0]=1 //  Explained below

    // This is the accumulative sum of the elements of A
    let sum = 0;

    // The count of wanted subarrays, whose Sum%K= zero
    let count=0;

    for(let i = 0; i < A.length; i++){

        sum=sum+A[i]


        var remainder= sum%K

        //ALWAYS CHOOSE THE POSITIVE REMAINDER
        if(remainder<0)remainder+=K // Explained below


        count+=freq[remainder]

        freq[remainder]++
    }
    return count
    

};

// https://leetcode.com/problems/subarray-sums-divisible-by-k/