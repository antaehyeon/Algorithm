function solution(N, A) {

    const C = []; // Counters
    let M = 0; // Max Value
    let PM = 0; // Previous Max Value
    let N1 = N + 1;
    let L = A.length; // Array Length
    
    for (I = 0; I < N; I++) C[I] = 0;

    for (I = 0; I < L; I++) {

        if (A[I] < N1) {
            let INDEX = A[I] - 1;
            if (C[INDEX] < PM) C[INDEX] = PM;
            C[INDEX]++;
            M = (M < C[INDEX]) ? C[INDEX] : M;
        } 
        else PM = M;
    }

    for (I = 0; I < N; I++) {
        if (C[I] < PM) C[I] = PM;
    }

    return C;
}

// function solution(N, A) {
//     var M = A.length; // Length of the entry array
//     var C = []; // Counters
//     var H = 0; // Highest counter
//     var PH = 0; // Previously recorded highest counter
    
//     for(K = 0; K < N; K++) { // Initialize the array
//       C[K] = 0;
//     }
          
//     // If you're having trouble understanding the problem, here's an
//     // explanation. The array you are receiving has instructions as
//     // to how perform mutations on an existing array. For instance,
//     // if the first element of the array is 3, that means you need
//     // to increment the third counter by 1 (C[3] + 1). Your array 
//     // would then look like [0, 0, 1, 0, 0]. Technically, we don't need
//     // N, but there is another rule where if the array element is
//     // equal to N + 1 then your counters will need to set to the
//     // highest counter value.
//     for(K = 0; K < M; K++) { // Iterate through the array (M = A.length)
//       // If the element is not N + 1, we need to increase a specific counter
//       if (A[K] !== N + 1) { 
//         // Increase the counter designated. We will need to subtract 1
//         // because arrays start at 0, not 1.
//         C[A[K] - 1]++; 
//         // Let's keep track of the highest counter we have reached and
//         // assign it to the variable H.
//         if (H < C[A[K] - 1]) H = C[A[K] - 1];        
//         continue;
//       }
      
//       // This is an optimization. Basically, in large arrays with huge
//       // amounts of max counters, you will be performing O(N + M) operations
//       // constantly because you will need to assign every counter to the
//       // maximum over and over. We can solve this problem by keeping track 
//       // of the previous maximum counter and if it changes, then we know we
//       // need to iterate through the counters and set the maximum.
//       if (H === PH) continue;
          
//       // Iterate through the counters and assign the maximum. This operation is
//       // O(N + M), so we need to make sure to call this the least amount possible.
//       // If we've reached this point, we can be sure that it's a maximum counter
//       // operation.
//       for(J = 0; J < N; J++) C[J] = PH = H;
//     }
    
//     // Return the counters
//     return C;
//   }

console.log(solution(5, [3,4,4,6,1,4,4]));